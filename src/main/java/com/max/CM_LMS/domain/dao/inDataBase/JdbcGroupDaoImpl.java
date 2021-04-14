package com.max.CM_LMS.domain.dao.inDataBase;

import com.max.CM_LMS.domain.Group;
import com.max.CM_LMS.domain.dao.GroupDao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcGroupDaoImpl implements GroupDao {

    /**
     * @return query for saveGroup, help to get id
     */
    private String insertGroupQueryToGetNewId() {
        return "select id from \"GROUP\" where NAME = ? and DIRECTION = ? and \"startDate\" = ?;";
    }

    /**
     * @return query for saveGroup, help to create new line in db
     */
    private String insertGroupQuery() {
        return "insert into \"GROUP\" (NAME, DIRECTION, \"startDate\") " +
                "values ( ?, ?, ? );";
    }

    /**
     * @return query to delete Group by id
     */
    private String deleteGroupByIdQuery() {
        return "delete from \"GROUP\" where id = ?;";
    }

    private String updateGroupQuery() {
        return "update \"GROUP\" set NAME = ?, DIRECTION = ?, \"startDate\" = ? where id = ?;";
    }

    @Override
    public List<Group> getAll() throws Exception {
        List<Group> groups = new ArrayList<>();

        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();

        String queryToSelect = "select *from \"GROUP\";";
        ResultSet result = statement.executeQuery(queryToSelect);
        Group group = new Group("-1", "-1", LocalDate.now());
        while (result.next()) {
            // create new group with another pointer
            group = new Group("-1", "-1", LocalDate.now());
            // set values
            group.setId(result.getInt(1));
            group.setName(result.getString(2));
            group.setDirection(result.getString(3));
            group.setStartDate(LocalDate.parse(result.getString(4)));
            groups.add(group);
        }
        /*  data base is empty
         * we need to return null
         */
        if (group.getName().equals("-1")) {
            return null;
        }
        return groups;
    }

    @Override
    public Group saveGroup(Group group) throws Exception {
        if (group.getId() != 0 && group.getId() != null) {
            updateGroup(group);
            return group;
        }
        Connection connection = DbUtils.getConnection();

        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(insertGroupQuery());
        /*set values  Name, direction, dateOfStart*/
        statement.setString(1, group.getName());
        statement.setString(2, group.getDirection());
        statement.setString(3, group.getStartDate().toString());
        /*executing a query*/
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /* now new group needs in id
         * id auto increments in db
         * i find new group in data base with name, direction, startDate
         * */
        statement = connection.prepareStatement(insertGroupQueryToGetNewId());
        /*
         * set values
         */
        statement.setString(1, group.getName());
        statement.setString(2, group.getDirection());
        statement.setString(3, group.getStartDate().toString());

        ResultSet result = statement.executeQuery();

        int newId = 0;
        /*
         * there is always one cell with index
         * in worth case when we have to the same group(but it`s impossible)
         * i`ll get id the last cell
         * */
        while (result.next()) {
            newId = Integer.parseInt(result.getString(1));
        }
        group.setId(newId);
        return group;

    }




    @Override
    public Group getGroupById(int id) throws Exception {
        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();

        String query = "select *from \"GROUP\" where  id =" + id + ";";
        ResultSet result = statement.executeQuery(query);
        Group group = new Group("-1", "-1", LocalDate.now());
        while (result.next()) {
            group.setId(result.getInt(1));
            group.setName(result.getString(2));
            group.setDirection(result.getString(3));
            group.setStartDate(LocalDate.parse(result.getString(4)));
        }
        /* we haven`t found group with input id
         * we need to return null
         */
        if (group.getName().equals("-1")) {
            return null;
        }
        return group;
    }


    @Override
    public boolean updateGroup(Group group) throws Exception {
        if (group.getId() == 0 || group.getId() == null) {
            return false;
        }
        Connection connection = DbUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(updateGroupQuery());
        statement.setString(1, group.getName());
        statement.setString(2, group.getDirection());
        statement.setString(3, group.getStartDate().toString());
        statement.setString(4, group.getId().toString());
        int res = -999;
        res = statement.executeUpdate();
        return res > 0;
    }


    @Override
    public boolean deleteGroupById(int id) throws Exception {
        Connection connection = DbUtils.getConnection();
        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(deleteGroupByIdQuery());
        /* set id*/
        statement.setString(1, Integer.toString(id));
        int result = -999;
        try {
            result = statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        /*
         * in case when there isn't group with input id
         * statement.executeUpdate() will return 0 (zero line was affected)
         * and result=0
         */
        return result > 0;
    }
}

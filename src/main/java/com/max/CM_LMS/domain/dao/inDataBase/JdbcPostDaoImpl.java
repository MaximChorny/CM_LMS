package com.max.CM_LMS.domain.dao.inDataBase;

import com.max.CM_LMS.domain.*;
import com.max.CM_LMS.domain.dao.PostDao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcPostDaoImpl implements PostDao {
    final JdbcUserDaoImpl userFromBase = new JdbcUserDaoImpl();
    private final JdbcGroupDaoImpl groupFromBase = new JdbcGroupDaoImpl();

    private String insertPostToGetNewIdQuery() {
        return "select  id from \"Post\" where TEXT= ? and  \"datePost\" = ?;";
    }

    private String insertPostQuery() {
        return "insert into \"Post\"(text, \"datePost\", id_feed, id_user) " +
                "values ( ?, ?, ?, ?);";
    }

    private String deletePostByIdQuery() {
        return "delete from \"Post\" where id = ?;";
    }

    private String updatePostQuery() {
        return "update \"Post\" set TEXT = ?, \"datePost\" = ?, ID_FEED = ?, ID_USER = ? where id = ?;";
    }

    @Override
    public List<Post> getAll() throws Exception {
        List<Post> posts = new ArrayList<>();

        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();

        String query = "select *from \"Post\";";
        ResultSet result = statement.executeQuery(query);
        Post post = new Post("-1", LocalDate.now());
        while (result.next()) {
            //create new pointer
            post = new Post("-1", LocalDate.now());
            //set values
            post.setId(result.getInt(1));
            post.setText(result.getString(2));
            post.setDatePost(LocalDate.parse(result.getString(3)));
            post.setFeed(smallQueryToGetFeed(connection, result.getInt(4)));
            post.setAuthor(userFromBase.getUserById(result.getInt(5)));
            posts.add(post);
        }
        //case when db is empty
        if (post.getText().equals("-1")) {
            return null;
        }
        return posts;
    }

    @Override
    public Post savePost(Post post) throws Exception {
        if (post.getId() != 0 && post.getId() != null) {
            updatePost(post);
            return post;
        }
        Connection connection = DbUtils.getConnection();
        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(insertPostQuery());
        /*set values  text,  datePost, idFeed, idUser*/
        statement.setString(1, post.getText());
        statement.setString(2, post.getDatePost().toString());
        if (post.getFeed().getId() == 0) {
            statement.setString(3, "null");
        } else {
            statement.setString(3, post.getFeed().getId().toString());
        }
        if (post.getAuthor().getId() == 0) {
            statement.setString(4, "null");
        } else {
            statement.setString(4, post.getAuthor().getId().toString());
        }
        /*executing a query*/
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /* now new post needs in id
         * id auto increments in db
         * i find new post in data base with text
         * */
        statement = connection.prepareStatement(insertPostToGetNewIdQuery());
        /*
         * set values
         */
        statement.setString(1, post.getText());
        statement.setString(2, post.getDatePost().toString());

        ResultSet result = statement.executeQuery();

        int newId = 0;
        /*
         * there is always one cell with index
         * in worth case when we have two the same Post(but it`s impossible)
         * i`ll get id the last cell
         * */
        while (result.next()) {
            newId = Integer.parseInt(result.getString(1));
        }
        post.setId(newId);
        return post;
    }


    @Override
    public Post getPostById(int id) throws Exception {

        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();

        String query = "select *from \"Post\" where id = " + id + ";";
        ResultSet result = statement.executeQuery(query);
        Post post = new Post("-1", LocalDate.now());
        while (result.next()) {
            //set values
            post.setId(result.getInt(1));
            post.setText(result.getString(2));
            post.setDatePost(LocalDate.parse(result.getString(3)));
            post.setFeed(smallQueryToGetFeed(connection, result.getInt(4)));
            post.setAuthor(userFromBase.getUserById(result.getInt(5)));
        }
        /* we haven`t found group with input id
         * we need to return null
         */
        if (post.getText().equals("-1")) {
            return null;
        }
        return post;
    }

    /**
     * i use it to avoid recursion
     *
     * @return feed from db
     * @throws SQLException
     */
    private Feed smallQueryToGetFeed(Connection connection, int id) throws Exception {
        Statement statement = connection.createStatement();
        String query = "select *from FEED where ID= " + id + " ;";
        ResultSet result = statement.executeQuery(query);
        Feed feed = new Feed(new Group("-1", "-1", LocalDate.now()));
        while (result.next()) {
            feed = new Feed(groupFromBase.getGroupById(id));
        }
        if (feed.getGroup().getName().equals("-1")) {
            return null;
        }
        return feed;
    }

    @Override
    public boolean updatePost(Post post) throws Exception {
        if (post.getId() == 0 || post.getId() == null) {
            return false;
        }
        Connection connection = DbUtils.getConnection();

        PreparedStatement statement = connection.prepareStatement(updatePostQuery());
        /*set value  text , date , feed, author id to update*/
        statement.setString(1, post.getText());
        statement.setString(2, post.getDatePost().toString());
        statement.setString(3, post.getFeed().getId().toString());
        statement.setString(4, post.getAuthor().getId().toString());
        statement.setString(5, post.getId().toString());
        int res = -999;
        try {
            res = statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res > 0;
    }

    @Override
    public boolean deletePostById(int id) throws Exception {
        Connection connection = DbUtils.getConnection();
        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(deletePostByIdQuery());
        /* set id*/
        statement.setString(1, Integer.toString(id));
        int result = -999;
        try {
            result = statement.executeUpdate();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        /*
         * in case when there isn't post with input id
         * statement.executeUpdate() will return 0 (zero line was affected)
         * and result=0
         */
        return result > 0;
    }


}

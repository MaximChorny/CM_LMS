package com.max.CM_LMS.domain.dao.inDataBase;

import com.max.CM_LMS.domain.Feed;
import com.max.CM_LMS.domain.Group;
import com.max.CM_LMS.domain.Post;
import com.max.CM_LMS.domain.dao.FeedDao;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class inDataBaseFeedDao implements FeedDao {
    static final String URL = "jdbc:h2:file:C:\\Users\\Максим\\IdeaProjects\\CM_LMS\\src\\database\\please";

    private String getInsertMessageToGetNewId() {
        return "select id from FEED where ID_GROUP = ?;";
    }

    private String getInsertMessageToSaveFeed() {
        return "insert into FEED (ID_GROUP) values ( ? );";
    }

    private String queryToDeleteFeedById() {
        return "delete  from FEED where  ID = ?;";
    }

    private String queryToUpdateFeed() {
        return "update FEED set ID_GROUP = ? where id = ?;";
    }
    @Override
    public List<Feed> getAll() throws SQLException {
        List<Feed> feeds = new ArrayList<>();
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        Statement statement = connection.createStatement();
        String queryToSelect = "select * from FEED;";
        ResultSet result = statement.executeQuery(queryToSelect);
        Feed feed = new Feed(new Group("-1", "-1", LocalDate.now()));
        while (result.next()) {
            // create new feed with another pointer
            feed = new Feed(new Group("-1", "-1", LocalDate.now()));
            // set values
            feed.setId(result.getInt(1));
            feed.setGroup(new inDataBaseGroupDao().getGroupById(result.getInt(2)));
            feeds.add(feed);
        }
        /*  data base is empty
         * we need to return null
         */
        if (feed.getGroup().getName().equals("-1")) {
            return null;
        }
        return feeds;
    }

    @Override
    public Feed saveFeed(Feed feed) throws SQLException {
        if (feed.getId() != 0) {
            updateFeed(feed);
            return feed;
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(getInsertMessageToSaveFeed());
        if (feed.getGroup().getId() == 0) {
            new inDataBaseGroupDao().saveGroup(feed.getGroup());
        }
        statement.setString(1, feed.getGroup().getId().toString());
        /*executing a query*/
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        /* now new feed needs in id
         * id auto increments in db
         * i find new post in data base with text
         * */
        statement = connection.prepareStatement(getInsertMessageToGetNewId());
        ResultSet result = statement.executeQuery();

        int newId = 0;
        /*
         * there is always one cell with index
         * in worth case when we have two the same Feed(but it`s impossible)
         * i`ll get id the last cell
         * */
        while (result.next()) {
            newId = Integer.parseInt(result.getString(1));
        }
        feed.setId(newId);
        Iterator<Post> iterator = feed.getPosts().iterator();
        while (iterator.hasNext()) {
            new inDataBasePostDao().savePost(iterator.next());
        }
        return feed;
    }

    @Override
    public Feed getFeedById(int id) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        Statement statement = connection.createStatement();
        String query = "select * from FEED where ID = " + id + ";";
        ResultSet result = statement.executeQuery(query);
        Feed feed = new Feed(new Group("-1", "-1", LocalDate.now()));
        while (result.next()) {
            feed.setId(result.getInt(1));
            feed.setGroup(new inDataBaseGroupDao().getGroupById(result.getInt(2)));
        }
        if (feed.getGroup().getName().equals("-1")) {
            return null;
        }
        return feed;
    }

    @Override
    public boolean updateFeed(Feed feed) throws SQLException {
        if (feed.getId() == 0) {
            return false;
        }
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        PreparedStatement statement = connection.prepareStatement(queryToUpdateFeed());
        Group group = new inDataBaseGroupDao().saveGroup(feed.getGroup());
        statement.setString(1, group.getId().toString());
        statement.setString(2, feed.getId().toString());
        Iterator<Post> iterator = feed.getPosts().iterator();
        while (iterator.hasNext()) {
            new inDataBasePostDao().savePost(iterator.next());
        }
        int res = -999;
        res = statement.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean deleteFeedById(int id) throws SQLException {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL);
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(queryToDeleteFeedById());
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

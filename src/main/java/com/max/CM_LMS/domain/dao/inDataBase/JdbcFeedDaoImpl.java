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

public class JdbcFeedDaoImpl implements FeedDao {
private final JdbcGroupDaoImpl groupFromBase = new JdbcGroupDaoImpl();
private  final JdbcPostDaoImpl postFromBase = new JdbcPostDaoImpl();

    private String insertFeedQueryToGetNewId() {
        return "select id from FEED where ID_GROUP = ?;";
    }

    private String insertFeedQuery() {
        return "insert into FEED (ID_GROUP) values ( ? );";
    }

    private String deleteFeedByIdQuery() {
        return "delete  from FEED where  ID = ?;";
    }

    private String updateFeedQuery() {
        return "update FEED set ID_GROUP = ? where id = ?;";
    }

    @Override
    public List<Feed> getAll() throws Exception {
        List<Feed> feeds = new ArrayList<>();

        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();

        String queryToSelect = "select * from FEED;";
        ResultSet result = statement.executeQuery(queryToSelect);
        Feed feed;
        Group group = groupFromBase.getGroupById(result.getInt(2));
        if (group == null) {
            return null;
        }
        while (result.next()) {
            // create new feed with another pointer
            feed = new Feed(new Group("-1", "-1", LocalDate.now()));
            // set values
            feed.setId(result.getInt(1));
            feed.setGroup(group);
            feeds.add(feed);
        }
        return feeds;
    }

    @Override
    public Feed saveFeed(Feed feed) throws Exception {
        if (feed.getId() != 0 && feed.getId() != null) {
            updateFeed(feed);
            return feed;
        }
        Connection connection = DbUtils.getConnection();
        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(insertFeedQuery());
        if (feed.getGroup().getId() == 0) {
          groupFromBase.saveGroup(feed.getGroup());
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
        statement = connection.prepareStatement(insertFeedQueryToGetNewId());
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
           postFromBase.savePost(iterator.next());
        }
        return feed;
    }

    @Override
    public Feed getFeedById(int id) throws Exception {
        Connection connection = DbUtils.getConnection();
        Statement statement = connection.createStatement();
        String query = "select * from FEED where ID = " + id + ";";
        ResultSet result = statement.executeQuery(query);
        Feed feed = new Feed(new Group("-1", "-1", LocalDate.now()));
        while (result.next()) {
            feed.setId(result.getInt(1));
            feed.setGroup(groupFromBase.getGroupById(result.getInt(2)));
        }
        if (feed.getGroup().getName().equals("-1")) {
            return null;
        }
        return feed;
    }

    @Override
    public boolean updateFeed(Feed feed) throws Exception {
        if (feed.getId() == null || feed.getId() == 0) {
            return false;
        }
        Connection connection = DbUtils.getConnection();
        PreparedStatement statement = connection.prepareStatement(updateFeedQuery());

        Group group = groupFromBase.saveGroup(feed.getGroup());
        statement.setString(1, group.getId().toString());
        statement.setString(2, feed.getId().toString());
        Iterator<Post> iterator = feed.getPosts().iterator();
        while (iterator.hasNext()) {
          postFromBase.savePost(iterator.next());
        }
        int res = -999;
        res = statement.executeUpdate();
        return res > 0;
    }

    @Override
    public boolean deleteFeedById(int id) throws Exception {
        Connection connection = DbUtils.getConnection();
        /*get insert query*/
        PreparedStatement statement = connection.prepareStatement(deleteFeedByIdQuery());
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

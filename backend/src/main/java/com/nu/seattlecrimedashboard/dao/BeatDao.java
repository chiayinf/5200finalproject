package com.nu.seattlecrimedashboard.dao;

import com.nu.seattlecrimedashboard.model.Beat;
import com.nu.seattlecrimedashboard.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BeatDao {

  private static BeatDao instance = null;
  protected ConnectionManager connectionManager;

  protected BeatDao() {
    connectionManager = new ConnectionManager();
  }

  public static BeatDao getInstance() {
    if (instance == null) {
      instance = new BeatDao();
    }
    return instance;
  }

  public Beat create(Beat beat) throws SQLException {
    String insert =
        "INSERT INTO Beat(BeatName) " +
            "VALUES(?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insert,
          Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, beat.getBeatName());

      insertStmt.executeUpdate();

      resultKey = insertStmt.getGeneratedKeys();
      int beatId = -1;
      if (resultKey.next()) {
        beatId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      beat.setBeatId(beatId);
      return beat;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (insertStmt != null) {
        insertStmt.close();
      }
      if (resultKey != null) {
        resultKey.close();
      }
    }
  }

  public List<Beat> getAllBeat() throws SQLException {
    List<Beat> beats = new ArrayList<>();
    String selectBeats = "SELECT BeatID,BeatName FROM Beat;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectBeats);
      results = selectStmt.executeQuery();
      while(results.next()) {
        int beatId = results.getInt("BeatID");
        String beatName = results.getString("BeatName");
        Beat beat = new Beat(beatId, beatName);
        beats.add(beat);
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(selectStmt != null) {
        selectStmt.close();
      }
      if(results != null) {
        results.close();
      }
    }
    return beats;
  }

  public Beat getBeatById(int beatId) throws SQLException {
    String selectReviews =
        "SELECT BeatID,BeatName" +
            " FROM Beat" +
            " WHERE BeatID=?; ";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectReviews);
      selectStmt.setInt(1, beatId);
      results = selectStmt.executeQuery();
      if (results.next()) {
        int resultBeatID = results.getInt("BeatID");
        String beatName = results.getString("BeatName");

        Beat beat = Beat.builder().beatId(resultBeatID).beatName(beatName).build();
        return beat;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (selectStmt != null) {
        selectStmt.close();
      }
      if (results != null) {
        results.close();
      }
    }
    return null;
  }

  public Beat updateName(Beat beat, String newName)
      throws SQLException {
    String update = "UPDATE Beat SET BeatName=? WHERE BeatID=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(update);
      updateStmt.setString(1, newName);
      updateStmt.setLong(2, beat.getBeatId());
      updateStmt.executeUpdate();
      beat.setBeatName(newName);
      return beat;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (updateStmt != null) {
        updateStmt.close();
      }
    }
  }

  public Beat delete(Beat beat) throws SQLException {
    String delete = "DELETE FROM Beat WHERE BeatID = ?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(delete);
      deleteStmt.setInt(1, beat.getBeatId());
      deleteStmt.executeUpdate();
      // Return null so the caller can no longer operate on the BlogPosts instance.
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }
}

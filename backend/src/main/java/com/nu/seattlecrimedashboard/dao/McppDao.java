package com.nu.seattlecrimedashboard.dao;

import com.nu.seattlecrimedashboard.model.Mcpp;
import com.nu.seattlecrimedashboard.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class McppDao {

  private static McppDao instance = null;
  protected ConnectionManager connectionManager;

  protected McppDao() {
    connectionManager = new ConnectionManager();
  }

  public static McppDao getInstance() {
    if (instance == null) {
      instance = new McppDao();
    }
    return instance;
  }

  public List<Mcpp> getAllMcpp() throws SQLException {
    List<Mcpp> mcpps = new ArrayList<>();
    String selectMCPPs = "SELECT MCPPID,MCPPName FROM MCPP;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectMCPPs);
      results = selectStmt.executeQuery();
      while(results.next()) {
        int mcppId = results.getInt("MCPPID");
        String mcppName = results.getString("MCPPName");
        Mcpp mcpp = new Mcpp(mcppId, mcppName);
        mcpps.add(mcpp);
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
    return mcpps;
  }

  public Mcpp create(Mcpp mcpp) throws SQLException {
    String insert =
        "INSERT INTO MCPP(MCPPName) " +
            "VALUES(?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insert,
          Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, mcpp.getMcppName());

      insertStmt.executeUpdate();

      resultKey = insertStmt.getGeneratedKeys();
      int mcppId = -1;
      if (resultKey.next()) {
        mcppId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      mcpp.setMcppId(mcppId);
      return mcpp;
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

  public Mcpp getMcppById(int mcppId) throws SQLException {

    String selectReviews =
        "SELECT MCPPID,MCPPName" +
            " FROM MCPP" +
            " WHERE MCPPID=?; ";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectReviews);
      selectStmt.setInt(1, mcppId);
      results = selectStmt.executeQuery();
      if (results.next()) {
        int resultMcppID = results.getInt("MCPPID");
        String mcppName = results.getString("MCPPName");

        Mcpp mcpp = Mcpp.builder().mcppId(resultMcppID).mcppName(mcppName).build();

        return mcpp;
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


  public Mcpp updateName(Mcpp mcpp, String newName)
      throws SQLException {

    String update = "UPDATE MCPP SET MCPPName =? WHERE MCPPID =?; ";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(update);
      updateStmt.setString(1, newName);
      updateStmt.setLong(2, mcpp.getMcppId());

      updateStmt.executeUpdate();

      mcpp.setMcppName(newName);
      return mcpp;
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


  public Mcpp delete(Mcpp mcpp) throws SQLException {

    String delete = "DELETE FROM MCPP WHERE MCPPID=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(delete);
      deleteStmt.setInt(1, mcpp.getMcppId());
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

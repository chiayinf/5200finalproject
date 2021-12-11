package com.nu.seattlecrimedashboard.dao;

import com.nu.seattlecrimedashboard.model.Sector;
import com.nu.seattlecrimedashboard.util.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SectorDao {

  private static SectorDao instance = null;
  protected ConnectionManager connectionManager;

  protected SectorDao() {
    connectionManager = new ConnectionManager();
  }

  public static SectorDao getInstance() {
    if (instance == null) {
      instance = new SectorDao();
    }
    return instance;
  }

  public Sector create(Sector sector) throws SQLException {
    String insert =
        "INSERT INTO Sector(SectorName) " +
            "VALUES(?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insert,
          Statement.RETURN_GENERATED_KEYS);
      insertStmt.setString(1, sector.getSectorName());

      insertStmt.executeUpdate();

      resultKey = insertStmt.getGeneratedKeys();
      int sectorId = -1;
      if (resultKey.next()) {
        sectorId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      sector.setSectorId(sectorId);
      return sector;
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

  public List<Sector> getAllSector() throws SQLException {
    List<Sector> sectors = new ArrayList<>();
    String selectSectors = "SELECT SectorID,SectorName FROM Sector;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectSectors);
      results = selectStmt.executeQuery();
      while(results.next()) {
        int sectorId = results.getInt("SectorID");
        String sectorName = results.getString("SectorName");
        Sector sector = new Sector(sectorId, sectorName);
        sectors.add(sector);
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
    return sectors;
  }

  public Sector getSectorById(int sectorId) throws SQLException {

    String selectReviews =
        "SELECT SectorID, SectorName " +
            " FROM Sector" +
            " WHERE SectorID=?; ";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectReviews);
      selectStmt.setInt(1, sectorId);
      results = selectStmt.executeQuery();
      if (results.next()) {
        int resultSectorID = results.getInt("SectorID");
        String sectorName = results.getString("SectorName");

        Sector sector = Sector.builder().sectorId(resultSectorID).sectorName(sectorName).build();

        return sector;
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

  public Sector updateName(Sector sector, String newName)
      throws SQLException {

    String update = "UPDATE Sector SET SectorName=? WHERE SectorID=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(update);
      updateStmt.setString(1, newName);
      updateStmt.setLong(2, sector.getSectorId());

      updateStmt.executeUpdate();

      sector.setSectorName(newName);
      return sector;
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

  public Sector delete(Sector sector) throws SQLException {

    String delete = "DELETE FROM Sector WHERE SectorID=?; ";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(delete);
      deleteStmt.setInt(1, sector.getSectorId());
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

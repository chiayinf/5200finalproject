package com.nu.seattlecrimedashboard.service;

import com.nu.seattlecrimedashboard.dao.SectorDao;
import com.nu.seattlecrimedashboard.model.Sector;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class SectorService {
  public Sector getById(String id) throws SQLException {
    return SectorDao.getInstance().getSectorById(Integer.parseInt(id));
  }

  public List<Sector> getAllSector() throws SQLException {
    return SectorDao.getInstance().getAllSector();
  }

  public Sector add(String sectorName) throws SQLException {
    Sector sector = Sector.builder().sectorName(sectorName).build();
    return SectorDao.getInstance().create(sector);
  }

  public void update(String sectorId, String newName) throws SQLException {
    Sector sector = SectorDao.getInstance().getSectorById(Integer.parseInt(sectorId));
    SectorDao.getInstance().updateName(sector, newName);
  }

  public void delete(String sectorId) throws SQLException {
    Sector sector = Sector.builder().sectorId(Integer.parseInt(sectorId)).build();
    SectorDao.getInstance().delete(sector);
  }
}

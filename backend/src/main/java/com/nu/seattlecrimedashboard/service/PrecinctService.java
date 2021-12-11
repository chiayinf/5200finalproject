package com.nu.seattlecrimedashboard.service;

import com.nu.seattlecrimedashboard.dao.PrecinctDao;
import com.nu.seattlecrimedashboard.model.Precinct;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PrecinctService {
  public Precinct getById(String id) throws SQLException {
    return PrecinctDao.getInstance().getPrecinctById(Integer.parseInt(id));
  }

  public List<Precinct> getAllPrecinct() throws SQLException {
    return PrecinctDao.getInstance().getAllPrecinct();
  }

  public Precinct add(String precinctName) throws SQLException {
    Precinct precinct = Precinct.builder().precinctName(precinctName).build();
    return PrecinctDao.getInstance().create(precinct);
  }

  public void update(String precinctId, String newName) throws SQLException {
    Precinct precinct = PrecinctDao.getInstance().getPrecinctById(Integer.parseInt(precinctId));
    PrecinctDao.getInstance().updateName(precinct, newName);
  }

  public void delete(String precinctId) throws SQLException {
    Precinct precinct = Precinct.builder().precinctId(Integer.parseInt(precinctId)).build();
    PrecinctDao.getInstance().delete(precinct);
  }
}

package com.nu.seattlecrimedashboard.service;

import com.nu.seattlecrimedashboard.dao.McppDao;
import com.nu.seattlecrimedashboard.model.Mcpp;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class McppService {
  public Mcpp getById(String id) throws SQLException {
    return McppDao.getInstance().getMcppById(Integer.parseInt(id));
  }

  public List<Mcpp> getAllMcpp() throws SQLException {
    return McppDao.getInstance().getAllMcpp();
  }

  public Mcpp add(String mcppName) throws SQLException {
    Mcpp mcpp = Mcpp.builder().mcppName(mcppName).build();
    return McppDao.getInstance().create(mcpp);
  }

  public void update(String mcppId, String newName) throws SQLException {
    Mcpp mcpp = McppDao.getInstance().getMcppById(Integer.parseInt(mcppId));
    McppDao.getInstance().updateName(mcpp, newName);
  }

  public void delete(String mcppId) throws SQLException {
    Mcpp mcpp = Mcpp.builder().mcppId(Integer.parseInt(mcppId)).build();
    McppDao.getInstance().delete(mcpp);
  }
}

package com.nu.seattlecrimedashboard.service;

import com.nu.seattlecrimedashboard.dao.BeatDao;
import com.nu.seattlecrimedashboard.model.Beat;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BeatService {
  public Beat getById(String id) throws SQLException {
    return BeatDao.getInstance().getBeatById(Integer.parseInt(id));
  }

  public List<Beat> getAllBeat() throws SQLException {
    return BeatDao.getInstance().getAllBeat();
  }

  public Beat add(String beatName) throws SQLException {
    Beat beat = Beat.builder().beatName(beatName).build();
    return BeatDao.getInstance().create(beat);
  }

  public void update(String beatId, String newName) throws SQLException {
    Beat beat = BeatDao.getInstance().getBeatById(Integer.parseInt(beatId));
    BeatDao.getInstance().updateName(beat, newName);
  }

  public void delete(String beatId) throws SQLException {
    Beat beat = Beat.builder().beatId(Integer.parseInt(beatId)).build();
    BeatDao.getInstance().delete(beat);
  }
}

package com.nu.seattlecrimedashboard.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nu.seattlecrimedashboard.dao.mapper.OffenseDaoMapper;
import com.nu.seattlecrimedashboard.model.Offense;
import org.springframework.stereotype.Service;

@Service
public class OffenseService extends ServiceImpl<OffenseDaoMapper, Offense> {

  public Offense create(Offense offense) {
    save(offense);
    return offense;
  }
}

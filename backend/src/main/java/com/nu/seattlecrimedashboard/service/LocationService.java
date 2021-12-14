package com.nu.seattlecrimedashboard.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nu.seattlecrimedashboard.dao.mapper.LocationDaoMapper;
import com.nu.seattlecrimedashboard.model.Location;
import org.springframework.stereotype.Service;

@Service
public class LocationService extends ServiceImpl<LocationDaoMapper, Location> {


  public Location create(Location location) {
    save(location);
    return location;
  }
}

package com.nu.seattlecrimedashboard.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nu.seattlecrimedashboard.model.Location;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Mapper
public interface LocationDaoMapper extends BaseMapper<Location> {

}

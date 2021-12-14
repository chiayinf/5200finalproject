package com.nu.seattlecrimedashboard.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nu.seattlecrimedashboard.model.Offense;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OffenseDaoMapper extends BaseMapper<Offense> {

}

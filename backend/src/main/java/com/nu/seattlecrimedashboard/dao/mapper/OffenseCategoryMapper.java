package com.nu.seattlecrimedashboard.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nu.seattlecrimedashboard.model.Location;
import com.nu.seattlecrimedashboard.model.OffenseCategory;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OffenseCategoryMapper extends BaseMapper<OffenseCategory> {

}

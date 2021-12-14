package com.nu.seattlecrimedashboard.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.nu.seattlecrimedashboard.controller.vo.CimeCountCategoryVo;
import com.nu.seattlecrimedashboard.controller.vo.CimeCountYearlyVo;
import com.nu.seattlecrimedashboard.model.Offense;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OffenseDaoMapper extends BaseMapper<Offense> {

  List<CimeCountCategoryVo> analyzeCrimeCategoryCount(String start, String end);

  List<CimeCountYearlyVo> analyzeCrimeCategoryCountYearly(Integer offenseCategoryId);
}

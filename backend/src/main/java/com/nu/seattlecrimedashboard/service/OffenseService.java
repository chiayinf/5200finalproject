package com.nu.seattlecrimedashboard.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nu.seattlecrimedashboard.controller.vo.CimeCountCategoryVo;
import com.nu.seattlecrimedashboard.controller.vo.CimeCountYearlyVo;
import com.nu.seattlecrimedashboard.dao.mapper.OffenseDaoMapper;
import com.nu.seattlecrimedashboard.model.Offense;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class OffenseService extends ServiceImpl<OffenseDaoMapper, Offense> {

  @Resource
  private OffenseDaoMapper offenseDaoMapper;

  public Offense create(Offense offense) {
    save(offense);
    return offense;
  }

  public List<CimeCountCategoryVo> analyzeByCategory(int year) {
    String start = year + "-01-01";
    String end = year + "-12-31";
    List<CimeCountCategoryVo> offenseList = offenseDaoMapper.analyzeCrimeCategoryCount(start, end);
    return offenseList;
  }

  public List<CimeCountYearlyVo> analyzeByCategoryAndYear(Integer offenseCategoryId) {

    List<CimeCountYearlyVo> crimeCategoryCountYearlyList = offenseDaoMapper.analyzeCrimeCategoryCountYearly(offenseCategoryId);
    return crimeCategoryCountYearlyList;
  }


}

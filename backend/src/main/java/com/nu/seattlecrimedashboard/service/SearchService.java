package com.nu.seattlecrimedashboard.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.nu.seattlecrimedashboard.dao.mapper.RawMapper;
import com.nu.seattlecrimedashboard.model.Raw;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

  @Resource
  private RawMapper rawMapper;

  public List<Raw> searchByLocation(String MCPPName) {
    QueryWrapper<Raw> wrapper = new QueryWrapper<>();
    wrapper.eq("MCPP", MCPPName)
        .last("limit 100");
    return rawMapper.selectList(wrapper);
  }

  public List<Raw> searchByYear(String year) {
    QueryWrapper<Raw> wrapper = new QueryWrapper<>();
    wrapper.apply("YEAR(str_to_date(ReportDateTime, '%m/%d/%Y')) = " + year)
        .last("limit 100");
    return rawMapper.selectList(wrapper);
  }

  public List<Raw> searchByCrimeType(String crimeType) {
    QueryWrapper<Raw> wrapper = new QueryWrapper<>();
    wrapper.eq("CrimeAgainstCategory", crimeType)
        .last("limit 100");
    return rawMapper.selectList(wrapper);
  }

  public List<Raw> searchByTimeInterval(String interval) {
    String[] split = interval.split("-");
    QueryWrapper<Raw> wrapper = new QueryWrapper<>();
    wrapper.apply(
            "STR_TO_DATE(ReportDateTime, '%m/%d/%Y') > STR_TO_DATE('" + split[0] + "', '%m_%d_%Y')"
                + " and STR_TO_DATE(ReportDateTime, '%m/%d/%Y') < STR_TO_DATE('" + split[1] + "', '%m_%d_%Y')")
        .last("limit 100");
    return rawMapper.selectList(wrapper);
  }
}

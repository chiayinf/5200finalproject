package com.nu.seattlecrimedashboard.controller;

import com.nu.seattlecrimedashboard.controller.vo.CrimeReportVo;
import com.nu.seattlecrimedashboard.service.CrimeService;
import com.nu.seattlecrimedashboard.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.SQLException;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Crime")
@RestController
@CrossOrigin
@RequestMapping("/crime")
public class CrimeController {

  @Resource
  private CrimeService crimeService;

  @ApiOperation("创建新的crime 报告")
  @RequestMapping(value = "/new", method = RequestMethod.POST)
  public Response update(@RequestBody CrimeReportVo crimeReportVo) throws SQLException {
    crimeService.createCrimeReport(crimeReportVo);
    return Response.isSuccess();
  }


}

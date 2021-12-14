package com.nu.seattlecrimedashboard.controller;

import com.nu.seattlecrimedashboard.controller.vo.CrimeReportVo;
import com.nu.seattlecrimedashboard.model.OffenseCategory;
import com.nu.seattlecrimedashboard.service.CrimeService;
import com.nu.seattlecrimedashboard.service.OffenseCategoryService;
import com.nu.seattlecrimedashboard.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "OffenseCategory")
@RestController
@CrossOrigin
@RequestMapping("/offensecategory")
public class OffenseCategoryController {

  @Resource
  private OffenseCategoryService offenseCategoryService;

  @ApiOperation("获取所有犯罪类型列表")
  @RequestMapping(value = "/getAll", method = RequestMethod.GET)
  public Response getAll() throws SQLException {
    List<OffenseCategory> offenseCategoryList = offenseCategoryService.list();
    return Response.isSuccess().data(offenseCategoryList);
  }


}

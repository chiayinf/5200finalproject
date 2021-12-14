package com.nu.seattlecrimedashboard.controller;

import com.nu.seattlecrimedashboard.service.McppService;
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

@Api(tags = "Mcpp")
@RestController
@CrossOrigin
public class McppController {
  @Resource
  private McppService mcppService;

  @ApiOperation("根据id 获取Mcpp")
  @RequestMapping(value = "/mcpp/get/{id}", method = RequestMethod.GET)
  public Response getMcppById(@PathVariable("id") String id) throws SQLException {
    return Response.isSuccess().data(mcppService.getById(id));
  }

  @ApiOperation("获取所有Mcpp")
  @RequestMapping(value = "/mcpp/getAll", method = RequestMethod.GET)
  public Response getAllMcpp() throws SQLException {
    return Response.isSuccess().data(mcppService.getAllMcpp());
  }

  @ApiOperation("新增Mcpp")
  @RequestMapping(value = "/mcpp/add", method = RequestMethod.POST)
  public Response add(@RequestBody Map<String, String> params) throws SQLException {
    return Response.isSuccess().data(mcppService.add(params.get("mcppName")));
  }

  @ApiOperation("更新Mcpp")
  @RequestMapping(value = "/mcpp/update", method = RequestMethod.POST)
  public Response update(@RequestBody Map<String, String> params) throws SQLException {
    mcppService.update(params.get("mcppId"), params.get("mcppName"));
    return Response.isSuccess();
  }

  @ApiOperation("删除Mcpp")
  @RequestMapping(value = "/mcpp/delete", method = RequestMethod.POST)
  public Response delete(@RequestBody Map<String, String> params) throws SQLException {
    mcppService.delete(params.get("mcppId"));
    return Response.isSuccess();
  }
}

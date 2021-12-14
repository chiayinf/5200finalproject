package com.nu.seattlecrimedashboard.controller;

import com.nu.seattlecrimedashboard.service.CrimeService;
import com.nu.seattlecrimedashboard.service.SectorService;
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

@Api(tags = "Sector")
@RestController
@CrossOrigin
public class SectorController {
  @Resource
  private SectorService sectorService;


  @ApiOperation("根据id 获取sector")
  @RequestMapping(value = "/sector/get/{id}", method = RequestMethod.GET)
  public Response getMcppById(@PathVariable("id") String id) throws SQLException {
    return Response.isSuccess().data(sectorService.getById(id));
  }

  @ApiOperation("获取所有sector")
  @RequestMapping(value = "/sector/getAll", method = RequestMethod.GET)
  public Response getAllSector() throws SQLException {
    return Response.isSuccess().data(sectorService.getAllSector());
  }

  @ApiOperation("新增sector")
  @RequestMapping(value = "/sector/add", method = RequestMethod.POST)
  public Response add(@RequestBody Map<String, String> params) throws SQLException {
    return Response.isSuccess().data(sectorService.add(params.get("sectorName")));
  }

  @ApiOperation("更新sector")
  @RequestMapping(value = "/sector/update", method = RequestMethod.POST)
  public Response update(@RequestBody Map<String, String> params) throws SQLException {
    sectorService.update(params.get("sectorId"), params.get("sectorName"));
    return Response.isSuccess();
  }

  @ApiOperation("删除sector")
  @RequestMapping(value = "/sector/delete", method = RequestMethod.POST)
  public Response delete(@RequestBody Map<String, String> params) throws SQLException {
    sectorService.delete(params.get("sectorId"));
    return Response.isSuccess();
  }



}

package com.nu.seattlecrimedashboard.controller;

import com.nu.seattlecrimedashboard.service.BeatService;
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

@Api(tags = "Beat")
@RestController
@CrossOrigin
public class BeatController {
  @Resource
  private BeatService beatService;

  @ApiOperation("根据id 获取Beat")
  @RequestMapping(value = "/beat/get/{id}", method = RequestMethod.GET)
  public Response getMcppById(@PathVariable("id") String id) throws SQLException {
    return Response.isSuccess().data(beatService.getById(id));
  }

  @ApiOperation("获取所有Beat")
  @RequestMapping(value = "/beat/getAll", method = RequestMethod.GET)
  public Response getAllBeat() throws SQLException {
    return Response.isSuccess().data(beatService.getAllBeat());
  }

  @ApiOperation("新增Beat")
  @RequestMapping(value = "/beat/add", method = RequestMethod.POST)
  public Response add(@RequestBody Map<String, String> params) throws SQLException {
    return Response.isSuccess().data(beatService.add(params.get("beatName")));
  }

  @ApiOperation("更新Beat")
  @RequestMapping(value = "/beat/update", method = RequestMethod.POST)
  public Response update(@RequestBody Map<String, String> params) throws SQLException {
    beatService.update(params.get("beatId"), params.get("beatName"));
    return Response.isSuccess();
  }

  @ApiOperation("删除Beat")
  @RequestMapping(value = "/beat/delete", method = RequestMethod.POST)
  public Response delete(@RequestBody Map<String, String> params) throws SQLException {
    beatService.delete(params.get("beatId"));
    return Response.isSuccess();
  }
}

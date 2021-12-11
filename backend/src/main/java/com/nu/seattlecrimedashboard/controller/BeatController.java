package com.nu.seattlecrimedashboard.controller;

import com.nu.seattlecrimedashboard.service.BeatService;
import com.nu.seattlecrimedashboard.util.Response;
import java.sql.SQLException;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BeatController {
  @Resource
  private BeatService beatService;

  @RequestMapping(value = "/beat/get/{id}", method = RequestMethod.GET)
  public Response getMcppById(@PathVariable("id") String id) throws SQLException {
    return Response.isSuccess().data(beatService.getById(id));
  }

  @RequestMapping(value = "/beat/getAll", method = RequestMethod.GET)
  public Response getAllBeat() throws SQLException {
    return Response.isSuccess().data(beatService.getAllBeat());
  }

  @RequestMapping(value = "/beat/add", method = RequestMethod.POST)
  public Response add(@RequestBody Map<String, String> params) throws SQLException {
    return Response.isSuccess().data(beatService.add(params.get("beatName")));
  }

  @RequestMapping(value = "/beat/update", method = RequestMethod.POST)
  public Response update(@RequestBody Map<String, String> params) throws SQLException {
    beatService.update(params.get("beatId"), params.get("beatName"));
    return Response.isSuccess();
  }

  @RequestMapping(value = "/beat/delete", method = RequestMethod.POST)
  public Response delete(@RequestBody Map<String, String> params) throws SQLException {
    beatService.delete(params.get("beatId"));
    return Response.isSuccess();
  }
}

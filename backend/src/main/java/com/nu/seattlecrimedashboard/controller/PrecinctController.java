package com.nu.seattlecrimedashboard.controller;

import com.nu.seattlecrimedashboard.service.PrecinctService;
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
public class PrecinctController {
  @Resource
  private PrecinctService precinctService;

  @RequestMapping(value = "/precinct/get/{id}", method = RequestMethod.GET)
  public Response getMcppById(@PathVariable("id") String id) throws SQLException {
    return Response.isSuccess().data(precinctService.getById(id));
  }

  @RequestMapping(value = "/precinct/getAll", method = RequestMethod.GET)
  public Response getAllPrecinct() throws SQLException {
    return Response.isSuccess().data(precinctService.getAllPrecinct());
  }

  @RequestMapping(value = "/precinct/add", method = RequestMethod.POST)
  public Response add(@RequestBody Map<String, String> params) throws SQLException {
    return Response.isSuccess().data(precinctService.add(params.get("precinctName")));
  }

  @RequestMapping(value = "/precinct/update", method = RequestMethod.POST)
  public Response update(@RequestBody Map<String, String> params) throws SQLException {
    precinctService.update(params.get("precinctId"), params.get("precinctName"));
    return Response.isSuccess();
  }

  @RequestMapping(value = "/precinct/delete", method = RequestMethod.POST)
  public Response delete(@RequestBody Map<String, String> params) throws SQLException {
    precinctService.delete(params.get("precinctId"));
    return Response.isSuccess();
  }
}
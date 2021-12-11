package com.nu.seattlecrimedashboard.controller;

import com.nu.seattlecrimedashboard.service.SectorService;
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
public class SectorController {
  @Resource
  private SectorService sectorService;

  @RequestMapping(value = "/sector/get/{id}", method = RequestMethod.GET)
  public Response getMcppById(@PathVariable("id") String id) throws SQLException {
    return Response.isSuccess().data(sectorService.getById(id));
  }

  @RequestMapping(value = "/sector/getAll", method = RequestMethod.GET)
  public Response getAllSector() throws SQLException {
    return Response.isSuccess().data(sectorService.getAllSector());
  }

  @RequestMapping(value = "/sector/add", method = RequestMethod.POST)
  public Response add(@RequestBody Map<String, String> params) throws SQLException {
    return Response.isSuccess().data(sectorService.add(params.get("sectorName")));
  }

  @RequestMapping(value = "/sector/update", method = RequestMethod.POST)
  public Response update(@RequestBody Map<String, String> params) throws SQLException {
    sectorService.update(params.get("sectorId"), params.get("sectorName"));
    return Response.isSuccess();
  }

  @RequestMapping(value = "/sector/delete", method = RequestMethod.POST)
  public Response delete(@RequestBody Map<String, String> params) throws SQLException {
    sectorService.delete(params.get("sectorId"));
    return Response.isSuccess();
  }
}

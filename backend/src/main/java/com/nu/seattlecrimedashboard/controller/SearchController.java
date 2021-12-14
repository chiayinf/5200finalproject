package com.nu.seattlecrimedashboard.controller;


import com.nu.seattlecrimedashboard.service.SearchService;
import com.nu.seattlecrimedashboard.util.Response;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "Search")
@RestController
@CrossOrigin
@RequestMapping("/search")
public class SearchController {

  @Resource
  private SearchService searchService;

  @ApiOperation("Search by location (only MCPP)")
  @RequestMapping(value = "/location/{MCPPName}", method = RequestMethod.GET)
  public Response searchByLocation(@PathVariable("MCPPName") String MCPPName) {
    return Response.isSuccess().data(searchService.searchByLocation(MCPPName));
  }

  @ApiOperation("Search by year")
  @RequestMapping(value = "/year/{year}", method = RequestMethod.GET)
  public Response searchByYear(@PathVariable("year") String year) {
    return Response.isSuccess().data(searchService.searchByYear(year));
  }

  @ApiOperation("Search by crime type (PROPERTY or SOCIETY or PERSON)")
  @RequestMapping(value = "/type/{crimeType}", method = RequestMethod.GET)
  public Response searchByCrimeType(@PathVariable("crimeType") String crimeType) {
    return Response.isSuccess().data(searchService.searchByCrimeType(crimeType));
  }

  @ApiOperation("Search by time interval (format: m_d_y-m_d_y)")
  @RequestMapping(value = "/interval/{interval}", method = RequestMethod.GET)
  public Response searchByInterval(@PathVariable("interval") String interval) {
    return Response.isSuccess().data(searchService.searchByTimeInterval(interval));
  }
}

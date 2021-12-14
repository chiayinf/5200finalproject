package com.nu.seattlecrimedashboard.service;

import com.nu.seattlecrimedashboard.controller.vo.CrimeReportVo;
import com.nu.seattlecrimedashboard.model.GroupActionInformation;
import com.nu.seattlecrimedashboard.model.Location;
import com.nu.seattlecrimedashboard.model.Offense;
import java.sql.Timestamp;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrimeService {

  @Resource
  private LocationService locationService;

  @Resource
  private OffenseService offenseService;

  @Resource
  private GroupActionInformationService groupActionInformationService;


  @Transactional
  public void createCrimeReport(CrimeReportVo crimeReportVo) {

    // insert into location
    Location newLocation = Location.builder().beatId(crimeReportVo.getBeatId()).blockAddress(crimeReportVo.getBlockAddress())
        .precinctId(crimeReportVo.getPrecinctId()).sectorId(crimeReportVo.getSectorId()).mcppID(crimeReportVo.getMcppId()).build();
    locationService.save(newLocation);

    // insert into group action
    GroupActionInformation groupActionInformation = GroupActionInformation.builder().groupId(
        crimeReportVo.getGroupId()).sendTime(Timestamp.valueOf(crimeReportVo.getActionStartTime())).endTime(Timestamp.valueOf(crimeReportVo.getActionEndTime())).build();
    groupActionInformationService.save(groupActionInformation);

    // insert into offense
    Offense offense = Offense.builder().offenseCategoryId(crimeReportVo.getCrimeCategoryId()).offenseStartTime(Timestamp.valueOf(crimeReportVo.getCrimeStartTime()))
        .offenseEndTime(Timestamp.valueOf(crimeReportVo.getCrimeEndTime())).build();
    offenseService.save(offense);
    System.out.println("location: "+ newLocation.getLocationId() + " " + groupActionInformation.getActionId() + " " + offense.getOffenseId());


  }

}

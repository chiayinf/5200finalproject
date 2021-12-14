package com.nu.seattlecrimedashboard.controller.vo;

import java.sql.Date;
import java.sql.Timestamp;
import lombok.Data;

@Data
public class CrimeReportVo {
  private String crimeStartTime;
  private String crimeEndTime;
  private int crimeCategoryId;
  private int groupId;
  private String actionStartTime;
  private String actionEndTime;
  private String blockAddress;
  private int precinctId;
  private int sectorId;
  private int beatId;
  private int mcppId;

}

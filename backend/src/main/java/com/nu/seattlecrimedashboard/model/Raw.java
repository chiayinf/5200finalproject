package com.nu.seattlecrimedashboard.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("Raw")
public class Raw {
  @TableField("ReportNumber")
  private String reportNumber;
  @TableField("OffenceID")
  private String OffenceID;
  @TableField("OffenseStartDateTime")
  private String OffenseStartDateTime;
  @TableField("OffenseEndDateTime")
  private String OffenseEndDateTime;
  @TableField("ReportDateTime")
  private String ReportDateTime;
  @TableField("GroupName")
  private String GroupName;
  @TableField("CrimeAgainstCategory")
  private String CrimeAgainstCategory;
  @TableField("OffenseParentGroup")
  private String OffenseParentGroup;
  @TableField("Offense")
  private String Offense;
  @TableField("OffenseCode")
  private String OffenseCode;
  @TableField("Precinct")
  private String Precinct;
  @TableField("Sector")
  private String Sector;
  @TableField("Beat")
  private String Beat;
  @TableField("MCPP")
  private String MCPP;
  @TableField("100BlockAddress")
  private String BlockAddress;
  @TableField("Longitude")
  private String Longitude;
  @TableField("Latitude")
  private String Latitude;
}

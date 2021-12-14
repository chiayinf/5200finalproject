package com.nu.seattlecrimedashboard.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;

@Data
@Builder
@TableName("Location")
public class Location {

  @TableId(value = "LocationID", type = IdType.AUTO)
  private int locationId;

  @TableField("Longitude")
  private int longitude;
  @TableField("Latitude")
  private int latitude;
  @TableField("100BlockAddress")
  private String blockAddress;
  @TableField("PrecinctID")
  private int precinctId;
  @TableField("SectorID")
  private int sectorId;
  @TableField("BeatID")
  private int beatId;
  @TableField("MCPPID")
  private int mcppID;
}

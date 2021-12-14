package com.nu.seattlecrimedashboard.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.sql.Date;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@TableName("Offense")
public class Offense {
  @TableId(value = "OffenseID", type = IdType.AUTO)
  private int offenseId;
  @TableField("OffenseStartDateTime")
  private Timestamp offenseStartTime;
  @TableField("OffenseEndDateTime")
  private Timestamp offenseEndTime;
  @TableField("OffenseCategoryID")
  private int offenseCategoryId;
}

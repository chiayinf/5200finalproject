package com.nu.seattlecrimedashboard.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@TableName("OffenseCategory")
public class OffenseCategory {
  @TableId(value = "OffenseCategoryID", type = IdType.AUTO)
  private int offenseCategoryId;
  @TableField("OffenseCategoryName")
  private String offenseCategoryName;
  @TableField("OffenseContent")
  private String offenseContent;
  @TableField("OffenseCode")
  private String offenseCode;
}

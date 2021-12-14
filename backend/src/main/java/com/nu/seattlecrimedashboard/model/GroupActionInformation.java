package com.nu.seattlecrimedashboard.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@TableName("GroupActionInformation")
public class GroupActionInformation {
  @TableId(value = "ActionID", type = IdType.AUTO)
  private int actionId;
  @TableField("GroupID")
  private int groupId;
  @TableField("SendTime")
  private Timestamp sendTime;
  @TableField("EndTime")
  private Timestamp endTime;
}

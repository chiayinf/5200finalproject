package com.nu.seattlecrimedashboard.model;

import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GroupActionInformation {
  private int actionId;
  private int groupId;
  private Timestamp sendTime;
  private Timestamp endTime;
}

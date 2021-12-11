package com.nu.seattlecrimedashboard.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class OffenseCategory {
  private int offenseCategoryId;
  private String offenseCategoryName;
  private String offenseContent;
  private String offenseCode;
}

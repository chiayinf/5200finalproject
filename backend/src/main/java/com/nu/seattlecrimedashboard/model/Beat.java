package com.nu.seattlecrimedashboard.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Beat {
  private int beatId;
  private String beatName;
}

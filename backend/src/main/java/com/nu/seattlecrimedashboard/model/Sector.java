package com.nu.seattlecrimedashboard.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Sector {
  private int sectorId;
  private String sectorName;
}

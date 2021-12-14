package com.nu.seattlecrimedashboard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.nu.seattlecrimedashboard.dao.mapper")
@SpringBootApplication
public class SeattleCrimeDashboardApplication {

  public static void main(String[] args) {
    SpringApplication.run(SeattleCrimeDashboardApplication.class, args);
  }

}

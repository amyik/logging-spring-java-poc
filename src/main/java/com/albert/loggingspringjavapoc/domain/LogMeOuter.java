package com.albert.loggingspringjavapoc.domain;

import lombok.Data;

@Data
public class LogMeOuter {

  private String name = "I am LogMeOuter";
  private LogMeInner logMeInner;
  private LogMeInner nullLogMeInner = null;
}

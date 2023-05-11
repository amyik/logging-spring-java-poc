package com.albert.loggingspringjavapoc;

import com.albert.loggingspringjavapoc.aop.Loggable;
import com.albert.loggingspringjavapoc.domain.LogMeOuter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Loggable
@Slf4j
@Service
public class LoggingService {

  public void logMe(LogMeOuter logMeOuter) {
    log.debug("inside LoggingService.logMe");
  }

}

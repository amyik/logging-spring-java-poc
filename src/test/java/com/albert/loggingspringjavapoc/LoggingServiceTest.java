package com.albert.loggingspringjavapoc;

import com.albert.loggingspringjavapoc.domain.LogMeInner;
import com.albert.loggingspringjavapoc.domain.LogMeOuter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class LoggingServiceTest {

  @Autowired
  LoggingService loggingService;

  @Test
  void LoggableAnnotationShouldWork() {

    LogMeInner logMeInner = new LogMeInner();
    LogMeOuter logMeOuter = new LogMeOuter();
    logMeOuter.setLogMeInner(logMeInner);

    loggingService.logMe(logMeOuter);
  }
}
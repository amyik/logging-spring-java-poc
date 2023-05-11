package com.albert.loggingspringjavapoc.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  private final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

  @Before("@within(Loggable)")
  public void logMethodCall(JoinPoint joinPoint) {
    String methodName = joinPoint.getSignature().getName();
    String className = joinPoint.getTarget().getClass().getSimpleName();
    Object[] arguments = joinPoint.getArgs();

    StringBuilder argumentsString = new StringBuilder();
    for (Object arg : arguments) {
      argumentsString.append(arg).append(", ");
    }

    if (argumentsString.length() > 0) {
      argumentsString.setLength(argumentsString.length() - 2);
    }

    //argument의 toString을 logging한다.
    logger.info("Calling {}.{} with arguments: {}", className, methodName, argumentsString);
  }

  @AfterReturning(value = "@within(Loggable)", returning = "result")
  public void logMethodReturn(JoinPoint joinPoint, Object result) {
    String methodName = joinPoint.getSignature().getName();
    String className = joinPoint.getTarget().getClass().getSimpleName();
    logger.info("Finished {}.{} with result: {}", className, methodName, result);
  }
}

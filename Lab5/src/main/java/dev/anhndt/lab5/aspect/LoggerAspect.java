package dev.anhndt.lab5.aspect;

import dev.anhndt.lab5.entity.Logger;
import dev.anhndt.lab5.entity.Exception;
import dev.anhndt.lab5.logger.ExceptionService;
import dev.anhndt.lab5.logger.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Aspect
@Component
public class LoggerAspect {

    @Autowired
    LoggerService loggerService;

    @Autowired
    ExceptionService exceptionService;


    @After("execution(* dev.anhndt.lab5.service.*.*(..))")
    public void logAfterMethodExecution(JoinPoint joinPoint) {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();

        // Format date
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = now.format(formatterDate);

        // Format time
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(formatterTime);

        var logger = new Logger();
        logger.setOperation(joinPoint.getSignature().getName());
        logger.setDate(formattedDate);
        logger.setTime(formattedTime);
        logger.setPrinciple("Guest");
        loggerService.save(logger);
    }

    @AfterThrowing(pointcut = "execution(* dev.anhndt.lab5.service.*.*(..))", throwing = "throwable")
    public void logAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();

        // Format date
        DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = now.format(formatterDate);

        // Format time
        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = now.format(formatterTime);
        var exception = new Exception();
        exception.setDate(formattedDate);
        exception.setTime(formattedTime);
        exception.setPrinciple("Guest");
        exception.setOperation(joinPoint.getSignature().getName());
        exception.setException_type(throwable.getClass().getSimpleName());

        exceptionService.logException(exception);
    }

}

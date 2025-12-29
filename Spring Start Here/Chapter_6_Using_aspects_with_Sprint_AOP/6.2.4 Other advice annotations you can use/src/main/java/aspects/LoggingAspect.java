package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.logging.Logger;

@Aspect
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class.getName());

    @Around("@annotation(annotations.ToLog)")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.info("Logginh Aspect: Calling the intercepted method");

        Object returnValue = joinPoint.proceed();
        logger.info("Logging Aspect: Method executed and returned: " + returnValue);
        return returnValue;

    }

}

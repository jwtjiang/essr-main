package scheduled.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 切面做接口日志收集
 * Created by Administrator on 2019/7/22.
 */
@Aspect
@Component
public class LogAop {
    private static final Logger log = LoggerFactory.getLogger(LogAop.class);

    private static final String EXECUTION = "execution(* eley.controller..*.*(..))";

    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Before(EXECUTION)
    public void beforeTime(JoinPoint joinPoint){
        startTime.set(System.currentTimeMillis());
        log.info("我是方法调用前的时间戳--------"+System.currentTimeMillis());
    }

    @SuppressWarnings("unchecked")
    @After(EXECUTION)
    public void afterTime(JoinPoint joinPoint){
        Long time = System.currentTimeMillis();
        log.info("我是方法调用之后的时间戳---------"+time);
        log.info("我是方法调用总耗时：---------"+(time-startTime.get()));
    }
}

package cn.zmhappy.missiondemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MissionAspect {

//    @Pointcut("execution(public * cn.zmhappy.missiondemo.service.impl.MissionServiceImpl.*(..))")
//    public void executeMethod(){
//
//    }
//
//    @Before("executeMethod()")
//    public void doBeforeFindList() {
//        System.out.println("Before findList()");
//    }

}

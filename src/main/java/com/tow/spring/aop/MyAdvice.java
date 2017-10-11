package com.tow.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import static java.lang.System.out;

@Component("myAdvice")
@Aspect
public class MyAdvice {
    @Pointcut("execution(* com.tow.spring.aop.MyDependency..foo*(int)) && args(intValue)")
    public void fooExecution(int intValue) {

    }

    @Pointcut("bean(myDependency)")
    public void inMyDependency() {
    }

    @Before("fooExecution(intValue) && com.tow.spring.aop.MyAdvice.inMyDependency()")
    public void simpleBeforeAdvice(JoinPoint joinPoint, int intValue) {
        if (intValue != 100) {
            out.println("Executiong: " + joinPoint.getSignature().getDeclaringTypeName() + " " + joinPoint.getSignature().getName() + " arguments: " + intValue);
        }
    }

    @Around("fooExecution(intValue) && com.tow.spring.aop.MyAdvice.inMyDependency()")
    public Object simpleAroundAdvice(ProceedingJoinPoint pjp, int intValue) throws Throwable {
        out.println("Before execution: " + pjp.getSignature().getDeclaringType() + " " + pjp.getSignature().getName() + " argument: " + intValue);
        Object retVal = pjp.proceed();
        out.println("After execution: " + pjp.getSignature().getDeclaringTypeName() + " " + pjp.getSignature().getName() + " argument: " + intValue);
        return retVal;
    }
}

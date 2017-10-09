package com.tow.spring.aop;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

public class AspectexpPointcutExample {
    public static void main(String[] args) {
        AspectjexpBean target = new AspectjexpBean();

        AspectJExpressionPointcut pc = new AspectJExpressionPointcut();
        pc.setExpression("execution(* foo*(..))");
        Advisor advisor = new DefaultPointcutAdvisor(pc, new SimpleAdvice());

        ProxyFactory factory = new ProxyFactory();
        factory.addAdvisor(advisor);
        factory.setTarget(target);

        AspectjexpBean proxy = (AspectjexpBean) factory.getProxy();

        proxy.foo1();
        proxy.foo2();
        proxy.bar();
    }
}

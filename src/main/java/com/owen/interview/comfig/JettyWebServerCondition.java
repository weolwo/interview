package com.owen.interview.comfig;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class TomatWebServerCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        try {
            context.getClass().getClassLoader().loadClass("org.apache.catalina.startup.Tomcat");
        } catch (ClassNotFoundException e) {
            return false;
        }
        return true;
    }
}

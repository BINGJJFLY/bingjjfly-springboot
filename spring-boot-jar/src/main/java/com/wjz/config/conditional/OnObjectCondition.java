package com.wjz.config.conditional;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.core.type.ClassMetadata;
import org.springframework.core.type.MethodMetadata;

/**
 * @Conditional注解原理
 */
public class OnObjectCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        String name = getClassOrMethodName(annotatedTypeMetadata);
        System.out.println("OnObjectCondition - " + name);
        Environment environment = conditionContext.getEnvironment();
        System.out.println("OnObjectCondition - " + environment.getProperty("http.encoding"));
        return true;
    }

    private String getClassOrMethodName(AnnotatedTypeMetadata annotatedTypeMetadata) {
        if (annotatedTypeMetadata instanceof ClassMetadata) {
            return ((ClassMetadata) annotatedTypeMetadata).getClassName();
        } else {
            MethodMetadata methodMetadata = (MethodMetadata) annotatedTypeMetadata;
            return methodMetadata.getDeclaringClassName() + "#" + methodMetadata.getMethodName();
        }
    }

}

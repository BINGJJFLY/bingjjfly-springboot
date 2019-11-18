package com.wjz.springboot.features.failureAnalyzer;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.boot.diagnostics.AbstractFailureAnalyzer;
import org.springframework.boot.diagnostics.FailureAnalysis;
import org.springframework.boot.diagnostics.FailureAnalyzer;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class IFailureAnalyzer extends AbstractFailureAnalyzer<IllegalArgumentException> implements BeanFactoryAware, EnvironmentAware {

    private BeanFactory beanFactory;
    private Environment environment;

    @Override
    protected FailureAnalysis analyze(Throwable rootFailure, IllegalArgumentException cause) {
        String desc = "argument is illegal.";
        String action = "check your argument.";
        return new FailureAnalysis(desc, action, cause);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}

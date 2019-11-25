package com.wjz.configuration.impt;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

public class IRegistrar implements ImportBeanDefinitionRegistrar {

    @Override
    public void registerBeanDefinitions(AnnotationMetadata annotationMetadata, BeanDefinitionRegistry beanDefinitionRegistry) {
        if (!beanDefinitionRegistry.containsBeanDefinition(IBean.class.getName())) {
            GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
            beanDefinition.setBeanClass(IBean.class);
            beanDefinition.getConstructorArgumentValues().addIndexedArgumentValue(0, "last-name");
            beanDefinitionRegistry.registerBeanDefinition(IBean.class.getName(), beanDefinition);
        }
    }
}

package com.wjz.config.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.boot.env.OriginTrackedMapPropertySource;
import org.springframework.boot.env.PropertiesPropertySourceLoader;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Map;

public class EnvironmentPostProcessorExample implements EnvironmentPostProcessor, Ordered {

    public static final int DEFAULT_ORDER = Ordered.HIGHEST_PRECEDENCE + 100;
    private int order = DEFAULT_ORDER;
    private final PropertiesPropertySourceLoader loader = new PropertiesPropertySourceLoader();

    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        Resource path = new ClassPathResource("encrypting.properties");
        PropertySource<Map<String, Object>> propertySource = loadProperties(path);
        environment.getPropertySources().addLast(propertySource);
    }

    private PropertySource<Map<String, Object>> loadProperties(Resource path) {
        if (!path.exists()) {
            throw new IllegalArgumentException("Resource " + path + "does not exist");
        }
        try {
            return new DecryptedMapPropertySource((OriginTrackedMapPropertySource) loader.load("custom-resource", path).get(0));
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load properties configuration from " + path, e);
        }
    }

    private static class DecryptedMapPropertySource extends MapPropertySource {

        public DecryptedMapPropertySource(OriginTrackedMapPropertySource propertySource) {
            super(propertySource.getName(), propertySource.getSource());
        }

        @Override
        public Object getProperty(String name) {
            Object val = super.getProperty(name);
            if ("db.password".equals(name)) {
                return "DecryptedValue";
            }
            return val;
        }
    }

    @Override
    public int getOrder() {
        return order;
    }
}

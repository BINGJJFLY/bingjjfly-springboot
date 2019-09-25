package com.wjz.config.validator;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix = "validator")
@Validated
public class SampleProperties {

    /**
     * Sample host.
     */
    private String host;

    /**
     * Sample port.
     */
    private Integer port = 8080;

    public String getHost() {
        return this.host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Integer getPort() {
        return this.port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

}
package com.wjz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DataSizeUnit;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.util.unit.DataSize;
import org.springframework.util.unit.DataUnit;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 主配置文件映射Bean，属性类型测试
 */
@ConfigurationProperties(
        prefix = "boot.email"
)
@Validated
public class EmailProperties {

    @NotNull
    private String power;
    private EmailType type;
    @Valid
    private QQ qq = new QQ();
    private List<String> dreams = new ArrayList<>();
    private Date time;
    @DurationUnit(ChronoUnit.SECONDS)
    private Duration sessionTimeout = Duration.ofSeconds(30);
    @DataSizeUnit(DataUnit.MEGABYTES)
    private DataSize bufferSize = DataSize.ofMegabytes(2);


    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public EmailType getType() {
        return type;
    }

    public void setType(EmailType type) {
        this.type = type;
    }

    public QQ getQq() {
        return qq;
    }

    public List<String> getDreams() {
        return dreams;
    }

    public void setDreams(List<String> dreams) {
        this.dreams = dreams;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Duration getSessionTimeout() {
        return this.sessionTimeout;
    }

    public void setSessionTimeout(Duration sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public DataSize getBufferSize() {
        return bufferSize;
    }

    public void setBufferSize(DataSize bufferSize) {
        this.bufferSize = bufferSize;
    }

    public static class QQ {
        @NotEmpty
        private String lastName;

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}

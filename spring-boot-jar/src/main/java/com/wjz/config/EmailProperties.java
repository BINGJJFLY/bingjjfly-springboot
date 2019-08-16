package com.wjz.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 主配置文件映射Bean，属性类型测试
 */
@ConfigurationProperties(
        prefix = "boot.email"
)
public class EmailProperties {

    private String power;
    private EmailType type;
    private QQ qq = new QQ();
    private List<String> dreams = new ArrayList<>();
    private Date time;

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

    public void setQq(QQ qq) {
        this.qq = qq;
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

    static class QQ {
        private String lastName;

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }
    }
}

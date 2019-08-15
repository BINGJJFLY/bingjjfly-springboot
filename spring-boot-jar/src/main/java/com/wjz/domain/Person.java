package com.wjz.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 将配置中的属性映射至该组件，该类须为Spring中的组件
 * @ConfigurationProperties告诉SpringBoot将类中的属性和配置文件中的属性进行绑定，默认映射全局配置文件
 *      prefix/value：指定配置文件中的哪个属性
 */
@Component
@ConfigurationProperties("person")
@PropertySource({"classpath:person.properties"})
public class Person {

    private String lastName;
    private Integer age;
    private Boolean man;
    private Date birthday;
    private Dog dog;
    private Map<String, Object> kvs;
    private List<Object> items;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getMan() {
        return man;
    }

    public void setMan(Boolean man) {
        this.man = man;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Map<String, Object> getKvs() {
        return kvs;
    }

    public void setKvs(Map<String, Object> kvs) {
        this.kvs = kvs;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", man=" + man +
                ", birthday=" + birthday +
                ", dog=" + dog +
                ", kvs=" + kvs +
                ", items=" + items +
                '}';
    }
}

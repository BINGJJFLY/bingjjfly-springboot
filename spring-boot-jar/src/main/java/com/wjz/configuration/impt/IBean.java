package com.wjz.configuration.impt;

public class IBean {
    private String firstName;
    private String lastName;

    public IBean() {
        this.firstName = "first-name";
    }

    public IBean(String lastName) {
        this.lastName = lastName;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }
}

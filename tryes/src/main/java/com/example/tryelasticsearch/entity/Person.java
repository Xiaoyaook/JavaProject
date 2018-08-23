package com.example.tryelasticsearch.entity;

/**
 * created by xiaoyaook on 18-8-22
 */
public class Person {
    private String personId;
    private String name;

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId='" + personId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

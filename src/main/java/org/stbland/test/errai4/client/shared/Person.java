package org.stbland.test.errai4.client.shared;

import org.jboss.errai.common.client.api.annotations.Portable;

@Portable
public class Person {

    private Integer id;
    private String firstName;
    private String lastName;

    public Person() {
    }

    public Person(Integer id, String firstName, String lastName) {
        this();
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}

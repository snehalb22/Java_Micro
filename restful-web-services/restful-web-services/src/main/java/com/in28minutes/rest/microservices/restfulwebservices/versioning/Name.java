package com.in28minutes.rest.microservices.restfulwebservices.versioning;

public class Name {


    private String firstName;
    private String lastname;

    public Name(String firstName, String lastname) {
        this.firstName = firstName;
        this.lastname = lastname;
    }
    public String getFirstName() {
        return firstName;
    }

    public String getLastname() {
        return lastname;
    }

}

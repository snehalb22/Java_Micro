package com.in28minutes.rest.microservices.restfulwebservices.versioning;

public class PersonV1 {

    private String Name;

    public PersonV1(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

}

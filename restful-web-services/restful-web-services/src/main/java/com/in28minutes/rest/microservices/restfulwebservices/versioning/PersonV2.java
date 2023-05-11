package com.in28minutes.rest.microservices.restfulwebservices.versioning;

public class PersonV2 {

    private Name name;
    public PersonV2(Name name) {
        this.name = name;
    }

    public Name getName() {
        return name;
    }
}

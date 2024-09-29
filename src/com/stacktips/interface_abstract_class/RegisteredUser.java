package com.stacktips.interface_abstract_class;

public class RegisteredUser implements User {

    private final String name;

    public RegisteredUser(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void update(Document document) {
        System.out.println("User " + name
                + " notified of document update: " + document.getContent());
    }
}

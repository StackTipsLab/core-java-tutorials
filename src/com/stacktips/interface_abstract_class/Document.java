package com.stacktips.interface_abstract_class;

public abstract class Document {

    private String title;

    public abstract void addContent(String content);

    public abstract String getContent();

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
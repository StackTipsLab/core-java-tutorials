package com.stacktips.interface_abstract_class;

public class TextDocument extends Document {

    private final StringBuilder content = new StringBuilder();

    @Override
    public void addContent(String content) {
        this.content.append(content);
    }

    @Override
    public String getContent() {
        return content.toString();
    }
}
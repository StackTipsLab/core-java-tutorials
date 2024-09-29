package com.stacktips.collections.queue;

import java.util.ArrayDeque;

public class TextEditor {
    private StringBuilder text;
    private ArrayDeque<String> undoStack;
    private ArrayDeque<String> redoStack;

    public TextEditor() {
        text = new StringBuilder();
        undoStack = new ArrayDeque<>();
        redoStack = new ArrayDeque<>();
    }

    public void appendText(String newText) {
        undoStack.push(text.toString());
        redoStack.clear();
        text.append(newText);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(text.toString());
            text = new StringBuilder(undoStack.pop());
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(text.toString());
            text = new StringBuilder(redoStack.pop());
        }
    }

    public String getText() {
        return text.toString();
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        editor.appendText("Hello");
        editor.appendText(", World!");
        System.out.println("Current Text: " + editor.getText());

        editor.undo();
        System.out.println("After Undo: " + editor.getText());

        editor.redo();
        System.out.println("After Redo: " + editor.getText());

        editor.undo();
        editor.undo();
        System.out.println("After two Undos: " + editor.getText());
    }
}

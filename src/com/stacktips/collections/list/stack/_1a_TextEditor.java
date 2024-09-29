package com.stacktips.collections.list.stack;

import java.util.Stack;

public class _1a_TextEditor {
    private final Stack<String> textStack = new Stack<>();
    private final Stack<String> undoStack = new Stack<>();

    public void type(String text) {
        textStack.push(text);
        undoStack.clear();
    }

    public void undo() {
        if (!textStack.isEmpty()) {
            String lastText = textStack.pop();
            undoStack.push(lastText);
        } else {
            System.out.println("Nothing to undo.");
        }
    }

    public void redo() {
        if (!undoStack.isEmpty()) {
            String lastUndoText = undoStack.pop();
            textStack.push(lastUndoText);
        } else {
            System.out.println("Nothing to redo.");
        }
    }

    public void display() {
        System.out.println("Current Text: " + String.join("", textStack));
    }

    public static void main(String[] args) {
        _1a_TextEditor editor = new _1a_TextEditor();
        editor.type("Hello, ");
        editor.type("world!");
        editor.display();

        editor.undo();
        editor.display();

        editor.redo();
        editor.display();

        editor.undo();
        editor.undo();
        editor.display();

        editor.redo();
        editor.display();


    }
}


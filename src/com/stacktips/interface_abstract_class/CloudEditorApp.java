package com.stacktips.interface_abstract_class;

/**
 * Imagine a collaborative online document editing platform where multiple users
 * can work on a document simultaneously.
 *
 */
public class CloudEditorApp {

    public static void main(String[] args) {
        Document document = new TextDocument();
        document.setTitle("Collaborative Document");

        CollaborationService service = new CollaborationServiceImpl(document);
        User user1 = new RegisteredUser("Alice");
        User user2 = new RegisteredUser("Bob");

        service.addUser(user1, document);
        service.addUser(user2, document);

        document.addContent("Hello, world!");
        service.broadcastUpdate(document);
    }
}
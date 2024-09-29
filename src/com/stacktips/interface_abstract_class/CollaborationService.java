package com.stacktips.interface_abstract_class;

public interface CollaborationService {

    void addUser(User user, Document document);

    void removeUser(User user, Document document);

    void broadcastUpdate(Document document);
}
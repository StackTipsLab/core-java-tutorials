package com.stacktips.interface_abstract_class;

import java.util.ArrayList;
import java.util.List;

public class CollaborationServiceImpl implements CollaborationService {

    private final List<User> users = new ArrayList<>();
    private final Document document;

    public CollaborationServiceImpl(Document document) {
        this.document = document;
    }

    @Override
    public void addUser(User user, Document document) {
        if (this.document == document) {
            users.add(user);
        } else {
            throw new IllegalArgumentException("User cannot be added to a different document");
        }
    }

    @Override
    public void removeUser(User user, Document document) {
        if (this.document == document) {
            users.remove(user);
        } else {
            throw new IllegalArgumentException("User cannot be removed from a different document");
        }
    }

    @Override
    public void broadcastUpdate(Document document) {
        if (this.document == document) {
            for (User user : users) {
                user.update(document);
            }
        } else {
            throw new IllegalArgumentException("Cannot broadcast update for a different document");
        }
    }
}
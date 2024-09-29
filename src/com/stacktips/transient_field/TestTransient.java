package com.stacktips.transient_field;

import java.io.*;

public class TestTransient {

    public static void main(String[] args) {
        User user = new User("john_doe", "password123");

        // Serialization
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.txt"))) {
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.txt"))) {
            User deserializedUser = (User) ois.readObject();
            System.out.println(deserializedUser); // Password will be null
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
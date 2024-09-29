package com.stacktips.exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

public class FileReader {

    private StringBuilder readFile(String filePath) {

        try {
            Path path = validateFilePath(filePath);
            return readFileLineByLine(path);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private Path validateFilePath(String filePath) throws FileNotFoundException {
        Path path = Paths.get(filePath);
        if (!path.toFile().exists()) {
            throw new FileNotFoundException(filePath);
        }
        return path;
    }

    public StringBuilder readFileLineByLine(Path path) {
        StringBuilder content = null;

        try {
            BufferedReader br = Files.newBufferedReader(path);
            content = new StringBuilder();
            String line;

            if ((br.readLine()) == null) {
                throw new EmptyFileException("This file is empty");
            } else {
                while ((line = br.readLine()) != null) {
                    content.append(line);
                    content.append(System.lineSeparator());
                }
            }
        } catch (NoSuchFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Unable to read file: " + e.getMessage());
        }

        return content;
    }

    public static void main(String[] args) {
        System.out.println("Enter the path to the file");
        Scanner scanner = new Scanner(System.in);
        FileReader fileReader = new FileReader();
        StringBuilder content = fileReader.readFile(scanner.next());
        System.out.println(content);
    }
}
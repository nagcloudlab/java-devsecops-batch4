package com.npci;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class How_To_Build_Stream {
    public static void main(String[] args) throws IOException {

        // data sources
        // values | arrays | collections | I/O e.g files | database | kafka | etc.

        // way-1: values
        Stream.of("Java", "Python", "JavaScript", "C++", "C#")
                .forEach(System.out::println);

        System.out.println("-----");
        // way-2: arrays
        String[] languages = {"Java", "Python", "JavaScript", "C++", "C#"};
        Stream.of(languages)
                .forEach(System.out::println);

        System.out.println("-----");
        // way-3: collection ( most common way )
        java.util.List<String> languageList = java.util.List.of("Java", "Python", "JavaScript", "C++", "C#");
        languageList.stream()
                .forEach(System.out::println);

        System.out.println("-----");
        // way-4: I/O (e.g., reading from a file)
        Files.lines(Path.of("/Users/nag/java-devsecops-batch4/week2/functional-programming/languages.txt"))
                .forEach(System.out::println);
    }
}

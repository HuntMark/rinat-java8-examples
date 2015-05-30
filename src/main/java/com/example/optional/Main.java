package com.example.optional;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String str1 = "a";
        String defStr = "def";
        Optional<String> optional = Optional.ofNullable(str1);
        optional.ifPresent(System.out::println);
        System.out.println(optional.orElse(defStr).length());
    }

}

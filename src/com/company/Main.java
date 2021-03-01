package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
	// Exercise-1
        StringBuilder hello = new StringBuilder();
        String[] strArray = {"hello","world","radar","math","kayak","bank","rotor"};
        hello.append("h");
        hello.append("e");
        hello.append("l");
        hello.append("l");
        hello.append("o");

        StringBuilder strHelper = new StringBuilder();
        for (String str:strArray) {
            strHelper.append(str).reverse();
            if (str.equals(strHelper.toString())){
                System.out.println(str);
            }
            strHelper.setLength(0);
        }

        // Exercise-2
        String nameAndAge = String.format("%s %d", "Zion", 39);
        System.out.println(nameAndAge);
        System.out.printf("%s %d", "Zion", 39);
        // The biggest concern using String format is:
        // getting an IllegalFormatException at runtime that might break production

        // Exercise-3
        for (String str:strArray) {
            if (Pattern.matches(".*a.*",str)){
                System.out.println(str);
            }
        }

        // Exercise-4
        // Java Generic methods and generic classes enable programmers to specify, with a single method declaration,
        // a set of related methods, or with a single class declaration, a set of related types, respectively.

        // Exercise-5
        printType(1);
        printType("a");
        printType(1.25);
        printType(true);

        // Exercise-6
        // There is code duplication.
        // There is a logic mistake in calculate2: if d is bigger than 2, it's bigger than 1
        // The main only uses one method

        // Exercise-7
        System.out.println("Dictionary".indexOf("a"));
        System.out.println("Dictionary".replace("a","x"));

        // Exercise-8
        Method[] methods = String.class.getDeclaredMethods();
        System.out.println("Amount of public method in String class : "+ methods.length);
        for (Method method:methods) {
            System.out.println(method.getName());
        }

        // Exercise-9
        try {
            Constructor<User> userConstructor = User.class.getConstructor(String.class);
            User user = userConstructor.newInstance("Zion");
            Method userMethod = User.class.getDeclaredMethod("getName");
            userMethod.setAccessible(true);
            System.out.println(userMethod.invoke(user));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        // Exercise-10
        String sentence = "The dog says meow. All dogs say meow.";
        System.out.println(sentence.replaceAll("dog","cat"));
    }

    public static <T> void printType(T toType){
        System.out.println(toType);
    }
}

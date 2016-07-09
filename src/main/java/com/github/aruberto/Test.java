package com.github.aruberto;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class Test {

    public static void someFunction(SomeUtilClass util) {

        // This fails indentation rule
        util.myLambdaUtil(
                "FIRST_ARG",
                (string) -> System.out.println(string.trim()),
                "SECOND_ARG",
                () -> "WHAT WHAT!"
        );

        // This passes indentation rule
        util.myLambdaUtil(
                "FIRST_ARG",
            (string) -> System.out.println(string.trim()),
                "SECOND_ARG",
            () -> "WHAT WHAT!"
        );

        // This fails indentation rule
        Function<String, String> someFunction1 =
                (string) -> {
                    if (string.contains("abc")) {
                        return "SWEET!";
                    } else if (string.contains("123")) {
                        return "COOL!";
                    } else {
                        return "BOO!";
                    }
                };

        // This passes indentation rule
        Function<String, String> someFunction2 =
        (string) -> {
            if (string.contains("abc")) {
                return "SWEET!";
            } else if (string.contains("123")) {
                return "COOL!";
            } else {
                return "BOO!";
            }
        };
    }

    interface SomeUtilClass {

        void myLambdaUtil(String firstArg,
                          Consumer<String> firstLambda,
                          String secondArg,
                          Supplier<String> secondLambda);
    }
}

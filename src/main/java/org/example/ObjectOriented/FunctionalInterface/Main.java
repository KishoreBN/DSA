package org.example.ObjectOriented.FunctionalInterface;

import java.security.Provider;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Java provides built-in functional interfaces like Predicate, Consumer, Supplier, Function.
 */
public class Main {
    static int[] nums = {3,2,1};
    public static void main(String[] args) {
        /**
         * Predicate is a function which takes one argument and returns the boolean value.
         */
        Predicate<String> isGreaterThan5 = str -> str.length() > 5;
        System.out.println(isGreaterThan5.test("HelloWorld"));

        /**
         * Consumer is a function which takes one argument and returns nothing (void).
         */
        Consumer<int[]> iterator = (arr) ->{
            System.out.print("[ ");
          for(int i : arr)
              System.out.print(i + " ");
            System.out.print("]");
        };
        int[] arr = {1,2,3};
        iterator.accept(arr);

        /**
         * Supplier is a function which does not take any argument, but returns an object/primitive.
         */
        Supplier<int[]> sorted = () -> {
            Arrays.sort(nums);
            return arr;
        };
        System.out.println(Arrays.toString(sorted.get()));

        /**
         * Functions is an interface which accepts one argument and returns a value.
         */
        Function<String, Integer> getLength = (str) -> str.length();
        System.out.println(getLength.apply("HelloWorld"));
    }
}

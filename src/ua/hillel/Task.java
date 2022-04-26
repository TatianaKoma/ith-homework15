package ua.hillel;

import java.util.Arrays;
import java.util.List;

public class Task {
    public static void main(String[] args) {
        String[] words = {"wolf", "fox", "tiger"};
        System.out.println(toList(words));

    }

    public static <T> List<T> toList(T[] array) {
        List<T> targetList = Arrays.asList(array);
        return targetList;
    }
}

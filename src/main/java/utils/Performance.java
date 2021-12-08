package utils;

import java.util.List;
import java.util.function.Function;

import models.Person;

public class Performance {
    public static Long time(Function<String, List<Person>> function, String param){
        Long start = System.currentTimeMillis();

        function.apply(param);

        Long end = System.currentTimeMillis();
        Long executionTime = end-start;

        System.out.println("Execution time: " + executionTime +"ms.");

        return executionTime;
    }

    public static Long time(Function<String[], List<Person>> function, String[] param){
        Long start = System.currentTimeMillis();

        function.apply(param);

        Long end = System.currentTimeMillis();
        Long executionTime = end-start;

        System.out.println("Execution time: " + executionTime +"ms.");

        return executionTime;
    }
}

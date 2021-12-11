package utils;

import java.util.List;
import java.util.function.Function;

import model.Person;

public class Performance {
    static int tests = 1000000;

    public static Long time(Function<String, List<Person>> function, String param) {
        Long executionTimeMS = 0l;
        Long executionTimeNS = 0l;

        for (int i = 0; i < tests; i++) {
            Long startMS = System.currentTimeMillis();
            Long startNS = System.nanoTime();

            function.apply(param);

            Long endMS = System.currentTimeMillis();
            Long endNS = System.nanoTime();

            executionTimeMS += endMS - startMS;
            executionTimeNS += endNS - startNS;
        }

        executionTimeMS /= tests;
        executionTimeNS /= tests;
        System.out.println("Execution time: " + executionTimeMS + "ms and " + executionTimeNS + " ns.");

        return executionTimeMS;
    }

    public static Long time(Function<String[], List<Person>> function, String[] param) {
        Long executionTimeMS = 0l;
        Long executionTimeNS = 0l;

        for (int i = 0; i < tests; i++) {
            Long startMS = System.currentTimeMillis();
            Long startNS = System.nanoTime();

            function.apply(param);

            Long endMS = System.currentTimeMillis();
            Long endNS = System.nanoTime();

            executionTimeMS += endMS - startMS;
            executionTimeNS += endNS - startNS;
        }

        executionTimeMS /= tests;
        executionTimeNS /= tests;
        System.out.println("Execution time: " + executionTimeMS + "ms and " + executionTimeNS + " ns.");

        return executionTimeMS;
    }
}

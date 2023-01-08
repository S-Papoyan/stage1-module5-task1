package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> {
            for (String s : strings) {
                if (!Character.isUpperCase(s.toCharArray()[0])) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            List<Integer> temp = new ArrayList<>();
            for (Integer integer : integers) {
                if (integer % 2 == 0) {
                    temp.add(integer);
                }
            }
            integers.addAll(temp);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for (String s : values) {
                String[] s1 = s.split(" ");
                char[] chars = s.toCharArray();
                if (s1.length > 3 && Character.isUpperCase(chars[0]) && chars[chars.length - 1] == '.') {
                    list.add(s);
                }
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s : strings) {
                map.put(s, s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (integers, integers2) -> {
            List<Integer> result = new ArrayList<>();
            result.addAll(integers);
            result.addAll(integers2);
            return result;
        };
    }
}

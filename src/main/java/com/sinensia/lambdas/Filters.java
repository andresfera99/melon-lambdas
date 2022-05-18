package com.sinensia.lambdas;

import java.util.ArrayList;
import java.util.List;

public final class Filters {

    public Filters() {
        throw new AssertionError("Utility class can not be instantiated");
    }

    public static List<Melon> filterByType(List<Melon> melons, String type) {
        if (melons == null || type == null) {
            throw new IllegalArgumentException("arguments cant be null");
        }
        if (melons.isEmpty()) {
            return melons;
        }
        List<Melon> res = new ArrayList<>();
        for (int i = 0; i < melons.size(); ++i) {
            if (melons.get(i).getType().equalsIgnoreCase(type)) {
                res.add(melons.get(i));
            }
        }
        return res;
    }

    public static List<Melon> filterByWeigh(List<Melon> melons, int weight) {
        List<Melon> res = new ArrayList<>();
        if (melons == null || weight <= 0) {
            throw new IllegalArgumentException("arguments cant be null");
        }
        if (melons.isEmpty()) {
            return melons;
        }
        for (int i = 0; i < melons.size(); ++i) {
            if (melons.get(i).getWeight() == weight) {
                res.add(melons.get(i));
            }
        }
        return res;
    }

    public static List<Melon> filterMelon(List<Melon> melons, MelonPredicate predicate) {
        List<Melon> res = new ArrayList<>();
        if (melons == null) {
            throw new IllegalArgumentException("arguments cant be null");
        }
        if (melons.isEmpty()) {
            return melons;
        }

        for (Melon melon : melons) {
            if (melon != null && predicate.test(melon)) {
                res.add(melon);
            }
        }
        return res;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> res = new ArrayList<T>();
        if (list == null) {
            throw new IllegalArgumentException("arguments cant be null");
        }
        if (list.isEmpty()) {
            return list;
        }

        for (T t : list) {
            if (t != null && predicate.test(t)) {
                res.add(t);
            }
        }
        return res;
    }
}


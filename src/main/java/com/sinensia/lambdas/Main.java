package com.sinensia.lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Melon> melons = Arrays.asList(
                new Melon("Gac", 5500, "Europe"),
                new Melon("Bailan", 6000, "China"),
                new Melon("Watermelon", 1200, "Europe"),
                new Melon("Gac", 3400, "US"),
                new Melon("Bailan", 1300, "China")
        );

        for (int i = 0; i < melons.size(); ++i) {
            System.out.println(melons.get(i).toString());
        }

        System.out.println("Lista filtrada");
        List<Melon> bailan = filterByType(melons, "Bailan");
        for (Melon melon : bailan) {
            System.out.println(melon.toString());
        }

    }

    private static List<Melon> filterByType(List<Melon> melons, String type) {
        if (melons == null || type == null) {
            throw new IllegalArgumentException("arguments cant be null");
        }
        if (melons.isEmpty()) {
            return melons;
        }
        List<Melon> res = new ArrayList<Melon>();
        for (int i = 0; i < melons.size(); ++i) {
            if (melons.get(i).getType().equals(type)) {
                res.add(melons.get(i));
            }
        }
        return res;
    }


}

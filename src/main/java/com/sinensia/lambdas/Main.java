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
        List<Melon> bailan = Filters.filterByType(melons, "Bailan");
        for (Melon melon : bailan) {
            System.out.println(melon.toString());
        }
        System.out.println("Lista filtrada por peso");
        List<Melon> weightMelons = Filters.filterByWeigh(melons, 1200);
        for (Melon melon : weightMelons) {
            System.out.println(melon.toString());
        }


    }


}

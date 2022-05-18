package com.sinensia.lambdas;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

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

        System.out.println("Lista melones gac");
        GacMelonPredicate gacMelonPredicate = new GacMelonPredicate();
        List<Melon> gac = Filters.filterMelon(melons, gacMelonPredicate);
        for (Melon melon : gac) {
            System.out.println(melon.toString());
        }

        System.out.println("Lista melones pesados");

        List<Melon> heavy = Filters.filterMelon(melons, new HeavyMelonPredicate());
        for (Melon melon : heavy) {
            System.out.println(melon.toString());
        }


        System.out.println("Lista melones pesados 2");

        //clase anonima que implementa MelonPredicate
        List<Melon> tooheavy = Filters.filterMelon(melons, new MelonPredicate() {
            @Override
            public boolean test(Melon melon) {
                return melon != null && melon.getWeight() >= 6000;
            }
        });
        List<Melon> lambdaheavy = Filters.filterMelon(melons, melon -> melon != null && melon.getWeight() >= 6000);
        for (Melon melon : tooheavy) {
            System.out.println(melon.toString());
        }

        System.out.println("Lista sandias");
        List<Melon> as = Filters.filter(melons, (Melon m) -> "watermelon".equalsIgnoreCase(m.getType()));
        for (Melon m : as) {
            System.out.println(m);
        }

        System.out.println("HOLISSSS");
        melons.stream().forEach(x -> System.out.println(x.toString()));

        Optional<Melon> primero = melons.stream().findFirst(); //se wrappea en un optional por si no existiese el primero
        if (primero.isPresent()) {
            System.out.println(primero.get());
        }
        primero.ifPresent(melon -> System.out.println(melon));
    }


}

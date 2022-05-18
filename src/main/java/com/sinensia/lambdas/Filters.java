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
            if (melons.get(i).getType().equals(type)) {
                res.add(melons.get(i));
            }
        }
        return res;
    }
}

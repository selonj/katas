package com.selonj.katas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L.x on 16-2-25.
 */
public class PrimeFactors {
    public static List<Integer> of(int n) {
        ArrayList<Integer> primes = new ArrayList<>();

        for (int candidate = 2; n > 1; candidate++) {
            for (;n % candidate == 0;n /= candidate) {
                primes.add(candidate);
            }
        }
        return primes;
    }
}

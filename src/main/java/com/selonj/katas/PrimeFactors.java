package com.selonj.katas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L.x on 16-2-25.
 */
public class PrimeFactors {
    public static List<Integer> of(int n) {
        ArrayList<Integer> primes = new ArrayList<>();
        if (n > 1) {
            if (n % 2 == 0) {
                primes.add(2);
                n /= 2;
            }
            if (n > 1) {
                primes.add(n);
            }
        }
        return primes;
    }
}

package com.selonj.katas;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by L.x on 16-3-7.
 */
public class NMath {
    public static int factorial(int n) {
        if (n > 2) {
            return factorial(n - 1) * n;
        }
        return n;
    }

    public static int fib(int n) {
        if (n > 2) {
            return fib(n - 2) + fib(n - 1);
        }
        return 1;
    }

    public static List<Integer> primeFactors(int n) {
        ArrayList<Integer> primes = new ArrayList<>();

        for (int candidate = 2; n > 1; candidate++) {
            for (; n % candidate == 0; n /= candidate) {
                primes.add(candidate);
            }
        }
        return primes;
    }

    public static int gcd(int m, int n) {
        if (m % n == 0) {
            return n;
        }

        return gcd(n, m % n);
    }
}

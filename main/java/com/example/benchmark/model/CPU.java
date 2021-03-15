package com.example.benchmark.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CPU {

    private static void piDecimals(int n){
        BigInteger p, a = p = BigInteger.TEN.pow(10010).multiply(new BigInteger("2"));
        for(int i = 1; a.compareTo(BigInteger.ZERO) > 0; p = p.add(a)){
            a = a.multiply(new BigInteger(i+"")).divide(new BigInteger((2 * i++ + 1)+""));
        }
        for(int i = 0; i < n; i++){
            int val = ((p+"").charAt(i+1) - 48);
        }
    }

    public static List<Integer> primeFactors(int number) {
        int n = number;
        List<Integer> factors = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }
        return factors;
    }

    public static long cpuScore() {
        long finalTime = 0;

        long initTime = System.currentTimeMillis();
        for(int i = 1; i<=200000; i++){
            primeFactors(i);
        }
        piDecimals(500);
        finalTime = finalTime + (System.currentTimeMillis() - initTime);
        return finalTime;
    }
}

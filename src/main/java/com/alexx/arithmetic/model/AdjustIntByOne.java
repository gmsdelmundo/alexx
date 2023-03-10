package com.alexx.arithmetic.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdjustIntByOne implements AdjustNumberByOne<Integer> {

    private static final Map<Integer, Integer> INCREMENT_RESULTS = new ConcurrentHashMap<>();
    private static final Map<Integer, Integer> DECREMENT_RESULTS = new ConcurrentHashMap<>();

    private final int number;

    public AdjustIntByOne(int number) {
        this.number = number;
    }

    @Override
    public Integer increment() {
        if (INCREMENT_RESULTS.containsKey(number)) {
            return INCREMENT_RESULTS.get(number);
        } else {
            int absNumber = Math.abs(number);
            int result = number >= 0 ? incrementByOne(absNumber) : -1 * decrementByOne(absNumber);
            INCREMENT_RESULTS.put(number, result);
            return result;
        }
    }

    @Override
    public Integer decrement() {
        if (DECREMENT_RESULTS.containsKey(number)) {
            return DECREMENT_RESULTS.get(number);
        } else {
            int absNumber = Math.abs(number);
            int result = number > 0 ? decrementByOne(absNumber) : -1 * incrementByOne(absNumber);
            DECREMENT_RESULTS.put(number, result);
            return result;
        }
    }

    private int incrementByOne(int n) {
        return (-(~n));
    }

    private int decrementByOne(int n) {
        int minuend = n;
        int subtrahend = 1;

        while (subtrahend != 0) {
            int borrow = (~minuend) & subtrahend;
            minuend ^= subtrahend;
            subtrahend = borrow << 1;
        }

        return minuend;
    }

}

package com.alexx.arithmetic.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AdjustIntByOne implements AdjustNumberByOne<Integer> {

    private final static Map<Integer, Integer> INCREMENT_RESULTS = new ConcurrentHashMap<>();
    private final static Map<Integer, Integer> DECREMENT_RESULTS = new ConcurrentHashMap<>();

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

    private int incrementByOne(final int number) {
        return (-(~number));
    }

    private int decrementByOne(int number) {
        int subtractend = 1;
        while (subtractend != 0) {
            int borrow = (~number) & subtractend;
            number ^= subtractend;
            subtractend = borrow << 1;
        }
        return number;
    }

}

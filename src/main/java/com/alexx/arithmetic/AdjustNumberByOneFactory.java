package com.alexx.arithmetic;

import com.alexx.arithmetic.model.AdjustIntByOne;
import com.alexx.arithmetic.model.AdjustNumberByOne;

public enum AdjustNumberByOneFactory {

    INSTANCE;

    public AdjustNumberByOne<?> createAdjustNumberByOne(Object number) {
        return switch (number) {
            case Integer i -> (AdjustNumberByOne<?>) new AdjustIntByOne(i);
            default -> throw new IllegalArgumentException(String.format("[%s] type not supported", number.getClass()));
        };
    }

}

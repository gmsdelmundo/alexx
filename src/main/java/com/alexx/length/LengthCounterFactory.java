package com.alexx.length;

import com.alexx.length.model.LengthCounter;
import com.alexx.length.model.StringLengthCounter;

public enum LengthCounterFactory {

    INSTANCE;

    public LengthCounter createLengthCounter(Object obj) {
        return switch (obj) {
            case String s -> new StringLengthCounter(s);
            default -> throw new IllegalArgumentException(String.format("[%s] type not supported", obj.getClass()));
        };
    }

}

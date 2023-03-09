package com.alexx.length.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringLengthCounterTest {

    @Test
    public void getLength_whenStringIsEmpty_thenZero() {
        assertThat(0).isEqualTo(new StringLengthCounter("").getLength());
    }

    @Test
    public void getLength_whenStringHasOneCharacter_thenOne() {
        assertThat(1).isEqualTo(new StringLengthCounter("a").getLength());
    }

}

package com.alexx.arithmetic.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class AdjustIntByOneTest {

    @Test
    public void increment_whenOne_thenTwo() {
        assertThat(new AdjustIntByOne(1).increment()).isEqualTo(2);
    }

    @Test
    public void increment_whenZero_thenOne() {
        assertThat(new AdjustIntByOne(0).increment()).isEqualTo(1);
    }

    @Test
    public void increment_whenNegativeOne_thenZero() {
        assertThat(new AdjustIntByOne(-1).increment()).isEqualTo(0);
    }

    @Test
    public void increment_whenNegativeTwo_thenNegativeOne() {
        assertThat(new AdjustIntByOne(-2).increment()).isEqualTo(-1);
    }

    @Test
    public void decrement_whenTwo_thenOne() {
        assertThat(new AdjustIntByOne(2).decrement()).isEqualTo(1);
    }

    @Test
    public void decrement_whenOne_thenZero() {
        assertThat(new AdjustIntByOne(1).decrement()).isEqualTo(0);
    }

    @Test
    public void decrement_whenZero_thenNegativeOne() {
        assertThat(new AdjustIntByOne(0).decrement()).isEqualTo(-1);
    }

    @Test
    public void decrement_whenNegativeOne_thenNegativeTwo() {
        assertThat(new AdjustIntByOne(-1).decrement()).isEqualTo(-2);
    }

}

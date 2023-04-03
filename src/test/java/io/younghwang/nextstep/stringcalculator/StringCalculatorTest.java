package io.younghwang.nextstep.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void add_null_and_empty() {
        // given
        // when
        // then
        assertThat(stringCalculator.add(null)).isEqualTo(0);
        assertThat(stringCalculator.add("")).isEqualTo(0);
    }

    @Test
    void add_one_number() {
        // given
        // when
        // then
        assertThat(stringCalculator.add("1")).isEqualTo(1);
    }

    @Test
    void add_rest_separator() {
        // given
        // when
        // then
        assertThat(stringCalculator.add("1,2")).isEqualTo(3);
    }
}
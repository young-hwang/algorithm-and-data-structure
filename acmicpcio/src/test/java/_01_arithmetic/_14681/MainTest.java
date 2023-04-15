package _01_arithmetic._14681;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MainTest {

    @Test
    void test_1사분면_확인() {
        // given
        Main main = new Main();
        int x = 2;
        int y = 10;
        // when
        int quadrant = main.getQuadrant(x, y);
        // then
        assertThat(quadrant).isEqualTo(1);
    }

    @Test
    void test_2사분면_확인() {
        // given
        Main main = new Main();
        int x = -3;
        int y = 4;
        // when
        int quadrant = main.getQuadrant(x, y);
        // then
        assertThat(quadrant).isEqualTo(2);
    }

    @Test
    void test_3사분면_확인() {
        // given
        Main main = new Main();
        int x = -6;
        int y = -5;
        // when
        int quadrant = main.getQuadrant(x, y);
        // then
        assertThat(quadrant).isEqualTo(3);
    }

    @Test
    void test_4사분면_확인() {
        // given
        Main main = new Main();
        int x = 9;
        int y = -13;
        // when
        int quadrant = main.getQuadrant(x, y);
        // then
        assertThat(quadrant).isEqualTo(4);
    }
}
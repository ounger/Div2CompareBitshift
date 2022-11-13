package ch.oliverunger;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ThreadLocalRandom;

import static ch.oliverunger.GaussSumBitshift.gaussSumByBitshift;
import static ch.oliverunger.GaussSumDiv.gaussSumByDiv;
import static org.assertj.core.api.Assertions.assertThat;

public class GaussSumTest {

    private static final int ITERATIONS = 1_000_000;

    private static final long MIN_N = 1_000_000_000L;
    private static final long MAX_N = 3_000_000_000L;

    @Test
    public void testGaussSumByDiv() {
        assertThat(gaussSumByDiv(0)).isEqualTo(0);
        assertThat(gaussSumByDiv(1)).isEqualTo(1);
        assertThat(gaussSumByDiv(2)).isEqualTo(3);
        assertThat(gaussSumByDiv(3)).isEqualTo(6);
        assertThat(gaussSumByDiv(4)).isEqualTo(10);
        assertThat(gaussSumByDiv(5)).isEqualTo(15);
        assertThat(gaussSumByDiv(6)).isEqualTo(21);
        assertThat(gaussSumByDiv(7)).isEqualTo(28);
        assertThat(gaussSumByDiv(8)).isEqualTo(36);
        assertThat(gaussSumByDiv(9)).isEqualTo(45);
        assertThat(gaussSumByDiv(10)).isEqualTo(55);
        assertThat(gaussSumByDiv(100)).isEqualTo(5050);
    }

    @Test
    public void testGaussSumByBitshift() {
        assertThat(gaussSumByBitshift(0)).isEqualTo(0);
        assertThat(gaussSumByBitshift(1)).isEqualTo(1);
        assertThat(gaussSumByBitshift(2)).isEqualTo(3);
        assertThat(gaussSumByBitshift(3)).isEqualTo(6);
        assertThat(gaussSumByBitshift(4)).isEqualTo(10);
        assertThat(gaussSumByBitshift(5)).isEqualTo(15);
        assertThat(gaussSumByBitshift(6)).isEqualTo(21);
        assertThat(gaussSumByBitshift(7)).isEqualTo(28);
        assertThat(gaussSumByBitshift(8)).isEqualTo(36);
        assertThat(gaussSumByBitshift(9)).isEqualTo(45);
        assertThat(gaussSumByBitshift(10)).isEqualTo(55);
        assertThat(gaussSumByBitshift(100)).isEqualTo(5050);
    }

    @Test
    public void testRNG() {
        for (int i = 0; i < ITERATIONS; i++) {
            final long n = ThreadLocalRandom.current().nextLong(MIN_N, MAX_N + 1);
            assertThat(n).isBetween(MIN_N, MAX_N);
            assertThat((n * (n + 1)) >> 1).isBetween(500_000_000_500_000_000L, 4_500_000_001_500_000_000L);
        }
    }

}

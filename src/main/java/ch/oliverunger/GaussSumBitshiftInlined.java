package ch.oliverunger;

import java.util.concurrent.ThreadLocalRandom;

public class GaussSumBitshiftInlined {

    private static final int ITERATIONS = 1_000_000;

    private static final long MIN_N = 1_000_000_000L;
    private static final long MAX_N = 3_000_000_000L;

    public GaussSumBitshiftInlined() {
        for (int i = 0; i < ITERATIONS; i++) {
            final long n = ThreadLocalRandom.current().nextLong(MIN_N, MAX_N + 1);
            final long gaussSum = (n * (n + 1)) >> 1;
            System.out.println(gaussSum);
        }
    }

    public static void main(String[] args) {
        new GaussSumBitshiftInlined();
    }

}

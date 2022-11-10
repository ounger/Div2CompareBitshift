package ch.oliverunger;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import static ch.oliverunger.GaussSumBitshift.gaussSumByBitshift;
import static ch.oliverunger.GaussSumDiv.gaussSumByDiv;

public class GaussSumBM {

    private static final int ITERATIONS = 1_000_000;

    private static final long MIN_N = 1_000_000_000L;
    private static final long MAX_N = 4_000_000_000L;

    public static void main(String[] args) throws RunnerException {
        final Options opt = new OptionsBuilder()
                .include(GaussSumBM.class.getSimpleName())
                .mode(Mode.AverageTime)
                .forks(1)
                .timeUnit(TimeUnit.MILLISECONDS)
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void testGaussSumByDiv() {
        final Random rng = new Random();
        for(int i = 0; i < ITERATIONS; i++) {
            final long n = rng.nextLong(MAX_N - MIN_N) + MIN_N;
            gaussSumByDiv(n);
        }
    }

    @Benchmark
    public void testGaussSumByBitshift() {
        final Random rng = new Random();
        for(int i = 0; i < ITERATIONS; i++) {
            final long n = rng.nextLong(MAX_N - MIN_N) + MIN_N;
            gaussSumByBitshift(n);
        }
    }

}

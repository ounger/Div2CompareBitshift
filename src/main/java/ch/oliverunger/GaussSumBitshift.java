package ch.oliverunger;

public class GaussSumBitshift {
	
	public static void main(String[] args) {
		System.out.print("Gauss Summation for n = 10 by bitshift: ");
		System.out.println(gaussSumByBitshift(10));
    }

    public static long gaussSumByBitshift(final long n) {
        return (n * (n + 1)) >> 1;
    }

}

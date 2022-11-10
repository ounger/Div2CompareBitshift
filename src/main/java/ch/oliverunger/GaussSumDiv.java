package ch.oliverunger;

public class GaussSumDiv {
	
	public static void main(String[] args) {
		System.out.print("Gauss Summation for n = 10 by div: ");
		System.out.println(gaussSumByDiv(10));
    }

    public static long gaussSumByDiv(final long n) {
        return (n * (n + 1)) / 2;
    }

}

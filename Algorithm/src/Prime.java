

public class Prime {
	public static void main(String[] args) {
		System.out.println(primeSlightlyBetter(10));
	}
	
	/**
	 * 소수 판별
	 * @param n
	 * @return
	 */
	public static boolean primeSlightlyBetter(int n) {
		if (n < 2) return false;
		
		int sqrt = (int) Math.sqrt(n);
		
		for (int i = 2; i <= sqrt; i++) {
			if (sqrt % i == 0) return false;
		}
		
		return true;
	}

	
}

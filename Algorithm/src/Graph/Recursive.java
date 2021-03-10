package Graph;

public class Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(GCD(192, 162));
	}

	// 최대공약수
	public static int GCD(int a, int b) {
		if (a % b == 0) return b;
		else return GCD(b, a % b);
	}
}

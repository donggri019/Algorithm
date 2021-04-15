package BackJoon.Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Rope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] ropeArr = new int[N];
		
		for (int i=0; i<N; i++) {
			ropeArr[i] = sc.nextInt();
		}
	
		Arrays.sort(ropeArr);
		int max = 0;
		
		for (int i=0; i<N; i++) {
			max = Math.max(max, ropeArr[i] * (N-i));
		}
		
		System.out.println(max);
	}
}

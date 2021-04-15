package BackJoon.Greedy;

import java.util.Scanner;

public class ChageCoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		int[] coins = {500, 100, 50, 10, 5, 1};
		int changeCoin = 1000 - input;
		int changeCoinCnt = 0;
		
		for (int i=0; i<coins.length; i++) {
			changeCoinCnt += changeCoin / coins[i];
			changeCoin = changeCoin % coins[i];
		}
		
		System.out.println(changeCoinCnt);
		
	}

}

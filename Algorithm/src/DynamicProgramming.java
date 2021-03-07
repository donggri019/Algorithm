import java.util.Arrays;

public class DynamicProgramming {

	static int[] fiboMemo;
	static int[] change;

	// DP 동적계획법
	// 피보나치의 재귀오버헤드를 해결하기 위한 방
	// 이전에 구한 답을 다시 가져오는 방법
	// 분할 정복 알고리즘과 매우 유사
	
	// 하나의 문제를 한번만 풀도록 하는 알고리즘
	// 큰문제를 작은 문제로 나눈다 -> 작은 문제에서 구한 정잡은 그것을 포함하는 큰 문제에서도 동일
	// 메모이제이션 : 이미 계산한 결과는 배열에 담아놓음
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println("fiboOrigin(10) : " + fiboOrigin(10));
		
		// Java 컴파일러에서 허용된 int 범위값을 저장할 수 있는 범위가 피보나치 수열의 45
		//fiboMemo = new int[45];
		//System.out.println("fibo(10) : " + fibo(10));
		
		// 거스름돈 예제
		//change();
		
		// 정수 삼각형 최대값 
		//bestTriangle();
		
		
		
	}

	/**
	 *	정수 삼각형 거쳐간 최대 값  
	 *	[] n = 정수 삼각형 배열 
	 *  가장 큰 합산 값을 찾는
	 */
	public static void bestTriangle() {
		int[][] n = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		int nlen = n.length;
		int[] sumList = new int[nlen-1];
		sumList[0] = n[0][0];
		for (int i = 1; i < n[i].length; i++) {
			System.out.println("n[i].length : " + n[i].length);
			int maxSum = 0;
			for (int j = 0; j < i; j++) {
				if(maxSum < n[i][j] + n[i-1][j]) {
					maxSum = n[i][j] + n[i-1][j];
				}
			}
			sumList[i-1] = maxSum;
			System.out.println(Arrays.toString(sumList));
		}
	}
	
	/**
	 *	거스름돈 최소의 개수 문제 
	 *	n = n 가지 종류의 동전, 
	 *	k = 원하는 가치의 합   
	 *  탐욕 알고리즘은 완벽한 해를 구할 수 없으므로 동적 계획법을 사용해야 한다.
	 */
	public static void change() {
		int n = 3;
		// 500, 400, 100 원이 주어 질때 100 단위로 자른 후
		int[] coin = {5, 4, 1};
		// 최종 금액인 1200 에서 100 단위로 자른 후 
		int k = 12;
		
		// 최종 금액을 만드는데 사용한 동전 개수 
		int[] countMap = new int[k+1];
		// 이때 사용된 동전 
		int[] useCoinMap = new int[k+1];
		
		// 1개의 동전의 경우에 만드는데 사용한 동전입력 
		for (int i = 0; i < coin.length; i++) {
			countMap[coin[i]] = 1;
			useCoinMap[coin[i]] = coin[i];
		}
		
		// 1부터 입려된 잔돈 까지 솔루션 계산
		for (int i = 1; i < k+1; i++) {
			if (countMap[i] != 0) continue;
			else {
				int minNumber = Integer.MAX_VALUE;
				int selectCoin = 0;
				
				for (int j = 0; j < coin.length; j++) {
					if (i - coin[j] > 0) {
						if (minNumber > countMap[i - coin[j]] + 1) {
							minNumber = countMap[i - coin[j]] + 1;
							selectCoin = coin[j];
						}
					}
				}
				
				countMap[i] = minNumber;
				useCoinMap[i] = selectCoin;
			}
		}
		System.out.println("countMap : " + Arrays.toString(countMap));
		System.out.println("useCoinMap : " + Arrays.toString(useCoinMap));
		
		int useCoinCnt = 0;
		
		while(k != 0 ) {
			useCoinCnt++;
			System.out.println("Use Coin : " + useCoinMap[k] * 100);
			k = k - useCoinMap[k];
		}
		System.out.println("Use Coin Count : " + useCoinCnt);
	}
	
	// DP 피보나치
	public static int fibo(int a) {
		fiboMemo[0] = fiboMemo[1] = 1;
		
		for (int i = 2; (i <= a) && ( i < 45); i++) {
			fiboMemo[i] = fiboMemo[i-2] + fiboMemo[i-1];
		}
		
		return fiboMemo[a];
	}
	
	// DP 피보나치 (45 이상일 경우 재귀로 다시 )
	public static int fiboDp(int a) {
		if (a < 45) return fiboMemo[a];
		else return fiboDp(a-1) + fiboDp(a-2);
	}
	
	// 기본적인 재귀 피보나치
	public static int fiboOrigin(int a) {
		if (a == 1 || a == 0) return 1;
		return fiboOrigin(a - 1) + fiboOrigin(a -2);
		
	}
}

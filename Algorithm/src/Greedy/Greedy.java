package Greedy;

import java.util.Arrays;

public class Greedy {

	public static void main(String[] args) {
		
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        
		//print(solution("BBBAAAB"))#9
		//print(solution("ABABAAAAABA")) #11
		System.out.println(joystick("JEROEN"));
		        
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("수행 속도(ms) : "+secDiffTime);
		
		//change();
		//devideMinus(25, 3);
		//mulOrPlus("02984");
		//int[] arr = {2,3,1,2,2};
		//guild(5, arr);
		
		
	}
	
	// 현재 상황에서 지금 당장 좋은 것만 고르는 방법
	// 최소한의 아이디어를 떠올릴 수 있는 능력
	// 정당성 분석 중요
	// 단순히 가장 좋아보이는 것을 반복적으로 선택해도 최적의 해를 구할 수 있는지 검토 
	// 최적해 를 보장 할 수는 없다.
	// 결과값이 주어진 값의 배수가 되면 가능
	
	public static void change() {
		int n = 1260;
		int count = 0;
		int[] changeArrays = {500, 100, 50, 10};
		
		for (int i=0; i<changeArrays.length; i++) {
			count += n/changeArrays[i];
			n %= changeArrays[i];
		}
		
		System.out.println("count : " + count);
	}
	
	// n 이 1이 될때까지
	public static void devideMinus(int n, int k) {
		int result = 0;
		
		while(true) {
			// N 이 K 로 나누어 떨어지는 수가 될때까지 빼기
			int target = (n / k) * k;
			result += (n - target);
			n = target;
			
			if(n<k) break;
			
			result += 1;
			n /= k;
		}
		
		result += (n-1);
		System.out.println("result : " + result);
	}
	
	// *,+ 이용하여 만들어질 수 있는 가장 큰수
	// ex) 02984 = (((0+2)*9)*8)*4
	public static void mulOrPlus(String S) {
		String[] s = S.split("");
		int result = 0;
		
		for(int i=0; i < s.length; i++) {
			if(result < 2 || Integer.parseInt(s[i]) < 2 ) result += Integer.parseInt(s[i]);
			else result *= Integer.parseInt(s[i]);
		}
		
		System.out.println("result : " + result);
	}
	
	// 모험가 N 명 , 공포도 
	// 공포도가 X 인 모험가는 반드시 X 명 이상 구성 
	public static void guild(int n, int[] arr) {
		Arrays.sort(arr);
		int result = 0;
		int count = 0;
		
		for (int i=0; i<n; i++) {
			count += 1;
			if(count >= arr[i]) {
				result += 1;
				count = 0;
			}
		}
		
		System.out.println("result : " + result);
	}
	
	public static int joystick(String name) {

		int moveCnt = 0;
		int len = name.length();
		int minMove = len-1;
		
		// BBBAAAB #9
		// BBBAABB 11
		// ABABAAAAABA #11
		
		for (int i=0; i<name.length(); i++) {
			moveCnt += Math.min('Z'- name.charAt(i) + 1, name.charAt(i) - 'A');
			
			int nextIdx = i+1;
			while(nextIdx < len && name.charAt(nextIdx) == 'A') nextIdx++;
			
			minMove = Math.min(minMove, i+i+(len-nextIdx));
			
		}
		 moveCnt += minMove;
		
		return moveCnt;
	}
	
}

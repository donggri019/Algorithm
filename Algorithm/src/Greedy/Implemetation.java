package Greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Implemetation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기

		//System.out.println(Arrays.toString(upDownLeftRight(5, "RRRUDDLLLLLUUUDDDRRRRRRLLLLUUUUDD")));
		//System.out.println(timeCnt(5));
		//System.out.println(knight("a1"));
		System.out.println(stringSort("AJKDLSI412K4JSJ9D"));
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); // 두 시간에 차 계산
		System.out.println("수행 속도(ms) : " + secDiffTime);
	}

	// 머릿속에 있는 알고리즘을 소스코드로 바꾸는 과정
	// 풀이를 떠올리는 것은 쉽지만 소스코드로 옮기기 어려운 문제
	// 알고리즘 간단하지만 코드가 지나치게 긴 문제
	// 실수 연산을 다루고 특정 소수점 자리까지 출력해야 하는 문제
	// 문자열을 특정한 기준에 따라서 끊어 처리해야 하는 문제
	// 적절한 라이브러리를 찾아서 사용해야 하는 문제

	// 행렬에서 좌표로 이동하는 케이스
	// 어떤 방향
	// 동, 북, 서, 남
	// dx = {0, -1, 0, 1};
	// dy = {1, 0, -1, 0};

	// n = 공간 크기, d = 상하좌우 String
	public static int[] upDownLeftRight(int n, String d) {
		int[] dx = { 0, -1, 0, 1 };
		int[] dy = { 1, 0, -1, 0 };
		String[] moveType = { "R", "U", "L", "D" };
		int[] cor = { 1, 1 };

		for (String dOne : d.split("")) {
			int nx = 0;
			int ny = 0;

			for (int j = 0; j < 4; j++) {
				if (dOne.equals(moveType[j])) {
					nx = cor[0] + dx[j];
					ny = cor[1] + dy[j];
				}
			}

			if (nx < 1 || ny < 1 || nx > n || ny > n) continue;
			cor[0] = nx;
			cor[1] = ny;

//			if (dOne.equals("R") && (cor[1] + dy[0]) < n+1) { 
//				cor[0] += dx[0]; 
//				cor[1] += dy[0]; 
//			} 
//			if (dOne.equals("U") && (cor[0] + dx[1]) > 0) { 
//				cor[0] += dx[1];
//				cor[1] += dy[1]; 
//			} 
//			if (dOne.equals("L") && (cor[1] + dy[2]) > 0) { 
//				cor[0] += dx[2]; 
//				cor[1] += dy[2]; 
//			} 
//			if(dOne.equals("D") && (cor[0] + dx[3]) < n+1) {
//				cor[0] += dx[3]; 
//				cor[1] += dy[3]; 
//			}
			
		}

		return cor;
	}
	
	// 00시 00분 00초 ~ N시 59분 59초 중 3이 들어간 경우의 수
	public static int timeCnt (int n) {
		int cnt = 0;
		
		for (int h=0; h<=n; h++) {
			for (int m=0; m<60; m++) {
				for (int s=0; s<60; s++) {
					//if((String.valueOf(h) + String.valueOf(m) + String.valueOf(s)).contains("3")) {
					if(check(h, m, s)) {
						cnt++; 
					}
				}
			}
		}
		
		return cnt;
	}
	
	public static boolean check(int h, int m, int s) {
		if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3) return true;
		return false;
	}
	
	public static int knight(String cor) {
		int[] movX = {-1, -1, 1, 1, 2, 2, -2, -2};
		int[] movY = {2, -2, 2, -2, -1, 1, -1, 1};
		int[] nowCorChange = {cor.charAt(1) - '0'-1, cor.charAt(0) - 'a'};
		System.out.println(Arrays.toString(nowCorChange));
		int cnt =0;
		
		for(int i=0; i < movX.length; i++) {
			int mx = nowCorChange[0] + movX[i];
			int my = nowCorChange[1] + movY[i];;
			
			if(mx < 0 || my < 0 || mx > 7 || my > 7) continue;
			cnt++;
		}
		
		return cnt;
	}
	
	public static String stringSort(String n) {
		ArrayList<String> str = new ArrayList<String>();
		int num = 0;
		String rex = "[a-zA-Z]";
		
		for (String one : n.split("")) {
			if (one.matches(rex)) str.add(one);
			else num += Integer.parseInt(one);
		}
		Collections.sort(str);
		return String.join("", str) + String.valueOf(num);
				
	}
}

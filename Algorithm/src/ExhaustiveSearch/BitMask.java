package ExhaustiveSearch;

import java.util.Arrays;

public class BitMask {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		bitMask();
	}

	// 2진수를 이용하는 컴퓨터의 연산 이용
	// 모든 경우의 수가 원소 포함/미포함 두 가지 선택으로 구성 되는 경우 유
	public static void bitMask() {
		int[] a = {1, 0, 1, 0};
		int[] b = {1, 1, 1, 1};
		int len = a.length;	
		int[] c = new int[len];
		
		// A & B
		for (int i = 0; i < len; i++) {
			c[i] = a[i] == 1 && b[i] == 1 ? 1 : 0;
		}
		System.out.println("A & B : " +Arrays.toString(c));
		
		// A | B
		for (int i = 0; i < len; i++) {
			c[i] = a[i] == 1 || b[i] == 1 ? 1 : 0;
		}
		System.out.println("A | B : " +Arrays.toString(c));
		
		// A ^ B
		for (int i = 0; i < len; i++) {
			c[i] = a[i] != b[i]  ? 1 : 0;
		}
		System.out.println("A ^ B : " +Arrays.toString(c));
		
		// ~ A 
		for (int i = 0; i < len; i++) {
			c[i] = a[i] == 1  ? 0 : 1;
		}
		System.out.println("~ A : " +Arrays.toString(c));
		
		// ~ B
		for (int i = 0; i < len; i++) {
			c[i] = b[i] == 1  ? 0 : 1;
		}
		System.out.println("~ A : " +Arrays.toString(c));
	}
}

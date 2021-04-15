package BackJoon.Greedy;

import java.util.Scanner;

public class LostParenthesis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		String line = sc.nextLine();
		
		String[] s1 = line.split("-");
		int sum = 0;
		
		for (int i=0; i<s1.length; i++) {
			int temp = 0;
			if (s1[i].contains("+")) {
				String[] s2 = s1[i].split("\\+");
				for (int j=0; j<s2.length; j++) {
					temp += Integer.parseInt(s2[j]);
				}
				if (i==0) sum += temp;
				else sum -= temp;
			} else {
				if (i==0) sum += Integer.parseInt(s1[i]);
				else sum -= Integer.parseInt(s1[i]);
			}
		}
		
		System.out.println(sum);
	}

}

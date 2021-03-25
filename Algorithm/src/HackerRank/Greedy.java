package HackerRank;

import java.util.Arrays;
import java.util.Comparator;

public class Greedy {

	public static void main(String[] args) {
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		
//		String[] grid = {"kc", "iu"};
//		char[] gridOne = grid[0].toCharArray();
//		
//		Arrays.sort(gridOne);
//		String gridSort = String.valueOf(gridOne);
//		grid[0] = gridSort;
//		System.out.println(gridSort);
//		System.out.println(Arrays.toString(grid));
		
		int[][] contests = {{5,1}, {2,1}, {1,1}, {8,1}, {10,0}, {5,0}};
		
		int[] c = {2,5,6};
		
		for (int i=0; i<contests.length; i++){
            for (int j=0; j<contests[i].length; j++) {
                System.out.print("[" + contests[i][j] + "]");        
            }
            System.out.println();
        }
		
		Arrays.sort(contests, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0]; 
			}
		});
		
		System.out.println("===========================");
		for (int i=0; i<contests.length; i++){
            for (int j=0; j<contests[i].length; j++) {
                System.out.print("[" + contests[i][j] + "]");        
            }
            System.out.println();
        }
		
		
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("수행 속도(ms) : "+secDiffTime);
	}
	
	public static void marcsCakewalk() {
		int n = 4;
		int[] calorie = {7, 4, 9, 6};
		
		
		
	}
}

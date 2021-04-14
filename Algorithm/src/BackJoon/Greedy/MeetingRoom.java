package BackJoon.Greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class MeetingRoom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int N = 11;
		//int[][] timeArr = {{1,4},{3,5},{0,6},{5,7},{3,8},{5,9},{6,10},{8,11},{8,12},{2,13},{12,14}};
		
		//int N = 9;
		//int[][] timeArr = {{8,8},{5,8},{3,4},{2,5},{2,7},{8,8},{1,10},{3,3},{10,10}};
		
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] timeArr = new int[N][2];
		
		for (int i=0; i<timeArr.length; i++) {
			for (int j=0; j<timeArr[i].length; j++) {
				timeArr[i][j] = sc.nextInt();
			}
		}

		meetingRoomSolution(N, timeArr);
	}

	public static int meetingRoomSolution(int N, int[][] timeArr) {

		int[] cntList = new int [N];
		int maxCnt = 0;
		int end = 0;
		Arrays.sort(timeArr, new Comparator<int[]>() {
			@Override
			public int compare(int[] i1, int[] i2) {
				if(i1[1] == i2[1]) {
					return i1[0] - i2[0];
				}
				return i1[1] - i2[1];
			}
		});
		
		System.out.println("timerArr : " + Arrays.deepToString(timeArr));
		
		for (int i=0; i<timeArr.length; i++) {
			if(end <= timeArr[i][0]) {
				maxCnt++;
				end = timeArr[i][1];
			}
		}
		
		System.out.println("maxCnt : " + maxCnt);
		
		return maxCnt;
	}
}

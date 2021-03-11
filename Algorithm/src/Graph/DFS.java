package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class DFS {

	public static boolean[][] visited;
	public static String[] visitedWord;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * for (int i=0; i<9; i++) { graph.add(new ArrayList<Integer>()); }
		 * 
		 * // 노드 1에 연결된 노드 정보 저장 graph.get(1).add(2); graph.get(1).add(3);
		 * graph.get(1).add(8);
		 * 
		 * // 노드 2에 연결된 노드 정보 저장 graph.get(2).add(1); graph.get(2).add(7);
		 * 
		 * // 노드 3에 연결된 노드 정보 저장 graph.get(3).add(1); graph.get(3).add(4);
		 * graph.get(3).add(5);
		 * 
		 * // 노드 4에 연결된 노드 정보 저장 graph.get(4).add(3); graph.get(4).add(5);
		 * 
		 * // 노드 5에 연결된 노드 정보 저장 graph.get(5).add(3); graph.get(5).add(4);
		 * 
		 * // 노드 6에 연결된 노드 정보 저장 graph.get(6).add(7);
		 * 
		 * // 노드 7에 연결된 노드 정보 저장 graph.get(7).add(2); graph.get(7).add(6);
		 * graph.get(7).add(8);
		 * 
		 * // 노드 8에 연결된 노드 정보 저장 graph.get(8).add(1); graph.get(8).add(7);
		 * 
		 * dfsEx(1);
		 */
		
		long beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
        
//		int[] input = {1, 1, 1, 1, 1};
//		System.out.println(dfsTarget(input, 3, 0, 0));
//		int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}; 
//		int[][] computers = {{1, 0, 1, 1, 0, 0}, {0, 1, 0, 0, 1, 1}, {1, 0, 1, 1, 1, 1}, {1, 0, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}}; 
//		System.out.println(solutionNetwork(3, computers));

		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		//String[] words = {"hot", "dot", "dog", "lot", "log"};
				
		System.out.println(solution(begin, target, words));
		long afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
		long secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
		System.out.println("수행 속도(ms) : "+secDiffTime);
        
	}

	public static int solution(String begin, String target, String[] words) { 
		int answer = words.length;
		boolean exist = false;
		for (String one : words) {
			if (one.equals(target)) exist = true;
		}
		
		if (!exist) return 0;

		for (int i = 0; i < words.length; i++) { 
			boolean[] visited = new boolean[words.length]; 
			if (isDiffOneChar(begin, words[i])) { 
				answer = Math.min(answer, dfs(words[i], target, i, words, visited, 1)); 
			} 
		} 
		 
		return answer; 
	}

	public static int dfs(String begin, String target, int index, String[] words, boolean[] visited, int cnt) {
		if (begin.equals(target)) return cnt; 
		if (visited[index]) return cnt; 
		
		visited[index] = true; 
		int ans = 0; 
		for (int i = 0; i < words.length; i++) { 
			if (index != i && isDiffOneChar(begin, words[i]) && !visited[i]) { 
				ans = dfs(words[i], target, i, words, visited, cnt + 1); 
			} 
		} 
		
		return ans; 
	}

	public static boolean isDiffOneChar(String str1, String str2) { 
		int cnt = 0; 
		for (int i = 0; i < str1.length() && cnt < 2; i++) { 
			if (str1.charAt(i) != str2.charAt(i)) cnt++; 
		} 
		return cnt == 1; 
	}

	
//	public static int solutionNetwork(int n, int[][] computers) {
//		int result = 0;
//		visited = new boolean[n][n];
//		
//		for (int i=0; i<n; i++) {
//			if (!visited[i][i]) {
//				defNetwork(i, n, computers);
//				result++;
//				System.out.println("result++ =========================");
//			}
//		}
//		
//		return result;
//	}
	
//	public static void defNetwork(int start, int n, int[][] computers) {
//		
//		System.out.println("boolean =========================");
//		for(int p=0; p<n; p++) {
//			for(int q=0; q<n; q++) {
//				System.out.print("[" + visited[p][q] + "]");
//			}
//			System.out.println("");
//		}
//		
//		for(int i=0; i<n; i++) {
//			if (computers[start][i] == 1 && !visited[start][i]) {
//				visited[start][i] = visited[i][start] = true;
//				defNetwork(i, n, computers);
//			}
//		}
//	}
//	
//	public static int dfsTarget(int[] num, int target, int sum, int i) {
//		
//		if(i == num.length) {
//			if(sum == target) return 1;
//			else return 0;
//		}
//		
//		return dfsTarget(num, target, sum + num[i], i+1) + dfsTarget(num, target, sum - num[i], i+1);
//	}
	
//	public static void dfsEx(int a) {
//		visited[a] = true;
//		System.out.println(a + " ");
//		for (int i=0; i <graph.get(a).size(); i++) {
//			int y = graph.get(a).get(i);
//			if(!visited[y]) dfsEx(y);
//		}
//	}
}

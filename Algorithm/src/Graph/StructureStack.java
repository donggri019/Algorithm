package Graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StructureStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		stack();
		queue();
	}
	
	// 선입후출
	public static void stack() {
		Stack<Integer> s = new Stack<>();
		s.push(5);
		s.push(2);
		s.push(3);
		s.push(7);
		s.pop();
		s.push(1);
		s.push(4);
		s.pop();
		
		while(!s.empty()) {
			System.out.println(s.peek() + " ");
			s.pop();
		}
	}
	
	public static void queue() {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(5);
		q.offer(2);
		q.offer(3);
		q.offer(7);
		q.poll();
		q.offer(1);
		q.offer(4);
		q.poll();
		
		while(!q.isEmpty()) {
			System.out.println(q.poll() + " ");
		}
	}

}

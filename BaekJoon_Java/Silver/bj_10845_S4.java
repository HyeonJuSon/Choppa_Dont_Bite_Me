package silver;
import java.io.*;
import java.util.*;
public class bj_10845_S4 {
	static class Node{
		int val;
		Node next;
		Node(int val){
			this.val = val;
		}
	}
	static Node head = null;
	static int count = 0;
	static void push(int val) {
		Node newNode = new Node(val);
		if(head==null) {
			head = newNode;
		}else {
			Node tail = head;
			while(tail.next!=null) tail= tail.next;
			tail.next = newNode;
		}
		++count;
	}
	static void pop() {
		int val = head==null ?-1: head.val;
		if(head.next!=null) {
			head = head.next;
		}else head = null;
		--count;
		System.out.println(val);
	}
	
	static void isEmpty() {
		System.out.println(count==0?1:0);
	}
	
	static void front() {
		System.out.println(head==null?-1:head.val);
	}
	
	static void back() {
		Node tail = head;
		while(tail.next!=null) tail = tail.next;
		System.out.println(tail==null?-1:tail.val);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;++i) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			String order = st.nextToken();
			switch(order) {
			case "push":
				int val = Integer.parseInt(st.nextToken());
				push(val);
				break;
			case "pop":
				pop();
				break;
			case "size":
				System.out.println(count);
				break;
			case "empty":
				isEmpty();
				break;
			case "front":
				front();
				break;
			case "back":
				back();
				break;
			}
		}
	}

}

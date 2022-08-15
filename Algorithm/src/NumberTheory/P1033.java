package NumberTheory;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class P1033 {
	
	static ArrayList<cNode>[] A;
	static long lcm;
	static boolean visited[];
	static long D[];
	
	public static void main(String[] args) throws Exception {
		 Scanner scanner = new Scanner(System.in);
		 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		 int N = scanner.nextInt();
		 A = new ArrayList[N];
		 visited = new boolean[N];
		 D = new long[N];
		 lcm = 1;
		 for (int i=0; i<N; i++) {
			 A[i] = new ArrayList<cNode>(); // 인접 리스트 배열에 에지 정보 저장
		 }
		 for (int i=0; i<N-1; i++) {
			 int a = scanner.nextInt();
			 int b = scanner.nextInt();
			 int p = scanner.nextInt();
			 int q = scanner.nextInt();
			 A[a].add(new cNode(b, p, q));
			 A[b].add(new cNode(a, q, p));
			 lcm *= (p * q / gcd(p, q)); // 최소 공배수는 두 수의 곱을 최대 공약수로 나눈 것
		 }
		 D[0] = lcm; // 0번 노드에 최소 공배수 저장
		 DFS(0); // 0번에서 DFS 탐색 수행
		 long mgcd = D[0]; 
		 for (int i=1; i<N; i++) { // DFS를 이용해 업데이트된 D 배열의 값들의 최대 공약수 계산
			 mgcd = gcd(mgcd, D[i]);
		 }
		 for (int i=0; i<N; i++) { // D 배열의 각 값들을 최대 공약수로 나눠 정답 출력
			 System.out.print(D[i] / mgcd + " ");
		 }
	}
	
	public static long gcd(long a, long b) { // 최대 공약수 함수 구현
		if (b == 0) // b가 0일 경우 a가 최대 공약수
			return a;
		else // 재귀 함수 형태로 구현
			return gcd(b, a % b);
	}
	
	public static void DFS(int Node) { // DFS 구현
		visited[Node] = true; // visited 배열에 현재 노드 방문 기록
		for (cNode i : A[Node]) {
			int next = i.getB();
			if (!visited[next]) { // 현재 노드의 연결 노드 중 방문하지 않은 노드로 >> 다음 노드의 값 = 현재 노드의 값 * 비율 << 저장
				D[next] = D[Node] * i.getQ() / i.getP(); // 주어진 비율로 다음 노드값 갱신
				DFS(next); // DFS 실행(재귀)
			}
		}
	}
}

class cNode {
	
	int b; // 다음 노드
	int p; // 비율 1
	int q; // 비율 2
	
	public cNode(int b, int p, int q) {
		super();
		this.b = b;
		this.p = p;
		this.q = q;
	}
	
	public int getB() {
		return b;
	}
	
	public int getP() {
		return p;
	}
	
	public int getQ() {
		return q;
	}
}

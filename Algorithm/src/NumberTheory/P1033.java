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
			 A[i] = new ArrayList<cNode>(); // ���� ����Ʈ �迭�� ���� ���� ����
		 }
		 for (int i=0; i<N-1; i++) {
			 int a = scanner.nextInt();
			 int b = scanner.nextInt();
			 int p = scanner.nextInt();
			 int q = scanner.nextInt();
			 A[a].add(new cNode(b, p, q));
			 A[b].add(new cNode(a, q, p));
			 lcm *= (p * q / gcd(p, q)); // �ּ� ������� �� ���� ���� �ִ� ������� ���� ��
		 }
		 D[0] = lcm; // 0�� ��忡 �ּ� ����� ����
		 DFS(0); // 0������ DFS Ž�� ����
		 long mgcd = D[0]; 
		 for (int i=1; i<N; i++) { // DFS�� �̿��� ������Ʈ�� D �迭�� ������ �ִ� ����� ���
			 mgcd = gcd(mgcd, D[i]);
		 }
		 for (int i=0; i<N; i++) { // D �迭�� �� ������ �ִ� ������� ���� ���� ���
			 System.out.print(D[i] / mgcd + " ");
		 }
	}
	
	public static long gcd(long a, long b) { // �ִ� ����� �Լ� ����
		if (b == 0) // b�� 0�� ��� a�� �ִ� �����
			return a;
		else // ��� �Լ� ���·� ����
			return gcd(b, a % b);
	}
	
	public static void DFS(int Node) { // DFS ����
		visited[Node] = true; // visited �迭�� ���� ��� �湮 ���
		for (cNode i : A[Node]) {
			int next = i.getB();
			if (!visited[next]) { // ���� ����� ���� ��� �� �湮���� ���� ���� >> ���� ����� �� = ���� ����� �� * ���� << ����
				D[next] = D[Node] * i.getQ() / i.getP(); // �־��� ������ ���� ��尪 ����
				DFS(next); // DFS ����(���)
			}
		}
	}
}

class cNode {
	
	int b; // ���� ���
	int p; // ���� 1
	int q; // ���� 2
	
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

package Search;
// N x M ũ���� �̷ΰ� �־��� �� (1, 1)���� ����� (N, M)�� ��ġ�� �̵��ϱ� ���� ������ �ϴ� ĭ ���� �ּڰ��� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
// 1��° �ٿ� �� ���� N, M, ���� N���� �ٿ��� �̷��� ������ M���� ������ �־�����. 
// 1��° �ٿ� ������ �ϴ� ĭ ���� �ּڰ��� ����Ѵ�.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P2178 {
	static int dx[] = {0, 1, 0, -1}; // dx, dy -> �����¿� Ž���� ���� define�� ���� ����
	static int dy[] = {1, 0, -1, 0};
	static boolean[][] visited;
	static int[][] A;
	static int N, M; // row, column
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		A = new int[N][M]; // A �迭 �ʱ�ȭ
		visited = new boolean[N][M]; // visited �迭 �ʱ�ȭ
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for (int j=0; j<M; j++) {
				A[i][j] = Integer.parseInt(line.substring(j, j+1)); // A �迭�� ������ ����
			}
		}
		BFS(0, 0);
		System.out.println(A[N-1][M-1]);
	}
	
	public static void BFS(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {i, j});
		while (!queue.isEmpty()) {
			int now[] = queue.poll(); // ť���� ��� ������ �������� (poll ����)
			visited[i][j] = true; // visited �迭�� ���� ��� �湮 ���
			for (int k=0; k<4; k++) {
				int x = now[0] + dx[k];
				int y = now[1] + dy[k];
				if (x >= 0 && y >= 0 && x < N && y < M) { // ��ǥ ��ȿ�� �˻�
					if (A[x][y] != 0 && !visited[x][y]) { // �� �� �ִ� ĭ && �湮���� ���� ���
						visited[x][y] = true; // visited �迭�� ���� ��� �湮 ���
						A[x][y] = A[now[0]][now[1]]+1; // A �迭�� depth�� ���� ����� depth+1�� ������Ʈ�ϱ�
						queue.add(new int[] {x, y}); // ť�� ������ ����
					}
				}
			}
		}
	}
	/*
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long n = scanner.nextLong();
		long m = scanner.nextLong(); // m<=100 ���������� n>=2 ���Ǹ� �ֱ⿡ n�� ���� m�� long���� ������
		
		for (int i=0; i<n; i++) { // (4, 6)�� ��� i�� 4�ٱ��� j�� 6�ٱ��� �ް� �ϱ�
			for (int j=0; j<m; m++) {
				int space = scanner.nextInt();
			}
			System.out.println(" "); // (1�ٿ� 6�� �� �޾����� ���� �ٷ� �ѱ��)
		}
	}
	*/
}

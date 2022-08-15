package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11660 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// ���� ��� ���� -> Ű���� �Է��� ���� ������ �� ���ھ� ���۷� ����, ���۰� ���� ���ų� ���� ���ڰ� ��Ÿ���� ������ �� ���� ���α׷��� ���� -> �� ���� ���� ������ ���� ȿ�����̰� ����
		StringTokenizer st = new StringTokenizer(br.readLine());
		// readLine() �� ���
		// 1) ���� ���� string���� �����Ǿ� string�� �ƴ� �ٸ� Ÿ������ �Է� ���� ��� ����ȯ �ؾ� ��
		// 2) ����ó���� import java.io.IOException ����� main ���� throws IOException �ۼ�
		int N = Integer.parseInt(st.nextToken()); // readLine()�� ���� �Է¹��� ���� ���� ������ �����Ͽ� ������� ȣ��
		int M = Integer.parseInt(st.nextToken());
		int A[][] = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int D[][] = new int[N+1][N+1];
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) { // ���� �� ���ϱ�
				D[i][j] = D[i][j-1] + D[i-1][j] - D[i-1][j-1] + A[i][j];
			}
		}
		for (int i=0; i<M; i++) { // ���� �� �迭�� ���� �亯
			int X1 = Integer.parseInt(st.nextToken()); // i ��ġ ����
			int Y1 = Integer.parseInt(st.nextToken()); // j ��ġ ����
			int X2 = Integer.parseInt(st.nextToken()); // i ��ġ ��
			int Y2 = Integer.parseInt(st.nextToken()); // j ��ġ ��
			
			int result = D[X2][Y2] - D[X1-1][Y2] - D[X2][Y1-1] + D[X1-1][Y1-1];
			System.out.println(result);
		}
	}
	
}

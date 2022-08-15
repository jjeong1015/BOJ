package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11659 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// ���� ��� ���� -> Ű���� �Է��� ���� ������ �� ���ھ� ���۷� ����, ���۰� ���� ���ų� ���� ���ڰ� ��Ÿ���� ������ �� ���� ���α׷��� ���� -> �� ���� ���� ������ ���� ȿ�����̰� ����
		StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		// readLine() �� ���
		// 1) ���� ���� string���� �����Ǿ� string�� �ƴ� �ٸ� Ÿ������ �Է� ���� ��� ����ȯ �ؾ� ��
		// 2) ����ó���� import java.io.IOException ����� main ���� throws IOException �ۼ�
		int suNo = Integer.parseInt(stringTokenizer.nextToken()); // readLine()�� ���� �Է¹��� ���� ���� ������ �����Ͽ� ������� ȣ��
		int quizNo = Integer.parseInt(stringTokenizer.nextToken());
		long S[] = new long[suNo+1];
		stringTokenizer = new StringTokenizer(bufferedReader.readLine());
		for (int i=1; i<=suNo; i++) {
			S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
		}
		for (int q=0; q<quizNo; q++) {
			stringTokenizer = new StringTokenizer(bufferedReader.readLine());
			int i = Integer.parseInt(stringTokenizer.nextToken());
			int j = Integer.parseInt(stringTokenizer.nextToken());
			System.out.println(S[j] - S[i-1]);
		}
		/*
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int A[] = new int[N];
		int S[] = new int[N];
		int sum[] = new int[M];
		int i, j =0;
		for (i=1; i<=N; i++) {
			A[i] = scanner.nextInt();
			S[1] = A[1];
			S[i+1] = S[i] + A[i+1];
			System.out.print(S[i]);
		}
		for (i=0; i<M; i++) {
			i = scanner.nextInt();
			j = scanner.nextInt();
		}
		sum[i] = A[i+1] + A[j+1]; // �迭�� �ε��� ������ 0������ �Է� ������ 1���Ͷ�
		System.out.print(sum[i]);
		*/
	}
	
}

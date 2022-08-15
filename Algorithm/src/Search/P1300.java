package Search;
// N x M �� �迭 A�� ��� �ִ� ���� A[i][j]=ixj�� 1���� �迭 B�� ������ B�� ũ��� N X M�� �ȴ�. B�� �������� �������� �� B[k]�� ���϶�.
// 1��° �ٿ� �迭�� ũ�� N, 2��° �ٿ� k�� �־�����.
// B[k] ���
import java.util.Scanner;

public class P1300 {
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // �迭 ũ��
		int K = scanner.nextInt(); // ���ϰ��� �ϴ� index
		long start = 1, end = K;
		long answer = 0;
		
		while (start <= end) { 
			long middle = (start+end)/2;
			long cnt = 0; // �߾Ӱ����� ���� �� �� ������ ���
			for (int i=1; i<=N; i++) {
				cnt += Math.min(middle/i, N); // cnt�� �߾� �ε����� i�� ���� ���� N�� ���� ���� ���� -> ���� �� ī��Ʈ
			}
			if (cnt < K) { // ���� �߾Ӱ����� ���� ���� ������ K���� ����
				start = middle + 1;
			}
			else { // ���� �߾Ӱ����� ���� ���� ������ K���� ũ�ų� ����
				answer = middle; // ���� �ܰ��� �߾Ӱ��� ���� ������ ����
				end = middle - 1; // ���� ������ �߾Ӱ� ����
			}
		}
		System.out.println(answer);
	}
}

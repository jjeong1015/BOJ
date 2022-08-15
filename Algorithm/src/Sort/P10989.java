package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class P10989 {
	
	public static int A[];
	public static long result;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		A = new int[N];
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		Radix_Sort(A, 5);
		for (int i=0; i<N; i++) {
			bw.write(A[i] + "\n");
		}
		bw.flush();
		bw.close();
	}
	
	public static void Radix_Sort(int A[], int max_size) {
		int output[] = new int[A.length]; // �ӽ� ������ ���� �迭
		int jarisu = 1; // ���� �ڸ����� ǥ���ϴ� ��
		int count = 0;
		
		while (count != max_size) { // �ִ� �ڸ�����ŭ �ݺ�
			int bucket[] = new int[10]; // bucket -> ���� �ڸ������� ������ �� �迭�� ���·� �˷��ִ� �迭
			// ex) bucket[4] -> ���� ���� �ڸ����� 0~4 ���� �� ���� �����Ͱ� �ִ��� ����
			
			for (int i=0; i<A.length; i++) {
				bucket[(A[i] / jarisu) % 10]++; // ���� �ڸ����� ����
			}
			for (int i=1; i<10; i++) { // �� �迭�� �̿��� index ���
				bucket[i] += bucket[i-1];
			}
			for (int i=A.length-1; i>=0; i--) { // ���� �ڸ����� �������� ����
				output[bucket[(A[i] / jarisu % 10)] - 1] = A[i];
				bucket[(A[i] / jarisu) % 10]--;
			}
			for (int i=0; i<A.length; i++) { // ���� �ڸ����� �̵��ϱ� ���� A �迭�� ���� �ڸ��� ���� ���� ������ ����
				A[i] = output[i];
			}
			jarisu = jarisu * 10; // �ڸ��� ������Ű��
			count++;
		}
	};
}

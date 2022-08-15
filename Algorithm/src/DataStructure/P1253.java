package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1253 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int Result = 0;
		long A[] = new long[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		for (int k=0; k<N; k++) {
			long find = A[k];
			int i = 0;
			int j = N-1;
			
			while (i<j) { // �� ������ �˰���
				if (A[i] + A[j] == find) { // find�� ���� �ٸ� �� ���� ���̾�� ���� üũ
					if (i != k && j != k) { // �ᱣ���� �ݿ� �� while�� ����
						Result++;
						break;
					}
					else if (i == k) { // ������ ���� �� ��� ����
						i++;
					}
					else if (j == k) { // ������ ���� �� ��� ����
						j--;
					}
				}
				else if (A[i] + A[j] < find) { // ������ i ����
					i++;
				}
				else { // ������ j ����
					j--;
				}
			}
		}
		System.out.println(Result);
		bf.close();
	}
}

package DataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P1940 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());
		int A[] = new int[N];
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i=0; i<N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(A);
		int count = 0;
		int i = 0;
		int j = N - 1;
		while (i<j) { // �� ������ �̵� ��Ģ�� ���� �����͸� �̵��ϸ� ó��
			if (A[i] + A[j] < M) { // ��� �� < M -> ���� ��ȣ ��Ḧ �� ĭ ���� �����ϱ�
				i++;
			}
			else if (A[i] + A[j] > M) { // ��� �� > M -> ū ��ȣ ��Ḧ �� ĭ �Ʒ��� �����ϱ�
				j--;
			}
			else { // ����� �� ����, ���� index �����ϱ�
				count++;
				i++;
				j--;
			}
		}
		System.out.println(count);
		bf.close();
	}
	/*
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int num[] = new int[N];
		int count = 0;
		
		for (int i=0; i<N; i++) {
			num[i] = scanner.nextInt();
		}
		
		for (int i=0; i<num.length-1; i++) {
			for (int j=i+1; j<num.length; j++) {
				if (num[i]>num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			for (int j=i+1; j<N; j++) {
				if ((num[i] + num[j]) == M)
					count++;
			}
		}
		System.out.println("count���� " + count);
	}
	*/
}
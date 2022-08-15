package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1377 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		mData A[] = new mData[N]; // Ŭ������ �����ͷ� ��� �迭
		for (int i=0; i<N; i++) {
			A[i] = new mData(Integer.parseInt(br.readLine()), i);
		}
		Arrays.sort(A); // A �迭 ����(O(nlogn) �ð� ���⵵)
		int Max = 0;
		for (int i=0; i<N; i++) {
			if (Max < A[i].index - i) // A[i]�� ���� �� index - ���� �� index ����� �ִ� ����
				Max = A[i].index - i;
		}
		System.out.println(Max + 1); // �ִ� + 1�� �������� ���
	}
}

class mData implements Comparable<mData> { // ���� Ŭ���� ����
	int value;
	int index;
	
	public mData(int value, int index) {
		super();
		this.value = value;
		this.index = index;
	}

	@Override
	public int compareTo(mData o) { // value ���� �������� ����
		return this.value - o.value;
	}
}

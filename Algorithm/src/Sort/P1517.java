package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1517 {
	
	public static int A[], tmp[];
	public static long result;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		tmp = new int[N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken()); // nextToken -> 공백 자리 땡기기
		}
		result = 0;
		merget_sort(1, N); // 병합 정렬 수행
		System.out.println(result);
	}
	private static void merget_sort(int s, int e) {
		if (e - s < 1)
			return;
		int m = s + (e - s) / 2; // 시작 : s, 종료 : e, 중간 : m
		merget_sort(s, m); // 재귀 함수 구현
		merget_sort(m+1, e);
		for (int i=s; i<=e; i++) {
			tmp[i] = A[i];
		}
		int k = s;
		int index1 = s; // 앞쪽 그룹 시작점
		int index2 = m + 1; // 뒤쪽 그룹 시작점
		while (index1 <= m && index2 <= e) { // 두 그룹 병합 로직
			// 양쪽 그룹의 index가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고 선택된 데이터의 index 값을 오른쪽으로 한 칸 이동
			if (tmp[index1] > tmp[index2]) {
				A[k] = tmp[index2];
				result = result + index2 - k; //뒤쪽 데이터 값이 작은 경우 result 업데이트
				k++;
				index2++;
			}
			else {
				A[k] = tmp[index1];
				k++;
				index1++;
			}
		}
		while (index1 <= m) { // 한쪽 그룹이 모두 선택된 후(반복문이 끝난 후) 남아 있는 값 정리
			A[k] = tmp[index1];
			k++;
			index1++;
		}
		while (index2 <= e) {
			A[k] = tmp[index2];
			k++;
			index2++;
		}
	}
}

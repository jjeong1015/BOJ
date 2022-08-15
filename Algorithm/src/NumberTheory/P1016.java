package NumberTheory;

import java.util.Scanner;

public class P1016 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long min = scanner.nextLong();
		long max = scanner.nextLong();
		boolean check[] = new boolean[(int) (max - min +1)]; // 최댓값과 최솟값의 차이만큼 배열 선언
		
		for (long i=2; i*i<=max; i++) { // 2의 제곱수인 4부터 max보다 작거나 같은 값까지 반복
			long pow = i*i; // 제곱수
			long start_index = min/pow; // 최솟값 / 제곱수
			if (min % pow != 0) // 최솟값에서 제곱수를 나눈 나머지가 0이 아닐 경우
				start_index++; // 나머지가 있을 경우 1을 더해야 min보다 큰 제곱수에서 시작
			for (long j = start_index; pow*j<=max; j++) { // 제곱수의 배수 형태로 탐색
				check[(int) ((j*pow)-min)] = true; // j*pow가 max보다 작을 때 최솟값, 최댓값 사이의 제곱수이므로 check 배열에 저장
			}
		}
		int count = 0; // 제곱이 아닌 수 카운트
		for (int i=0; i<=max-min; i++) {
			if (!check[i]) { // check 배열에서 제곱이 아닌 수라면 count 증가
				count++;
			}
		}
		System.out.println(count);
	}
}
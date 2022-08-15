package NumberTheory;

import java.util.Scanner;

public class P1456 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		long A = scanner.nextLong();
		long B = scanner.nextLong();
		long prime[] = new long[10000001];
		
		for (int i=2; i<prime.length; i++) { // 10¹⁴의 제곱근인 10^7까지 반복(소수 탐색)
			prime[i] = i;
		}
		for (int i=2; i<=Math.sqrt(prime.length); i++) { // 10^7의 제곱근까지 반복 -> 밑에 for문으로 배수 구하려고 얘는 제곱근?
			if (prime[i] == 0) { // 소수가 아닐 경우 넘어감
				continue; // 현재 단계 중단 -> 다음 단계로 넘어가기
			}
			for (int j=i+i; j<prime.length; j=j+i) { // 소수의 배숫값을 10^7까지 반복
				// ex) i=2 -> for (int j=2+2(i값의 2배부터 시작); j<prime.length; j=4+2(i값 만큼 증가))
				prime[j] = 0; // i를 제외한 i의 배수들은 소수가 아닌 것을 표시
			}
		}
		int count = 0;
		for (int i=2; i<1000001; i++) {
			if (prime[i] != 0) { // prime 배열에서 소수인 값일 경우
				long temp = prime[i]; // temp = 현재 소수
				// 현재 소수의 제곱근이 B보다 작을 때를 기준으로 하지만 곱셈이 long 범위를 넘어갈 수 있어 이항 정리로 처리
				while ((double)prime[i] <= (double)B/(double)temp) { // 현재 소수 <= B/temp
					if ((double)prime[i] >= (double)A/(double)temp) { // 현재 소수 >= A/temp
						count++; // 카운트 증가
					}
					temp = temp * prime[i]; // temp = temp * 현재 소수
				}
			}
		}
		System.out.println(count);
	}
}
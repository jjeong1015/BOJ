package NumberTheory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11689 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine()); // 소인수 표현
		long result = n; // 결괏값
		for (long p=2; p<=Math.sqrt(n); p++) { // 모든 배수마다 연산 수행해서 제곱근까지 계산
			if (n % p == 0) { // p가 소인수인 경우
				result = result - result / p; // 결괏값 = 결괏값 - 결괏값 / 현재값
				while (n % p == 0) { // n에서 현재 소인수 내역 제거 ex) 2^7*11이라면 2^7을 없애고 11만 남김
					n /= p;
				}
			}
		}
		if (n > 1) // 아직 소인수 구성이 남아 있을 때 반복문에서 제곱근까지만 탐색했으므로 1개의 소인수가 누락되는 케이스(n이 마지막 소인수일 때)
			result = result - result / n; // // 결괏값 = 결괏값 - 결괏값 / n
		System.out.println(result);
	}
}
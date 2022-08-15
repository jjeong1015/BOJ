package NumberTheory;

import java.util.Scanner;

public class P1929 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int M = scanner.nextInt();
		int N = scanner.nextInt();
		int prime[] = new int[N+1];
		for (int i=2; i<=N; i++) { // 배열 초기화
			prime[i] = i;
		}
		for (int i=2; i<=Math.sqrt(N); i++) { // 제곱근까지만 수행
			// N의 제곱근까지만 탐색하는 이유
			// N이 a*b라고 가정했을 때, a와 b 모두 N의 제곱근보다 클 수 없음
			// 따라서 N의 제곱근까지만 확인해도 전체 범위의 소수 판별 가능
			// ex) 16 = 4*4 -> 16보다 작은 숫자는 항상 4보다 작은 약수를 갖게 됨
			// 따라서 4까지만 확인하고 소수 판별 진행
			if (prime[i] == 0) { // 소수가 아니면 넘어감
				continue;
			}
			for (int j=i+i; j<=N; j=j+i) { // 소수의 배수 값을 N까지 반복
				prime[j] = 0; // 배수 지우기
			}
		}
		for (int i=M; i<=N; i++) {
			if (prime[i] != 0) { // 소수인 값 출력
				System.out.println(prime[(int) i]);
			}
		}
		/*
		int prime[] = new int[N-M+1];
		int i = 0;
		int count = 0;
		System.out.println("N-M+1 : " + (N-M+1));
		
		for (i=M; i<=N; i++) {
			if (count != 0) {
				for (i=0; i<N/M; i++) { // 몫값 배수까지 모두 삭제
					System.out.println("소수 아님");
				}
				count = 0;
			}
			
			if (N % M == 0) { // 나머지가 0 -> 나눠짐 -> 해당 수의 배수를 모두 삭제하기
				for (i=0; i<N/M; i++) { // 몫값 배수까지 모두 삭제
					System.out.println("삭제");
				}
			}
			
			else {
				System.out.println(M);
				M++;
				count = 1;
			}
		}
		*/
	}
}

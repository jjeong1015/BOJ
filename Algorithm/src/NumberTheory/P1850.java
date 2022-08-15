package NumberTheory;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class P1850 {
	
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		long A = scanner.nextLong();
		long B = scanner.nextLong();
		long result = gcd(A, B);
		
		while (result > 0) { // A, B의 최대 공약수만큼 1을 반복해 출력
			bw.write("1"); // 출력 횟수가 많기 때문에 BufferedWriter 사용
			result--;
		}
		bw.flush();
		bw.close();
	}
	
	public static long gcd(long A, long B) { // 최대 공약수 gcd() 함수 구현
		if (B == 0) // B가 0이 되는 경우 A가 최대 공약수 ex) A % B = 나머지1 => B % 나머지1 = 나머지2 => 나머지1 % 나머지2 = 나머지3
			return A; // (연산할 때마다 B 위치가 A 위치로, 나머지 위치가 B 위치로 넘어가기 때문에)
		else // 재귀 함수 형태로 구현
			return gcd(B, A % B); // gcd(작은 수, 큰 수 % 작은 수)
	}
}

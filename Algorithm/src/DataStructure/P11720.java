package DataStructure;
import java.util.Scanner;
import java.util.StringTokenizer;

public class P11720 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // ���� ����
		String sNum = scanner.next(); // �Է°��� String ���� sNum�� ������ �� char[]�� ������ ��ȯ
		char[] cNum = sNum.toCharArray();
		int sum = 0;
		for (int i=0; i<cNum.length; i++) {
			sum += cNum[i] - '0'; // cNum[i]�� ���������� ��ȯ�ϸ鼭 sum�� ���Ͽ� �����ϱ�
		}
		System.out.println(sum);
		/*
		String sum = null;
		for (int i=0; i<N; i++) {
			String num = scanner.nextLine();
			String tokens[] = num.split("");
			sum += tokens[i];
			System.out.print("i�� "+ i);
		}
		System.out.print(sum);
		*/
	}

}

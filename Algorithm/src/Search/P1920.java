package Search;
// X��� ������ �����ϴ��� �˾Ƴ��� ���α׷�
// 1��° �ٿ� �ڿ��� N, �� ���� �ٿ� N���� ����(A[1], ..., A[N])�� �־�����. �� ���� �ٿ� M, �� ���� �ٿ� M���� ������ �־����µ� �� ������ A �ȿ� �����ϴ��� �˾Ƴ���.
// M���� �ٿ� ���� ����Ѵ�. �����ϸ� 1, �������� ������ 0 ���
import java.util.Scanner;

public class P1920 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int ndata[] = new int[n];
		for (int i=0; i<ndata.length; i++) {
			ndata[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();
		int mdata[] = new int[m];
		for (int i=0; i<mdata.length; i++) {
			mdata[i] = scanner.nextInt();
		}
		
		for (int i=0; i<ndata.length-1; i++) {
			for (int j=i+1; j<ndata.length; j++) {
				if (ndata[i]>ndata[j]) { // ���ʿ� �ִ� i�� �����ʿ� �ִ� j���� ���� Ŭ ��� ��ȯ
					int temp = ndata[i];
					ndata[i] = ndata[j];
					ndata[j] = temp;
				}
			}
		}
	}

}

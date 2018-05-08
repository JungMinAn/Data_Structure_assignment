import java.util.*;

/**
 * Lab 002 
 * @version 1.0
 * @author Sanghwan Lee
 * @id 20181234
 */

class LabTest {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(true) {
		System.err.print("Enter n m : ");
		int cbn = in.nextInt();
		int cbm = in.nextInt();
		if(cbn == 0) {
			break;
		}
		else {
		System.out.printf("Combination(%d, %d) : " + Combi(cbn, cbm) + "\n",cbn, cbm);
	}
	}
	}
	static int Combi(int n, int m) {
		if (m == 0 || m == n) {
			return 1;
	}
		else {
				return Combi(n-1, m-1) + Combi(n-1, m);
	}
	}
	}



// Lab 012	: Natural Merge
// Name :
// Student ID :

import java.util.*;


class NaturalMerge {
	int noe;  // the number of elements
	private int[] inputArray; // input array 
	int[] outputArray; // output array 


	NaturalMerge() { 
		// Graph constructor. 
		noe = 0;
	}

	public String toString() {
		String str = new String();
		str = "Input : ";
		for(int i = 0; i < noe; i++) {
			str += inputArray[i] + " ";
		}
		str += "\nOutput : ";
		for(int i = 0; i < noe; i++) {
			str += outputArray[i] + " ";
		}
		return str;
	}

	void Init(int [] arr, int n) { 
		noe = n;
		inputArray = new int[noe];
		System.arraycopy(arr, 0, inputArray, 0, n);

		outputArray = new int[noe];
	}

	void Merge() { 
		int n = noe;
		int r = 0;
		System.out.print("n = " + n);
		for (int i = 0; i<n; i++){
			if (inputArray[i] > inputArray[i+1]){
				r = i+1;
				System.out.print(", m = " + r);
				System.out.println();
				break;
			}
		}
		int lidx = 0;
		int ridx = r;
		int oidx = 0;
		while (lidx < r && ridx < n){
			if (inputArray[lidx]>inputArray[ridx]){
				System.out.print("R ");
				outputArray[oidx++] = inputArray[ridx++];
			}
			else {
				System.out.print("L ");
				outputArray[oidx++] = inputArray[lidx++];
			}
		}
		for (; lidx<r; lidx++){
			outputArray[oidx++] = inputArray[lidx];
		}
		for (; ridx<n; ridx++){
			outputArray[oidx++] = inputArray[ridx];
		}

	// NEED TO IMPLEMENT










		System.out.println();
	}
}








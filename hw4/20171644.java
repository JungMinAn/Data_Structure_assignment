// HW 184, QuickSort
// Name :
// Student ID :

import java.util.*;


class QuickSort {
    int[] arr; // array
	int arrSize;  // number of elements in arr

	QuickSort() { 
		arr = new int[1024];  
		arrSize = 0;
	}


	void Show(int s, int e) { 
		// Show all the element in the arr
		if(s > e)
			return ;
		String str = new String();
		str = "arr : ";

		// print all the nodes in the arr
		for(int i = 0; i < arrSize; i++) {
			if(i == s)
				str += "[";
			else
				str += " ";
			str += arr[i];
			if(i == e)
				str += "]";
			else
				str += " ";
		}
		System.out.println( str);
	}

	void  Init(int[] es, int n) {	
		// fill the arr array by the input
		arrSize = n;
		for(int i = 0; i < n; i++)
			arr[i] = es[i];
	}


	void  Sort() {
		// sort arr[0:arrSize-1] into nonincreasing order
		// This is an invoking method to the Partition() and QSort() 
		QSort(0, arrSize - 1);	// quick sort from 0 to n-1
	}



	void  QSort(int s, int e) {	
		// sort arr[s:e] into nonincreasing order
		System.out.println("Sort in [" + s + "," + e + "]");
		Show(s, e);
		int f = s;
		int l = e+1;
		int temp;
		if(s >= e){
			return;
		}
		int m = (s + e)/2;
		int pivot;
		if (((arr[s] >= arr[m]) && (arr[s] <= arr[e])) || ((arr[s] >= arr[e]) && (arr[s] <= arr[m]))){
			pivot = arr[s];
		}
		else if (((arr[m] >= arr[s]) && (arr[m] <= arr[e])) || ((arr[m] >= arr[e]) && (arr[m] <= arr[s]))){
			pivot = arr[m];
			temp = arr[m];
			arr[m] = arr[s];
			arr[s] = temp;
		}
		else {
			pivot = arr[e];
			temp = arr[e];
			arr[e] = arr[s];
			arr[s] = temp;
		}
		while(f<l){
			f++;
			l--;
			while(arr[f] > pivot){
				f++;
			}
			while(arr[l] < pivot){
				l--;
			}
			if (f<l){
				temp = arr[l];
				arr[l] = arr[f];
				arr[f] = temp;
			}
		}
		// f = s;
		// for (int i = s; i<e; i++){
		// 	if (arr[f+1] >= pivot){
		// 		f++;
		// 	}
		// }
		//	"NEED TO IMPLEMENT" 
		temp = arr[l];
		arr[l] = arr[s];
		arr[s] = temp;
		QSort(s, l-1);
		QSort(l+1, e);


	}

}



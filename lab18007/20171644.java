import java.util.*;
import java.lang.reflect.*;

/**
 * Generic version of the MinHeap class.
 * @param <T> the type of the value being added
 */

class MinHeap <T extends Comparable> {
	private T[] heapArray;
	private int heapSize;	// number of heap elements

	/**
	 * Create an empty MinHeap of size capacity
	 */
	MinHeap(Class<T> elemType, int capacity) {
		heapArray = (T []) Array.newInstance(elemType, capacity);
		heapSize = 0;
	}


	/**
	 * Insert item into the MinHeap
	 */
	void Insert (T item) { 
		heapSize++;
		int compareidx = heapSize;
		while ((compareidx > 1) && (item.compareTo(heapArray[compareidx/2]) < 0)){
			heapArray[compareidx] = heapArray[compareidx/2];
			compareidx /= 2;
		}
		heapArray[compareidx] = item;

	}

	void PostOrder (final int idx) { 
		if (idx*2+1 <= heapSize){
			PostOrder(idx*2);
			PostOrder(idx*2+1);
		}
		System.out.print(heapArray[idx] + " ");	
	}

	public String toString() {
		String a = new String();
        a = "Min Heap : - ";
        for(int i = 1; i <= heapSize; i++) {
            a += heapArray[i] + "  ";
        }
        return a;
    }
}; 





import java.util.*;

/**
 */

class WinnerTree  {
	int[] tree; // Winner tree

	int capacity;	// size of the tree
	int n;	// number of external elements in WinnerTree


	WinnerTree(int theCapacity) { // WinnerTree constructor. 
		capacity = theCapacity;
		tree = new int[capacity];	// tree[0] is not used
		n = 0;
	}

	public String toString() { // Show all the element in sequence
		String str = new String();
		str = "WT : - ";

		// print all the nodes in the tree
		for(int i = 1; i < n * 2; i++)
			str += tree[i] + "  ";
		return str;

	}

	void  Init(int[] treedata, int nitems) {	
		// initialize the tree by using the input
		n = nitems / 2;

		int i = 1; 
		for(i = 1; i < nitems; i++) {
			tree[i] = treedata[i];
		}
	}

	void PopNReplace(int data) {	
		// NEED TO IMPLEMENT

		int tree_idx = n;
		while(tree_idx<=n*2){
			if (tree[tree_idx] == tree[1]){
				tree[tree_idx] = data;
				break;
			}
			tree_idx++;
		}
		while (tree_idx > 1){
			if (tree_idx%2 == 0){
				if (tree[tree_idx] < tree[tree_idx+1]){
					tree[tree_idx/2] = tree[tree_idx];
				}
				else{
					tree[tree_idx/2] = tree[tree_idx+1];
				}
			}
			else{
				if (tree[tree_idx] < tree[tree_idx-1]){
					tree[tree_idx/2] = tree[tree_idx];
				}
				else{
					tree[tree_idx/2] = tree[tree_idx-1];
				}
			}
			tree_idx /= 2;
		}		
	}

}


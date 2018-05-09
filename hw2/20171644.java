import java.util.*;

// Name :
// Student ID :


class DblList <T> {
	class DblListNode <U> {
		private U data;	// storage for data
		private DblListNode<U> left;	// link to the left node
		private DblListNode<U> right;	// link to the right node

		// constructors come here
		DblListNode() {
			this.right = this;
			// the right field contains the DblListNode itself
		}
		DblListNode(U data) {
			// set the data field 
			this.data = data;
		}
		DblListNode(U data, DblListNode<U> right) {
			// set the data field and right field
			this.data = data;
			this.right = right;
		}
	};

	private DblListNode<T> first; // reference to the dummy head node
	private DblListNode<T> current; // current position of the hand
	private DblListNode<T> cutnode; // Node that has been cut


	DblList() { 
		// DblList constructor. Create a dummy head node

		first = new DblListNode<T>(); 
		first.right = first.left = first;
		current = first; // current position of the hand
		cutnode = null; // Node that has been cut
	}


	/**
	 * Show all the elements in DblList
	 */
	public String toString() {
	//	cerr << "NEED TO IMPLEMENT" << endl;
		String str = new String();
		str = "";
		DblListNode<T> p = first.right;
		while (p != first){
			if (p == current){
				str += ("[" + p.data + "] ");
			}
			else{
				str += (" " + p.data + "  ");
			}
			p = p.right;
		}
		if (cutnode != null){
			str += (": " + cutnode.data);
		}
		return str;
	}


	boolean  PutLeft()  {
		if (cutnode == null){
			return false;
		}
		else{
			if (first.right == first){
				current = first;
			}
			DblListNode<T> p = cutnode;
			p.right = current;
			p.left = current.left;
			current.left.right = p;
			current.left = p;
			cutnode = null;
			current = p;
		}
	//	cerr << "NEED TO IMPLEMENT" << endl;
		return true;
	}



	boolean  PutRight()  {
		if (cutnode == null){
			return false;
		}
		else{
			if (first.right == first){
				current = first;
			}
			DblListNode<T> p = cutnode;
			p.left = current;
			p.right = current.right;
			current.right.left = p;
			current.right = p;
			cutnode = null;
			current = p;
		}
			return true;
		//	cerr << "NEED TO IMPLEMENT" << endl;
	}


	boolean  MoveLeft()  {
		if (current.left == first){
			return false;
		}
		else{
			current = current.left;
		}
	//	cerr << "NEED TO IMPLEMENT" << endl;
	
		return true;
	}


	boolean  MoveRight()  {
		if (current.right == first){
			return false;
		}
		else{
			current = current.right;
		}
		//	cerr << "NEED TO IMPLEMENT" << endl;
	
		return true;
	}
	
	void  MoveEnd()  {
		current = first.left;
		//	cerr << "NEED TO IMPLEMENT" << endl;

	}


	boolean  Cut()  {
		if ((first.right == first) || (cutnode != null)){
			return false;
		}
		else{
			cutnode = current;
			if (current.right == first){
				current = current.left;
				current.right.left = null;
				current.right.right = null;
				current.right = first;
				first.left = current;
			}
			else{
				current = current.right;
				current.left = current.left.left;
				current.left.right = current;
			}
		}
		return true;
	}

	void  InsertBack(final T e) {	
		DblListNode<T> p = new DblListNode<T>(e);
		p.left = first.left;
		p.right = first;
		first.left.right = p;
		first.left = p;
		current = p;
		// insert the element into the back of the list
		//	cerr << "NEED TO IMPLEMENT" << endl;

	}

	void Reverse() { 
		DblListNode<T> p = first;
		p.left = p.right;
		p = p.right;
		while(p != first){
			p.left = p.right;
			p = p.right;
		}
		p = first;
		p.left.right = p;
		p = p.left;
		while(p != first){
			p.left.right = p;
			p = p.left;
		}
		// Reverse the list
		//	cerr << "NEED TO IMPLEMENT" << endl;


	}

	boolean equals(DblList<T> dbl) { 
		DblListNode<T> p = first.right;
		DblListNode<T> q = dbl.first.right;
		while ((p != first) || (q != dbl.first)){
			if (p.data != q.data){
				return false;
			}
			p = p.right;
			q = q.right;
		}
		if ((p != first) || (q != dbl.first)){
			return false;
		}
		// check whether the two lists are equal
		//	cerr << "NEED TO IMPLEMENT" << endl;

		return true;
	}

}


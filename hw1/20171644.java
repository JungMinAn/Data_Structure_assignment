import java.util.*;



class Expression {
	static Stack<String> stack1 = new Stack<String>();
	static Stack<Double> stack2 = new Stack<Double>();
	static String Back_Equiate_String = new String();
	static int Popped_Count;
	static double Final_Result;
	static double Eval(Vector<String> infix) throws Exception {
		toString1(infix);
		SetText(infix);
		EvalBackword();
		stack1.removeAllElements();
		Back_Equiate_String = "";
	// NEED TO IMPLEMENT
		return Final_Result;
	}

	static void toString1(Vector<String> infix) {
		String Middle_Equiate_String = new String();
		String Obj = "";
		System.out.print("infix expression : ["); 
		for (int i = 0; i<infix.size();i++){
			Obj = infix.elementAt(i);
			Middle_Equiate_String += (Obj + "  ");
		}
		System.out.println(Middle_Equiate_String.substring(0, Middle_Equiate_String.length()-2) + "]"); 
	}
	
	static void SetText(Vector<String> infix){
		String Obj = "";
		String Sstack = new String();
		for (int i = 0; i<infix.size(); i++){
			Obj = infix.elementAt(i);
			System.out.println("Token : " + Obj);
			if (Obj.equals("(")){
				stack1.push(Obj);
				Sstack += (Obj + " ");
			}
			else if (Obj.equals(")") || Obj.equals("+") || Obj.equals("-") || Obj.equals("*") || Obj.equals("/")){
				if (stack1.isEmpty() != true){
					Deal_With_Stack(Obj);
					int countx2 = 2 * Popped_Count;
					Sstack = Sstack.substring(0, Sstack.length()-countx2);
					if (!Obj.equals(")")){
						Sstack += (Obj + " ");
					}
				}
				else {
					stack1.push(Obj);
					Sstack += (Obj + " ");
				}
			}
			else{
				Back_Equiate_String += (Obj + "  ");
			}
			System.out.println("Stack : " + Sstack);
		}
		while (!stack1.isEmpty()){
			Back_Equiate_String += (stack1.pop() + "  ");
		}
		System.out.println("Postfix expression : [" + Back_Equiate_String.substring(0, Back_Equiate_String.length()-2) + "]");
	}
	static int ComparePriority(String s1, String s2){
		int s1p, s2p;
		switch (s1){
			case "+":
				s1p = 3;
				break;
			case "-":
				s1p = 3;
				break;
			case "*":
				s1p = 2;
				break;
			case "/":
				s1p = 2;	
				break;
			case "(":
				s1p = 100;
			case ")":
				s1p = 50;
			default:
				s1p = 100;
		}
		switch (s2){
			case "+":
				s2p = 3;
				break;
			case "-":
				s2p = 3;
				break;
			case "*":
				s2p = 2;
				break;
			case "/":
				s2p = 2;	
				break;
			case "(":
				s2p = 100;
			case ")":
				s2p = 50;
			default:
				s2p = 50;
		}
		return s1p-s2p;
	}

	static void Deal_With_Stack(String C_stack){
		Popped_Count = 0;
		String P_stack = "";
		P_stack = stack1.peek();
		int Compare_int = ComparePriority(P_stack, C_stack); 
		while ((Compare_int <= 0) && (!stack1.isEmpty())){
			Back_Equiate_String += (stack1.pop() + "  ");
			Popped_Count += 1;
			if (stack1.isEmpty()){
				break;
			}
			else{
			P_stack = stack1.peek();
			Compare_int = ComparePriority(P_stack, C_stack);
			}
		}
		if (C_stack.equals(")")){
			stack1.pop();
			Popped_Count += 1;
		}
		else{
			stack1.push(C_stack);
		}
	}
	static void EvalBackword(){
		Final_Result = 0.0;
		for (int i=0; i<Back_Equiate_String.length()/3; i++){
			String B_Operator = Back_Equiate_String.substring(3*i, (3*i)+1);
			double opr1, opr2, D_result;
			if ((B_Operator.equals("+")) || (B_Operator.equals("-")) || (B_Operator.equals("*")) || (B_Operator.equals("/"))){
				opr1 = stack2.pop();
				opr2 = stack2.pop();
				switch (B_Operator){
					case "+":
						D_result = opr2 + opr1;
						break;
					case "-":
						D_result = opr2 - opr1;
						break;
					case "*":
						D_result = opr2 * opr1;
						break;
					case "/":
						D_result = opr2 / opr1;
						break;
					default:
						D_result = 0.0;
				}
				stack2.push(D_result);
			}
			else{
				stack2.push(Double.parseDouble(B_Operator));
			}
		}
		Final_Result = stack2.pop();
	}
}; 




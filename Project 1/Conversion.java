/**
 * Author: Opeyemi Ajisegiri
 * Class: CMSC 350 - Data Structures and Analysis
 * Project: 1
 * Date: August 31th, 2021
 * File: The conversion class
 * Purpose:  Accepts the user prefix or postfix expression input
 * 			 and converts it into either a postfix or prefix expression. 
 */

//import java.util.EmptyStackException;
import java.util.Stack;
import java.util.StringTokenizer;

public class Conversion {
	private String input;

	private  Stack<String> expression = new Stack<String>();
	
	public Conversion(String Input) {
		this.input = Input;
	}
	
	/*	Getters and Setters	*/
	public String getInput() { return this.input; }
	public void setInput(String Input) { this.input = Input; }	
	
	public String ConvertToPostfix() throws EmptyStackException {
		Stack<String> operand = new Stack<String>();
		Stack<String> finalExpression = new Stack<String>();
		
		/*String token;
		StringTokenizer tokened = new StringTokenizer(this.getInput(),"+-/* ",true);
		while(tokened.hasMoreTokens()) {
			token = tokened.nextToken();
			if(!token.equals(" "))
				operand.push(token);
		}
		while(!(operand.isEmpty())) {
			token = operand.pop();
			if(Character.isDigit(token.charAt(0)))
				finalExpression.push(token);
			else {
				String tempA = finalExpression.pop();
				System.out.println("A:" + tempA);
				//String tempB = finalExpression.pop();
				//System.out.println("B:" + tempB);
				expression.push(tempA+token);
			}
			System.out.println(finalExpression);
		}
		return finalExpression.pop();*/
		String Expression ="";
		String[] tempStr = this.getInput().split("");
		for(int a = 0; a < tempStr.length; a++) {
			if(Character.isSpaceChar(a))
			//if(tempStr[a] == " ")
				continue;
			else
				operand.push(tempStr[a]);
		}
		while(!(operand.isEmpty())) {
			String top = operand.pop();
			if((top == "+")||(top == "-")||(top == "/")||(top == "*")||(top == "%")) {
				String i = operand.pop();
				String j = operand.pop();
				finalExpression.push(i+j+top);		
			}
			else
				finalExpression.push(top);
		}
		while(!(finalExpression.isEmpty())){
			Expression = finalExpression.pop() + Expression;	
		}
		return Expression;
	}
	
	public String ConvertToPrefix() throws EmptyStackException {
		Stack<String> prefixOrder = new Stack<String>();
		String token,Expression="";
		StringTokenizer tokened = new StringTokenizer(this.getInput(),"+-*/ ",true);
		while(tokened.hasMoreTokens()) {
			token = tokened.nextToken();
			System.out.println(prefixOrder);
			System.out.println(token);
			if(token.equals(" "))
				continue;
			else if(Character.isDigit(token.charAt(0)))
				prefixOrder.push(token);
			else {
				String tempA = prefixOrder.pop();
				System.out.println("A:" + tempA);
				//String tempB = prefixOrder.pop();
				//System.out.println("B:" +tempB);
				prefixOrder.push(token+tempA/*+tempB*/);
			}
		}
		while(!(prefixOrder.isEmpty())){
			Expression = prefixOrder.pop()+Expression;	
		}
		return Expression;

	}
}
/**
 * Author: Opeyemi Ajisegiri
 * Class: CMSC 350 - Data Structures and Analysis
 * Project: 3
 * Date: September 28th, 2021
 * File: Binary Tree class [BinaryTree.java]
 * Purpose:  Accepts a string and creates a binary tree that is interacted with through depth-first
 * traversal or breath-first traversal .
 */

//import java.util.StringTokenizer;
import java.util.*;


public class BinaryTree {
	
	protected static class Node{
		char data;
		Node left; 
		Node right;
		
		Node(){}
		Node(char vArray){
			this.data = vArray;
			this.left = null; 
			this.right = null;
		}
	} 
	
	/*static*/ Node root;
	Node parent;
	static Stack<Node> stack = new Stack<Node>();
	
	public BinaryTree()	{}
	
	public BinaryTree(String item) throws InvalidTreeSyntax
	{
		StringTokenizer tokenized = new StringTokenizer(item, "( )", true);
		System.out.println(item);
		//BinaryTree.root = constructTree(root, tokenized);
		/*BinaryTree.*/root = constructTree(root, item);
	}
		
	private Node constructTree(Node node, /*StringTokenizer*/String value) throws InvalidTreeSyntax {
		Node current = null; Node temp = null; parent = null;
		/***********  SECOND ITERATION:  RECURSION  ************/
		/*if(value.charAt(stack.size()) ==  '(') {
			System.out.println(stack.size());
			stack.add(new Node(value.charAt(stack.size())));
			constructTree(node,value.substring(stack.size()-1));
		}
		else {
			if(value.charAt(stack.size()) == ')') {
				stack.add(new Node(value.charAt(stack.size())));
				//while(!stack.isEmpty()) {
				//	temp = stack.pop();
				//	if(temp.data == '(' || temp == root)
				//		break;
				//}
				//constructTree(node,value.substring(stack.size()));
				return null;
			}else 
			//if(root ==  null) {
			//		root = new Node(value.charAt(stack.size()));
			//		stack.add(root);
			//		constructTree(root.left,value.substring(stack.size()));
			//	}else 
					if(node == null){
					node = new Node(value.charAt(stack.size()));
					stack.add(node);
					//if(stack.size() != value.length()) {
						constructTree(node,value.substring(stack.size()));
					//}
					return node;
				}else if(value.charAt(stack.size()-1)!= '(') {
					//constructTree(node.left,value.substring(stack.size()));
					constructTree(node.right,value.substring(stack.size()));
				}else {
					constructTree(node.left,value.substring(stack.size()-1));
					constructTree(node.right,value.substring(stack.size()));
				}
			
		}*/
		if(value.isEmpty())
			throw new InvalidTreeSyntax("Missing Parenthesized Order String");
		char[] vArray = value.toCharArray();
		for(int a = 0;a<vArray.length;a++) {
			if(vArray[a] == ' ') {
				throw new InvalidTreeSyntax("Invalid String Format");
			}
			else if(vArray[a] == '(') {
				if(!stack.isEmpty())
					parent = stack.peek();
				else
					stack.add(new Node(vArray[a]));
			}
			else {
				if(root == null) {
					root = new Node(vArray[a]);
					stack.add(root);
					parent = root;
					System.out.println(root.data);
					System.out.println("root: "+stack.peek().data);
					}
				else if(vArray[a] == ')') {
					while(!stack.isEmpty()) {
						temp = stack.pop();
						if(temp.data == '(') {
							temp.right = parent;
							break;
						}
						if(stack.isEmpty())
							throw new InvalidTreeSyntax("Missing Parenthesis: '('");
					}
				}
				else if(vArray[a-1] == '(') {
					if(temp != null && parent.left != null) {
						root.right = new Node(vArray[a]);
						System.out.println("root.right: "+root.right.data);
						stack.push(root.right);
					}else {
					System.out.println("parent "+parent.data);
					parent.left = new Node(vArray[a]);
					stack.add(parent.left);
					System.out.println(root.left.data);
					System.out.println("left: "+stack.peek().data);
					System.out.println(parent.left.data);
					}
				}
				else {
					System.out.println("parent: "+parent.data);
					parent.right = new Node(vArray[a]);
					stack.add(parent.right);
					System.out.println("right: "+stack.peek().data);
					}
			}	
		}
		if(!stack.isEmpty())
			throw new InvalidTreeSyntax("Missing Parenthesis: ')'");
		System.out.println("root: "+root.data);
		System.out.println("root.left: "+root.left.data);
		System.out.println("root.left.left: "+root.left.left.data);
		System.out.println("root.right: "+root.right.data);
		return root;
		
		/************ FIRST ITERATION: ITERATIVE SOLUTION  ****************/
		/*while(value.hasMoreTokens()) {
			String token = value.nextToken();
				if(token == "(") {
					System.out.print("token: "+token);
					stack.push(new Node(token));}
				else if(token != "("){
					if(root == null && token != "(") {
						root = new Node(token);
						stack.push(root);
						System.out.println();
						System.out.println(stack.peek().data);
						System.out.println("root: "+root.data);
					}else if(root != null ) {
						if(!(stack.isEmpty()) && token == ")") {
							while(!stack.isEmpty()) {
							temp = stack.pop();
							}
							if(temp.data == "(")
								break;
						}
						if(temp == null && (stack.peek().data == "(")) {
							System.out.println(token);
							stack.peek().left = new Node(token);
							stack.push(stack.peek().left);
							System.out.println("left: "+stack.peek().left);
						}else if(temp != null && stack.peek().data != "(") {
							temp.right = new Node(token);
							stack.push(temp.right);
							System.out.println("right: "+temp.right);
						}
					}}*/
						/*current = parent;
						if(parent.left == null) {
							current = parent;
							current = current.left;
							System.out.println();
							current = new Node(token);
							System.out.println("left "+current.data);
							System.out.println("parent: "+parent.data);
						}else if(parent.left != null) {
							parent = current;
							current = current.right;
							current = new Node(token);
							System.out.println("right " +current.data);
						}else {
							throw new InvalidTreeSyntax("Improper String Formation");
						}
					parent = current;*/
				//} //break;
				//}
			//System.out.println(token);
			/*if(token == ")") {
				popped = temp.pop();
			while(popped != "(") {
				current = parent; 
				if(current == root) {
					current = parent = root.right;
					break;
				}else if(temp.isEmpty())
					throw new InvalidTreeSyntax("Missing Parenthesis: ')'");
				popped = temp.pop();
				}
			}*/
			//}
		//}
		/*if(temp.isEmpty())
			throw new InvalidTreeSyntax("Missing Parenthesis: '('");*/
		//return root;
	}
	

	
	

	
	public int treeHeight() {return treeHeight(/*BinaryTree.*/root);}
	
	private int treeHeight(Node node) {
		if(node == null)
			return 0;
		int ldepth = treeHeight(node.left);
		int rdepth = treeHeight(node.right);
		return Math.max(ldepth, rdepth)+1;
		//return (ldepth > rdepth ? ldepth : rdepth) + 1;
	}
	
	public boolean isTreeFull() {return isTreeFull(/*BinaryTree.*/root);}
	
	private boolean isTreeFull(Node node) {
		if(node == null)
			return false;
		if(node.left == null && node.right == null)
			return true; 
		if((node.left != null) && (node.right != null))
			return (isTreeFull(node.left) && isTreeFull(node.right));
		return false;
	}
	
	public boolean isBalanced() {return isBalanced(/*BinaryTree.*/root);}
	
	private boolean isBalanced(Node node) {
		if(node == null)
			return true;
		int ldepth = treeHeight(node.left);
		int rdepth = treeHeight(node.right);
		if((Math.abs(ldepth - rdepth) <= 1) && 
				(isBalanced(node.left) && isBalanced(node.right)))
			return true;
		return false;
	}
	
	public boolean isProper() { return isProper(/*BinaryTree.*/root);}
	
	private boolean isProper(Node node) {
		if(node == null)
			return true; 
		if(node.left == null && node.right == null)
			return true;
		else if((node.left != null) && (node.right != null))
			return true;
		return false;
	}
	
	public int nodeCount() {return nodeCount(root);}
	
	private int nodeCount(Node node) {
		int count = 0;
		if(node == null)
			return count;
		return count = 1 + nodeCount(node.left)+nodeCount(node.right);
	}
	
	public String inOrderTrasversal() {  
		String string = "";//new StringBuilder();
		string = inOrderTrasversal(/*BinaryTree.*/root);
		return string;
	}
	
	private String inOrderTrasversal(Node node) {
		StringBuilder strTemp = new StringBuilder();
		String str = "";
		//String random = "people";
		if(node != null) {
			inOrderTrasversal(node.left);
			//str.append(node.data);
			//str += String.valueOf(node.data);
			strTemp.append(node.data);
			System.out.println(node.data);
			inOrderTrasversal(node.right);
		}
		str = strTemp.toString();
		return str;
	}
	
	private Node delete() {
		//not implemented
		return new Node();
	}
}

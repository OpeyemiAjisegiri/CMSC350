/**
 * Author: Opeyemi Ajisegiri
 * Class: CMSC 350 - Data Structures and Analysis
 * Project: 2
 * Date: September 14th, 2021
 * File: Polynomial class [Polynomial.java]
 * Purpose: Implements the Polynomial single linked-list with each node in the list
 * containing a polynomial [Example: 3x^2]; i.e. the node contains the coefficient, exponent 
 * and a pointer to the next node in the list.
 */

import java.io.File;
//import java.io.FileNotFoundException;
import java.util.*;
import java.util.Iterator;
//import java.util.ListIterator;

public class Polynomial implements Iterable<Polynomial>,Comparable<Polynomial> {
	
	/* Node Data Struct*/
	/*private static class Struct {
		float coefficient;
		float exponent;
	}*/
	
	/* Node */
	private static class Node {
		//private Struct data;
		private int coefficient; 
		private int exponent;
		private Node next;
				
		public Node(int coefficient, int exponent){
			this.coefficient = coefficient;
			this.exponent = exponent;
			this.next = null;	
		}
		
		public String toString() {
			//StringBuilder temp = new StringBuilder();
			String temp = ""; 
			if(this.coefficient == 0)
				temp = "";
			else {
				if(this.exponent == 0)
					temp += this.coefficient;
				else if(this.exponent == 1)
					temp += this.coefficient + "X";
				else 
					temp += this.coefficient + "X^"+this.exponent;
			}
			return temp;}
	}
	
	/* Placeholder */
	private Node current, head, tail;
	private int size = 0;
	private char[] tempStr;

	/* Constructor */
	Polynomial(String StrInput){
		int tsize = 0;
		tempStr = StrInput.toCharArray();
		/* Sadly, this system doesn't work for any floating number */
		for(tsize = 0;tsize <= (tempStr.length)-1; tsize+=4) {
			Node node = new Node(tempStr[tsize], tempStr[(tsize)+2]);
			//System.out.println();
			//System.out.println(tempStr[tsize]);
			//System.out.println(tempStr[(tsize)+2]);
			this.add(node);		
		}
	}
    
	public Node add(Node node) {
		if(head == null) {
			head = tail = node;
			size++;
		} else {
			tail = tail.next;
			tail = node;
			size++;
		}
		return node;
	}

	public boolean remove(Node element)
	{
		size--;
		return (head = remove(head, element)) != null;
	}
	
	private Node remove(Node node, Node element)
	{
		if (node.equals(null))
			return null;
		else
		{
			node.next = remove(node.next, element);
			return node;
		}
	}
	
	//@Override
	public Node remove(int index) {
		if (index >= size || head == null)
			return null;
		Node element;
		if (index == 0)	{	
			element = head;
			head = head.next;
		} else {
			Node temp = remove(head, 0, index);
			element = temp.next; 
			temp.next = temp.next.next;
		}
		size--;
		return element;
	}
	
	private Node remove(Node node, int current, int index){
		if (current == index - 1)
			return node;
		else
			return remove(node.next, current + 1, index);
	}
	

	
	//@Override
	public Node get(int index){
		return get(head, 0, index);
	}

	private Node get(Node tempnode, int current, int index){
		if (tempnode == null)
			return null;
		if (index == current)
			return tempnode;
		return get(tempnode.next, current + 1, index);
	}
	
	//@Override
	public int size(){
		return size;
	}

	public Iterator iterator() {
		return new ListIterator();
	}
	
	public class ListIterator implements Iterator<Node>{
		//private Node current;
		
		@Override
		public boolean hasNext() {
			if (current == null)
				return head != null;
			else
				return current.next != null;
			//return current != null ?current == null: current.next != null; 
		}

		@Override
		public Node next() {
			if (current == null)
				current = head;
			else
				current = current.next;
			return current;
		}
		
		@Override
		public void remove()
		{
		}
		
	}


	@Override
	public String toString()
	{
		//Node nodeTemp;
		String temp = "";
		if(head == null)
			return temp;
		else {
			temp += head.toString();
			Node nodeTemp = head;
			//System.out.println(tail.toString());
			while(this.iterator().hasNext()) {
				nodeTemp = (Polynomial.Node) this.iterator().next();
				//nodeTemp = nodeTemp.next;
				temp += " + "+nodeTemp.toString();
			}
		}
		return temp;
	}

	//@Override
	public int compareTo(Polynomial other) {
		int diff = 0;
		while(this.iterator().hasNext()) {
			diff = Integer.compare(this.current.exponent, other.current.coefficient);
			if(diff == 0) {
				diff = Integer.compare(this.current.coefficient, other.current.coefficient);
				if(diff == 0) {
					this.current = current.next;
					other.current = other.current.next;
				}
			}
		}
		return diff;
	}
}
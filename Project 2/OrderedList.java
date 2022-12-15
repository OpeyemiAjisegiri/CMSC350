import java.util.Comparator;
import java.util.Iterator;

/**
 * Author: Opeyemi Ajisegiri
 * Class: CMSC 350 - Data Structures and Analysis
 * Project: 2
 * Date: September 14th, 2021
 * File: OrderedList Class [OrderedList.java]
 * Purpose:  *******************************************
 */
public class OrderedList /*implements Comparable<Polynomial>*/ {

	private static boolean checkSorted (Polynomial list) {
		/*  Accepts list supplied as a parameter 
		 * [Accepts list of elements that implement Comparable ]
		 * The first should call the second (overloaded) function 
		 * 	*/
		if(list.size() == 1)
			return true;
		Iterator<Polynomial> iter = list.iterator();
		Polynomial current, previous = iter.next();
		while(iter.hasNext()) {
			current = iter.next();
			if(previous.compareTo(current) > 0)
				return false;
			previous = current;
		}
		return true;
	} 
	
	private static boolean checkSorted(Polynomial list, Comparator<Polynomial> polynomialComparison ) {
		/* Accepts a list of elements that implement the Comparator interface
		 * */
		if(list.size() == 1)
			return true;
		Iterator<Polynomial> iter = list.iterator();
		Polynomial current, previous = iter.next();
		while(iter.hasNext()) {
			current = iter.next();
			if(polynomialComparison.compare(current, previous) > 0)
				return false;
			previous = current;
		}
		return true;
	}
}

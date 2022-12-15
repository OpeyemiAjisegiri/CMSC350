/**
 * Author: Opeyemi Ajisegiri
 * Class: CMSC 350 - Data Structures and Analysis
 * Project: 2
 * Date: September 14th, 2021
 * File: InvalidPolynomialSyntax.java
 * Purpose: The InvalidPolynomialSynatx class defines an unchecked error thrown in the Polynomial
 * constructor function when the supplied string (coefficient and exponents) of an improper type or
 * the exponents fails to be listed in strictly descending order.
 */


public class InvalidPolynomialSyntax extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidPolynomialSyntax(String error) {
		super(error);
	}
	
}

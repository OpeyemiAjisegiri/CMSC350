/**
 * Author: Opeyemi Ajisegiri
 * Class: CMSC 350 - Data Structures and Analysis
 * Project: 3
 * Date: September 28th, 2021
 * File: Invalid Tree Syntax class [InvalidTreeSyntax.java]
 * Purpose:  Is thrown when a invalid string is supplied and the Make Tree button is clicked;
 * It (the exception) is caught and communicated in the main class.
 */
public class InvalidTreeSyntax extends Exception {

	public InvalidTreeSyntax(String error)
	{
		super(error);
	}
}

/**
 * Author: Opeyemi Ajisegiri
 * Class: CMSC 350 - Data Structures and Analysis
 * Project: 1
 * Date: August 31th, 2021
 * File: GUI Class and Main Function
 * Purpose:  Creates a Graphic User Interface through which the user inputs the 
 * 				order of the sequence to be analyzed and outputs the result. 
 */

import java.awt.*;
import java.awt.event.ActionListener;
//import java.util.EmptyStackException;
/*import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;*/

import javax.swing.*;

public class GUI{
	
	private JFrame window = new JFrame("Expression Converter");
	private JPanel content = new JPanel();
	private JLabel label = new JLabel("Enter Expression");  
	private JTextField order = new JTextField(50);
	private JButton original = new JButton("Prefix to Postfix"), reversal = new JButton("Postfix to Prefix");
	private JLabel Result = new JLabel("Result:"), expressionResult = new JLabel();

    /*	Adding listeners to the reversal order button 
     * to analyze the order and output the result */
	private final ActionListener convert = event ->
	{
    //reversal.addMouseListener(new MouseAdapter() {
    	//public void mouseClicked(MouseEvent e) {
    		try {
        		String input = order.getText();
    			Conversion converted = new Conversion(input);
    			String convertedExpression;
    			convertedExpression = converted.ConvertToPrefix();
        		expressionResult.setText(convertedExpression);
    		}catch(/*EmptyStack*/Exception E) {
    			JOptionPane.showMessageDialog(null, E);
    		} 
    };
    	
    /*	Adding listeners to the original order button 
     * to analyze the order and output the result */
    private final ActionListener secondConvert = event ->
    {
    	try{
       		String input = order.getText();
       		Conversion converted = new Conversion(input);
       		String convertedExpression = converted.ConvertToPostfix();
       		expressionResult.setText(convertedExpression);
       	} catch (/*EmptyStack*/Exception e) {
       		JOptionPane.showMessageDialog(null, e);
		}
     };
	
	public GUI() {
	
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		content.setLayout(new BorderLayout());
		content.setLayout(null);
        
        label.setHorizontalAlignment(JLabel.LEFT);
        label.setVerticalAlignment(JLabel.TOP);
        label.setBounds(15, 20, 300, 25);
        content.add(label);
        
        order.setBounds(120, 20, 300, 25 );
        content.add(order);
        
		original.setBounds(55, 65, 150, 25);
		content.add(original);
		reversal.setBounds(210, 65, 150, 25);
        reversal.addActionListener(convert);
        original.addActionListener(secondConvert);
		content.add(reversal);
		
		Result.setBounds(55, 100, 80, 30);
		expressionResult.setBounds(100, 100, 300, 30);
		content.add(Result);
		content.add(expressionResult);
		
        /*	Making window and content visible	*/
		//window.setContentPane(content);
		window.add(content);
		window.setLocation(150, 150);
	    window.setSize(450, 200);
	    window.setVisible(true);
	    
	}
	/*	Main Function	*/
	public static void main(String[] args) {
		
		/*	Creating and instantiating the User Interface	*/
		new GUI();	
	}
}
/**
 * Author: Opeyemi Ajisegiri
 * Class: CMSC 350 - Data Structures and Analysis
 * Project: 3
 * Date: September 28th, 2021
 * File: TreeGUI class [TreeGUI.java]
 * Purpose: Creates a user interface that accepts a string to create a binary tree
 * 			and buttons to interact with the tree. 
 */

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class TreeGUI extends JFrame {
	
	private final JTextField input = new JTextField(35),
			output = new JTextField(35);
	private final JButton make = new JButton("Make Tree"),
			balanced = new JButton("Is Balanced?"),
			full = new JButton("Is Full?"),
			proper = new JButton("Is Proper?"),
			height = new JButton("Height"),
			nodes = new JButton("Nodes"),
			inorder = new JButton("InOrder");
	private JPanel inputPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	private JPanel outputPanel = new JPanel();
	private JLabel inputLabel = new JLabel("Enter Tree: ");
	private JLabel outputLabel = new JLabel("InOrder Trasversal: ");
	BinaryTree tree;
	
	public TreeGUI() {
		super("Binary Tree Categorizer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLayout(new BorderLayout());
		setLayout(new GridLayout(3, 2, 10, 10));
		inputPanel.setLayout(new FlowLayout());
		inputPanel.add(inputLabel);
		inputPanel.add(input);
		buttonPanel.add(make);
		buttonPanel.add(balanced);
		buttonPanel.add(full);
		buttonPanel.add(proper);
		buttonPanel.add(height);
		buttonPanel.add(nodes);
		buttonPanel.add(inorder);
		outputPanel.setLayout(new FlowLayout());
		outputPanel.add(outputLabel/*,output*/);
		outputPanel.add(output);
		add(inputPanel);
		add(buttonPanel);
		add(outputPanel);
		setLocation(150, 150);
	    setSize(675, 250);
	    setVisible(true);
	    
	    
	    make.addActionListener(event -> makeTree());
	    balanced.addActionListener(event -> balance());
	    height.addActionListener(event ->  output.setText("The height of the tree is "+tree.treeHeight()+" layers."));
	    proper.addActionListener(event ->  tProper());
	    full.addActionListener(event ->    tFull());
	    nodes.addActionListener(event -> output.setText("The tree has "+tree.nodeCount()+" nodes."));
	    inorder.addActionListener(event -> output.setText(tree.inOrderTrasversal()));
	}
	
	private void makeTree()	{
		try	{
			tree = new BinaryTree(input.getText());
			JOptionPane.showMessageDialog(null, "Tree Constructed");
		} catch (InvalidTreeSyntax exception)	{
			JOptionPane.showMessageDialog(null, "Invalid Tree Syntax: " +
				exception.getMessage());
		}
	}
	
	private void balance()	{
    		try {
        		boolean result = tree.isBalanced();
        		if(result == true)
	        		output.setText("The tree is balanced");
        		else
	        		output.setText("The tree is not balanced");
    		}catch(Exception E) {
    			JOptionPane.showMessageDialog(null, E);
    		} 
    }
    
	
	private void tProper()	{
		try {
    		boolean result = tree.isProper();
    		if(result == true)
        		output.setText("The tree is proper");
    		else
        		output.setText("The tree is not proper");
		}catch(Exception E) {
			JOptionPane.showMessageDialog(null, E);
		} 
	}
	
	private void tFull()	{
		try {
    		boolean result = tree.isTreeFull();
    		if(result == true)
        		output.setText("The tree is full");
    		else
        		output.setText("The tree is not full");
		}catch(Exception E) {
			JOptionPane.showMessageDialog(null, E);
		} 
	}	
	

	
	public static void main(String[] args) {
		new TreeGUI();
	}

}

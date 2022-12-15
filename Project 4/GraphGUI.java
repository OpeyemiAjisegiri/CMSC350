/**
 * Author: Opeyemi Ajisegiri
 * Class: CMSC 350 - Data Structures and Analysis
 * Project: 4
 * Date: October 12th, 2021
 * File: GraphGUI class [GraphGUI.java]
 * Purpose: This file contains the main function of the program and utilizes JFileChooser of the Java Swing Class
 * to interact with the user of the program to select a file and read from the file into the Directedgraph class.
 */

//import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import javax.swing.*;




public class GraphGUI extends JFileChooser{

	/**
	 * @param args
	 */
	private JFileChooser chooser;
	private JButton  open = new JButton();
	
	public GraphGUI() {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Open File");
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if(chooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
    		try {
   			 BufferedReader in = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsolutePath())); 
   			 String line = null;
   	         while ((line = in.readLine()) != null) {
   	            System.out.println(line);
   	            DirectedGraph adj = new DirectedGraph();
   	            StringTokenizer tokened = new StringTokenizer(line," ",false);
   	            LinkedList<String> tempList = new LinkedList<String>();
   	            while(tokened.hasMoreTokens()) {   	            	
   	            	tempList.add(tokened.nextToken());
   	            }
   	            /*** 	Removing the first node in the list to use as the Source
   	             * 		Before using the list									***/
   	            String temp = tempList.removeFirst();
   	            adj.addEdge(temp, tempList);
	            	System.out.println(tempList.toString());
	            	//System.out.println(isMaximumSizeSet());
   	        }
   	         in.close();
	   		}catch(Exception E) {
	   			JOptionPane.showMessageDialog(null, E);
	   		}
		}
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GraphGUI();

	}

}
/**
 * Author: Opeyemi Ajisegiri
 * Class: CMSC 350 - Data Structures and Analysis
 * Project: 2
 * Date: September 14th, 2021
 * File: FileGUI Class [FileGUI.java]
 * Purpose: This file contains the main function of the program and utilizes JFileChooser of the Java Swing Class
 * to interact with the user of the program to select a file and read from the file into the polynomial class.
 */

import java.awt.*;
import javax.swing.*;
import java.awt.Event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
//import java.util.LinkedList;

import javax.swing.filechooser.*;
import java.awt.event.ActionListener;


public class FileGUI extends JFileChooser {

	/*private JFrame window = new JFrame("Select input File");
	 * private JPanel content = new JPanel();*/
	private JFileChooser chooser;
	JButton  open = new JButton();
	//private ArrayList<String> inputList = new ArrayList<String>();
	private ArrayList<Polynomial> inputList = new ArrayList<Polynomial>();
	//Polynomial inputList;
	
	private final ActionListener openFile = event -> {
		try {
  			 BufferedReader in = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsolutePath()));
  			 //System.out.println(in);    
  			 String line = null;
  	         while ((line = in.readLine()) != null) {
  	            System.out.println(line);
  	            //inputList.add(line);
  	            //jTextArea1.append(line + "\n");
  	        }
  	         in.close();
	   		}catch(Exception E) {
	   			JOptionPane.showMessageDialog(null, E);
	   		}
    };
	
	FileGUI(){

		
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		//chooser.setFileFilter(null);
		chooser.setDialogTitle("Open File");
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if(chooser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
			//open.addActionListener(openFile);
    		try {
   			 BufferedReader in = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsolutePath()));
   			 //System.out.println(in);    
   			 String line = null;
   	         while ((line = in.readLine()) != null) {
   	            System.out.println(line);
   	            Polynomial list = new Polynomial(line);
   	            for(int a = 0; a <= list.size(); a++) {
   	            	System.out.println(list.toString());
   	            }
   	            inputList.add(list);
   	        }
   	         in.close();
	   		}catch(Exception E) {
	   			JOptionPane.showMessageDialog(null, E);
	   		}
			//System.out.println("\nYou Choose "+chooser.getSelectedFile().getName()/*.getAbsolutePath()*/);
		}
	}
	
	public static void main(String[] args) {
		new FileGUI();
	}

}

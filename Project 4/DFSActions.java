import java.util.LinkedList;

/**
 * Author: Opeyemi Ajisegiri
 * Class: CMSC 350 - Data Structures and Analysis
 * Project: 4
 * Date: October 12th, 2021
 * File: DFSActions [DFSActions.java]
 * Purpose: ***********
 */
public interface DFSActions<T> {
	void cycleDetected(T v,LinkedList<T> visited);
	void processVertex();
	void descend();
	 void ascend();
}

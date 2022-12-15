import java.util.LinkedList;
import java.util.Stack;

/**
 * Author: Opeyemi Ajisegiri
 * Class: CMSC 350 - Data Structures and Analysis
 * Project: 4
 * Date: October 12th, 2021
 * File: Hierachy [Hierachy.java]
 * Purpose: Implement DFSAction's functions using Depth First Search
 */

public class Hierachy<T> implements DFSActions {

	DirectedGraph adj = new DirectedGraph();
	@Override
	public void cycleDetected(Object v, LinkedList visited) {
		LinkedList<T> isVisited = new LinkedList<T>();
		Stack<T> intended = new Stack<T>();
		/*for(int i = 0; i < adj.size() ; i++) {
			if(this.adj.get(i) == v) {
				isVisited.add(v);
				cycle = true;
				return;
			}else {
				for(int z = 0; z < vertices.get(i).size() ; z++) {
					intended.add(vertices.get(i).get(z));
				}
				while(!intended.isEmpty()) {
					T temp = intended.pop();
					//isVisited.add(temp);
					if(isVisited.contains(temp))
						continue;
					else {
						isVisited.add(temp);
						if(temp == v) {
							cycle = true;
							return;
						}else
							continue;
					}
						
				}
			}
		}
		
	}
		}*/
	}

	@Override
	public void processVertex() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void descend() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ascend() {
		// TODO Auto-generated method stub
		
	}


}

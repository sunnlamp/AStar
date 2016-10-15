package algorithm;

import java.awt.Color;
import java.util.ArrayList;

public class AStar {
	
	public void AStarSearch(Node startNode, Node endNode){
		
		ArrayList<Node> OpenList = new ArrayList<Node>(); // OpenList stores the nodes that can be traveled to
		ArrayList<Node> ClosedList = new ArrayList<Node>(); // ClosedList stores the node that are already visited

		OpenList.add(startNode); 
		// Your code goes here...


		
		
	}

	void PrintNodeCost(Node node){ // This metod prints the cost of each node on the node
		node.nodeBtn.setText(node.name + " F: " + (node.G + node.H));
	}
	
	void PaintNodeGreen(Node node){ // Paint expanded nodes green
		node.nodeBtn.setBackground(Color.GREEN);
		node.nodeBtn.setOpaque(true);
	}
	
	void PaintNodeYellow(Node node){ // Paint evaluated nodes yellow
		node.nodeBtn.setBackground(Color.YELLOW);
		node.nodeBtn.setOpaque(true);
	}

	void PaintNodeBlue(Node node){ // Paint the goal node blue
		node.nodeBtn.setBackground(Color.BLUE);
		node.nodeBtn.setOpaque(true);
	}
}

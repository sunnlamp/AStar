package algorithm;

import java.awt.Color;
import java.util.ArrayList;

public class AStar {
	
	public void AStarSearch(Node startNode, Node endNode){
		
		ArrayList<Node> openList = new ArrayList<Node>(); // OpenList stores the nodes that can be traveled to
		ArrayList<Node> closedList = new ArrayList<Node>(); // ClosedList stores the node that are already visited
		
		// Your code goes here...
		openList.add(startNode);
		Node currNode;
	
		while (openList.size() > 0) {
			currNode = openList.get(0);
			for (int j = 0; j < openList.size(); j++) {
				if (openList.get(j).F <= currNode.F) {
					currNode = openList.get(j);
				}
			}
			PaintNodeGreen(currNode);
			for (int i = 0; i < currNode.adjacents.size(); i++) {
				if (currNode == endNode) {
					PaintNodeBlue(currNode);
					return;
				}
				if (!closedList.contains(currNode.adjacents.get(i))) {
					PaintNodeYellow(currNode.adjacents.get(i));
					currNode.adjacents.get(i).parentNode = currNode;
					currNode.adjacents.get(i).G = currNode.distancesToAdjacents.get(i);
					currNode.adjacents.get(i).G = currNode.adjacents.get(i).G;
					currNode.adjacents.get(i).F = currNode.adjacents.get(i).G + currNode.adjacents.get(i).H;
					PrintNodeCost(currNode.adjacents.get(i));
				}
				if (!closedList.contains(currNode.adjacents.get(i)) &&
					!openList.contains(currNode.adjacents.get(i))) {
					openList.add(currNode.adjacents.get(i));
				}
			}
			closedList.add(currNode);
			openList.remove(currNode);
		}
	}

	void PrintNodeCost(Node node){ // This method prints the cost of each node on the node
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

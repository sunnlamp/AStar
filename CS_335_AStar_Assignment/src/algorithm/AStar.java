package algorithm;

import java.awt.Color;
import java.util.ArrayList;

public class AStar {
	
	public void AStarSearch(Node startNode, Node endNode){
		
		ArrayList<Node> openList = new ArrayList<Node>(); // OpenList stores the nodes that can be traveled to
		ArrayList<Node> closedList = new ArrayList<Node>(); // ClosedList stores the node that are already visited
		ArrayList<Node> path = new ArrayList<Node>();
		final int MAX_VALUE = 100000;
		
		openList.add(startNode);
		path.add(startNode);
		// Your code goes here...
		Node currNode = openList.get(0);
		while (openList.size() > 0) {
			for (int j = 0; j < openList.size(); j++) {
				if (openList.get(j).F < MAX_VALUE) {
					currNode = openList.get(j);
				}
			}
			openList.remove(currNode);
			for (int i = 0; i < currNode.adjacents.size(); i++) {
				if (currNode == endNode) {
					return;
				}
				currNode.adjacents.get(i).G = currNode.distancesToAdjacents.get(i);
				currNode.adjacents.get(i).parentNode = currNode;
				currNode.adjacents.get(i).G = currNode.G + currNode.adjacents.get(i).G;
				currNode.adjacents.get(i).F = currNode.adjacents.get(i).G + currNode.adjacents.get(i).H;
			}
		}
	}
/*
initialize the open list
initialize the closed list
put the starting node on the open list (you can leave its f at zero)

while the open list is not empty
    find the node with the least f on the open list, call it "q"
    pop q off the open list
    generate q's 8 successors and set their parents to q
    for each successor
    	if successor is the goal, stop the search
        successor.g = q.g + distance between successor and q
        successor.h = distance from goal to successor
        successor.f = successor.g + successor.h

        if a node with the same position as successor is in the OPEN list \
            which has a lower f than successor, skip this successor
        if a node with the same position as successor is in the CLOSED list \ 
            which has a lower f than successor, skip this successor
        otherwise, add the node to the open list
    end
    push q on the closed list
end
	*/

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

package algorithm;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Node {
	
	public String name; // Name of the node
	
	public int G = 0; // Cost so far to reach N
	public int H = 0; // Heuristic cost
	public int F = 0; // Estimated total cost of path through N to goal
	
	public int straightDist = 0; // Straight distance to Bucharest from this node
	public int obstacles = 0; // If there are obstacles around this node, this variable will have a higher value
	
	public Node parentNode;
	
	public JButton nodeBtn;	// Reference to the button object that visually represents the node

	public ArrayList<Node> adjacents = new ArrayList<Node>(); // List of adjacent nodes
	public ArrayList<Integer> distancesToAdjacents = new ArrayList<Integer>(); // This list keeps the distances to each adjacent node
	
	public Node(String n, int sdt, int obs){ // Node initialization
		this.name = n;
		this.H = sdt + obs; // Calculating the heuristic cost
	}
	
	public void SetAdjacentNode(Node adj, int dist){ // Set adjacent nodes and their distances
		adjacents.add(adj);
		distancesToAdjacents.add(dist);
	}
}

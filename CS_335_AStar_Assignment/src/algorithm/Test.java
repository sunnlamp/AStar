package algorithm;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;

public class Test  {
	
	public static Node StartNode = null;
	public static Node GoalNode = null;

	static JButton btnArad = new JButton("Ar");
	static JButton btnZerind = new JButton("Ze");
	static JButton btnOradea = new JButton("Or");
	static JButton btnBucharest = new JButton("Bu");
	static JButton btnCraoiva = new JButton("Cr");
	static JButton btnDobreta = new JButton("Db");
	static JButton btnFagaras = new JButton("Fg");
	static JButton btnLugoj = new JButton("Lu");
	static JButton btnMehadia = new JButton("Me");
	static JButton btnPitesti = new JButton("Pi");
	static JButton btnRV = new JButton("RV");
	static JButton btnSibiu = new JButton("Si");
	static JButton btnTimisoara = new JButton("Ti");
		
	public static void main(String[] args) {
		
		/* INITIALIZE NODES */
		// Constructor parameters: (Node name, straight distance to Bucharest, obstacles)
		final Node Arad = new Node("Ar", 366, 0);		 
		final Node Bucharest = new Node("Bu", 0, 0);
		final Node Craoiva = new Node("Cr", 160, 0);
		final Node Dobreta = new Node("Db", 242, 0);
		final Node Fagaras = new Node("Fg", 178, 0);
		final Node Lugoj = new Node("Lu", 244, 0);
		final Node Mehadia = new Node("Me", 241, 0);
		final Node Oradea = new Node("Or", 380, 0);
		final Node Pitesti = new Node("Pi", 98, 0);
		final Node RV = new Node("RV", 193, 0);
		final Node Sibiu = new Node("Si", 253, 0);
		final Node Timisoara = new Node("Ti", 329, 0);
		final Node Zerind = new Node("Ze", 374, 0);
		
		GoalNode = Bucharest;
		
		Arad.SetAdjacentNode(Zerind, 75);
		Arad.SetAdjacentNode(Sibiu, 140);
		Arad.SetAdjacentNode(Timisoara, 118);
		
		Zerind.SetAdjacentNode(Arad, 75);
		Zerind.SetAdjacentNode(Oradea, 71);
		
		Timisoara.SetAdjacentNode(Arad, 118);
		Timisoara.SetAdjacentNode(Lugoj, 111);
		
		Oradea.SetAdjacentNode(Zerind, 71);
		Oradea.SetAdjacentNode(Sibiu, 151);
		
		Lugoj.SetAdjacentNode(Timisoara, 111);
		Lugoj.SetAdjacentNode(Mehadia, 70);
		
		Mehadia.SetAdjacentNode(Lugoj, 70);
		Mehadia.SetAdjacentNode(Dobreta, 75);

		Craoiva.SetAdjacentNode(Craoiva, 75);
		Craoiva.SetAdjacentNode(RV, 146);
		Craoiva.SetAdjacentNode(Pitesti, 138);
		
		Sibiu.SetAdjacentNode(Arad, 140);
		Sibiu.SetAdjacentNode(Oradea, 151);
		Sibiu.SetAdjacentNode(Fagaras, 99);
		Sibiu.SetAdjacentNode(RV, 80);

		RV.SetAdjacentNode(Sibiu, 80);
		RV.SetAdjacentNode(Craoiva, 146);
		RV.SetAdjacentNode(Pitesti, 97);
		
		Dobreta.SetAdjacentNode(Mehadia, 75);
		Dobreta.SetAdjacentNode(Craoiva, 120);

		Pitesti.SetAdjacentNode(RV, 97);
		Pitesti.SetAdjacentNode(Craoiva, 138);
		Pitesti.SetAdjacentNode(Bucharest, 101);
		
		Fagaras.SetAdjacentNode(Sibiu, 99);
		Fagaras.SetAdjacentNode(Bucharest, 211);
		
		Bucharest.SetAdjacentNode(Pitesti, 101);
		Bucharest.SetAdjacentNode(Fagaras, 211);

		Arad.nodeBtn = btnArad;
		Zerind.nodeBtn = btnZerind;
		Oradea.nodeBtn = btnOradea;
		Bucharest.nodeBtn = btnBucharest;
		Craoiva.nodeBtn = btnCraoiva;
		Dobreta.nodeBtn = btnDobreta;
		Fagaras.nodeBtn = btnFagaras;
		Lugoj.nodeBtn = btnLugoj;
		Mehadia.nodeBtn = btnMehadia;
		Pitesti.nodeBtn = btnPitesti;
		RV.nodeBtn = btnRV;
		Sibiu.nodeBtn = btnSibiu;
		Timisoara.nodeBtn = btnTimisoara;
		
		btnArad.addMouseListener(new java.awt.event.MouseAdapter() { public void mouseClicked(java.awt.event.MouseEvent evt) {SetPath(Arad);}});
		btnZerind.addMouseListener(new java.awt.event.MouseAdapter() {public void mouseClicked(java.awt.event.MouseEvent evt) {SetPath(Zerind);}});	
		btnOradea.addMouseListener(new java.awt.event.MouseAdapter() {public void mouseClicked(java.awt.event.MouseEvent evt) {SetPath(Oradea);}});
		btnCraoiva.addMouseListener(new java.awt.event.MouseAdapter() {public void mouseClicked(java.awt.event.MouseEvent evt) {SetPath(Craoiva);}});
		btnDobreta.addMouseListener(new java.awt.event.MouseAdapter() {public void mouseClicked(java.awt.event.MouseEvent evt) {SetPath(Dobreta);}});
		btnFagaras.addMouseListener(new java.awt.event.MouseAdapter() {public void mouseClicked(java.awt.event.MouseEvent evt) {SetPath(Fagaras);}});
		btnLugoj.addMouseListener(new java.awt.event.MouseAdapter() {public void mouseClicked(java.awt.event.MouseEvent evt) {SetPath(Lugoj);}});
		btnMehadia.addMouseListener(new java.awt.event.MouseAdapter() {public void mouseClicked(java.awt.event.MouseEvent evt) {SetPath(Mehadia);}});
		btnPitesti.addMouseListener(new java.awt.event.MouseAdapter() {public void mouseClicked(java.awt.event.MouseEvent evt) {SetPath(Pitesti);}});
		btnRV.addMouseListener(new java.awt.event.MouseAdapter() {public void mouseClicked(java.awt.event.MouseEvent evt) {SetPath(RV);}});
		btnSibiu.addMouseListener(new java.awt.event.MouseAdapter() {public void mouseClicked(java.awt.event.MouseEvent evt) {SetPath(Sibiu);}});
		btnTimisoara.addMouseListener(new java.awt.event.MouseAdapter() {public void mouseClicked(java.awt.event.MouseEvent evt) {SetPath(Timisoara);}});    
		
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("A* Search");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container pane = frame.getContentPane();
				
		pane.add(btnArad);
		pane.add(btnZerind);
		pane.add(btnOradea);
		pane.add(btnBucharest);
		pane.add(btnCraoiva);
		pane.add(btnDobreta);
		pane.add(btnFagaras);
		pane.add(btnLugoj);
		pane.add(btnMehadia);
		pane.add(btnPitesti);
		pane.add(btnRV);
		pane.add(btnSibiu);
		pane.add(btnTimisoara);

		btnArad.setBounds(10, 200, 100, 40);		    
		btnZerind.setBounds(30, 130, 100, 40);		    
		btnOradea.setBounds(100, 60, 100, 40);
		btnBucharest.setBounds(500, 400, 100, 40);
		btnCraoiva.setBounds(280, 410, 100, 40);
		btnDobreta.setBounds(150, 420, 100, 40);
		btnFagaras.setBounds(330, 250, 100, 40);
		btnLugoj.setBounds(140, 280, 100, 40);
		btnMehadia.setBounds(155, 350, 100, 40);
		btnPitesti.setBounds(350, 360, 100, 40);
		btnRV.setBounds(270, 300, 100, 40);
		btnSibiu.setBounds(200, 230, 100, 40);
		btnTimisoara.setBounds(25, 270, 100, 40);
		
        JApplet applet = new DrawingApplet();
        frame.getContentPane().add(applet);
        applet.init();
        frame.pack();
		frame.setSize(700, 600);
		frame.setVisible(true);
		
		CleanMap();
	}
	
	public static void SetPath(Node node){
		
		CleanMap();
		StartNode = node;
        System.out.println(StartNode.name);

		if(StartNode != null){
			AStar astar = new AStar();
			astar.AStarSearch(StartNode, GoalNode);
		}

	}
	
	public static void CleanMap(){
		StartNode = null;
		
		btnArad.setBackground(Color.WHITE);
		btnArad.setOpaque(true);
		btnArad.setText("Ar");
		
		btnZerind.setBackground(Color.WHITE);
		btnZerind.setOpaque(true);
		btnZerind.setText("Ze");

		btnOradea.setBackground(Color.WHITE);
		btnOradea.setOpaque(true);
		btnOradea.setText("Or");

		btnBucharest.setBackground(Color.GREEN);
		btnBucharest.setOpaque(true);
		btnBucharest.setText("Bu");

		btnCraoiva.setBackground(Color.WHITE);
		btnCraoiva.setOpaque(true);
		btnCraoiva.setText("Cr");

		btnDobreta.setBackground(Color.WHITE);
		btnDobreta.setOpaque(true);
		btnDobreta.setText("Do");

		btnFagaras.setBackground(Color.WHITE);
		btnFagaras.setOpaque(true);
		btnFagaras.setText("Fa");

		btnLugoj.setBackground(Color.WHITE);
		btnLugoj.setOpaque(true);
		btnLugoj.setText("Lu");

		btnMehadia.setBackground(Color.WHITE);
		btnMehadia.setOpaque(true);
		btnMehadia.setText("Me");

		btnPitesti.setBackground(Color.WHITE);
		btnPitesti.setOpaque(true);
		btnPitesti.setText("Pi");

		btnRV.setBackground(Color.WHITE);
		btnRV.setOpaque(true);
		btnRV.setText("RV");

		btnSibiu.setBackground(Color.WHITE);
		btnSibiu.setOpaque(true);
		btnSibiu.setText("Si");

		btnTimisoara.setBackground(Color.WHITE);
		btnTimisoara.setOpaque(true);
		btnTimisoara.setText("Ti");
	}
}

class DrawingApplet extends JApplet {

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        g2.draw(new Line2D.Double(10 + 40, 200 + 15, 30 + 40, 130));
        g2.draw(new Line2D.Double(10 + 40, 200 + 15, 25 + 40, 270));
        g2.draw(new Line2D.Double(10 + 40, 200 + 15, 200 + 40, 230));
        
        g2.draw(new Line2D.Double(30 + 40, 130 + 20, 80 + 40, 80));

        g2.draw(new Line2D.Double(80 + 40, 80 + 20, 200 + 40, 230));
        
        g2.draw(new Line2D.Double(200 + 40, 230 + 20, 330 + 40, 250 + 20));
        g2.draw(new Line2D.Double(200 + 40, 230 + 20, 270 + 40, 300));

        g2.draw(new Line2D.Double(25 + 40, 270 + 20, 140 + 40, 280 + 20));

        g2.draw(new Line2D.Double(140 + 40, 280 + 20, 155 + 40, 320 + 20));

        g2.draw(new Line2D.Double(155 + 40, 320 + 40, 150 + 40, 390 + 20));
        
        g2.draw(new Line2D.Double(150 + 40, 390 + 40, 280 + 40, 410 + 20));

        g2.draw(new Line2D.Double(280 + 40, 410 + 40, 270 + 40, 300 + 20));
        g2.draw(new Line2D.Double(280 + 40, 410 + 40, 350 + 40, 360 + 20));

        g2.draw(new Line2D.Double(270 + 40, 300, 350 + 40, 360 + 20));

        g2.draw(new Line2D.Double(330 + 40, 250, 500 + 40, 400 + 20));
        
        g2.draw(new Line2D.Double(350 + 40, 360, 500 + 40, 400 + 20));
    }
}

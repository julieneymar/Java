 package sanake_game;

import java.awt.Color;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;
import javax.swing.JPanel;

public class Graphic 
extends JPanel
implements ActionListener 
{
	private Timer t = new Timer(100,this);
	
	
	public String state;
	
	private Snake s;
	private food f;
	private Game game;
	
	public Graphic(	Game g)
	{
		t.start();
		state = "START";
		game = g;
		s = g.getPlayer();
		f = g.getFood();
		
		this.addKeyListener(g);
		this.setFocusable(true);
		this.setFocusTraversalKeysEnabled(false);

	}
	public void paintComponent (java.awt.Graphics g) 
	{
		super.paintComponent(g);
		
		Graphics2D gd2 = (Graphics2D) g ;
		gd2.setColor(Color.black);
		gd2.fillRect(0, 0, Game.width * Game.dimension, Game.height * Game.dimension);
		
		if ("START".equals(state)) 
		{
			gd2.setColor(Color.white);
			gd2.drawString("Press Any Key ", Game.width/2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 20);	
		}
		else if ("RUNNING".equals(state)) 
		{
			gd2.setColor(Color.red);
			gd2.fillRect(f.getX() * Game.dimension, f.getY() * Game.dimension, Game.dimension, Game.dimension);
			
			gd2.setColor(Color.green);
			for (Rectangle r : s.getBody())
			{
				gd2.fill(r);
			}
			
		}
		else 
		{
			gd2.setColor(Color.white);
			gd2.drawString("Your Score :" + (s.getBody().size() - 3),Game.width/2 * Game.dimension - 40, Game.height / 2 * Game.dimension - 20);
		}
		
		
		
	
	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		game.update();
		repaint();
		
	}
	
	public Snake getS() {
		return s;
	}
	public void setS(Snake s) {
		this.s = s;
	}
	public food getF() {
		return f;
	}
	public void setF(food f) {
		this.f = f;
	}
	public Game getGame() {
		return game;
	}
	public void setGame(Game game) {
		this.game = game;
	}
	public Timer getT() {
		return t;
	}
	public void setT(Timer t) {
		this.t = t;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	
	

}

package sanake_game;


import java.awt.event.KeyEvent;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game
implements KeyListener {
	// attribut
		private Snake player;
		private food food;
		private Graphic graphics;
		
		private JFrame  window;
		
		public static final int width = 30;
		public static final int height = 30;
		public static final int dimension = 20;

		
		public Game () 
		{
			window = new JFrame();
			
			player = new Snake();
			
			food = new food(player)
					;
			graphics = new Graphic(this);
			
			window.add(graphics);
			
		
			window.addKeyListener(this);
			window.setFocusable(true);
			window.requestFocusInWindow();

			
			
			window.setTitle("Snake");
			window.setSize(width * dimension + 2, height * dimension + dimension + 4);
			window.setVisible(true);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			
			
		}
		
		public void start() 
		{
			graphics.state = "RUNNING";
			window.requestFocusInWindow();
		}
		
		public void update() 
		{
			
			if ("RUNNING".equals(graphics.state)) 
			{
				if (check_food_collision()) 
				{
					player.grow();
					food.random_spawn(player);
				}
				else if (check_wall_collision()|| check_self_collision()) 
				{
					graphics.state = "END";
				}
				else 
				{
					player.move();
				}
				
			}
		}
		private boolean check_wall_collision() 
		{
			if(player.getX() < 0 || player.getX() >= width * dimension || player.getY() < 0 || player.getY() >= height * dimension ) 
			{
				return true;
			}
			return false;
		}
		
		private boolean check_food_collision() 
		{
			if (player.getX() == food.getX() * dimension && player.getY() == food.getY() * dimension) 
			{
				return true;
			}
			return false;
		}
		private boolean check_self_collision ()
		{
			for (int i = 1 ; i < player.getBody().size() ; i++)
			{
				if(player.getX() == player.getBody().get(i).x && player.getY() == player.getBody().get(i).y )
				{
					return true;
				}
			}
			return false;
		}


		@Override
		public void keyTyped(KeyEvent e) {}


		@Override
		public void keyPressed(KeyEvent e)
		{
			int KeyCode = e.getKeyCode();
			if ( "RUNNING".equals(graphics.state)) 
			{
				if ( KeyCode == KeyEvent.VK_Z && !"DOWN".equals(player.getMove())) 
				{
					player.up();	
				}
				if ( KeyCode == KeyEvent.VK_S && !"UP".equals(player.getMove()) ) 
				{
					player.down();
				}
				if ( KeyCode == KeyEvent.VK_A && !"RIGHT".equals(player.getMove()) ) 
				{
					player.left();
				}
				if ( KeyCode == KeyEvent.VK_Q && !"LEFT".equals(player.getMove())) 

				{
					player.right();
				}
			}
			
			else
			{
				graphics.state = "RUNNING";
				this.start();;
				
			}
		}


		@Override
		public void keyReleased(KeyEvent e) {}


		public Snake getPlayer() {
			return player;
		}


		public void setPlayer(Snake player) {
			this.player = player;
		}


		public food getFood() {
			return food;
		}


		public void setFood(food food) {
			this.food = food;
		}


		public JFrame getWindow() {
			return window;
		}


		public void setWindow(JFrame window) {
			this.window = window;
		}
}

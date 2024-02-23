package sanake_game;

import java.awt.Rectangle;

public class food 
{
	private int x ;
	private int y ;
	
	
	public food ( Snake players) 
	{
		this.random_spawn(players);
		
	}
	
	
	public void random_spawn( Snake players) 
	{
		
		boolean onSnake;
		do 
		{
			onSnake = false;
			x = (int)(Math.random() * Game.width - 1);
			y = (int)(Math.random() * Game.height - 1);
			
			for (Rectangle r : players.getBody()) 
			{
				if (r.x == x && r.y ==y ) 
				{
					onSnake = true;
					break;
				}
			}	
		}while (onSnake);
	}


	public int getX() {
		return x;
	}


	public void setX(int x) {
		this.x = x;
	}


	public int getY() {
		return y;
	}


	public void setY(int y) {
		this.y = y;
	}
}

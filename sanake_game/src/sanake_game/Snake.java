package sanake_game;

import java.awt.Rectangle;

import java.util.ArrayList;

public class Snake 
{
	private ArrayList <Rectangle> body;
	private int w = Game.width;
	private int h = Game.height;
	private int d = Game.dimension;
	
	private String move;
	
	public Snake() 
	{
		body = new ArrayList<>();
		Rectangle temp = new Rectangle (Game.dimension,Game.dimension);
		temp.setLocation(Game.width / 2 * Game.dimension, Game.height / 2 * Game.dimension);
		body.add(temp);
		
		temp = new Rectangle(d,d);
		temp.setLocation((w / 2 -1) * d , (h / 2 ) * d);
		body.add(temp);
		
		temp = new Rectangle(d,d);
		temp.setLocation((w / 2 -2 ) * d , (h / 2 ) * d);
		body.add(temp);
		
		move = "NOTHING";
	}
	public void move () 
	{
		if( !"NOTHING".equals(move) ) 
		{
			Rectangle first = body.get(0);
			
			Rectangle temp = new Rectangle (Game.dimension, Game.dimension);
			if("UP".equals(move)) 
			{
				temp.setLocation(first.x,first.y - Game.dimension);
			}
			else if ("DOWN".equals(move)) 
			{
				temp.setLocation(first.x,first.y + Game.dimension);
			}
			else if (move == "LEFT") 
			{
				temp.setLocation(first.x - Game.dimension,first.y );
			}
			else 
			{
				temp.setLocation(first.x + Game.dimension,first.y );
			}
			body.add(0,temp);
			body.remove(body.size()-1);
		}
	}
	public void grow() 
	{
		Rectangle first = body.get(0);
		
		Rectangle temp = new Rectangle (Game.dimension, Game.dimension);
		if(move == "UP") 
		{
			temp.setLocation(first.x,first.y - Game.dimension);
		}
		else if (move == "DOWN") 
		{
			temp.setLocation(first.x,first.y + Game.dimension);
		}
		else if (move == "LEFT") 
		{
			temp.setLocation(first.x - Game.dimension,first.y );
		}
		else 
		{
			temp.setLocation(first.x + Game.dimension,first.y );
		}
		body.add(0,temp);
	}

	public ArrayList<Rectangle> getBody() {
		return body;
	}

	public void setBody(ArrayList<Rectangle> body) {
		this.body = body;
	}
	
	public int getX() 
	{
		return body.get(0).x ;
	}
	public int getY() 
	{
		return body.get(0).y ;
	}
	public String getMove() {
		return move;
	}
	public void setMove(String move) {
		this.move = move;
	}
	public void up() 
	{
		if(!"DOWN".equals(move)) 
		{
		move = "UP";
		}
	}
	public void left() 
	{
		if(!"RIGHT".equals(move))
		{
		move = "LEFT";
		}
	}
	public void down() 
	{
		if(!"UP".equals(move)) 
		{
		move = "DOWN";
		}
	}
	public void right() 
	{
		if(!"LEFT".equals(move))
		{
		move = "RIGHT";
		}
	}
}

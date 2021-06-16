package com.lkestudios.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.lkestudios.main.Game;

public class Tubo extends Entity{

	public Tubo(double x, double y, int width, int height, double speed, BufferedImage sprite) {
		super(x, y, width, height, speed, sprite);
	
	}

	public void tick() {
		x--;
		if(x+width <= 0) {
			//System.out.println("destruido");
			//Game.score+=0.5;
			Game.entities.remove(this);
			return;
		}
		if(Game.player.getX() == this.getX()) {
			Game.score+=0.5;
		}
	}
	
	public void render(Graphics g) {
		/*
		g.setColor(Color.green);
		g.fillRect((int)x,(int) y, width, height);
		*/
		if(sprite != null) {
			g.drawImage(sprite, this.getX(), this.getY(), width, height, null);
		}
		else {
			g.setColor(Color.green);
			g.fillRect(this.getX(), this.getY(), width, height);
		}
	}
}

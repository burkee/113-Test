package com.me.mygdxgame;

import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;

import com.badlogic.gdx.math.Rectangle;

public class Bill {

	
	public final Animation image;
	public final Rectangle bounds;
	
	public Bill(){
		image = Assets.bill;
		bounds = new Rectangle(10, 10, 128, 128);
		
		
	}
}

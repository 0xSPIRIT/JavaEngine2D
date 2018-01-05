package com.engine.render;

import java.awt.Graphics;

import com.engine.entity.Entity;
import com.engine.main.Vector;

public class Sprite {

	private EImage image;
	private Entity entity;
	private Vector pos;
	private int width, height;
	
	public Sprite(EImage image, Vector pos, int width, int height) {
		this.image = image;
		this.pos = pos;
		this.width = width;
		this.height = height;
	}

	public Sprite(EImage image, float x, float y, int width, int height) {
		this(image, new Vector(x, y), width, height);
	}

	public Sprite(EImage image, Vector pos) {
		this(image, pos, image.getWidth(), image.getHeight());
	}
	
	public Sprite(EImage image, float x, float y) {
		this(image, new Vector(x, y), image.getWidth(), image.getHeight());
	}
	
	public void render(Graphics g) {
		image.render(g, pos, width, height);
	}

	// GETTERS AND SETTERS:
	
	public EImage getEImage() {
		return image;
	}

	public void setEImage(EImage image) {
		this.image = image;
	}

	public Vector getPosition() {
		return pos;
	}

	public void setPosition(Vector pos) {
		if (entity == null) {
			this.pos = pos;
		} else {
			System.out.println("Warning: function called setPosition(x, y) will be overriden by the follow entity that the sprite object is calling.");
		}
	}

	public void setPosition(float x, float y) {
		if (entity == null) {
			pos.x = x;
			pos.y = y;
		} else {
			System.out.println("Warning: function called setPosition(x, y) will be overriden by the follow entity that the sprite object is calling.");
		}
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setFollowEntity(Entity entity) {
		this.entity = entity;
	}

}

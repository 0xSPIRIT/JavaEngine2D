package com.engine.entity;

import java.awt.Graphics;

import com.engine.main.Vector;
import com.engine.render.Sprite;

public abstract class Entity {

	protected Vector pos;
	protected Vector dir; // normal vec.
	protected Sprite sprite;
	
	public Entity(Vector pos, Vector dir, Sprite sprite) {
		this.pos = pos;
		this.dir = dir;
		this.sprite = sprite;
	}
	
	public Entity(Vector pos, Vector dir) {
		this(pos, dir, null);
	}
	
	public Entity(Vector pos) {
		this(pos, new Vector(0, 0), null);
	}

	public Entity(Vector pos, Sprite sprite) {
		this(pos, new Vector(0, 0), sprite);
	}
	
	public void move() {
		pos.add(dir);
	}
	
	public void updateSprite() {
		sprite.setPosition(pos);
	}
	
	public abstract void update();
	
	public abstract void render(Graphics g);

	// GETTERS AND SETTERS:
	
	public Vector getPos() {
		return pos;
	}

	public void setPos(Vector pos) {
		this.pos = pos;
	}

	public Vector getDir() {
		return dir;
	}

	public void setDir(Vector dir) {
		this.dir = dir;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
}

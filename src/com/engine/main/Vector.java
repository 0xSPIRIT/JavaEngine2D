package com.engine.main;

import java.util.Random;

public class Vector {

	public float x, y;

	public Vector(float x, float y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector() {
		this(0, 0);
	}

	public void add(Vector other) {
		x += other.x;
		y += other.y;
	}

	public void sub(Vector other) {
		x -= other.x;
		y -= other.y;
	}

	public void mult(Vector other) {
		x *= other.x;
		y *= other.y;
	}
	
	public void mult(float z) {
		x *= z;
		y *= z;
	}

	public void div(Vector other) {
		x /= other.x;
		y /= other.y;
	}
	
	public float angle() {
		return (float) Math.atan(y/x);
	}

	public float mag() {
		return (float) Math.sqrt(x * x + y * y);
	}
	
	public void normalize() {
		x = Math.signum(x);
		y = Math.signum(y);
	}
	
	public void clamp(float bx, float by, float bwidth, float bheight) {
		if (x < bx) 	 x = bx;
		if (y < by) 	 y = by;
		if (x > bwidth)	 x = bwidth;
		if (y > bheight) y = bheight;
	}
	
	public static Vector createRandom() {
		Random random = new Random();
		return new Vector(random.nextFloat() * 2 - 1, random.nextFloat() * 2 - 1);
	}
	
	public static Vector createFromAngle(float angle) {
		return new Vector((float) Math.cos(angle), (float) Math.sin(angle));
	}
}

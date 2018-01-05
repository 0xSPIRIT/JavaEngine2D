package com.engine.main.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	public static final int MAX_KEYS = 256;
	
	private boolean keys[];
	
	public Keyboard() {
		keys = new boolean[MAX_KEYS];
		
		for (int i = 0; i < keys.length; i++) {
			keys[i] = false;
		}
	}
	
	public boolean isKeyPressed(int keycode) {
		return keys[keycode];
	}

	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
		System.out.println(keys[e.getKeyCode()]);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
}

package com.engine.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

import com.engine.main.input.Keyboard;

public abstract class Application extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private Thread thread;
	private boolean running = false;

	public JFrame frame;

	public int width, height;
	public String title;

	private double fps_cap = 60.0;
	private boolean fps_show = true;

	private int frames = 0;
	private int updates = 0;
	
	public static final Keyboard KEYBOARD = new Keyboard();

	public Application(int width, int height, String title) {
		this.width = width;
		this.height = height;
		this.title = title;

		setPreferredSize(new Dimension(this.width, this.height));
		setMaximumSize(new Dimension(this.width, this.height));
		setMinimumSize(new Dimension(this.width, this.height));

		frame = new JFrame(this.title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(this);
		frame.pack();

		setFocusable(true);
		requestFocus();
		frame.addKeyListener(KEYBOARD);

		start();
	}

	public void run() {
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / fps_cap;
		double delta = 0;
		frames = 0;
		updates = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				updates++;
				delta--;
			}
			sRender();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				if (fps_show) {
					frame.setTitle(title + " | FPS: " + frames + ", UPS: " + updates);
				}
				frames = 0;
				updates = 0;
			}
		}
		stop();
	}

	public abstract void update();

	private void sRender() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		render(g);

		g.dispose();
		bs.show();
	}

	public abstract void render(Graphics g);

	private synchronized void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		try {
			running = false;
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void drawCenteredString(String s, int x, int y, int w, int h, Graphics g) {
		java.awt.FontMetrics fm = g.getFontMetrics();
		int xx = (w - fm.stringWidth(s)) / 2;
		int yy = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
		g.drawString(s, x + xx, y + yy);
	}

	public boolean isRunning() {
		return running;
	}

	public JFrame getFrame() {
		return frame;
	}

	public double getMaxFPS() {
		return fps_cap;
	}

	public void setMaxFPS(double fps_cap) {
		this.fps_cap = fps_cap;
	}

	public void showFPS(boolean show) {
		fps_show = show;
	}

	public int getFrames() {
		return frames;
	}

	public int getUpdates() {
		return updates;
	}

}

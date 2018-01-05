package com.engine.render;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.engine.main.Vector;

public class EImage {

	private BufferedImage image;
	private int width, height;
	
	public EImage(BufferedImage img) {
		image = img;
		width = image.getWidth();
		height = image.getHeight();
	}
	
	public EImage(String path) {
		try {
			image = ImageIO.read(new File(path));
			width = image.getWidth();
			height = image.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
			image = null;
		}
	}
	
	public void render(Graphics g, Vector renderPos) {
		g.drawImage(image, (int) renderPos.x, (int) renderPos.y, null);
	}
	
	public void render(Graphics g, Vector renderPos, int width, int height) {
		g.drawImage(image, (int) renderPos.x, (int) renderPos.y, width, height, null);
	}
	
	public BufferedImage getBufferedImage() {
		return image;
	}

	public void setBufferedImage(String path) {
		try {
			image = ImageIO.read(new File(path));
			width = image.getWidth();
			height = image.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setBufferedImage(BufferedImage img) {
		image = img;
		width = image.getWidth();
		height = image.getHeight();
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}

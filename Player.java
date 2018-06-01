package car;
//////////////////////GKTTTH
import java.awt.Image;
//////////////////////GKTTTH!!!!
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;

public class Player {
	
	public static final int MAX_V = 30;
	public static final int MAX_TOP = 520;
	public static final int MAX_BOTTOM = 730;
	
	
	Image img_c = new ImageIcon("res/carone.png").getImage();
	Image img_l = new ImageIcon("res/carjneleft.png").getImage();
	Image img_r = new ImageIcon("res/caroneright.png").getImage();
	
	Image img = img_c;
	
	
	public Rectangle getRect(){
		return new Rectangle(x, y, 150, 53);
		
	}
	
	int v = 0;
	int dv = 0;
	int s = 0;
	
	int x = 10;
	int y = 10;
	int dy = 0;
	
	int layer1 = 0;
	int layer2 = 1200;
	
	
	public void move(){
		s += v;
		v += dv;
		if (v <= 0) v = 0;
		if (v >= MAX_V) v = MAX_V;
		y -= dy;
		if (y <= MAX_TOP) y = MAX_TOP;
		if (y >= MAX_BOTTOM) y = MAX_BOTTOM;
		if (layer2 - v <= 0){
			layer1 = 0;
			layer2 = 1200;
			
		} else{
			
		
		
		 layer1 -= v;
		layer2 -= v;
		
		}
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT) {
			dv = 1;
		}
		if (key == KeyEvent.VK_LEFT){
			dv = -1;	
		}
		if (key == KeyEvent.VK_UP) {
			dy = 5;
			img = img_l;
		
		}
		if (key == KeyEvent.VK_DOWN) {
			dy = -5;
			img = img_r;
		}
	}
		
	
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_LEFT){
			dv = 0;
	}
		if (key == KeyEvent.VK_UP || key == KeyEvent.VK_DOWN){
			dy = 0;
			img = img_c;
			
		}
	}
	}

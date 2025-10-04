import java.util.ArrayList;
import java.util.List;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Main {
	
	public static void main(String[] args) {
	
		new BouncingBalls();
	
	}
	
}

class BouncingBalls extends JPanel {
	
	JFrame frame;
	
	static final Balls b = new Balls(25);
	
	static final int WIDTH 	= 500;
	static final int HEIGHT = 500;
	
	BouncingBalls(){	// To put the panel inside of.
		
		frame = new JFrame();
		
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		frame.setTitle("Bouncing Balls");	// TODO: Come up with a better name.
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setUndecorated(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add(this);
		frame.pack();
	}

	public void paint(Graphics g) {
		
		try {
			Thread.sleep(16);	
		} catch (Exception e) 
		{
		}
			
		b.run(g);
		
		frame.repaint();
	
	}
	
}

class Balls {

	List<Ball> balls;
	
	Balls(int n) {
		
        balls = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			
			balls.add(new Ball(
			
			25 + (int) (Math.random() * 450),
			25 + (int) (Math.random() * 450)
			
			));
			
		}
    }
	
	void run(Graphics g) {
		
		for (Ball b: balls) {
			
			b.update(g);
			
		}
	}

}

class Ball {
	
	int x, y;
	
	int addx = 1 + (int) (Math.random() * 15);
	int addy = 1 + (int) (Math.random() * 15);

	Ball(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	void update(Graphics g) {
		
		g.drawOval(
		
		x - 25, y - 25,
		50,		50
		
		);
		
		if (x < 25 || x > 475) {
			
			addx = -addx;
			
		}
		
		if (y < 25 || y > 475) {
			
			addy = -addy;
			
		}
		
		x += addx;
		y += addy;
		
		
	}

}

class Vector2D {
	
	double x, y;
	
	Vector2D() {
		
	}
	
	Vector2D(double x, double y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	void add(Vector2D v) {
		
		this.x += v.x;
		this.y += v.y;
		
	}
	
	void sub(Vector2D v) {
		
		this.x -= v.x;
		this.y -= v.y;
		
	}
	
	void div(double d) {
		
		x /= d;
		y /= d;
		
	}
	
	void mult(double d) {
		
		x *= d;
		y *= d;
		
	}
	
	double mag() {
		
        return Math.sqrt(x*x + y*y);
		
    }
	
	void normalize() {
		double mag = mag();
		if (mag != 0) {
			x /= mag;
			y /= mag;
		}
		
	}
	
}

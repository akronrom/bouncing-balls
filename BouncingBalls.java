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
	
	int WIDTH 	= 500;
	int HEIGHT 	= 500;
	
	JFrame frame;
	
	BouncingBalls() {	// To put the panel inside of.
	
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		frame = new JFrame();
		
		frame.setTitle("Bouncing Balls");	// TODO: Come up with a better name.
		
		frame.setSize(WIDTH, HEIGHT);
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
		frame.add(this);
		frame.pack();
	}
	
	public Balls b = new Balls(25, this);
	
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
	
	int WIDTH, HEIGHT;

	Balls(int n, BouncingBalls e) {
		
		this.WIDTH 	= e.WIDTH;
		this.HEIGHT = e.HEIGHT;
		
        balls = new ArrayList<>();
		
		
		for (int i = 0; i < n; i++) {
			
			int randy = (int) ((Math.random() - .5) * 250);
			int randx = (int) ((Math.random() - .5) * 250);
			
			balls.add(new Ball(
			
			(WIDTH	/	2) + randx,
			(HEIGHT	/	2) + randy
			
			));
			
		}
    }
	
	void run(Graphics g) {
		
		for (Ball b: balls) {
			
			b.update(g, WIDTH, HEIGHT);
			
		}
	}

}

class Ball {
	
	final int SIZE = 50;
	// + (int) (Math.random() * 100);
	
	int x, y;
	
	int addx = 1 + (int) (Math.random() * 10);
	int addy = 1 - (int) (Math.random() * 10);

	Ball(int x, int y) {
		
		this.x = x;
		this.y = y;
		
	}
	
	void update(Graphics g, int WIDTH, int HEIGHT) {
		
		
		g.drawOval(
		
		x - SIZE/2, y - SIZE/2,
		SIZE,		SIZE
		
		);
		
		if (x < SIZE/2 || x > WIDTH - SIZE/2) {
			
			addx = -addx;
			
		}
		
		if (y < SIZE/2 || y > HEIGHT - SIZE/2) {
			
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

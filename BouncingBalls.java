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
	
	int WIDTH 	= 1000;
	int HEIGHT 	= 1000;
	
	JFrame frame;
	
	BouncingBalls() {	// To put the panel inside of.
	
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		
		frame = new JFrame();
		
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
	
	Balls b = new Balls(10, this);
	
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
			
			int rand = (int) ((Math.random() - .5) * 250);
		
			balls.add(new Ball(
			
			(WIDTH	/	2) + rand,
			(HEIGHT	/	2) + rand
			
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
	
	int SIZE = 5 + (int) (Math.random() * 80);
	
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
		//SIZE--;
		
		
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
	
	// Vector2D: Addition and Subtraction
	
	void add(Vector2D v) {
		
		this.x += v.x;
		this.y += v.y;
		
	}
	
	void sub(Vector2D v) {
		
		this.x -= v.x;
		this.y -= v.y;
		
	}
	
	// Vector2D: Magnitude, Vector Length
	
	double mag() {
		
        return Math.sqrt(
		
			x*x + y*y
			
		);
		
    }
	
	void normalize() {
		double mag = mag();
		if (mag != 0) {
			x /= mag;
			y /= mag;
		}
		
	}
	
	void div(double d) {
		
		x /= d;
		y /= d;
		
	}
	
	void mult(double d) {
		
		x *= d;
		y *= d;
		
	}
	
}

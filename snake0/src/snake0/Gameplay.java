package snake0;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Gameplay extends JPanel implements KeyListener, ActionListener {

	private int[] snakexlength = new int[750];
	private int[] snakeylength = new int[750];
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;

	private ImageIcon rightmouth;
	private ImageIcon leftmouth;
	private ImageIcon upmouth;
	private ImageIcon downmouth;

	private Timer timer;
	private int delay = 100;
	private ImageIcon snakeImage;

	private int lengthofsnake = 3;
	private int moves = 0;

	public Gameplay() {
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		// timer=new Timer(delay,this);
		// timer.start();
	}

	public void paint(Graphics g) {
		if (moves == 0) {
			snakexlength[2] = 50;
			snakexlength[1] = 75;
			snakexlength[0] = 100;

			snakeylength[2] = 50;
			snakeylength[1] = 75;
			snakeylength[0] = 100;
		}

		g.setColor(Color.WHITE);
		g.drawRect(24, 10, 851, 55);
		// titleImage=new ImageIcon();
		g.setColor(Color.white);
		g.drawRect(24, 74, 851, 577);

		g.setColor(Color.black);
		g.drawRect(25, 75, 850, 575);

		rightmouth = new ImageIcon("rightmouth.png");
		rightmouth.paintIcon(this, g, snakexlength[0], snakeylength[0]);

		for (int a = 0; a <= lengthofsnake; a++) {
			if (a == 0 && right) {
				rightmouth = new ImageIcon("rightmouth.png");
				rightmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if (a == 0 && left) {
				leftmouth = new ImageIcon("leftmouth.png");
				leftmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if (a == 0 && up) {
				upmouth = new ImageIcon("upmouth.png");
				upmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if (a == 0 && down) {
				downmouth = new ImageIcon("downmouth.png");
				downmouth.paintIcon(this, g, snakexlength[a], snakeylength[a]);
			}
			if (a != 0) {

				snakeImage = new ImageIcon("snakeimage.png");
				snakeImage.paintIcon(this, g, snakexlength[a], snakeylength[a]);

			}

		}

		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		if

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_RIGHT) {
			moves++;
			if(!left) {
				right=true;
			}
			else {
				right=false;left=true;
			}
		//	right=true;
			up=false;down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_LEFT) {
			moves++;
			if(!right) {
				left=true;
			}
			else {
				right=true;left=false;
			}
		//	right=true;
			up=false;down=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_UP) {
			moves++;
			if(!down) {
				up=true;
			}
			else {
				up=false;down=true;
			}
		//	right=true;
			right=false;left=false;
		}
		if(e.getKeyCode()==KeyEvent.VK_DOWN) {
			moves++;
			if(!up) {
				down=true;
			}
			else {
				up=false;down=true;
			}
		//	right=true;
			right=false;left=false;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}

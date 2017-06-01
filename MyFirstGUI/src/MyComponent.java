import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Random;

import javax.swing.JComponent;

public class MyComponent extends JComponent {

	private static int counter = 0;

	private static MutableCar theCars[];


	Random genRand = new Random();

	public static final int LaneWidth = 40;
	private static boolean someCarWon = false;

	public boolean getSomeCarWon(){ return someCarWon;}

	public MyComponent(int numCars) {
		theCars = new MutableCar[numCars];
		for(int i=0; i<numCars; i++){ int laneY = i*LaneWidth;
		theCars[i] = new MutableCar(0,laneY, Color.DARK_GRAY, 10,1);
		}
	}
	public boolean carBumped(MutableCar c) {
		return ((c.getCarDirection() > 0) && (c.getxPos()+60 >= this.getWidth()) || (c.getxPos() <= 0));
	}


	public void paintComponent(Graphics g) {		


		int iMax=0;
		for(int i=0; i<theCars.length;i++){	
			theCars[i].draw(g);
			theCars[i].move(genRand.nextInt(20),0);
			theCars[i].setColor(Color.RED);
			
			if (theCars[iMax].getxPos()<theCars[i].getxPos()){
				iMax = i;
			}
			
			if (this.carBumped(theCars[i]))
			{
				this.someCarWon = true;
			}



			theCars[iMax].setColor(Color.GREEN);
			
			System.out.println("Painted " + counter++ + " times");
		}

	}
}

import javax.swing.JFrame;

public class Main {
	public static void main (String[] args) throws InterruptedException {
		JFrame mainFrame = new JFrame();
		mainFrame.setSize(400, 600);
		mainFrame.setTitle("My First Java GUI With Mutable Cars Rocks!!");
		
		int numCars = 5;
//		int numCars = mainFrame.getHeight()/MyComponent.LaneWidth;
		
		MyComponent theComponent = new MyComponent(numCars);
		mainFrame.add(theComponent);
		
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		while (!theComponent.getSomeCarWon()) {
			mainFrame.repaint();
			Thread.sleep(150);
		}
	}
}

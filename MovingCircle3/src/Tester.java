import java.awt.*;
class MovingCircle extends Frame implements Runnable
{
	private int x1,x2,x3;
	private Thread c1,c2,c3;
	
	
	public MovingCircle() {
		c1=new Thread (this,"c1");
		c2=new Thread (this,"c2");
		c3=new Thread (this,"c3");
		c1.start();
		c2.start();
		c3.start();
		
	}
	public void paint(Graphics g ) {
		
		g.setColor(Color.red);
		g.fillOval(x1, 100, 100, 100);
		g.setColor(Color.blue);
		g.fillOval(x2, 250, 100, 100);
		g.setColor(Color.green);
		g.fillOval(x3, 400, 100, 100);	
		
		
	}
	
	public void run() {
		while(true)
		{
			if(Thread.currentThread()==c1) {
				synchronized(this) {
				x1++;
				if(x1==this.getWidth()-100) {
					try {
						wait();
					}catch (InterruptedException e1) {
						
					}
				}
			}
				try{
					Thread.sleep(10);
				}catch(Exception e ){
				}
			}
			else if(Thread.currentThread()==c2) 
			{
				synchronized(this) {
				x2++;
				if(x2==this.getWidth()-100) {
					try {
						wait();
					}catch(InterruptedException e ) {
				}
			}
				}
				    try {
				    	Thread.sleep(30);
				    }catch(Exception e ) {
				    	
				    }
				}

			else if(Thread.currentThread()==c3) {
				synchronized(this) {
				x3++;
				if(x3==this.getWidth()-100) {
					x1=x2=x3=0;
					notifyAll();
				}
			}
				try {
					Thread.sleep(60);
				}catch(Exception e ) {}
		}
			repaint();
		
		}
	}
}



public class Tester {
	public static void main(String[] args) {
	MovingCircle mc = new MovingCircle();
	mc.setSize(600,600);
	mc.setVisible(true);
	}
}

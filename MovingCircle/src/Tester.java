import java.awt.*;
class MovingStrings extends Frame implements Runnable
{
	
	private Thread c1;
	private int x,y,r,s;
	
	
	public MovingStrings() {
		x=100;
		c1=new Thread(this ,"c1");
		c1.start();
	}

	public void paint(Graphics g )
	{
		g.setColor(Color.red);
		g.fillOval(x, 200, 100, 100);

		
	}
	@Override
	public void run() {
		int move = 0;
		while(true)
		{
			if(Thread.currentThread()==c1)
			{
				if(move==0)
					x++;
				else if (move ==1)
					x--;
				if(x==this.getWidth()-100)
					move = 1;
				if(x==0)
					move=0;
				try {
					Thread.sleep(30);
				}catch(Exception e){
					
				}
			}
			
			repaint();
				
		}
		
	}
	

}





public class Tester {

	public static void main(String[] args) {
		MovingStrings ms = new MovingStrings();
		ms.setSize(500,500);
		ms.setVisible(true);

	}

}

package views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import models.Gravedad;

public class Persona extends JLabel implements Runnable{
	Gravedad gravedad;
	
	
	public Persona(Gravedad grav) {
		this.gravedad=grav;
		ImageIcon image = new ImageIcon(getClass().getResource("/img/man.png"));
		setIcon(image);
	}

	@Override
	public void run() {
		
		while(!gravedad.isFin()) {
			synchronized (gravedad) {
	            try{ 
	            	gravedad.wait();
	            }catch(InterruptedException e){
	            	
	            	Thread.currentThread().interrupt();
	            }
	            if(gravedad.isFin())
	            	Thread.currentThread().interrupt();
	            mover(gravedad.getPx(), gravedad.isArriba());
	        }
		}
		
	}
	
	private void mover(int px, boolean arriba) {
		
		int y=this.getLocation().y;
		if(arriba){
			y-=px;
		}
		else {
			y+=px;
		}
		this.setLocation(this.getLocation().x, y);
	}
}

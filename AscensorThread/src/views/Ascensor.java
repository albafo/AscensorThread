package views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import models.Gravedad;

public class Ascensor extends JLabel implements Runnable {
	
	Gravedad gravedad;
	
	public Ascensor(Gravedad g) {
		ImageIcon image = new ImageIcon(getClass().getResource("/img/ascensor.jpg"));
		setIcon(image);
		this.gravedad=g;
	}

	@Override
	public void run() {
		
		while(true) {
			mover(4, 20, true);
			if(this.getLocation().y<=0){
				synchronized (gravedad) {
					gravedad.setFin();
					gravedad.notify();
	                // msg.notifyAll();
	            }
				Thread.currentThread().interrupt();
			}
		}
	}
	
	private void mover(int px, int ms, boolean arriba) {
		try {
			
			Thread.sleep(ms);
			
			int y=this.getLocation().y;
			if(arriba){
				y-=px;
			}
			else {
				y+=px;
			}
			this.setLocation(this.getLocation().x, y);
			synchronized (gravedad) {
				gravedad.setPx(px);
			
				gravedad.setArriba(arriba);
				gravedad.notify();
                // msg.notifyAll();
            }
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}
}

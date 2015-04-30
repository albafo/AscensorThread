package models;

public class Gravedad {
	private int px, ms;
	boolean arriba;
	boolean fin=false;
	
	public int getPx() {
		return px;
	}
	public void setPx(int px) {
		this.px = px;
	}
	
	public boolean isArriba() {
		return arriba;
	}
	public void setArriba(boolean arriba) {
		this.arriba = arriba;
	}
	
	public void setFin() {
		fin=true;
	}
	
	public boolean isFin() {
		return fin;
	}
	
	
}

package ejemploentorno;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;

public class Barra {
	
	private int ancho;
	private int alto;
	private int x;
	private int y;
	private int velocidad;
	private Image imagen;
	
	public Barra(int x, int y) {
		this.x = x;
		this.y = y;
		this.ancho = 100;
		this.alto = 50;
		this.velocidad = 5;
	}
	
	public void dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(x, y, ancho, alto, 0, Color.CYAN);
	
	}
	
	public void moverDerecha() {
		this.x += velocidad;
	}
	
	public void moverIzquierda() {
		this.x -= velocidad;
	}
	
	
	// Getters y Setters
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public int getAncho() {
		return ancho;
	}
	public int getAlto() {
		return alto;
	}
	
	

}

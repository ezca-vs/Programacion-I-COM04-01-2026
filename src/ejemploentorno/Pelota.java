package ejemploentorno;

import java.awt.Color;

import entorno.Entorno;

/*
 * Esta clase modela el comportamiento de una pelota
 * de ping pong
 */
public class Pelota {
	
	int diametro; 
	double x;
	double y;
	double anguloDireccion; // En radianes
	int velocidad;
	Color color;
	
	public Pelota(double x, double y) {
		this.diametro = 30;
		this.x = x;
		this.y = y;
		this.velocidad = 2;
		this.anguloDireccion = 0.5;
		this.color = Color.WHITE;
	}
	
	/**
	 * Esto dibuja la pelota dentro del entorno
	 */
	public void dibujar(Entorno entorno) {
		entorno.dibujarCirculo(x, y, diametro, color);
	}
	
	/*
	 * Permite mover la pelota dentro del entorno
	 */
	public void mover() {
		this.x = this.x + Math.cos(anguloDireccion);
		this.y = this.y + Math.sin(anguloDireccion);
	}
	
	public void rebotar(Entorno entorno) {
		if(y - (this.diametro)/2 <= 0 || 
				y + (this.diametro/2) >= entorno.alto()) {
			this.anguloDireccion = this.anguloDireccion * (-1);
		}else {
			this.anguloDireccion = Math.PI - this.anguloDireccion; 
		}
	}
	
	public boolean colisionaConElBorde(Entorno entorno) {
		double radio = (this.diametro/2);
		double bordeIzqPelota = this.x - radio;
		double bordeDerPelota = this.x + radio;
		double bordeArribaPelota = this.y - radio;
		double bordeAbajoPelota = this.y + radio;
		// x = 0 borde izq
		if(bordeIzqPelota <= 0) {
			return true;
		}
		// x = entorno.ancho() borde der
		if(bordeDerPelota >= entorno.ancho()) {
			System.out.println("x: " + x + ", y: " + y);
			return true;
		}
		// y = 0 borde arriba
		if(bordeArribaPelota <= 0) {
			return true;
		}
		// y = entorno.alto() borde debajo
		if(bordeAbajoPelota >= entorno.alto()) {
			return true;
		}
		
		return false;
	}

}

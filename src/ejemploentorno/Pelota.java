package ejemploentorno;

import java.awt.Color;
import java.awt.Image;

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
	private Image image;
	
	public Pelota(double x, double y) {
		this.diametro = 30;
		this.x = x;
		this.y = y;
		this.velocidad = 2;
		this.anguloDireccion = 0.5;
		this.color = Color.WHITE;
		this.image = image;
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
		this.x = this.x + Math.cos(anguloDireccion)*5;
		this.y = this.y + Math.sin(anguloDireccion)*5;
	}
	
	/**
	 * Esto hace rebotar la pelota
	 * @param entorno
	 */
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
			return false;
		}
		
		return false;
	}
	
	public void rebotar(Double x1, Double x2, Double y1, Double y2) {
		double radio = this.getDiametro()/2;
		double bordeDerechoPelota = this.x + radio;
		double bordeIzquierdoPelota = this.x - radio;
		boolean estaDentroHorizontalmente = x1 <= bordeDerechoPelota &&
												x2 >= bordeIzquierdoPelota;	
		if(this.y + diametro/2  > y1 && estaDentroHorizontalmente) {
			this.anguloDireccion = this.anguloDireccion * (-1); 
		}
	}

	public int getDiametro() {
		return diametro;
	}

	public void setDiametro(int diametro) {
		this.diametro = diametro;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAnguloDireccion() {
		return anguloDireccion;
	}

	public void setAnguloDireccion(double anguloDireccion) {
		this.anguloDireccion = anguloDireccion;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
	

}

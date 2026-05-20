package ejemploentorno;


import java.awt.Color;

import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	
	// Variables y métodos propios de cada grupo
	int n;
	Pelota pelota;
	Barra barra;
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Ping Pong", 600, 400);
		
		// Inicializar lo que haga falta para el juego
		n = 0;
		pelota = new Pelota(100, 100);
		barra = new Barra(entorno.ancho()/2, entorno.alto());

		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		// Procesamiento de un instante de tiempo
		// ...
		// Para moverlo horizontalmente necesitamos alterar el eje x
		// En cada tick hacemos avanzar el eje x
		
		if(pelota.colisionaConElBorde(entorno)) {
			pelota.rebotar(entorno);
		}
		
		pelota.dibujar(entorno);
		barra.dibujar(entorno);
		
		// Movimientos
		if(sePresionoIzq() && !estaEnElBordeIzquierdo(barra.getX() - barra.getAncho()/2))
			barra.moverIzquierda();
		if(sePresionoDer() && !estaEnElBordeDerecho(barra.getX() + barra.getAncho()/2))
			barra.moverDerecha();
		
		pelota.mover();
		
		// Colisiones
	}
	
	public boolean sePresionoIzq() {
		return entorno.estaPresionada('a') || entorno.estaPresionada(entorno.TECLA_IZQUIERDA);
	}
	
	public boolean sePresionoDer() {
		return entorno.estaPresionada('d') || entorno.estaPresionada(entorno.TECLA_DERECHA);
	}
	
	public boolean estaEnElBordeDerecho(int x) {
		return x >= entorno.ancho();
	}
	
	public boolean estaEnElBordeIzquierdo(int x) {
		return x <= 0;
	}
	
	

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}

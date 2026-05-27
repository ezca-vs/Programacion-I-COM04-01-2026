package ejemploListas;

public class ListaInt {
	NodoInt primero;

	public ListaInt() {
		this.primero = null;
	}

	public void imprimir() {
		System.out.print("[");
		NodoInt actual = this.primero;
		while (actual != null) {
			System.out.print(actual.elemento + " ");
			actual = actual.siguiente;
		}
		System.out.println("]");
	}

	public void agregarAdelante(int n) {

		NodoInt nuevo = new NodoInt(n);
		nuevo.siguiente = this.primero;
		this.primero = nuevo;

	}

	public void agregarAtras(int n) {
		NodoInt nuevo = new NodoInt(n);

		if (this.primero == null)
			this.primero = nuevo;

		else {
			NodoInt actual = this.primero;
			while (actual.siguiente != null)
				actual = actual.siguiente;

			actual.siguiente = nuevo;
		}
	}

	public void quitar(int n) {

		if (this.primero != null && this.primero.elemento == n)
			this.primero = this.primero.siguiente;

		else {
			NodoInt actual = this.primero;

			while (actual.siguiente != null && actual.siguiente.elemento != n)
				actual = actual.siguiente;

			if (actual.siguiente != null)
				actual.siguiente = actual.siguiente.siguiente;
		}
	}

	void recortarDesde(int k) {
		if (k == 0) {
			this.primero = null;
		} else {
			NodoInt actual = this.primero;
			int pos = 0;
			while (pos < k - 1 && actual.siguiente != null) {
				actual = actual.siguiente;
				pos++;
			}
			if (actual != null)
				actual.siguiente = null;
		}

	}

	void recortarHasta(int k) {
		if (this.primero != null && k == 0) {
			this.primero = primero.siguiente;
		} else {
			NodoInt actual = this.primero;
			int pos = 0;
			while (pos <= k && actual != null) {
				actual = actual.siguiente;
				pos++;
			}
			this.primero = actual;
		}
	}
	
	public int iesimo(int pos) {
		// casos bordes
		if(pos < 0 || this.primero == null) {
			throw new IndexOutOfBoundsException();
		}
		
		// caso normal
		int posActual = 0;
		NodoInt actual = this.primero;
		while(actual != null && posActual < pos) {
			
			actual = actual.siguiente;
			posActual++;
		}
		//return actual.elemento; // nullpointerexception
		if(actual == null) {
			//throw new Exception();
			throw new IndexOutOfBoundsException();
		}
		
		return actual.elemento;
	}
	
	/*
	 * [-9,1,-7,6,11,6]
	 * sublista(2,5) -->  [-7,6,11,6] | hasta inclusive**
	 */
	
	public ListaInt sublista(int desde, int hasta) {
		
		NodoInt actual = this.primero;
		int posActual = 0;
		while(actual != null && posActual < desde) {
			actual = actual.siguiente;
			posActual++;
		}
		
		ListaInt sublistaNueva = new ListaInt();
		if(actual == null) {
			return sublistaNueva; // lista vacia
		}
		
		// caso normal
		while(actual != null && posActual <= hasta) {
			sublistaNueva.agregarAtras(actual.elemento);
			actual = actual.siguiente;
			posActual++;
		}
		
		return sublistaNueva;
	}

}

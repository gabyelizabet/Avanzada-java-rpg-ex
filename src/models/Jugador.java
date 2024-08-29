package models;

public class Jugador extends Entidad {
  private InventarioJugador inventario;
  private Ubicacion ubicacionActual;
  private int capacidadMax = 100;
  private boolean bloqueando;

  public Jugador(String nombre, Ubicacion ubicacionInicial) {
    super(nombre, 100, 15);
    this.inventario = new InventarioJugador(capacidadMax);
    this.ubicacionActual = ubicacionInicial;
  }

  @Override
  public void recibirDanio(int danio) {
    if (bloqueando){
      danio /= 2; //para reducir el daño recibido en un 50%
      bloqueando = false; //desbloqueo 
    }
    this.vida -= danio;
  }

  @Override
  public String atacar(Entidad objetivo) {
    String resultado = "";
    objetivo.recibirDanio(this.ataque);
    resultado += (this.nombre + " ataca a " + objetivo.getNombre() + " causando " + this.ataque + " puntos de daño.");
    return resultado;
}

  public void curarse(int cantidadCuracion, String nombre) {
    this.vida = Math.min(100, getVida() + cantidadCuracion);
  }

  public String mostrarInventario() {
    return inventario.listarObjetos();
  }

  public Ubicacion getUbicacionActual() {
    return ubicacionActual;
  }

  public InventarioJugador getInventario() {
    return inventario;
  }

  public void setInventario(InventarioJugador inventario) {
    this.inventario = inventario;
  }

  public void setUbicacionActual(Ubicacion ubicacionActual) {
    this.ubicacionActual = ubicacionActual;
  }

  public int getCapacidadMax() {
    return capacidadMax;
  }

  public void setCapacidadMax(int capacidadMax) {
    this.capacidadMax = capacidadMax;
  }

  public void setBloqueando(boolean bloqueando) {
    this.bloqueando = bloqueando;
  }
}
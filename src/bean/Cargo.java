package bean;

public class Cargo {
	int id;
	String Detalle, Estado, FechaCreacion, FechaEdicion;
	boolean Valido;

	public Cargo() { }
	
	public Cargo(int id, String detalle, String estado, String fechaCreacion, String fechaEdicion) {
		this.id = id;
		Detalle = detalle;
		Estado = estado;
		FechaCreacion = fechaCreacion;
		FechaEdicion = fechaEdicion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

	public String getFechaCreacion() {
		return FechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}

	public String getFechaEdicion() {
		return FechaEdicion;
	}

	public void setFechaEdicion(String fechaEdicion) {
		FechaEdicion = fechaEdicion;
	}

	public boolean isValido() {
		return Valido;
	}

	public void setValido(boolean valido) {
		Valido = valido;
	}
	

}

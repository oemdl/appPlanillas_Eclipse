package bean;

public class Departamento {
	int id;
	String RazonSocial, Cuenta, Estado, FechaCreacion, FechaEdicion;
	boolean Valido;
	
	public Departamento() { }
	
	public Departamento(int id, String razonSocial, String cuenta, String estado, String fechaCreacion, String fechaEdicion) {
		this.id = id;
		RazonSocial = razonSocial;
		Cuenta = cuenta;
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

	public String getRazonSocial() {
		return RazonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		RazonSocial = razonSocial;
	}

	public String getCuenta() {
		return Cuenta;
	}

	public void setCuenta(String cuenta) {
		Cuenta = cuenta;
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

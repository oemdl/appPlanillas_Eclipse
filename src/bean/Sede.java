package bean;

public class Sede {
	int id;
	String RazonSocial;
	String Direccion;
	int idDepartamento;
	int idProvincia;
	int idDistrito;
	int idEstado;
	String FechaCreacion;
	String FechaEdicion;
	boolean Valido;

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
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	public int getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public int getIdProvincia() {
		return idProvincia;
	}
	public void setIdProvincia(int idProvincia) {
		this.idProvincia = idProvincia;
	}
	public int getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(int idDistrito) {
		this.idDistrito = idDistrito;
	}
	public int getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
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
	
	public Sede() { }
	
	public Sede(String[] aRegistro) {
		Valido = false;
		if ( aRegistro == null ) return;

		id = Integer.parseInt( aRegistro[0] );
		RazonSocial = aRegistro[1];
		Direccion = aRegistro[2];
		idDepartamento = Integer.parseInt( aRegistro[3] );;
		idProvincia = Integer.parseInt( aRegistro[4] );
		idDistrito = Integer.parseInt( aRegistro[5] );
		idEstado = Integer.parseInt( aRegistro[6] );
		FechaCreacion = aRegistro[7];
		FechaEdicion = aRegistro[8];
		Valido = true;
	}

	public Sede(int id, String razonSocial, String direccion, int idDepartamento, int idProvincia, int idDistrito,
			int idEstado, String fechaCreacion, String fechaEdicion, boolean valido) {
		super();
		this.id = id;
		RazonSocial = razonSocial;
		Direccion = direccion;
		this.idDepartamento = idDepartamento;
		this.idProvincia = idProvincia;
		this.idDistrito = idDistrito;
		this.idEstado = idEstado;
		FechaCreacion = fechaCreacion;
		FechaEdicion = fechaEdicion;
		Valido = valido;
	}

	public Object[] getColumnas() {
		return new Object[] { id,RazonSocial,Direccion,idDepartamento,idProvincia,idDistrito };
	}
	
	@Override
	public String toString() {
		return String.format( 
				"%s,%s,%s,%s,%s,%s",
				id, RazonSocial, Direccion, idDepartamento, idProvincia, idDistrito );
	}

}

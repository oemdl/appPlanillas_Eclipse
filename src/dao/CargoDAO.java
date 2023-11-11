package dao;

import javax.swing.table.DefaultTableModel;

import bean.Cargo;

public class daoCargo {
	db.Db db = new db.Db("Planilla");

	public DefaultTableModel getCargos() {
		db.Sentencia("call sp_getCargos()");
		return db.getDefaultTableModel();
	}

	public void Guardar(Cargo cargo) {
		db.Sentencia( String.format("call sp_guardarCargo( %s,'%s')", cargo.getId(), cargo.getDetalle() ) ) ;
		cargo.setValido( db.Ejecutar() == 1 );
	}

}

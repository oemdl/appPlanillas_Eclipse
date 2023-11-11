package dao;

import javax.swing.table.DefaultTableModel;

import bean.CentroCosto;

public class CentroCostoDAO {

	db.Db db = new db.Db("Planilla");

	public DefaultTableModel getCentroCostos() {
		db.Sentencia("call sp_getCentroCostos()");
		return db.getDefaultTableModel();
	}

	public void Guardar(CentroCosto centroCosto) {
		db.Sentencia( String.format("call sp_guardarCentroCosto( %s,'%s')", centroCosto.getId(), centroCosto.getDetalle() ) ) ;
		centroCosto.setValido( db.Ejecutar() == 1 );
	}

}

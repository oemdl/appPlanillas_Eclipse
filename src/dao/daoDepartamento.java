package dao;

import javax.swing.table.DefaultTableModel;

import bean.Departamento;

public class daoDepartamento {
	db.Db db = new db.Db("Planilla");

	public DefaultTableModel getDepartamentos() {
		db.Sentencia("call sp_getDepartamentos()");
		return db.getDefaultTableModel();
	}

	public void Guardar(Departamento departamento) {
		db.Sentencia( String.format("call sp_guardarDepartamentos( %s,'%s','%s')",
				departamento.getId(), departamento.getRazonSocial(), departamento.getCuenta() ) ) ;
		departamento.setValido( db.Ejecutar() == 1 );
	}

}
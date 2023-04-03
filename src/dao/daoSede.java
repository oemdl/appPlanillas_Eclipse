package dao;

import javax.swing.table.DefaultTableModel;

import bean.Sede;

public class daoSede {
	db.Db db = new db.Db("Planilla");

	public DefaultTableModel getSedes() {
		db.Sentencia("call sp_getSedes()");
		return db.getDefaultTableModel();
	}

	public void Guardar(Sede sede) {
		
	}

}

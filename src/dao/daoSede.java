package dao;

import javax.swing.table.DefaultTableModel;

import bean.Sede;

public class daoSede {
	db.Db db = new db.Db("Planilla");

	public DefaultTableModel getSedes() {
		db.Sentencia("call sp_getSedes()");
		return db.getDefaultTableModel();
	}
	
	public Sede getSede(int id) {
		db.Sentencia( String.format( "call sp_getSede(%s)", id ) );
		return new Sede( db.getRegistro() );
	}

	public void Guardar(Sede sede) {
		
	}

}

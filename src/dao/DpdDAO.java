package dao;

import java.util.ArrayList;

import javax.swing.JComboBox;

public class DpdDAO {
	db.Db db = new db.Db("DPD");
	
	public ArrayList<String> getDepartamentos(JComboBox<String> cboDepartamento, String sTexto) {
		db.Sentencia( "call sp_getDepartamentos()" );
		return db.getComboBox(cboDepartamento, sTexto);
	}
	
	public ArrayList<String> getProvincias(JComboBox<String> cboProvincia, String sTexto, String sID) {
		db.Sentencia( String.format( "call sp_getProvincias(%s)", sID ) );
		return db.getComboBox(cboProvincia, sTexto);
	}
	
	public ArrayList<String> getDistritos(JComboBox<String> cboDistrito, String sTexto, String sID) {
		db.Sentencia( String.format( "call sp_getDistritos(%s)", sID ) );
		return db.getComboBox(cboDistrito, sTexto);
	}
	
}
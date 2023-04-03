package dao;

import java.util.ArrayList;

import javax.swing.JComboBox;

public class daoDPD {
	db.Db db = new db.Db("DPD");
	
	public void getDepartamentos(JComboBox<String> cboDepartamento, ArrayList<String> aID, String sTexto) {
		db.Sentencia( "call sp_getDepartamentos()" );
		db.getComboBox(cboDepartamento, aID, sTexto);
	}
	
}

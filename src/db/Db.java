package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class Db {
	String _IP="localhost", _PORT="3306", _BD="", _USER="root", _PASSWORD="", _SQL="";
	Connection cn = null;
	PreparedStatement ps = null;

	public Db(String bd) {
		_BD = bd;
		getConexion();
	}

	public Db(String ip, String port, String bd, String user, String password) {
		_IP = ip;
		_PORT = port;
		_BD = bd;
		_USER = user;
		_PASSWORD = password;
		getConexion();
	}
	
	private void getConexion() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn = DriverManager.getConnection( String.format("jdbc:mysql://%s:%s/%s", _IP, _PORT, _BD ), _USER, _PASSWORD );
		} catch (ClassNotFoundException | SQLException e) { e.printStackTrace(); }
	}

	public void Sentencia(String sql) {
		if ( cn == null ) return;
		
		this._SQL = sql;
		try {
			ps = cn.prepareStatement(sql);
		} catch (SQLException e) { e.printStackTrace(); }
	}

	public void Parametros(String sColumnas) {
		Object[] columnas = sColumnas.split( "," );
		if ( cn == null || columnas == null || columnas.length == 0 ) return;

		_SQL += "(?";
		for ( int i=1; i < columnas.length; i++, _SQL += ",?" );
		_SQL += ")";
	
		try {
			ps = cn.prepareStatement( _SQL );
			for ( int i=0; i < columnas.length; i++ )
				ps.setObject( i+1, columnas[i] );
		} catch (SQLException e) { e.printStackTrace(); }

	}
		
	public DefaultTableModel getDefaultTableModel() {
		DefaultTableModel modelo = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;
			
			@Override
		    public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }
		};

		if ( cn == null || ps == null ) return modelo;
		
		try {
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			
			if ( rsmd.getColumnCount() > 0 ) {
				int columnas = rsmd.getColumnCount();
				
				for(int i=0; i < columnas; i++)
					modelo.addColumn( rsmd.getColumnName(i+1) );
				
				String[] aRegistro = new String[columnas];
				while ( rs.next() ) {
					for(int columna=0; columna < columnas; columna++)
						aRegistro[columna] = rs.getString( columna + 1 ).trim();
					modelo.addRow( aRegistro );
				}
					
				return modelo;
			}
		} catch (SQLException e) { e.printStackTrace(); }
		
		return modelo;
	}

	public int Ejecutar() {
		if ( cn == null ) return -1;
		
		try {
			return ps.executeUpdate();
		} catch (SQLException e) { e.printStackTrace(); }

		return -1;
	}

	public ArrayList<String> getComboBox(JComboBox<String> cbo, String sTexto) {
		if ( cn == null || ps == null ) return null;
	
		ArrayList<String> aID = new ArrayList<>();
		aID.add("");
		
		cbo.removeAllItems();
		cbo.addItem(sTexto);

		try {
			ResultSet rs = ps.executeQuery();
			if ( rs.last() ) {
				rs.beforeFirst();
				while( rs.next() ) {
					aID.add( rs.getString(1) );
					cbo.addItem( rs.getString(2).trim() );
				}
			}
		} catch (SQLException e) { e.printStackTrace(); }
		
		return aID;
	}

	public String[] getRegistro() {
		if ( cn == null || ps == null ) return null;
		
		try {
			ResultSet rs = ps.executeQuery();
			if ( rs.next() ) {
				int columnas = rs.getMetaData().getColumnCount();
				String[] aRegistro = new String[ columnas ];
				for( int i=0; i < columnas; i++ )
					aRegistro[i] = rs.getString( i + 1 ).trim();
				
				return aRegistro;
			}
		} catch (SQLException e) { e.printStackTrace();	}
		
		return null;
	}

}

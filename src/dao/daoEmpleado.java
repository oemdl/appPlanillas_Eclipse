package dao;

import bean.Empleado;

public class daoEmpleado {

	public void Guardar(Empleado empleado) {
		
	}

	public void Login(Empleado empleado) {
		empleado.setValido( true );
		
	}

}


/* Guardar

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

try {
	//"1,Omar,Espinoza,Manrique de Lara,Puente Piedra,12345678,123456"
	FileWriter fileWriter = new FileWriter("Empleados.txt");
	BufferedWriter bufferedWriter  = new BufferedWriter(fileWriter);
	bufferedWriter.write( empleado.toString() + "\n" );
	bufferedWriter.close();
	fileWriter.close();
} catch (IOException e) { e.printStackTrace(); } 
*/

/* Login
try {
	//["1","Omar","Espinoza","Manrique de Lara","Puente Piedra","12345678","123456"]
	FileReader fileReader = new FileReader("Empleados.txt");
	BufferedReader bufferedReader  = new BufferedReader(fileReader);
	
	String linea = null;
	while ( (linea = bufferedReader.readLine()) != null ) {
		String[] aLinea = linea.split(",");
		if ( empleado.getDni().equals(aLinea[5]) && empleado.getPassword().equals(aLinea[6]) ) {
			empleado.setId( Integer.parseInt(aLinea[0]) );
			empleado.setNombres( aLinea[1] );
			empleado.setApellidoPaterno( aLinea[2] );
			empleado.setApellidoMaterno( aLinea[3] );
			empleado.setDireccion( aLinea[4] );
			empleado.setValido(true);
			break;
		}
		
	}
	bufferedReader.close();
	fileReader.close();
} catch (IOException e) { e.printStackTrace(); }
*/
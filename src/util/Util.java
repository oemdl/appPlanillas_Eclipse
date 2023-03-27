package util;

import java.awt.event.KeyEvent;
import java.util.HashMap;

import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.w3c.dom.events.Event;

public class Util {
	
	public HashMap<String,String> ESTADOS = new HashMap<String,String>() { 
		private static final long serialVersionUID = 1L;
		{
	        put( "C", "Creado" );
	        put( "V", "Verificado" );
	        put( "A", "Anulado" );
	        put( "E", "Editado" );
	    } };
	
    public HashMap<Integer,String> ROLES = new HashMap<Integer,String>() { 
		private static final long serialVersionUID = 1L;
		{
	        put( 0, "Empleado" );
	        put( 1, "Administrador" );
	        put( 2, "Jefe Área" );
	        put( 3, "Gerente" );
	    } };

	public void BloquearCtrl_V( JTextField txt ) {
		InputMap inputMap = txt.getInputMap( JComponent.WHEN_FOCUSED );
		inputMap.put( KeyStroke.getKeyStroke( KeyEvent.VK_V, Event.AT_TARGET ), "null" );
	}
	
	public void txt_LetterSpace(KeyEvent e) {
		JTextField txt = (JTextField) e.getSource();
		int longitud = txt.getText().length();
		boolean bLetter = Character.isLetter( e.getKeyChar() ); 
		boolean bSpace  = Character.isSpaceChar( e.getKeyChar() );
		
		if ( longitud == txt.getColumns() ||
			 !( bLetter || bSpace ) ||
			 ( bSpace && longitud == 0 ) ||
			 ( bSpace && longitud > 0 && txt.getText().endsWith(" ") ) )
			e.consume();
	}

}
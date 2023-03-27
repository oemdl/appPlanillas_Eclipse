package ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Insets;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.CaretListener;

import javax.swing.event.CaretEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class frmLogin extends JFrame {
	private static final long serialVersionUID = 1L;

	JTextField txtUsuario;
	JPasswordField txtPassword;
	JButton btnIniciar;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLogin frame = new frmLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 400, 300);
		getContentPane().setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JPanel pnlTitulo = new JPanel();
		pnlTitulo.setBounds(0,0,400,60);
		pnlTitulo.setBackground( new Color(90, 17, 93) );
		pnlTitulo.setLayout(null);
		getContentPane().add(pnlTitulo);
		
		JLabel imgTitulo = new JLabel();
		imgTitulo.setBounds(96,8,208,43);
		imgTitulo.setIcon(new ImageIcon(frmLogin.class.getResource("/ui/img/logo.png")));
		pnlTitulo.add(imgTitulo);
		
		JLabel imgCerrar = new JLabel();
		imgCerrar.setBounds(360,14,32,32);
		imgCerrar.setIcon(new ImageIcon(frmLogin.class.getResource("/ui/img/cerrar.png")));
		pnlTitulo.add(imgCerrar);
		
		JLabel lblUsuario = new JLabel("Usuario :");
		lblUsuario.setBounds(120, 120, 80, 30);
		getContentPane().add(lblUsuario);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(120, 160, 80, 30);
		getContentPane().add(lblPassword);

		txtUsuario = new JTextField();
		txtUsuario.setBounds(200, 120, 80, 30);
		txtUsuario.setColumns(8);
		txtUsuario.setMargin(new Insets(2, 5, 2, 5));
		getContentPane().add(txtUsuario);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(200, 160, 80, 30);
		txtPassword.setColumns(6);
		txtPassword.setMargin( new Insets(2, 5, 2, 5));
		getContentPane().add(txtPassword);

		btnIniciar = new JButton("Iniciar");		
		
		btnIniciar.setBounds(80, 220, 100, 30);
		btnIniciar.setBackground( new Color(90, 17, 93) );
		btnIniciar.setBorderPainted(false);
		btnIniciar.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		btnIniciar.setEnabled(false);
		btnIniciar.setFocusPainted(false);
		btnIniciar.setForeground( Color.white );
		getContentPane().add(btnIniciar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(220, 220, 100, 30);
		btnCancelar.setBackground( new Color(90, 17, 93) );
		btnCancelar.setBorderPainted(false);
		btnCancelar.setCursor( new Cursor( Cursor.HAND_CURSOR ) );
		btnCancelar.setFocusPainted(false);
		btnCancelar.setForeground( Color.white );
		getContentPane().add(btnCancelar);
		
		this.addWindowListener(new WindowAdapter() { public void windowOpened(WindowEvent e) { form_windowsOpened(); } });
		
		imgCerrar.addMouseListener(new MouseAdapter() { public void mouseClicked(MouseEvent e) { imgCerrar_mouseClicked(); } });
		
		txtUsuario.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) { txt_focusGained( txtUsuario ); }
			public void focusLost(FocusEvent e) { txt_focusLost( txtUsuario ); } } );
		
		txtPassword.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) { txt_focusGained( txtPassword ); }
			public void focusLost(FocusEvent e) { txt_focusLost( txtPassword );} } );
		
		btnIniciar.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) { btn_focusGained( btnIniciar ); }
			public void focusLost(FocusEvent e) { btn_focusLost( btnIniciar ); } } );

		btnCancelar.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) { btn_focusGained( btnCancelar ); }
			public void focusLost(FocusEvent e) { btn_focusLost( btnCancelar ); } } );

		btnIniciar.addMouseListener(new MouseAdapter() { 
			public void mouseEntered(MouseEvent e) { btn_focusGained( btnIniciar );	}
			public void mouseExited(MouseEvent e) { btn_focusLost( btnIniciar );  } });
				
		btnCancelar.addMouseListener(new MouseAdapter() { 
			public void mouseEntered(MouseEvent e) { btn_focusGained( btnCancelar ); }
			public void mouseExited(MouseEvent e) { btn_focusLost( btnCancelar );  } });

		txtUsuario.addKeyListener( new KeyAdapter() { public void keyTyped(KeyEvent e) { txt_keyTyped( e ); } });
		txtPassword.addKeyListener(new KeyAdapter() { public void keyTyped(KeyEvent e) { txt_keyTyped( e ); } });
		
		txtUsuario.addCaretListener(new CaretListener() { public void caretUpdate(CaretEvent e) { txt_caretUpdate(); } });
		txtPassword.addCaretListener(new CaretListener() { public void caretUpdate(CaretEvent e) { txt_caretUpdate(); } });
		
		btnIniciar.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) { btnIniciar_click(); } });
		btnCancelar.addActionListener( new ActionListener() { public void actionPerformed(ActionEvent e) { imgCerrar_mouseClicked(); } });
	}

	protected void form_windowsOpened() {
		util.Util util = new util.Util();
		
		util.BloquearCtrl_V(txtUsuario);
		util.BloquearCtrl_V(txtPassword);
	}

	protected void txt_caretUpdate() {
		btnIniciar.setEnabled( txtUsuario.getText().length() == txtUsuario.getColumns() && txtPassword.getPassword().length == txtPassword.getColumns() );		
	}

	protected void txt_keyTyped( KeyEvent e ) {
		JTextField txt = (JTextField) e.getSource();
		if ( !Character.isDigit( e.getKeyChar() ) || txt.getText().length() == txt.getColumns() )
			e.consume();
	}

	protected void txt_focusGained(JTextField txt) {
		txt.setBackground( new Color(226,244,252) );
	}

	protected void txt_focusLost(JTextField txt) {
		txt.setBackground( Color.white );
	}

	protected void btn_focusGained(JButton btn) {
		if ( btn.isEnabled() )
			btn.setBackground( Color.black );
	}

	protected void btn_focusLost(JButton btn) {
		if ( btn.isEnabled() )
			btn.setBackground( new Color(90,17,93) );
	}

	protected void imgCerrar_mouseClicked() {
		if ( JOptionPane.showConfirmDialog(this, "¿ Desea salir de la app ?", "Salir", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION )
			System.exit(0);		
	}
	
	protected void btnIniciar_click() {
		bean.Empleado empleado = new bean.Empleado();
		
		empleado.setDni( txtUsuario.getText() );
		empleado.setPassword( new String( txtPassword.getPassword() ) );
		new dao.daoEmpleado().Login( empleado );
		
		if ( empleado.isValido() ) {
			frmPlanilla frame = new frmPlanilla();
			frame.setEmpleado( empleado );
			frame.setVisible(true);
		}
		
	}
	
}
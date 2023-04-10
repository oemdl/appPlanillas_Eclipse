package ui;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.border.LineBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class frmSede extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	util.Util util = new util.Util();
	bean.Sede sede = new bean.Sede();
	dao.daoSede daoSede = new dao.daoSede();
	dao.daoDPD daoDPD = new dao.daoDPD();
	
	JPanel pnlRegistros;
	JTable tblRegistros;
	JTextField txtBuscar, txtCodigo, txtSede, txtDireccion;
	JTextField txtFechaCreacion, txtFechaEdicion;
	JLabel lblEstado, lblFechaCreacion, lblFechaEdicion;
	JButton btnAgregar, btnEditar, btnEliminar, btnGuardar, btnCancelar;
	JComboBox<String> cboDepartamento, cboProvincia, cboDistrito, cboEstado;
	ArrayList<String> aIDDepartamento, aIDProvincia, aIDDistrito;

	TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>();

	boolean bHayRegistros, bCombos;
	
	public frmSede() {
		setBounds(0, 0, 1065, 680);
		getContentPane().setLayout(null);

		JLabel lblTitulo = new JLabel("GESTIÓN SEDES");
		lblTitulo.setBounds(10, 10, 250, 30);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblTitulo.setForeground(Color.red);
		getContentPane().add(lblTitulo);
		
		pnlRegistros = new JPanel();
		pnlRegistros.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlRegistros.setBounds(0,50,250,597);
		pnlRegistros.setLayout(null);
		getContentPane().add(pnlRegistros);

		JLabel lblBuscar = new JLabel("Buscar :");
		lblBuscar.setBounds(5,40,50,30);
		pnlRegistros.add(lblBuscar);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(3,72,246,30);
		txtBuscar.setColumns(30);
		txtBuscar.setMargin( new Insets(2, 5, 2, 5) );
		pnlRegistros.add(txtBuscar);
		
		tblRegistros = new JTable();
		tblRegistros.setBorder(new LineBorder(Color.LIGHT_GRAY));
		tblRegistros.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		pnlRegistros.add(tblRegistros);

		JPanel pnlRegistro = new JPanel();
		pnlRegistro.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlRegistro.setBounds(251,50,803,597);
		pnlRegistro.setLayout(null);
		getContentPane().add(pnlRegistro);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10,10,100,30);
		btnAgregar.setBackground(Color.white);
		btnAgregar.setContentAreaFilled(false);
		btnAgregar.setFocusPainted(false);
		btnAgregar.setMargin(new Insets(2, 5, 2, 5));
		btnAgregar.setIconTextGap(5);
		btnAgregar.setIcon(new ImageIcon(frmSede.class.getResource("/ui/img/agregar.png")));
		pnlRegistro.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(120,10,100,30);
		btnEditar.setBackground(Color.white);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setFocusPainted(false);
		btnEditar.setMargin(new Insets(2, 5, 2, 5));
		btnEditar.setIconTextGap(5);
		btnEditar.setIcon(new ImageIcon(frmSede.class.getResource("/ui/img/editar.png")));
		pnlRegistro.add(btnEditar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(230,10,100,30);
		btnEliminar.setBackground(Color.white);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setFocusPainted(false);
		btnEliminar.setMargin(new Insets(2, 5, 2, 5));
		btnEliminar.setIconTextGap(5);
		btnEliminar.setIcon(new ImageIcon(frmSede.class.getResource("/ui/img/eliminar.png")));
		pnlRegistro.add(btnEliminar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10,10,100,30);
		btnGuardar.setBackground(Color.white);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setFocusPainted(false);
		btnGuardar.setMargin(new Insets(2, 5, 2, 5));
		btnGuardar.setIconTextGap(5);
		btnGuardar.setIcon(new ImageIcon(frmSede.class.getResource("/ui/img/guardar.png")));
		pnlRegistro.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(120,10,100,30);
		btnCancelar.setBackground(Color.white);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setMargin(new Insets(2, 5, 2, 5));
		btnCancelar.setIconTextGap(5);
		btnCancelar.setIcon(new ImageIcon(frmSede.class.getResource("/ui/img/cancelar.png")));
		pnlRegistro.add(btnCancelar);
		
		JLabel lblCodigo = new JLabel("Código :");
		lblCodigo.setBounds(50,100,80,25);
		pnlRegistro.add(lblCodigo);
		
		JLabel lblSede = new JLabel("Sede :");
		lblSede.setBounds(50,130,80,25);
		pnlRegistro.add(lblSede);
		
		JLabel lblDireccion = new JLabel("Dirección :");
		lblDireccion.setBounds(50,160,80,25);
		pnlRegistro.add(lblDireccion);
		
		JLabel lblDepartamento = new JLabel("Departamento :");
		lblDepartamento.setBounds(50,190,100,25);
		pnlRegistro.add(lblDepartamento);
		
		JLabel lblProvincia = new JLabel("Provincia :");
		lblProvincia.setBounds(50,220,80,25);
		pnlRegistro.add(lblProvincia);
		
		JLabel lblDistrito = new JLabel("Distrito :");
		lblDistrito.setBounds(50,250,80,25);
		pnlRegistro.add(lblDistrito);
		
		lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(50,280,80,25);
		pnlRegistro.add(lblEstado);
		
		lblFechaCreacion = new JLabel("Fecha creación :");
		lblFechaCreacion.setBounds(50,310,100,25);
		pnlRegistro.add(lblFechaCreacion);
		
		lblFechaEdicion = new JLabel("Fecha edición :");
		lblFechaEdicion.setBounds(50,340,100,25);
		pnlRegistro.add(lblFechaEdicion);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(150,100,50,25);
		txtCodigo.setFocusable(false);
		txtCodigo.setMargin( new Insets(2,5,2,5) );
		pnlRegistro.add(txtCodigo);
		
		txtSede = new JTextField();
		txtSede.setBounds(150,130,200,25);
		txtSede.setColumns(30);
		txtSede.setMargin( new Insets(2,5,2,5) );
		pnlRegistro.add(txtSede);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(150,160,250,25);
		txtDireccion.setColumns(50);
		txtDireccion.setMargin( new Insets(2,5,2,5) );
		pnlRegistro.add(txtDireccion);
		
		cboDepartamento = new JComboBox<>();
		cboDepartamento.setBounds(150,190,200,25);
		pnlRegistro.add(cboDepartamento);
		
		cboProvincia = new JComboBox<>();
		cboProvincia.setBounds(150,220,200,25);
		pnlRegistro.add(cboProvincia);
		
		cboDistrito = new JComboBox<>();
		cboDistrito.setBounds(150,250,200,25);
		pnlRegistro.add(cboDistrito);
		
		cboEstado = new JComboBox<>();
		cboEstado.setBounds(150,280,150,25);
		pnlRegistro.add(cboEstado);
		
		txtFechaCreacion = new JTextField();
		txtFechaCreacion.setBounds(150,310,150,25);
		txtFechaCreacion.setFocusable(false);
		txtFechaCreacion.setMargin( new Insets(2,5,2,5) );
		pnlRegistro.add(txtFechaCreacion);
		
		txtFechaEdicion = new JTextField();
		txtFechaEdicion.setBounds(150,340,150,25);
		txtFechaEdicion.setFocusable(false);
		txtFechaEdicion.setMargin( new Insets(2,5,2,5) );
		pnlRegistro.add(txtFechaEdicion);
		
		addComponentListener(new ComponentAdapter() {  public void componentMoved(ComponentEvent e) { form_componentMoved(); } });
		addInternalFrameListener(new InternalFrameAdapter() {  public void internalFrameOpened(InternalFrameEvent e) { form_Opened(); } });

		btnAgregar.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { btnAgregar_actionPerformed(); } });
		btnEditar.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { btnEditar_actionPerformed(); } });
		btnEliminar.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { btnEliminar_actionPerformed(); } });
		btnGuardar.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { btnGuardar_actionPerformed(); } });
		btnCancelar.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) { btnCancelar_actionPerformed(); } });
		
		txtBuscar.addKeyListener( new KeyAdapter() {  public void keyTyped(KeyEvent e) { util.txt_LetterSpace(e); } });
		txtSede.addKeyListener(new KeyAdapter() {  public void keyTyped(KeyEvent e) { util.txt_LetterSpace(e); } });
		txtDireccion.addKeyListener(new KeyAdapter() {  public void keyTyped(KeyEvent e) { util.txt_LetterSpaceNumber(e); } });
		
		txtBuscar.addFocusListener(new FocusAdapter() {  public void focusLost(FocusEvent e) { txt_focusLost( txtBuscar ); } });
		txtSede.addFocusListener(new FocusAdapter() {  public void focusLost(FocusEvent e) { txt_focusLost( txtSede ); } });
		txtDireccion.addFocusListener(new FocusAdapter() {  public void focusLost(FocusEvent e) { txt_focusLost( txtDireccion ); } });
		
		txtBuscar.addCaretListener(new CaretListener() { public void caretUpdate(CaretEvent e) { txtBuscar_caretUpdate(); } });
		
		tblRegistros.addMouseListener(new MouseAdapter() {  public void mouseClicked(MouseEvent e) { verRegistro( tblRegistros.getSelectedRow() ); } });
		tblRegistros.addKeyListener(new KeyAdapter() {  public void keyReleased(KeyEvent e) { tblRegistros_keyReleased( e.getKeyCode() ); } });
		
		cboDepartamento.addItemListener(new ItemListener() { public void itemStateChanged(ItemEvent e) { cboDepartamento_itemStateChanged(); } });
		cboProvincia.addItemListener(new ItemListener() { public void itemStateChanged(ItemEvent e) { cboProvincia_itemStateChanged(); } });

	}


	protected void form_componentMoved() {
		setBounds(0, 0, 1065, 680);		
	}

	protected void form_Opened() {
		util.BloquearCtrl_V( txtBuscar );
		util.BloquearCtrl_V( txtSede );
		util.BloquearCtrl_V( txtDireccion );
		
		getSedes();
		aIDDepartamento = daoDPD.getDepartamentos(cboDepartamento, "Seleccionar");
		bCombos = true;
		Configurar(true);
	}

	protected void tblRegistros_keyReleased(int code) {
		if ( code == KeyEvent.VK_DOWN || code == KeyEvent.VK_UP || code == KeyEvent.VK_ENTER )
			verRegistro( tblRegistros.getSelectedRow() );
	}

	protected void txtBuscar_caretUpdate() {
		tableRowSorter.setRowFilter( RowFilter.regexFilter( txtBuscar.getText().toLowerCase(), 5 ) );
		tblRegistros.setBounds(4,103,pnlRegistros.getWidth() - 7, tblRegistros.getRowCount() > 15 ? pnlRegistros.getHeight() - 5 : 30 * tblRegistros.getRowCount() );
	}

	protected void txt_focusLost(JTextField txt) {
		txt.setText( txt.getText().trim() );
	}

	protected void btnAgregar_actionPerformed() {
		//sede.setId( -1 );
		Configurar(false);
		verRegistro(-1);
	}

	protected void btnEditar_actionPerformed() {
		//sede.setId( Integer.parseInt( txtCodigo.getText() ) );
		//sede.setSede( txtSede.getText() );
		//sede.setDireccion( txtDireccion.getText() );
		Configurar(false);
	}

	protected void btnEliminar_actionPerformed() {
		Configurar(true);
	}

	protected void btnGuardar_actionPerformed() {
		boolean bExiste = false;
		String sDetalle = txtSede.getText();
		String sDireccion = txtDireccion.getText();
		
		if ( sDetalle.isEmpty() || sDireccion.isEmpty() ) {
			JOptionPane.showMessageDialog(this, "Registro en blanco, reintentar", "Mensaje",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		for (int i=0, count = tblRegistros.getRowCount(); i < count && !bExiste; i++ )
			bExiste = tblRegistros.getValueAt(i, 1).equals(sDetalle);
		
		if ( bExiste ) {
			JOptionPane.showMessageDialog(this, "Registro ya existe", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
			txtSede.requestFocus();
			return;
		}
		
		//sede.setDetalle( sDetalle );
		//sede.setDireccion( sDireccion );
		//daoSede.Guardar(sede);
		getSedes();
		
		if ( sede.isValido() ) {
			int index = -1;
			while ( !tblRegistros.getValueAt(++index, 1).equals(sDetalle) );
			tblRegistros.setRowSelectionInterval(index, index);
			verRegistro( tblRegistros.getSelectedRow() );
		}
		Configurar(true);
		JOptionPane.showMessageDialog(this, sede.isValido() ? "Registro guardado" : "Error al registrar, reeintentar...", "Guardar", JOptionPane.INFORMATION_MESSAGE);
	}

	protected void btnCancelar_actionPerformed() {
		Configurar(true);
		verRegistro( tblRegistros.getSelectedRow() );
	}

	protected void cboDepartamento_itemStateChanged() {
		if ( bCombos ) {
			bCombos = false;
			int index = cboDepartamento.getSelectedIndex();
			cboProvincia.removeAllItems();
			if ( index > 0 ) aIDProvincia = daoDPD.getProvincias(cboProvincia, "Seleccionar", aIDDepartamento.get( index ) );
			cboProvincia.setEnabled( index > 0 );
			cboDistrito.removeAllItems();
			cboDistrito.setEnabled( false );
			bCombos = true;
		}
	}

	protected void cboProvincia_itemStateChanged() {
		if ( bCombos ) {
			bCombos = false;
			int index = cboProvincia.getSelectedIndex();
			cboDistrito.removeAllItems();
			if ( index > 0 ) aIDDistrito = daoDPD.getDistritos(cboDistrito, "Seleccionar", aIDProvincia.get( index ) );
			cboDistrito.setEnabled( index > 0 );
			bCombos = true;
		}
	}
	
	private void getSedes() {
		tblRegistros.setModel( daoSede.getSedes() );
		tableRowSorter.setModel( (DefaultTableModel) tblRegistros.getModel() );
		tblRegistros.setRowSorter( tableRowSorter );
		
		if ( bHayRegistros = tblRegistros.getRowCount() > 0 ) {
			tblRegistros.setRowHeight(30);
			tblRegistros.setBounds(4,103,pnlRegistros.getWidth() - 7, tblRegistros.getRowCount() > 15 ? pnlRegistros.getHeight() - 5 : 30 * tblRegistros.getRowCount() );

			int[] columnas = {0,2};
			for( int columna : columnas ) {
				tblRegistros.getColumnModel().getColumn(columna).setMinWidth(0);
				tblRegistros.getColumnModel().getColumn(columna).setMaxWidth(0);	
			}
			
		}
	}
	
	private void verRegistro(int selectedRow) {
		boolean bLimpiar = selectedRow == -1;
		//txtCodigo.setText( bLimpiar ? "" : tblRegistros.getValueAt(selectedRow, 0).toString() );
		//txtSede.setText( bLimpiar ? "" : tblRegistros.getValueAt(selectedRow, 1).toString() );
		
		if ( !bLimpiar && frmPlanilla.empleado.getRol() > 0 ) {
			//txtEstado.setText( util.ESTADOS.get( tblRegistros.getValueAt(selectedRow, 2).toString() ) );
			//txtFechaCreacion.setText( tblRegistros.getValueAt(selectedRow, 3).toString() );	
			//txtFechaEdicion.setText( tblRegistros.getValueAt(selectedRow, 4).toString() );	
		}
	}
	
	private void Configurar(boolean bOnOff) {
		frmPlanilla.empleado.setRol(1);
		btnAgregar.setVisible(bOnOff);
		btnEditar.setVisible(bOnOff && bHayRegistros);
		btnEliminar.setVisible(bOnOff && bHayRegistros);
		btnGuardar.setVisible(!bOnOff);
		btnCancelar.setVisible(!bOnOff);
		
		txtBuscar.setFocusable(bOnOff && bHayRegistros);
		txtSede.setFocusable(!bOnOff);
		txtDireccion.setFocusable(!bOnOff);
		tblRegistros.setFocusable(bOnOff && bHayRegistros);

		cboDepartamento.setEnabled(!bOnOff);
		cboProvincia.setEnabled(!bOnOff);
		cboDistrito.setEnabled(!bOnOff);
		
		boolean bRol = bOnOff && frmPlanilla.empleado.getRol() > 0;
		cboDistrito.setEnabled( bRol );
		lblEstado.setVisible( bRol  );
		lblFechaCreacion.setVisible( bRol );
		lblFechaEdicion.setVisible( bRol );
		txtFechaCreacion.setVisible( bRol );
		txtFechaEdicion.setVisible( bRol );
		
		( bOnOff ? txtBuscar : txtSede).requestFocus();
	}

}
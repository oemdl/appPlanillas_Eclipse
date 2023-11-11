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

import javax.swing.ImageIcon;
import javax.swing.JButton;
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

public class frmCentroCosto extends JInternalFrame {
	private static final long serialVersionUID = 1L;

	util.Util util = new util.Util();
	bean.CentroCosto centroCosto = new bean.CentroCosto();
	dao.CentroCostoDAO daoCentroCosto = new dao.CentroCostoDAO();
	
	JPanel pnlRegistros;
	JTable tblRegistros;
	JTextField txtBuscar, txtCodigo, txtDetalle;
	JTextField txtEstado, txtFechaCreacion, txtFechaEdicion;
	JLabel lblEstado, lblFechaCreacion, lblFechaEdicion;
	JButton btnAgregar, btnEditar, btnEliminar, btnGuardar, btnCancelar;

	TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>();
	boolean bHayRegistros;
	
	public frmCentroCosto() {
		setBounds(0, 0, 1065, 680);
		getContentPane().setLayout(null);
		
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
		btnAgregar.setIcon(new ImageIcon(frmCentroCosto.class.getResource("/ui/img/agregar.png")));
		pnlRegistro.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(120,10,100,30);
		btnEditar.setBackground(Color.white);
		btnEditar.setContentAreaFilled(false);
		btnEditar.setFocusPainted(false);
		btnEditar.setMargin(new Insets(2, 5, 2, 5));
		btnEditar.setIconTextGap(5);
		btnEditar.setIcon(new ImageIcon(frmCentroCosto.class.getResource("/ui/img/editar.png")));
		pnlRegistro.add(btnEditar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(230,10,100,30);
		btnEliminar.setBackground(Color.white);
		btnEliminar.setContentAreaFilled(false);
		btnEliminar.setFocusPainted(false);
		btnEliminar.setMargin(new Insets(2, 5, 2, 5));
		btnEliminar.setIconTextGap(5);
		btnEliminar.setIcon(new ImageIcon(frmCentroCosto.class.getResource("/ui/img/eliminar.png")));
		pnlRegistro.add(btnEliminar);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(10,10,100,30);
		btnGuardar.setBackground(Color.white);
		btnGuardar.setContentAreaFilled(false);
		btnGuardar.setFocusPainted(false);
		btnGuardar.setMargin(new Insets(2, 5, 2, 5));
		btnGuardar.setIconTextGap(5);
		btnGuardar.setIcon(new ImageIcon(frmCentroCosto.class.getResource("/ui/img/guardar.png")));
		pnlRegistro.add(btnGuardar);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(120,10,100,30);
		btnCancelar.setBackground(Color.white);
		btnCancelar.setContentAreaFilled(false);
		btnCancelar.setFocusPainted(false);
		btnCancelar.setMargin(new Insets(2, 5, 2, 5));
		btnCancelar.setIconTextGap(5);
		btnCancelar.setIcon(new ImageIcon(frmCentroCosto.class.getResource("/ui/img/cancelar.png")));
		pnlRegistro.add(btnCancelar);
		
		JLabel lblCodigo = new JLabel("Código :");
		lblCodigo.setBounds(50,150,80,25);
		pnlRegistro.add(lblCodigo);
		
		JLabel lblDetalle = new JLabel("Detalle :");
		lblDetalle.setBounds(50,180,80,25);
		pnlRegistro.add(lblDetalle);
		
		lblEstado = new JLabel("Estado :");
		lblEstado.setBounds(50,210,80,25);
		pnlRegistro.add(lblEstado);
		
		lblFechaCreacion = new JLabel("Fecha creación :");
		lblFechaCreacion.setBounds(50,240,100,25);
		pnlRegistro.add(lblFechaCreacion);
		
		lblFechaEdicion = new JLabel("Fecha edición :");
		lblFechaEdicion.setBounds(50,270,100,25);
		pnlRegistro.add(lblFechaEdicion);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(150,150,50,25);
		txtCodigo.setFocusable(false);
		txtCodigo.setMargin( new Insets(2,5,2,5) );
		pnlRegistro.add(txtCodigo);
		
		txtDetalle = new JTextField();
		txtDetalle.setBounds(150,180,250,25);
		txtDetalle.setColumns(30);
		txtDetalle.setMargin( new Insets(2,5,2,5) );
		pnlRegistro.add(txtDetalle);

		txtEstado = new JTextField();
		txtEstado.setBounds(150,210,150,25);
		txtEstado.setFocusable(false);
		txtEstado.setMargin( new Insets(2,5,2,5) );
		pnlRegistro.add(txtEstado);
		
		txtFechaCreacion = new JTextField();
		txtFechaCreacion.setBounds(150,240,150,25);
		txtFechaCreacion.setFocusable(false);
		txtFechaCreacion.setMargin( new Insets(2,5,2,5) );
		pnlRegistro.add(txtFechaCreacion);
		
		txtFechaEdicion = new JTextField();
		txtFechaEdicion.setBounds(150,270,150,25);
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
		txtDetalle.addKeyListener(new KeyAdapter() {  public void keyTyped(KeyEvent e) { util.txt_LetterSpace(e); } });
		txtBuscar.addFocusListener(new FocusAdapter() {  public void focusLost(FocusEvent e) { txt_focusLost( txtBuscar ); } });
		txtDetalle.addFocusListener(new FocusAdapter() {  public void focusLost(FocusEvent e) { txt_focusLost( txtDetalle ); } });
		txtBuscar.addCaretListener(new CaretListener() { public void caretUpdate(CaretEvent e) { txtBuscar_caretUpdate(); } });
		
		tblRegistros.addMouseListener(new MouseAdapter() {  public void mouseClicked(MouseEvent e) { verRegistro( tblRegistros.getSelectedRow() ); } });
		tblRegistros.addKeyListener(new KeyAdapter() {  public void keyReleased(KeyEvent e) { tblRegistros_keyReleased( e.getKeyCode() ); } });
	}

	protected void form_componentMoved() {
		setBounds(0, 0, 1065, 680);		
	}

	protected void form_Opened() {
		util.BloquearCtrl_V( txtBuscar );
		util.BloquearCtrl_V( txtDetalle );
		
		getCentroCostos();
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
		centroCosto.setId( -1 );
		Configurar(false);
		verRegistro(-1);
	}

	protected void btnEditar_actionPerformed() {
		centroCosto.setId( Integer.parseInt( txtCodigo.getText() ) );
		centroCosto.setDetalle( txtDetalle.getText() );
		Configurar(false);
	}

	protected void btnEliminar_actionPerformed() {
		Configurar(true);
	}

	protected void btnGuardar_actionPerformed() {
		boolean bExiste = false;
		String sDetalle = txtDetalle.getText();
		
		if ( sDetalle.isEmpty() ) {
			JOptionPane.showMessageDialog(this, "Registro en blanco, reintentar", "Mensaje",JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		for (int i=0, count = tblRegistros.getRowCount(); i < count && !bExiste; i++ )
			bExiste = tblRegistros.getValueAt(i, 1).equals(sDetalle);
		
		if ( bExiste ) {
			JOptionPane.showMessageDialog(this, "Registro ya existe", "Mensaje",JOptionPane.INFORMATION_MESSAGE);
			txtDetalle.requestFocus();
			return;
		}
		
		centroCosto.setDetalle( sDetalle );
		daoCentroCosto.Guardar(centroCosto);
		getCentroCostos();
		
		if ( centroCosto.isValido() ) {
			int index = -1;
			while ( !tblRegistros.getValueAt(++index, 1).equals(sDetalle) );
			tblRegistros.setRowSelectionInterval(index, index);
			verRegistro( tblRegistros.getSelectedRow() );
		}
		Configurar(true);
		JOptionPane.showMessageDialog(this, centroCosto.isValido() ? "Registro guardado" : "Error al registrar, reeintentar...", "Guardar", JOptionPane.INFORMATION_MESSAGE);
	}

	protected void btnCancelar_actionPerformed() {
		Configurar(true);
		verRegistro( tblRegistros.getSelectedRow() );
	}

	private void getCentroCostos() {
		tblRegistros.setModel( daoCentroCosto.getCentroCostos() );
		tableRowSorter.setModel( (DefaultTableModel) tblRegistros.getModel() );
		tblRegistros.setRowSorter( tableRowSorter );
		
		if ( bHayRegistros = tblRegistros.getRowCount() > 0 ) {
			tblRegistros.setRowHeight(30);
			tblRegistros.setBounds(4,103,pnlRegistros.getWidth() - 7, tblRegistros.getRowCount() > 15 ? pnlRegistros.getHeight() - 5 : 30 * tblRegistros.getRowCount() );

			int[] columnas = {0,2,3,4,5};
			for( int columna : columnas ) {
				tblRegistros.getColumnModel().getColumn(columna).setMinWidth(0);
				tblRegistros.getColumnModel().getColumn(columna).setMaxWidth(0);	
			}
			
		}
	}
	
	private void verRegistro(int selectedRow) {
		boolean bLimpiar = selectedRow == -1;
		txtCodigo.setText( bLimpiar ? "" : tblRegistros.getValueAt(selectedRow, 0).toString() );
		txtDetalle.setText( bLimpiar ? "" : tblRegistros.getValueAt(selectedRow, 1).toString() );
		
		if ( !bLimpiar && frmPlanilla.empleado.getRol() > 0 ) {
			txtEstado.setText( util.ESTADOS.get( tblRegistros.getValueAt(selectedRow, 2).toString() ) );
			txtFechaCreacion.setText( tblRegistros.getValueAt(selectedRow, 3).toString() );	
			txtFechaEdicion.setText( tblRegistros.getValueAt(selectedRow, 4).toString() );	
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
		txtDetalle.setFocusable(!bOnOff);
		tblRegistros.setFocusable(bOnOff && bHayRegistros);

		boolean bRol = bOnOff && frmPlanilla.empleado.getRol() > 0;
		lblEstado.setVisible( bRol  );
		lblFechaCreacion.setVisible( bRol );
		lblFechaEdicion.setVisible( bRol );
		txtEstado.setVisible( bRol  );
		txtFechaCreacion.setVisible( bRol );
		txtFechaEdicion.setVisible( bRol );
		
		( bOnOff ? txtBuscar : txtDetalle).requestFocus();
	}

}
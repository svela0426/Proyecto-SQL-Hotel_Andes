package uniandes.isis2304.hotelandes.interfazApp;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uniandes.isis2304.hotelandes.negocio.Usuario;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JComboBox;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class DialogReqDos extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombreTextField;
	private JTextField apellidoTextField;
	private JTextField correoTextField;
	private JTextField nDocumentoTextField;
	private JLabel lblError;
	
	private JComboBox rolComboBox;
	
	private interfazHotelandesApp interfaz;
	private String resultado;

	/**
	 * Create the dialog.
	 */
	public DialogReqDos(interfazHotelandesApp interfazHA) {
		
		super(interfazHA, true);
        
        this.setSize(500,500); // This property is used to set the size of dialog box.
        this.setLocation(800,40);
        this.interfaz = interfazHA;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNombre = new JLabel("Nombre");
			GridBagConstraints gbc_lblNombre = new GridBagConstraints();
			gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
			gbc_lblNombre.gridx = 0;
			gbc_lblNombre.gridy = 0;
			contentPanel.add(lblNombre, gbc_lblNombre);
		}
		{
			JLabel lblApellido = new JLabel("Apellido");
			GridBagConstraints gbc_lblApellido = new GridBagConstraints();
			gbc_lblApellido.insets = new Insets(0, 0, 5, 5);
			gbc_lblApellido.gridx = 1;
			gbc_lblApellido.gridy = 0;
			contentPanel.add(lblApellido, gbc_lblApellido);
		}
		{
			JLabel lblRol = new JLabel("Rol");
			GridBagConstraints gbc_lblRol = new GridBagConstraints();
			gbc_lblRol.insets = new Insets(0, 0, 5, 0);
			gbc_lblRol.gridx = 2;
			gbc_lblRol.gridy = 0;
			contentPanel.add(lblRol, gbc_lblRol);
		}
		{
			nombreTextField = new JTextField();
			GridBagConstraints gbc_nombreTextField = new GridBagConstraints();
			gbc_nombreTextField.insets = new Insets(0, 0, 5, 5);
			gbc_nombreTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_nombreTextField.gridx = 0;
			gbc_nombreTextField.gridy = 1;
			contentPanel.add(nombreTextField, gbc_nombreTextField);
			nombreTextField.setColumns(10);
		}
		{
			apellidoTextField = new JTextField();
			GridBagConstraints gbc_apellidoTextField = new GridBagConstraints();
			gbc_apellidoTextField.insets = new Insets(0, 0, 5, 5);
			gbc_apellidoTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_apellidoTextField.gridx = 1;
			gbc_apellidoTextField.gridy = 1;
			contentPanel.add(apellidoTextField, gbc_apellidoTextField);
			apellidoTextField.setColumns(10);
		}
		{
			rolComboBox = new JComboBox();
			GridBagConstraints gbc_rolComboBox = new GridBagConstraints();
			gbc_rolComboBox.insets = new Insets(0, 0, 5, 0);
			gbc_rolComboBox.fill = GridBagConstraints.HORIZONTAL;
			gbc_rolComboBox.gridx = 2;
			gbc_rolComboBox.gridy = 1;
			contentPanel.add(rolComboBox, gbc_rolComboBox);
			
			rolComboBox.addItem("");
			rolComboBox.addItem("Cliente");
			rolComboBox.addItem("Recepcionista");
			rolComboBox.addItem("Empleado");
			rolComboBox.addItem("Admin. Datos");
			rolComboBox.addItem("Organizador de eventos");
			rolComboBox.addItem("Gerente");
			
		}
		{
			JLabel lblCorreo = new JLabel("Correo");
			GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
			gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
			gbc_lblCorreo.gridx = 0;
			gbc_lblCorreo.gridy = 2;
			contentPanel.add(lblCorreo, gbc_lblCorreo);
		}
		{
			JLabel lblDocumento = new JLabel("Numero de documento");
			GridBagConstraints gbc_lblDocumento = new GridBagConstraints();
			gbc_lblDocumento.insets = new Insets(0, 0, 5, 5);
			gbc_lblDocumento.gridx = 1;
			gbc_lblDocumento.gridy = 2;
			contentPanel.add(lblDocumento, gbc_lblDocumento);
		}
		{
			correoTextField = new JTextField();
			GridBagConstraints gbc_correoTextField = new GridBagConstraints();
			gbc_correoTextField.insets = new Insets(0, 0, 0, 5);
			gbc_correoTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_correoTextField.gridx = 0;
			gbc_correoTextField.gridy = 3;
			contentPanel.add(correoTextField, gbc_correoTextField);
			correoTextField.setColumns(10);
		}
		{
			nDocumentoTextField = new JTextField();
			GridBagConstraints gbc_nDocumentoTextField = new GridBagConstraints();
			gbc_nDocumentoTextField.insets = new Insets(0, 0, 0, 5);
			gbc_nDocumentoTextField.fill = GridBagConstraints.HORIZONTAL;
			gbc_nDocumentoTextField.gridx = 1;
			gbc_nDocumentoTextField.gridy = 3;
			contentPanel.add(nDocumentoTextField, gbc_nDocumentoTextField);
			nDocumentoTextField.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				lblError = new JLabel(" ");
				buttonPane.add(lblError);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				okButton.addActionListener(this);
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(this);
				buttonPane.add(cancelButton);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()) {
			case "OK":
				Usuario u = interfaz.getHotelAndes().adicionarUsuario(new BigDecimal(Long.parseLong(nDocumentoTextField.getText())), nombreTextField.getText(), apellidoTextField.getText(), correoTextField.getText());
				resultado += "Creando usuario \n\n";
				if (u == null){
					resultado+="Error en la adición del usuario";
					setVisible(false);
				}
				switch((String) rolComboBox.getSelectedItem()){
					case "":
						lblError.setText("Debe seleccionar un rol para el usuario");
					case "Cliente":
						resultado += "Creando Cliente\n\n";
						String idHotel = JOptionPane.showInputDialog (this, "Id del hotel al que pertenece el cliente?", "Id de hotel", JOptionPane.QUESTION_MESSAGE);
						interfaz.getHotelAndes().adicionarRolUsuario(u.getIdUsuario(), "Cliente");
						interfaz.getHotelAndes().adicionarCliente(new BigDecimal(0), new BigDecimal(Long.parseLong(idHotel)), null);
						resultado += "Cliente creado\n\n";
						setVisible(false);
					case "Recepcionista":
						resultado += "Creando Recepcionista\n\n";
						interfaz.getHotelAndes().adicionarRolUsuario(u.getIdUsuario(), "Recepcionista");
						setVisible(false);
						resultado += "Recepcionista creado\n\n";
					case "Empleado":
						resultado += "Creando Empleado\n\n";
						interfaz.getHotelAndes().adicionarRolUsuario(u.getIdUsuario(), "Empleado");
						resultado += "Empleado creado\n\n";
						setVisible(false);
					case "Admin. Datos":
						resultado += "Creando Administrador de datos\n\n";
						interfaz.getHotelAndes().adicionarRolUsuario(u.getIdUsuario(), "Administrador Datos");
						resultado += "Administrador de Datos creado\n\n";
						setVisible(false);
					case "Gerente":
						resultado += "Creando Gerente\n\n";
						interfaz.getHotelAndes().adicionarRolUsuario(u.getIdUsuario(), "Gerente");
						resultado += "Gerente creado\n\n";
						setVisible(false);
					case "Organizador de eventos":
						resultado += "Creando Organizador de eventos\n\n";
						interfaz.getHotelAndes().adicionarRolUsuario(u.getIdUsuario(), "Organizador Eventos");
						resultado += "Organizador de eventos creado\n\n";
						setVisible(false);		
				}
			case "Cancel":
				resultado += "Operacion cancelada por el usuario\n\n";
				setVisible(false);
		}
		
	}

	public String getResultado() {
		return resultado;
	}

}
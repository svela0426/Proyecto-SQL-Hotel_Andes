package uniandes.isis2304.hotelandes.interfazApp;

import java.util.List;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import uniandes.isis2304.hotelandes.negocio.Cliente;
import uniandes.isis2304.hotelandes.negocio.Cuenta;
import uniandes.isis2304.hotelandes.negocio.Habitacion;
import uniandes.isis2304.hotelandes.negocio.PlanDePagoAcordado;
import uniandes.isis2304.hotelandes.negocio.Reserva;
import uniandes.isis2304.hotelandes.negocio.Servicio;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class DialogReqDoce extends JDialog implements ActionListener{
    //private List<Servicio> servicios;
    //private List<Cliente> clientes;
    private interfazHotelandesApp interfaz;

    private List<String> clientesSelect;
    private List<String> serviciosSelect;
    private JTextField tipoHabitacion;
    private JTextField fechaInicio;
    private JTextField fechaFin;
    private String resultado;

    public DialogReqDoce(interfazHotelandesApp interfazHA, 
                        List<Servicio> servicios,
                        List<Cliente> clientes){
        super(interfazHA, true);
        
        this.setSize(500,500); // This property is used to set the size of dialog box.
        this.setLocation(800,40);
        
        //this.servicios = servicios;
        //this.clientes = clientes;
        this.interfaz = interfazHA;
        //this.tipoHabitacion = tipoHabitacion;
        //this.fechaInicio = fechaInicio;
        //this.fechaFin = fechaFin;
        
        JLabel lbServicios = new JLabel("Servicios");

		//Agregar elementos a Jlist
		JLabel lbClientes = new JLabel("Clientes");

		//Labels y textfields para los parametros restantes
		JLabel lbTipoHabitacion = new JLabel("Tipo de habitacion");
		tipoHabitacion = new JTextField();
		JLabel lbFechaInicio = new JLabel("Fecha de inicio");
		fechaInicio = new JTextField();
		JLabel lbFechaFin = new JLabel("Fecha de fin");
		fechaFin= new JTextField();

		JButton okButton = new JButton("Confirmar");
		//Adicion de los componentes al Jdialog


        tipoHabitacion.addActionListener(this);
        fechaInicio.addActionListener(this);
        fechaFin.addActionListener(this);
        okButton.addActionListener(this);

        tipoHabitacion.setActionCommand("tHabitacion");
        fechaInicio.setActionCommand("fechaI");
        fechaFin.setActionCommand("fechaF");
        okButton.setActionCommand("confirmar");

        
        String[] selements;
        selements = new String[servicios.size()]; //Arreglo de servicios para JList
        for(int i = 0; i<servicios.size(); i++){
            selements[i] = servicios.get(i).getNombre();
        }
			
		JList listaServicios = new JList(selements);
        //Listener para los elementos seleccionados
        listaServicios.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e){
                List<String> sSelect  = listaServicios.getSelectedValuesList();
                for (int i = 0; i<sSelect.size(); i++){
                    serviciosSelect.add(sSelect.get(i));
                }
                
            }
        });

        String[] celements;
        celements = new String[clientes.size()]; //Arreglo de clientes para JList
        for(int j = 0; j<clientes.size(); j++){
            celements[j] = Long.toString(clientes.get(j).getid().longValue());
        }
        
        JList listaClientes = new JList(celements);
        
        //Listener para los elementos seleccionados
        listaClientes.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e){
                List<String> cSelect  = listaClientes.getSelectedValuesList();
                for (int i = 0; i<cSelect.size(); i++){
                    clientesSelect.add(cSelect.get(i));
                }
                
            }
        });
        
        listaServicios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listaClientes.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
        
        //Adds al JDialog
        
        getContentPane().add(okButton, BorderLayout.SOUTH);
        
        JPanel panelServicios = new JPanel();
        panelServicios.setBorder(new EmptyBorder(5, 5, 5, 0));
        getContentPane().add(panelServicios, BorderLayout.WEST);
        panelServicios.setLayout(new BoxLayout(panelServicios, BoxLayout.Y_AXIS));
        panelServicios.add(lbServicios);
        panelServicios.add(listaServicios);
        
        JPanel panelClientes = new JPanel();
        panelClientes.setBorder(new EmptyBorder(5, 0, 5, 5));
        getContentPane().add(panelClientes, BorderLayout.EAST);
        panelClientes.setLayout(new BoxLayout(panelClientes, BoxLayout.Y_AXIS));
        panelClientes.add(lbClientes);
        panelClientes.add(listaClientes);
        
        
        //Añadir opciones generales
        
        JPanel panelOpciones = new JPanel();
        panelOpciones.setBorder(new EmptyBorder(10, 10, 10, 10));
        getContentPane().add(panelOpciones, BorderLayout.CENTER);
        GridBagLayout gbl_panelOpciones = new GridBagLayout();
        gbl_panelOpciones.columnWidths = new int[] {132, 107};
        gbl_panelOpciones.rowHeights = new int[]{0, 0, 21};
        gbl_panelOpciones.columnWeights = new double[]{1.0, 1.0};
        gbl_panelOpciones.rowWeights = new double[]{0.0, 0.0, 0.0};
        panelOpciones.setLayout(gbl_panelOpciones);
        
        //TipoHabitacion
        GridBagConstraints gbc_lbTipoHabitacion = new GridBagConstraints();
        gbc_lbTipoHabitacion.insets = new Insets(0, 10, 0, 10);
        gbc_lbTipoHabitacion.gridx = 0;
        gbc_lbTipoHabitacion.gridy = 0;
        panelOpciones.add(lbTipoHabitacion, gbc_lbTipoHabitacion);
        
        GridBagConstraints gbc_tipoHabitacion = new GridBagConstraints();
        gbc_tipoHabitacion.fill = GridBagConstraints.HORIZONTAL;
        gbc_tipoHabitacion.insets = new Insets(0, 10, 0, 10);
        gbc_tipoHabitacion.gridx = 0;
        gbc_tipoHabitacion.gridy = 1;
        panelOpciones.add(tipoHabitacion, gbc_tipoHabitacion);
        
        GridBagConstraints gbc_lbFechaInicio = new GridBagConstraints();
        gbc_lbFechaInicio.fill = GridBagConstraints.HORIZONTAL;
        gbc_lbFechaInicio.insets = new Insets(0, 10, 0, 10);
        gbc_lbFechaInicio.gridx = 1;
        gbc_lbFechaInicio.gridy = 0;
        panelOpciones.add(lbFechaInicio, gbc_lbFechaInicio);
        
        GridBagConstraints gbc_fechaInicio = new GridBagConstraints();
        gbc_fechaInicio.fill = GridBagConstraints.HORIZONTAL;
        gbc_fechaInicio.insets = new Insets(0, 10, 0, 10);
        gbc_fechaInicio.gridx = 1;
        gbc_fechaInicio.gridy = 1;
        panelOpciones.add(fechaInicio, gbc_fechaInicio);
        
        GridBagConstraints gbc_lbFechaFin = new GridBagConstraints();
        gbc_lbFechaFin.fill = GridBagConstraints.HORIZONTAL;
        gbc_lbFechaFin.insets = new Insets(0, 10, 0, 10);
        gbc_lbFechaFin.gridx = 1;
        gbc_lbFechaFin.gridy = 2;
        panelOpciones.add(lbFechaFin, gbc_lbFechaFin);
        
        GridBagConstraints gbc_fechaFin = new GridBagConstraints();
        gbc_fechaFin.fill = GridBagConstraints.HORIZONTAL;
        gbc_fechaFin.insets = new Insets(0, 10, 0, 10);
        gbc_fechaFin.gridx = 1;
        gbc_fechaFin.gridy = 3;
        panelOpciones.add(fechaFin, gbc_fechaFin);
        
        
        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        
    }

    public String getResultado(){
        return resultado;
    }


    @Override
	public void actionPerformed(ActionEvent e) {
        
        if (e.getActionCommand() == "confirmar"){

            resultado = "En buscar Tipo Bebida por nombre\n\n";

            String tipohabitacionT = tipoHabitacion.getText();
            String fechaInicio = this.fechaInicio.getText();
            String fechaFin = this.fechaFin.getText();

            String[] fechaInicioS = fechaInicio.split("-");
            String[] fechaFinS = fechaFin.split("-");
            
            Timestamp fechaInicioT = new Timestamp(Integer.parseInt(fechaInicioS[2]), Integer.parseInt(fechaInicioS[1]), Integer.parseInt(fechaInicioS[0]), 0, 0, 0, 0);
            Timestamp fechaFinT = new Timestamp(Integer.parseInt(fechaFinS[2]), Integer.parseInt(fechaFinS[1]), Integer.parseInt(fechaFinS[0]), 0, 0, 0, 0);

            PlanDePagoAcordado planPago = interfaz.getHotelAndes().adicionarPlanDePagoAcordado(tipohabitacionT, clientesSelect.size(), clientesSelect.size(), fechaInicioT, fechaFinT, "Activo");
            BigDecimal idPlanPago = new BigDecimal(planPago.getId());
            for(int i = 0; i<clientesSelect.size();i++){
                BigDecimal idCliente = new BigDecimal(Long.parseLong(clientesSelect.get(i)));
                
                List<Habitacion> habitaciones = interfaz.getHotelAndes().darHabitacionPorTipo(tipohabitacionT);
                List<Habitacion> habitacionesNoReservadas = interfaz.getHotelAndes().darHabitacionesNoReservadas();
                for(int u = 0; u<habitacionesNoReservadas.size(); u++){
                    Habitacion habitacion = habitacionesNoReservadas.get(u);
                    if (habitaciones.contains(habitacion)){
                        BigDecimal idHabitacion = habitacion.getIdHabitacion();
                        Reserva reservaH = interfaz.getHotelAndes().adicionarReserva(fechaInicioT, fechaFinT, new BigDecimal(1), idCliente, idPlanPago, "Activo");
                        BigDecimal idReserva = reservaH.getIdReserva();
                        Cuenta cuentaH = interfaz.getHotelAndes().adicionarCuenta(new BigDecimal(0));
                        BigDecimal idCuenta = cuentaH.getIdCuenta();
                        interfaz.getHotelAndes().adicionarHabitacionReservada(idHabitacion, idReserva, idCuenta);
                        
                    }
                }
            }


            for(int j = 0; j<serviciosSelect.size();j++){
                String nombreServicio = serviciosSelect.get(j);
                List<Servicio> servicio = interfaz.getHotelAndes().darServicioPorNombre(nombreServicio);

                for(int k = 0; k<servicio.size();k++){
                    Servicio servicioAguardar = servicio.get(k);
                    BigDecimal idServicio = servicioAguardar.getIdServicio();
                    BigDecimal costo = servicioAguardar.getCosto();
                    interfaz.getHotelAndes().adicionarServicio_Solicitado(idServicio, new BigDecimal (clientesSelect.size()), costo, fechaInicioT);
                }
            }
        }
    }
}

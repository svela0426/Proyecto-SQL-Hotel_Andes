package uniandes.isis2304.hotelandes.interfazApp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.List;

import javax.jdo.JDODataStoreException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import org.apache.log4j.Logger;

import oracle.net.aso.j;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonReader;

import uniandes.isis2304.hotelandes.negocio.Cliente;
import uniandes.isis2304.hotelandes.negocio.ClienteActivo;
import uniandes.isis2304.hotelandes.negocio.Consulta10;
import uniandes.isis2304.hotelandes.negocio.Consulta12;
import uniandes.isis2304.hotelandes.negocio.Consulta7;
import uniandes.isis2304.hotelandes.negocio.Consulta8;
import uniandes.isis2304.hotelandes.negocio.Consulta9;
import uniandes.isis2304.hotelandes.negocio.Habitacion;
import uniandes.isis2304.hotelandes.negocio.HabitacionReservada;
import uniandes.isis2304.hotelandes.negocio.Hotel;
import uniandes.isis2304.hotelandes.negocio.Hotelandes;
import uniandes.isis2304.hotelandes.negocio.Reserva;
import uniandes.isis2304.hotelandes.negocio.Servicio;
import uniandes.isis2304.hotelandes.negocio.Usuario;
import uniandes.isis2304.hotelandes.negocio.VOMetododePago;
import uniandes.isis2304.hotelandes.negocio.VOServicio;




@SuppressWarnings("serial")

public class interfazHotelandesApp extends JFrame implements ActionListener {
	
	
	private static Logger log = Logger.getLogger(interfazHotelandesApp.class.getName());
	
	
	private static final String CONFIG_INTERFAZ = "./src/main/resources/config/interfaceConfigApp.json"; 
	
	private static final String CONFIG_TABLAS = "./src/main/resources/config/TablasBD_A.json"; 

	
	/**
	 * Ruta al archivo de configuración de los nombres de tablas de la base de datos
	 */

    private JsonObject tableConfig;
    
    /**
     * Asociación a la clase principal del negocio.
     */
    private Hotelandes hotelandes;
    
    /* ****************************************************************
	 * 			Atributos de interfaz
	 *****************************************************************/
    
    
    private JsonObject guiConfig;

    
    private PanelDatos panelDatos;
    
    private JMenuBar menuBar;
    
    
    /* ****************************************************************
	 * 			Métodos
	 *****************************************************************/
    
    
    public interfazHotelandesApp( )
    {
    	
    	
        guiConfig = openConfig ("Interfaz", CONFIG_INTERFAZ);
        
        
        configurarFrame ( );
        if (guiConfig != null) 	   
        {
     	   crearMenu( guiConfig.getAsJsonArray("menuBar") );
        }
        
        tableConfig = openConfig ("Tablas BD", CONFIG_TABLAS);
        hotelandes = new Hotelandes (tableConfig);
        
    	String path = guiConfig.get("bannerPath").getAsString();
        panelDatos = new PanelDatos ( );

        setLayout (new BorderLayout());
        add (new JLabel (new ImageIcon (path)), BorderLayout.NORTH );          
        add( panelDatos, BorderLayout.CENTER );
        
        
        
 	
    }
    
    
    
    
    /* ****************************************************************
	 * 			Métodos de configuración de la interfaz
	 *****************************************************************/
    
    
    private JsonObject openConfig (String tipo, String archConfig)
    {
    	JsonObject config = null;
		try 
		{
			Gson gson = new Gson( );
			FileReader file = new FileReader (archConfig);
			JsonReader reader = new JsonReader ( file );
			config = gson.fromJson(reader, JsonObject.class);
			log.info ("Se encontró un archivo de configuración válido: " + tipo);
		} 
		catch (Exception e)
		{
//			e.printStackTrace ();
			log.info ("NO se encontró un archivo de configuración válido");			
			JOptionPane.showMessageDialog(null, "No se encontró un archivo de configuración de interfaz válido: " + tipo, "Parranderos App", JOptionPane.ERROR_MESSAGE);
		}	
        return config;
    }
    
    
    
    private void configurarFrame(  )
    {
    	int alto = 0;
    	int ancho = 0;
    	String titulo = "";	
    	
    	if ( guiConfig == null )
    	{
    		log.info ( "Se aplica configuración por defecto" );			
			titulo = "Hotel Andes APP Default";
			alto = 300;
			ancho = 500;
    	}
    	else
    	{
			log.info ( "Se aplica configuración indicada en el archivo de configuración" );
    		titulo = guiConfig.get("title").getAsString();
			alto= guiConfig.get("frameH").getAsInt();
			ancho = guiConfig.get("frameW").getAsInt();
    	}
    	
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        setLocation (50,50);
        setResizable( true );
        setBackground( Color.WHITE );

        setTitle( titulo );
		setSize ( ancho, alto);        
    }
    
    
    private void crearMenu(  JsonArray jsonMenu )
    {    	
    	// Creación de la barra de menús
        menuBar = new JMenuBar();       
        for (JsonElement men : jsonMenu)
        {
        	// Creación de cada uno de los menús
        	JsonObject jom = men.getAsJsonObject(); 

        	String menuTitle = jom.get("menuTitle").getAsString();        	
        	JsonArray opciones = jom.getAsJsonArray("options");
        	
        	JMenu menu = new JMenu( menuTitle);
        	
        	for (JsonElement op : opciones)
        	{       	
        		// Creación de cada una de las opciones del menú
        		JsonObject jo = op.getAsJsonObject(); 
        		String lb =   jo.get("label").getAsString();
        		String event = jo.get("event").getAsString();
        		
        		JMenuItem mItem = new JMenuItem( lb );
        		mItem.addActionListener( this );
        		mItem.setActionCommand(event);
        		
        		menu.add(mItem);
        	}       
        	menuBar.add( menu );
        }        
        setJMenuBar ( menuBar );	
    }

	/******************************************************************************************
	* REQ DE CONSULTA
	******************************************************************************************/

	//REQ 1

	public void consulta1(){
		String fechaInicio = JOptionPane.showInputDialog (this, "Fecha de inicio?", "MOSTRAR EL DINERO RECOLECTADO POR SERVICIOS EN CADA HABITACIÓN", JOptionPane.QUESTION_MESSAGE);
		String fechaFin = JOptionPane.showInputDialog (this, "Fecha de fin?", "MOSTRAR EL DINERO RECOLECTADO POR SERVICIOS EN CADA HABITACIÓN", JOptionPane.QUESTION_MESSAGE);
		if (fechaInicio != null && fechaFin != null){
			List<String> c1 = hotelandes.consulta1(fechaInicio, fechaFin);
			String resultado = "";
			if (c1 != null)
    		{
				for (int i = 0; i < c1.size(); i++) {
					resultado += c1.get(i) + "\n";
				}
				panelDatos.actualizarInterfaz(resultado);
			}
			else{
				panelDatos.actualizarInterfaz("No fue posible hacer la consulta");
			}
		}
		else{
			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
		}
		

	}

	//REQ 7

	public void consulta7(){
		List<Consulta7> c7 = hotelandes.consulta7();
		String resultado = "";
		if (c7 != null)
		{

			for (int i = 0; i < c7.size(); i++) {
				resultado += c7.get(i).toString() + "\n";
			}
			panelDatos.actualizarInterfaz(resultado);
		}
		else{
			panelDatos.actualizarInterfaz("No fue posible hacer la consulta");
		}

		if(c7.size() ==0){
			panelDatos.actualizarInterfaz("No se encontraron elementos");
		}
	}

	//REQ 8

	public void consulta8(){
		List<Consulta8> c8 = hotelandes.consulta8();
		String resultado = "";
		if (c8 != null)
		{
			
			for (int i = 0; i < c8.size(); i++) {
				resultado += c8.get(i).toString() + "\n";
			}
			panelDatos.actualizarInterfaz(resultado);
		}
		else{
			panelDatos.actualizarInterfaz("No fue posible hacer la consulta");
		}
		if(c8.size() ==0){
			panelDatos.actualizarInterfaz("No se encontraron elementos");
		}
	}

	//REQ 9

	public void consulta9(){
		List<Consulta9> c9 = hotelandes.consulta9();
		String resultado = "";
		if (c9 != null)
		{
			
			for (int i = 0; i < c9.size(); i++) {
				resultado += c9.get(i).toString() + "\n";
			}
			panelDatos.actualizarInterfaz(resultado);
		}
		else if(c9.size() ==0){
			panelDatos.actualizarInterfaz("No se encontraron elementos");
		}
		else{
			panelDatos.actualizarInterfaz("No fue posible hacer la consulta");
		}
	}

	//REQ 10

	public void consulta10(){
		List<Consulta10> c10 = hotelandes.consulta10();
		String resultado = "";
		if (c10 != null)
		{
			
			for (int i = 0; i < c10.size(); i++) {
				resultado += c10.get(i).toString() + "\n";
			}
			panelDatos.actualizarInterfaz(resultado);
		}
		else{
			panelDatos.actualizarInterfaz("No fue posible hacer la consulta");
		}

		if(c10.size() ==0){
			panelDatos.actualizarInterfaz("No se encontraron elementos");
		}
	}

	//REQ 12

	public void consulta12(){
		List<Consulta12> c12 = hotelandes.consulta12();
		String resultado = "";
		if (c12 != null)
		{
			
			for (int i = 0; i < c12.size(); i++) {
				resultado += c12.get(i).toString() + "\n";
			}
			panelDatos.actualizarInterfaz(resultado);
		}
		else{
			panelDatos.actualizarInterfaz("No fue posible hacer la consulta");
		}

		if(c12.size() ==0){
			panelDatos.actualizarInterfaz("No se encontraron elementos");
		}
	}

	/******************************************************************************************
	* Requerimiento 2
	******************************************************************************************/
	public void registrarUsuario(){
		DialogReqDos r2D = new DialogReqDos(this);
		//Dialog usado para llenar los campos
		r2D.setVisible(true);
		//Fin creacion de Dialog
		String resultado = r2D.getResultado()+"\n\nCreacion de usuario completa\n\n";
		panelDatos.actualizarInterfaz(resultado);
		
	}
    
    
    /* ****************************************************************
	 * 			CRUD de metodo de pago 
	 *****************************************************************/
    
    
    public void adicionarReserva () 
	{
    	String numeroPersonas = JOptionPane.showInputDialog (this, "Adicionar reserva?", "Adicionar el Numero de personas para su reserva", JOptionPane.QUESTION_MESSAGE);
		String idCliente = JOptionPane.showInputDialog (this, "Adicionar reserva?", "Adicionar id del cliente", JOptionPane.QUESTION_MESSAGE);
		String fechaEntrada = JOptionPane.showInputDialog (this, "Adicionar reserva?", "Adicionar id del cliente", JOptionPane.QUESTION_MESSAGE);
		String fechaSalida = JOptionPane.showInputDialog (this, "Adicionar reserva?", "Adicionar id del cliente", JOptionPane.QUESTION_MESSAGE);

    	
    	
    	
	}

    
    
    public void adicionarMetodopago () 
	{
    	

    	try 
    	{
    		String nombre = JOptionPane.showInputDialog (this, "Nombre del Metodo de pago?", "Adicionar el Metodo de pago", JOptionPane.QUESTION_MESSAGE);
    		String tipo = JOptionPane.showInputDialog (this, "Nombre del tipo de Metodo de pago?", "Adicionar tipo de Metodo de pago", JOptionPane.QUESTION_MESSAGE);

    		if (nombre != null && tipo != null)
    		{
    			VOMetododePago tb = hotelandes.adicionarMetodopago (nombre,tipo);
    			
        		if (tb == null)
        		{
        			throw new Exception ("No se pudo crear un tipo de Metodo de con nombre: " + nombre);
        		}
        		String resultado = "En adicionarTipoBebida\n\n";
        		resultado += "Tipo de bebida adicionado exitosamente: " + tb;
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    	
    	
	}
    
    
    public void listarMetododePago ()
	{
    	
    	try 
    	{
			List <VOMetododePago> lista = hotelandes.darVOMetododePago();

			String resultado = "En listarMetododePago";
			resultado +=  "\n" + listarTiposBebida (lista);
			panelDatos.actualizarInterfaz(resultado);
			resultado += "\n Operación terminada";
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
   	
	}
    
    
    public void eliminaMetodopagoPorId () 
	{
    	
    	try 
    	{
    		String idMetodoPago = JOptionPane.showInputDialog (this, "Id del tipo de bedida?", "Borrar tipo de bebida por Id", JOptionPane.QUESTION_MESSAGE);
    		if (idMetodoPago != null)
    		{
    			long idTipo = Long.valueOf (idMetodoPago);
    			long tbEliminados = hotelandes.eliminaMetodopagoPorId (idTipo);

    			String resultado = "En eliminar TipoBebida\n\n";
    			resultado += tbEliminados + " Tipos de bebida eliminados\n";
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
    	
    	
	}
    
 	public void eliminarMetodopagoPorNombre() {
 		
 		try 
    	{
    		String idMetodoPago = JOptionPane.showInputDialog (this, "Id del tipo de bedida?", "Borrar tipo de bebida por Id", JOptionPane.QUESTION_MESSAGE);
    		if (idMetodoPago != null)
    		{
    			long tbEliminados = hotelandes.eliminarMetodopagoPorNombre (idMetodoPago);

    			String resultado = "En eliminar TipoBebida\n\n";
    			resultado += tbEliminados + " Tipos de bebida eliminados\n";
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
 		
 		
 	}
 	
 	public void buscarMetodopagoPorNombre( )
    {

    	try 
    	{
    		String nombreTb = JOptionPane.showInputDialog (this, "Nombre del tipo de bedida?", "Buscar tipo de bebida por nombre", JOptionPane.QUESTION_MESSAGE);
    		if (nombreTb != null)
    		{
    			VOMetododePago tipoBebida = hotelandes.darMetododePagoPorNombre (nombreTb);
    			String resultado = "En buscar Tipo Bebida por nombre\n\n";
    			if (tipoBebida != null)
    			{
        			resultado += "El tipo de bebida es: " + tipoBebida;
    			}
    			else
    			{
        			resultado += "Un tipo de bebida con nombre: " + nombreTb + " NO EXISTE\n";    				
    			}
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
 		
 		
    }
 	

	/******************************************************************************************
	* Requerimiento 3
	******************************************************************************************/
	public void registrarTipoHabitacion(){
		try {
			String resultado = "En registrar tipo de habitación\n\n";
			String tipoHabitacion = JOptionPane.showInputDialog (this, "Nombre del tipo de habitacion?", "Registrar tipo de habitacion", JOptionPane.QUESTION_MESSAGE);
			String capacidad = JOptionPane.showInputDialog (this, "Capacidad de la habitacion?", "Registrar tipo de habitacion", JOptionPane.QUESTION_MESSAGE);
			String area = JOptionPane.showInputDialog (this, "Area?", "Registrar tipo de habitacion", JOptionPane.QUESTION_MESSAGE);
			
			if ((tipoHabitacion != null)&&(capacidad != null)&&(area != null)){
				hotelandes.adicionarTipo_Habitacion(tipoHabitacion, new BigDecimal(Long.parseLong(capacidad)), new BigDecimal(Long.parseLong(area)));
				resultado += "Tipo de habitacion adicionado: "+ tipoHabitacion;
				panelDatos.actualizarInterfaz(resultado);
			}
			else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} catch (Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}

	/******************************************************************************************
	* Requerimiento 5
	******************************************************************************************/
	public void registrarServicio(){
		try {
			String resultado = "En registrar tipo de habitación\n\n";
			String nombre = JOptionPane.showInputDialog (this, "Nombre del servicio?", "Registrar servicio", JOptionPane.QUESTION_MESSAGE);
			String descripcion = JOptionPane.showInputDialog (this, "Agregue una descripción del servicio", "Registrar servicio", JOptionPane.QUESTION_MESSAGE);
			String area = JOptionPane.showInputDialog (this, "Area?", "Registrar servicio", JOptionPane.QUESTION_MESSAGE);
			
			if ((nombre != null)&&(descripcion != null)&&(area != null)){
				hotelandes.adicionarServicio(nombre, descripcion, new BigDecimal(Long.parseLong(area)), null);
				resultado += "Servicio adicionado: "+ nombre;
				panelDatos.actualizarInterfaz(resultado);
			}
			else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} catch (Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}



	/******************************************************************************************
	* Requerimiento 11
	******************************************************************************************/
	public void registrarSalidaCliente(){
		try {
			String idCliente = JOptionPane.showInputDialog (this, "Id del cliente?", "Salida de un cliente", JOptionPane.QUESTION_MESSAGE);
			String resultado = "En registrar salidas de un cliente\n\n";
			if (idCliente != null){
				
				ClienteActivo c = hotelandes.darClienteActivoPorId(new BigDecimal(Long.parseLong(idCliente)));
				
				if (c != null){
					BigDecimal idReserva = c.getIdReserva();
					hotelandes.liberarReserva(idReserva);
					resultado += "La reserva "+idReserva+" ahora esta en estado 'Pasada'\n";
					hotelandes.eliminarClienteActivo(new BigDecimal(Long.parseLong(idCliente)), idReserva);
					resultado += "Salida del cliente "+idCliente+"\n";
				}
				else{
					resultado += "El cliente "+idCliente+" no se encuentra activo";
				}
				
				
				panelDatos.actualizarInterfaz(resultado);
			}
			else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
		} catch (Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
 	
 	
 	/******************************************************************************************
	* Requerimiento 12
	******************************************************************************************/
	public void reservarAlojamientoServiciosConvencion(){
		try {
			List<Servicio> servicios = hotelandes.darServicios();
			List<Cliente> clientes = hotelandes.darClientes();

			//Creacion de dialog para resolver el requerimiento
			
			DialogReqDoce r12D = new DialogReqDoce(this, servicios,clientes);
			//Dialog usado para llenar los campos
			r12D.setVisible(true);
			//Fin creacion de Dialog
			String resultado = r12D.getResultado()+"\n\nCreacion de convencion completa\n\n";
			panelDatos.actualizarInterfaz(resultado);


		} catch (Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
		

	}
 	
 	
 	

 	/******************************************************************************************
	* Requerimiento 13
	******************************************************************************************/
	public void cancelarReservasConvencion(){
		try {
			String idPlanPagoAcordado = JOptionPane.showInputDialog (this, "Id del plan de pago acordado?", "Eliminar convencion", JOptionPane.QUESTION_MESSAGE);
    		
			if (idPlanPagoAcordado != null)
    		{
				String resultado = "En cancelar las reservaciones de un plan de pago (convención)\n\n";
				List<Reserva> reservasAsociadas = hotelandes.darReservasPorPlanPago(new BigDecimal(Long.parseLong(idPlanPagoAcordado)));
				if (reservasAsociadas.size() != 0){
					
					for (int i = 0; i<reservasAsociadas.size(); i++){
						Reserva re = reservasAsociadas.get(i);
						BigDecimal idReserva = re.getIdReserva();
						hotelandes.eliminarHabitacionReservadaPorIdReserva(idReserva);
					}
					resultado += "Se liberaron las habitaciones\n";

					hotelandes.eliminarReservasPorplan_de_pago(Integer.parseInt(idPlanPagoAcordado));
					
					resultado += "Se eliminaron las reservas del plan de pago: " + idPlanPagoAcordado;
				}
				else
				{
					resultado += "Un plan de pago con id: " + idPlanPagoAcordado + " NO TIENE RESERVAS ASOCIADAS\n";    				
				}
    			
    			
    			resultado += "\n Operación terminada";
    			panelDatos.actualizarInterfaz(resultado);
    		}
    		else
    		{
    			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
    		}
			
		} catch (Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
		
	}
 	
 	/******************************************************************************************
	* Requerimiento 14
	******************************************************************************************/
 	public void registrarFinDeConvencion(){

		try {
			String idPlanPagoAcordado = JOptionPane.showInputDialog (this, "Id del plan de pago acordado (Convencion)?", "Poner fin a una convencion", JOptionPane.QUESTION_MESSAGE);
			if (idPlanPagoAcordado != null)
    		{
				String resultado = "Registrando fin de una convención\n\n";
				List<Cliente> listaClientes = hotelandes.darClienteporPlandepago(new BigDecimal(Long.parseLong(idPlanPagoAcordado)));
				if(listaClientes.size() != 0){
					for (int i = 0; i < listaClientes.size(); i++) {
						Cliente cl = listaClientes.get(i);
						BigDecimal idCliente = cl.getid();
						ClienteActivo c = hotelandes.darClienteActivoPorId(idCliente);
	
						BigDecimal idReserva = c.getIdReserva();
						hotelandes.liberarReserva(idReserva);
						resultado += "La reserva "+idReserva+" ahora esta en estado 'Pasada'\n";
						hotelandes.eliminarClienteActivo(idCliente, idReserva);
						resultado += "Salida del cliente "+idCliente+"\n";
					}
				}
				else{
					resultado += "No existen clientes asociados a la convención";
				}
				resultado += "\n Operación terminada";
				panelDatos.actualizarInterfaz(resultado);
				

			}
			else
			{
				panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
			}

		} catch (Exception e) {
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}

	 }
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	/******************************************************************************************
	* Requerimiento 15
	******************************************************************************************/
 	/*
	public void adicionarHabitacion () 
 	{
 		String numeroUsuario = "";
 		String nombreUsuario = "";
 		String apellidoUsuario = "";
 		String correoUsuario = "";
 		 
 		try 
     	{
 			numeroUsuario = JOptionPane.showInputDialog (this, "Numero del usuario?", "Adicionar el Metodo de pago", JOptionPane.QUESTION_MESSAGE);
     		nombreUsuario = JOptionPane.showInputDialog (this, "Nombre del usuario?", "Adicionar tipo de Metodo de pago", JOptionPane.QUESTION_MESSAGE);
     		apellidoUsuario = JOptionPane.showInputDialog (this, "Apellido del usuario?", "Adicionar tipo de Metodo de pago", JOptionPane.QUESTION_MESSAGE);
     		correoUsuario = JOptionPane.showInputDialog (this, "Coreo del usuario?", "Adicionar tipo de Metodo de pago", JOptionPane.QUESTION_MESSAGE);

     		
     		Long numeroLong = Long.parseLong(numeroUsuario);
     		
	
     		if (nombreUsuario != null && numeroLong != null && apellidoUsuario != null && correoUsuario != null)
     		{
     			Usuario usu = hotelandes.adicionarUsuario (numeroLong,nombreUsuario,apellidoUsuario,correoUsuario);
     			
         		if (usu == null)
         		{
         			throw new Exception ("No se pudo adicionar el usuario: " + nombreUsuario);
         		}
         		String resultado = "En adicionar Usuario \n\n";
         		resultado += "El Usuario se anadio exitosamente: " + usu;
     			resultado += "\n Operación terminada";
     			panelDatos.actualizarInterfaz(resultado);
     		}
     		else
     		{
     			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
     		}
 		} 
     	catch (Exception e) 
     	{
// 			e.printStackTrace();
 			String resultado = generarMensajeError(e);
 			panelDatos.actualizarInterfaz(resultado);
 		}
 		
 		
 		try 
    	{
			List<VOMetododePago> lista = hotelandes.darVOMetododePago();

			String resultado = "En listarMetododePago";
			resultado +=  "\n" + listarTiposBebida (lista);
			panelDatos.actualizarInterfaz(resultado);
			resultado += "\n Operación terminada";
		} 
    	catch (Exception e) 
    	{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}

     	try 
     	{
     		String nombre = JOptionPane.showInputDialog (this, "Nombre del Metodo de pago?", "Adicionar el Metodo de pago", JOptionPane.QUESTION_MESSAGE);
     		String tipoHabitacion = JOptionPane.showInputDialog (this, "Nombre del tipo de Metodo de pago?", "Adicionar tipo de Metodo de pago", JOptionPane.QUESTION_MESSAGE);
     		String numeroHabitacion = JOptionPane.showInputDialog (this, "Nombre del tipo de Metodo de pago?", "Adicionar tipo de Metodo de pago", JOptionPane.QUESTION_MESSAGE);
     		String idEmpleado = JOptionPane.showInputDialog (this, "Nombre del tipo de Metodo de pago?", "Adicionar tipo de Metodo de pago", JOptionPane.QUESTION_MESSAGE);

     		
     		Long numeroHabitacionLong = Long.parseLong(numeroHabitacion);
     		
     		Long idEmpleadoLong = Long.parseLong(idEmpleado);
	
     		if (nombre != null && tipoHabitacion != null && numeroHabitacionLong != null && idEmpleadoLong != null)
     		{
     			Habitacion tb = hotelandes.adicionarHabitacion (nombre,tipoHabitacion,numeroHabitacionLong,idEmpleadoLong);
     			
         		if (tb == null)
         		{
         			throw new Exception ("No se pudo adicionar la habitacion: " + nombre);
         		}
         		String resultado = "En adicionar Habitacion \n\n";
         		resultado += "la habitacion se anadio exitosamente: " + tb;
     			resultado += "\n Operación terminada";
     			panelDatos.actualizarInterfaz(resultado);
     		}
     		else
     		{
     			panelDatos.actualizarInterfaz("Operación cancelada por el usuario");
     		}
 		} 
     	catch (Exception e) 
     	{
// 			e.printStackTrace();
 			String resultado = generarMensajeError(e);
 			panelDatos.actualizarInterfaz(resultado);
 		}
     	
     	
 	}
    */
 	

 	public void mostrarLogHotelAndes ()
	{
		mostrarArchivo ("hotelandes.log");
	}
	
	/**
	 * Muestra el log de datanucleus
	 */
	public void mostrarLogDatanuecleus ()
	{
		mostrarArchivo ("datanucleus.log");
	}
 	
 	
 	
 	
 	
 	
 	
 	public void limpiarLogHotelAndes ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("hotelandes.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de hotelandes ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
	public void limpiarLogDatanucleus ()
	{
		// Ejecución de la operación y recolección de los resultados
		boolean resp = limpiarArchivo ("datanucleus.log");

		// Generación de la cadena de caracteres con la traza de la ejecución de la demo
		String resultado = "\n\n************ Limpiando el log de datanucleus ************ \n";
		resultado += "Archivo " + (resp ? "limpiado exitosamente" : "NO PUDO ser limpiado !!");
		resultado += "\nLimpieza terminada";

		panelDatos.actualizarInterfaz(resultado);
	}
 	
 
 	
 	public void limpiarBD ()
	{
		try 
		{
    		// Ejecución de la demo y recolección de los resultados
			long eliminados [] = hotelandes.limpiarHotelandes();
			
			// Generación de la cadena de caracteres con la traza de la ejecución de la demo
			String resultado = "\n\n************ Limpiando la base de datos ************ \n";
			
			resultado += eliminados [0] + " CLIENTE eliminados\n";
			resultado += eliminados [1] + " CLIENTE ACTIVO eliminados\n";
			resultado += eliminados [2] + " CUENTA eliminados\n";
			resultado += eliminados [3] + " CUENTA CARGADA eliminadas\n";
			resultado += eliminados [4] + " EMPLEADO eliminados\n";
			resultado += eliminados [5] + " EMPLEADO ACTIVO eliminados\n";
			resultado += eliminados [6] + " HABITACION eliminados\n";
			resultado += eliminados [7] + " HABITACION OFERTADA eliminados\n";
			resultado += eliminados [8] + " HABITACION RESERVADA eliminados\n";
			resultado += eliminados [9] + " HOTEL  eliminados\n";
			resultado += eliminados [10] + " METODO DE PAGO  eliminados\n";
			resultado += eliminados [11] + " PLAN DE CONSUMO  eliminados\n";
			resultado += eliminados [12] + " PLAN DE OFRECIDO  eliminados\n";
			resultado += eliminados [13] + " RESERVA  eliminados\n";
			resultado += eliminados [14] + " SERVICIO  eliminados\n";
			resultado += eliminados [15] + " SERVICIO  OFRECIDO eliminados\n";
			resultado += eliminados [16] + " SERVICIO  SOLICITADO eliminados\n";
			resultado += eliminados [17] + " TIPO   HABITACION eliminados\n";
			resultado += eliminados [18] + " TIPO   RESERVA eliminados\n";


			resultado += "\nLimpieza terminada";
   
			panelDatos.actualizarInterfaz(resultado);
		} 
		catch (Exception e) 
		{
//			e.printStackTrace();
			String resultado = generarMensajeError(e);
			panelDatos.actualizarInterfaz(resultado);
		}
	}
 	
 	
 	
 	
 	
 	
 	
 	
 	

 	/* ****************************************************************
	 * 			arreglar
	 *****************************************************************/
 	
 	
 	
 	
 	public void mostrarPresentacionGeneral ()
	{
		mostrarArchivo ("data/HotelAndesinfo.pdf");
	}
	
	/**
	 * Muestra el modelo conceptual de Parranderos
	 */
	public void mostrarModeloConceptual ()
	{
		mostrarArchivo ("data/umlHotel.pdf");
	}
	
	/**
	 * Muestra el esquema de la base de datos de Parranderos
	 */
	public void mostrarEsquemaBD ()
	{
		mostrarArchivo ("data/Esquema BD HotelAndes.pdf");
	}
 	
 
 	
 	
 	/* ****************************************************************
	 * 			arreglar
	 *****************************************************************/
    
 	
 	
 	
 	public void mostrarScriptBD ()
	{
		mostrarArchivo ("data/EsquemaHotelAndes .sql");
	}
	
	/**
	 * Muestra la arquitectura de referencia para Parranderos
	 */
	public void mostrarArqRef ()
	{
		mostrarArchivo ("data/ArquitecturaReferencia.pdf");
	}
	
	/**
	 * Muestra la documentación Javadoc del proyectp
	 */
	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	 public void acercaDe ()
     {
 		String resultado = "\n\n ************************************\n\n";
 		resultado += " * Universidad	de	los	Andes	(Bogotá	- Colombia)\n";
 		resultado += " * Departamento	de	Ingeniería	de	Sistemas	y	Computación\n";
 		resultado += " * \n";		
 		resultado += " * Curso: isis2304 - Sistemas Transaccionales\n";
 		resultado += " * Proyecto: Hotel Andes Uniandes\n";
 		resultado += " * @version 1.0\n";
 		resultado += " * @author Santiago  vela \n";
 
 		resultado += "\n ************************************\n\n";

 		panelDatos.actualizarInterfaz(resultado);		
     }
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	

    
    
    
    

	/* ****************************************************************
	 * 			Métodos privados para la presentación de resultados y otras operaciones
	 *****************************************************************/
    
    


 	private String listarTiposBebida(List<VOMetododePago> lista) 
    {
    	String resp = "Los tipos de Metodos de pago existentes son:\n";
    	int i = 1;
        for (VOMetododePago tb : lista)
        {
        	resp += i++ + ". " + tb.toString() + "\n";
        }
        return resp;
	}

	
	
	
	
	
	
 	private String darDetalleException(Exception e) 
	{
		String resp = "";
		if (e.getClass().getName().equals("javax.jdo.JDODataStoreException"))
		{
			JDODataStoreException je = (javax.jdo.JDODataStoreException) e;
			return je.getNestedExceptions() [0].getMessage();
		}
		return resp;
	}

	
    private String generarMensajeError(Exception e) 
	{
		String resultado = "************ Error en la ejecución\n";
		resultado += e.getLocalizedMessage() + ", " + darDetalleException(e);
		resultado += "\n\nRevise datanucleus.log y parranderos.log para más detalles";
		return resultado;
	}
    
    
    private boolean limpiarArchivo(String nombreArchivo) 
	{
		BufferedWriter bw;
		try 
		{
			bw = new BufferedWriter(new FileWriter(new File (nombreArchivo)));
			bw.write ("");
			bw.close ();
			return true;
		} 
		catch (IOException e) 
		{
//			e.printStackTrace();
			return false;
		}
	}
    
    
    
    
    
    
    
    private void mostrarArchivo (String nombreArchivo)
	{
		try
		{
			Desktop.getDesktop().open(new File(nombreArchivo));
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	


	
	
	
	@Override
	public void actionPerformed(ActionEvent pEvento) {
		// TODO Auto-generated method stub
		
		
		String evento = pEvento.getActionCommand( );		
        try 
        {
			Method req = interfazHotelandesApp.class.getMethod ( evento );			
			req.invoke ( this );
		} 
        catch (Exception e) 
        {
			e.printStackTrace();
		} 
		
	}
	
	/* ****************************************************************
	 * 			Programa principal
	 *****************************************************************/
    /**
     * Este método ejecuta la aplicación, creando una nueva interfaz
     * @param args Arreglo de argumentos que se recibe por línea de comandos
     */
    public static void main( String[] args )
    {
        try
        {
        	
            // Unifica la interfaz para Mac y para Windows.
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName( ) );
            interfazHotelandesApp interfaz = new interfazHotelandesApp( );
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
	
	
	Hotelandes getHotelAndes(){
		return this.hotelandes;
	}
	
}

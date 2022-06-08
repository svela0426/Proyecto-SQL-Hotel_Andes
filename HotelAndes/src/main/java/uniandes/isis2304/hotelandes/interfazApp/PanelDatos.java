package uniandes.isis2304.hotelandes.interfazApp;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")

public class PanelDatos extends JPanel {
	
	
	private JTextArea textArea;
	
	
	
	public PanelDatos ()
    {
        setBorder (new TitledBorder ("Panel de información"));
        setLayout( new BorderLayout( ) );
        
        textArea = new JTextArea("Aquí sale el resultado de las operaciones solicitadas");
        textArea.setEditable(false);
        add (new JScrollPane(textArea), BorderLayout.CENTER);
    }
	
	
	public void actualizarInterfaz (String texto)
    {
    	textArea.setText(texto);
    }

}

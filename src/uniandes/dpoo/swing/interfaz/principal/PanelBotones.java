package uniandes.dpoo.swing.interfaz.principal;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelBotones extends JPanel implements ActionListener
{
    /**
     * El comando para el botón para crear un nuevo restaurante
     */
    private static final String NUEVO = "Nuevo";

    /**
     * El comando para el botón para ver todos los restaurantes en el mapa
     */
    private static final String VER = "Ver todos";

    private JButton butNuevo;
    private JButton butVerTodos;
    private VentanaPrincipal ventanaPrincipal;

    public PanelBotones( VentanaPrincipal ventanaPrincipal )
    {
        this.ventanaPrincipal = ventanaPrincipal;

        this.setLayout( new FlowLayout( ) );

        
        this.butNuevo = new JButton(NUEVO);
        this.butVerTodos = new JButton(VER);
        this.add(butNuevo);
        this.add(butVerTodos);
        butNuevo.addActionListener(this);
        butVerTodos.addActionListener(this);
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( comando.equals( NUEVO ) )
        {
            ventanaPrincipal.mostrarVetanaNuevoRestaurante( );
//            System.out.println("Se oprimió nuevo");
        }
        else if( comando.equals( VER ) )
        {
            ventanaPrincipal.mostrarVentanaMapa( );
//            System.out.println("Se oprimió ver todos");
        }
    }
}

package uniandes.dpoo.swing.interfaz.mapa;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import uniandes.dpoo.swing.interfaz.principal.VentanaPrincipal;
import uniandes.dpoo.swing.mundo.Restaurante;

@SuppressWarnings("serial")
public class VentanaMapa extends JFrame implements ActionListener
{
    /**
     * El comando para reconocer al radio que muestra sólo los restaurantes visitados
     */
    private static final String VISITADOS = "Visitados";

    /**
     * El comando para reconocer al radio que muestra todos los restaurantes
     */
    private static final String TODOS = "Todos";

    /**
     * El panel con el mapa
     */
    private PanelMapaVisualizar panelMapa;

    /**
     * El radio button para hacer que se muestren todos los restaurantes. Si este está activo, radioVisitados debe estar inactivo.
     */
    private JRadioButton radioTodos;

    /**
     * El radio button para hacer que se muestren sólo los restaurantes visitados. Si este está activo, radioTodos debe estar inactivo.
     */
    private JRadioButton radioVisitados;

    /**
     * La referencia a la ventana principal
     */
    private VentanaPrincipal ventanaPrincipal;

    public VentanaMapa( VentanaPrincipal ventanaPrincipal)
    {
        this.ventanaPrincipal = ventanaPrincipal;

        panelMapa = new PanelMapaVisualizar();
        panelMapa.actualizarMapa(new ArrayList<Restaurante>());
        add(panelMapa, BorderLayout.CENTER);

        JPanel panelOpciones = new JPanel();
        panelOpciones.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

        radioTodos = new JRadioButton(TODOS);
        radioTodos.addActionListener(this);

        radioVisitados = new JRadioButton(VISITADOS);
        radioVisitados.addActionListener(this);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioTodos);
        grupo.add(radioVisitados);

        panelOpciones.add(radioTodos);
        panelOpciones.add(radioVisitados);

        add(panelOpciones, BorderLayout.SOUTH);

        // Termina de configurar la ventana y la muestra
        pack( );
        setResizable( false );
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setLocationRelativeTo( null );
    }

    @Override
    public void actionPerformed( ActionEvent e )
    {
        String comando = e.getActionCommand( );
        if( TODOS.equals( comando ) )
        {
            panelMapa.actualizarMapa( ventanaPrincipal.getRestaurantes( true ) );
        }
        else if( VISITADOS.equals( comando ) )
        {
            panelMapa.actualizarMapa( ventanaPrincipal.getRestaurantes( false ) );
        }
    }

}

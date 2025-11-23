package uniandes.dpoo.swing.interfaz.agregar;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PanelEditarRestaurante extends JPanel
{
    /**
     * El campo para que el usuario ingrese el nombre del restaurante
     */
    private JTextField txtNombre;

    /**
     * Un selector (JComboBox) para que el usuario seleccione la calificación (1 a 5) del restaurante
     */
    private JComboBox<String> cbbCalificacion;

    /**
     * Un selector (JComboBox) para que el usuario indique si ya visitó el restaurante o no
     */
    private JComboBox<String> cbbVisitado;

    public PanelEditarRestaurante( )
    {
    	this.setLayout(new GridLayout(3, 1));

        JPanel panelNombre = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblNombre = new JLabel("Nombre:  ");
        txtNombre = new JTextField(20);
        panelNombre.add(lblNombre);
        panelNombre.add(txtNombre);

        JPanel panelCalif = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblCalif = new JLabel("Calificación:  ");
        cbbCalificacion = new JComboBox<>();
        cbbCalificacion.addItem("1");
        cbbCalificacion.addItem("2");
        cbbCalificacion.addItem("3");
        cbbCalificacion.addItem("4");
        cbbCalificacion.addItem("5");
        panelCalif.add(lblCalif);
        panelCalif.add(cbbCalificacion);

        JPanel panelVisitado = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblVisitado = new JLabel("Visitado:  ");
        cbbVisitado = new JComboBox<>();
        cbbVisitado.addItem("Sí");
        cbbVisitado.addItem("No");
        panelVisitado.add(lblVisitado);
        panelVisitado.add(cbbVisitado);

        this.add(panelNombre);
        this.add(panelCalif);
        this.add(panelVisitado);

    }

    /**
     * Indica si en el selector se seleccionó la opción que dice que el restaurante fue visitado
     * @return
     */
    public boolean getVisitado( )
    {
    	String valor = (String)cbbVisitado.getSelectedItem();
        return valor.equals("Sí");
    }

    /**
     * Indica la calificación marcada en el selector
     * @return
     */
    public int getCalificacion( )
    {
        String calif = ( String )cbbCalificacion.getSelectedItem( );
        return Integer.parseInt( calif );
    }

    /**
     * Indica el nombre digitado para el restaurante
     * @return
     */
    public String getNombre( )
    {
    	return txtNombre.getText();
    }
}

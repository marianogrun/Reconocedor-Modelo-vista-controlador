
package reconocedordeidioma;

import vista.Vista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;

public class Controlador
{
    private Vista v;
    private Analizador a;
    
    public Controlador() 
    {
        this.a = new Analizador();
        this.v = new Vista();
        this.v.agregarAnalizarListener( new AnalizarHandler() );
    }
    
    public void iniciar ()
    {
        this.v.setVisible(true);
        this.v.setDefaultCloseOperation(this.v.EXIT_ON_CLOSE);
        this.v.setLocationRelativeTo(null);
    }
    
    private class AnalizarHandler implements ActionListener 
    {
        public void actionPerformed(ActionEvent e) 
        {
            String laCadena = v.obtenerTexto();            
            if ( laCadena.isEmpty() )
            {
                v.mostrarError("No hay texto para analizar");
            }
            else
            {
                a.analizar( v.obtenerTexto() );
                v.mostrarResultado( a.getIdiomaResultante().getNOMBRE() , a.getIdiomaResultante().getBANDERA() );
            }
            
        }
    }
}

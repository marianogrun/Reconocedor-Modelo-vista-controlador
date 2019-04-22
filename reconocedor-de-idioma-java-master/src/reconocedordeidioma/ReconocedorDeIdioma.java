
package reconocedordeidioma;

public class ReconocedorDeIdioma
{
    public static void main(String[] args)
    {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Controlador c = new Controlador();
                c.iniciar();
            }
        });
    }
}

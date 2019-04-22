
package reconocedordeidioma;

import javax.swing.Icon;

public class Idioma
{
    private final String NOMBRE;
    private final Icon BANDERA;
    private final double[] FRECUENCIA_RELATIVA;

    public Idioma(String nombre, Icon bandera, double[] frecuenciaRelativa)
    {
        this.NOMBRE = nombre;
        this.BANDERA = bandera;
        this.FRECUENCIA_RELATIVA = frecuenciaRelativa;
    }   

    public String getNOMBRE()
    {
        return NOMBRE;
    }

    public double[] getFRECUENCIA_RELATIVA()
    {
        return FRECUENCIA_RELATIVA;
    }
    
    public Icon getBANDERA()
    {
        return BANDERA;
    }
    
    
}

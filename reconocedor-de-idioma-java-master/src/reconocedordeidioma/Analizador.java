package reconocedordeidioma;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Analizador
{
    private String cadena;
    private Idioma[] idiomas;
    private double[] frecuencia;
    private Idioma idiomaResultante;
    private static final int CANT_CARACTERES = 26;

    public Analizador() {
        this.idiomas = cargarIdiomas();
    }
    
    private Idioma[] cargarIdiomas()
    {
        Icon cas = new ImageIcon(getClass().getResource("/recursos/Argentina.png"));
        Icon ing = new ImageIcon(getClass().getResource("/recursos/United-Kingdom.png"));
        Icon ale = new ImageIcon(getClass().getResource("/recursos/Germany.png"));

        Idioma c = new Idioma("castellano", cas, new double[] {11.05,0.87,6.82,4.77,11.93,1.18,0.93,0.37,8.91,0.24,0.01,5.65,2.7,7.41,9.51,2.29,0.78,5.46,8.14,5.09,4.21,0.76,0.01,0.11,0.7,0.1});
        Idioma i = new Idioma("inglés", ing, new double[] {7.81,1.28,2.93,4.11,13.05,2.88,1.39,5.85,6.77,0.23,0.42,3.6,2.62,7.28,8.21,2.15,0.14,6.64,6.46,9.02,2.77,1,1.49,0.3,1.51,0.09});
        Idioma a = new Idioma("alemán", ale, new double[] {6.11,1.87,2.67,5.56,16.51,1.48,2.89,4.15,8.26,0.26,1.67,3.4,2.72,10.28,3.03,1.01,0.02,7.83,6.27,6.09,4.48,1.08,1.2,0.05,0.08,1.03});
                
        return new Idioma[] {c,i,a};
    }
    
    public void analizar(String cad)
    {
        this.cadena = cad.toUpperCase();
        this.frecuencia = obtenerFrecuenciaRelativa( obtenerFrecuenciaDeCaracteres() );
        double errorActual;
        double errorMenor;
        
        errorMenor = calcularECM(frecuencia, idiomas[0].getFRECUENCIA_RELATIVA());
        this.idiomaResultante = this.idiomas[0];
        
        for (int i = 1; i < this.idiomas.length; i++) 
        {
            errorActual = calcularECM(frecuencia, idiomas[i].getFRECUENCIA_RELATIVA());
            if (errorActual < errorMenor) 
            {
                errorMenor = errorActual;
                this.idiomaResultante = this.idiomas[i];
            }
        }
    }
    
    private int[] obtenerFrecuenciaDeCaracteres ()
    {
        char caracterExtraido;
        int[] frec = new int[CANT_CARACTERES];
        for (int i = 0; i < this.cadena.length(); i++)
        {
            caracterExtraido = this.cadena.charAt(i);
            if ( esLetra( caracterExtraido ) )
            {
                frec[ caracterExtraido - 65 ]++; // Como los caracteres son números, aprovecho esa ventaja y accedo al arreglo con una pequeña fórmula
            }
        }
        
        return frec;
    }
    
    private int contarCaracteres ()
    {
        char caracterExtraido;
        int contador = 0;
        
        for (int i = 0; i < this.cadena.length(); i++)
        {
            caracterExtraido = this.cadena.charAt(i);
            if ( esLetra( caracterExtraido ) )
            {
                contador++;
            }
        }
        
        return contador;
    }
    
    private boolean esLetra (char letra)
    {
        // A - Z (De 65 a 90)
        return letra >= 65 && letra <= 90;
    }
    
    private double[] obtenerFrecuenciaRelativa (int[] arreglo)
    {
        double[] frec = new double[CANT_CARACTERES];
        int totalLetras = contarCaracteres();
        
        for (int i = 0; i < arreglo.length; i++)
	{
            // Guardo en cada posición el equivalente en porcentaje
            frec[i] = (arreglo[i] * 100.0) / totalLetras;
	}
        
        return frec;
    }
    
    private double calcularECM (double[] frecCadena, double[] frecLenguaje)
    {
        double aux = 0;
	double ecm;
        
        // El ECM se define como la diferencia entre la predicción y lo obtenido.

	for (int i = 0; i < frecCadena.length; i++)
	{
            aux += (frecLenguaje[i] - frecCadena[i]) * (frecLenguaje[i] - frecCadena[i]);
	}

	ecm = aux / (double) frecCadena.length;
        
	return ecm;
    }

    public Idioma getIdiomaResultante() {
        return idiomaResultante;
    }
    
    
}

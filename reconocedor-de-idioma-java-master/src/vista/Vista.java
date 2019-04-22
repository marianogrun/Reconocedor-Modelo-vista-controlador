
package vista;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class Vista extends javax.swing.JFrame
{
    public Vista()
    {
        //establecerIcono();
        initComponents();
    }
    
    /*private void establecerIcono() {
        Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/recursos/DibujoCaemci.png"));
        setIconImage(icon);
    }*/
    
    public void agregarAnalizarListener (ActionListener al)
    {
        this.jButtonAnalizar.addActionListener( al );
    }  
    
    public String obtenerTexto()
    {
        return this.jTextAreaTexto.getText();
    }
    
    public void mostrarResultado(String idioma, Icon bandera)
    {
        JOptionPane.showMessageDialog(null, "El texto está en " + idioma, "Resultado", 1, bandera);
    }
    
    public void mostrarError(String mensaje)
    {
        JOptionPane.showMessageDialog(null, mensaje, "Error", 0);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelContenido = new javax.swing.JPanel();
        jLabelLeyenda = new javax.swing.JLabel();
        panelDesplazable = new javax.swing.JScrollPane();
        jTextAreaTexto = new javax.swing.JTextArea();
        jButtonAnalizar = new javax.swing.JButton();
        jPanelAutor = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelLicencia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reconocedor de idioma");
        setBackground(new java.awt.Color(231, 235, 239));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        jPanelContenido.setLayout(new java.awt.BorderLayout());

        jLabelLeyenda.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabelLeyenda.setForeground(new java.awt.Color(20, 34, 57));
        jLabelLeyenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLeyenda.setText("Ingrese un texto para reconocer el idioma en que está escrito:");
        jPanelContenido.add(jLabelLeyenda, java.awt.BorderLayout.PAGE_START);

        jTextAreaTexto.setBackground(new java.awt.Color(237, 244, 252));
        jTextAreaTexto.setColumns(20);
        jTextAreaTexto.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextAreaTexto.setRows(5);
        jTextAreaTexto.setMargin(new java.awt.Insets(5, 5, 5, 5));
        panelDesplazable.setViewportView(jTextAreaTexto);

        jPanelContenido.add(panelDesplazable, java.awt.BorderLayout.CENTER);

        jButtonAnalizar.setBackground(new java.awt.Color(97, 134, 198));
        jButtonAnalizar.setFont(new java.awt.Font("Consolas", 1, 48)); // NOI18N
        jButtonAnalizar.setForeground(new java.awt.Color(237, 244, 252));
        jButtonAnalizar.setText("ANALIZAR");
        jButtonAnalizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanelContenido.add(jButtonAnalizar, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(jPanelContenido);

        jPanelAutor.setName(""); // NOI18N
        jPanelAutor.setPreferredSize(new java.awt.Dimension(500, 45));
        jPanelAutor.setLayout(new java.awt.BorderLayout());

        jLabelLogo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanelAutor.add(jLabelLogo, java.awt.BorderLayout.LINE_START);

        jLabelLicencia.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        jLabelLicencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLicencia.setText("2017");
        jLabelLicencia.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jPanelAutor.add(jLabelLicencia, java.awt.BorderLayout.EAST);

        getContentPane().add(jPanelAutor);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAnalizar;
    private javax.swing.JLabel jLabelLeyenda;
    private javax.swing.JLabel jLabelLicencia;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JPanel jPanelAutor;
    private javax.swing.JPanel jPanelContenido;
    private javax.swing.JTextArea jTextAreaTexto;
    private javax.swing.JScrollPane panelDesplazable;
    // End of variables declaration//GEN-END:variables
}

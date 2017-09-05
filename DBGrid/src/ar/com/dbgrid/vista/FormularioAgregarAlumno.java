package ar.com.dbgrid.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ar.com.dbgrid.dao.AlumnoDao;
import ar.com.dbgrid.modelo.Alumno;
import ar.com.dbgrid.modelo.finalObservable;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.GridLayout;

public class FormularioAgregarAlumno extends JFrame implements ActionListener
{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private final static finalObservable OBSERVER = new finalObservable();
    
    private JPanel contentPane;
    private JTextField Nombre_Alumno = new JTextField();;
    private JTextField Apellido_Alumno = new JTextField();
    JButton btnAceptar = new JButton("Aceptar");

    /**
     * Create the frame.
     */
    public FormularioAgregarAlumno()
    {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 429, 263);
        contentPane = new JPanel();
        contentPane.setPreferredSize(new Dimension(400, 200));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_datos = new JPanel();
        contentPane.add(panel_datos, BorderLayout.CENTER);
        panel_datos.setLayout(null);
        Nombre_Alumno.setBounds(6, 23, 234, 28);
        
        Nombre_Alumno.setMinimumSize(new Dimension(12, 12));
        panel_datos.add(Nombre_Alumno);
        Nombre_Alumno.setColumns(5);
        
        Apellido_Alumno.setBounds(6, 69, 236, 28);
        panel_datos.add(Apellido_Alumno);
        Apellido_Alumno.setColumns(10);
        
        JPanel panel_labels = new JPanel();
        panel_labels.setPreferredSize(new Dimension(80, 150));
        panel_labels.setSize(new Dimension(50, 200));
        contentPane.add(panel_labels, BorderLayout.WEST);
        panel_labels.setLayout(null);
        
        JLabel lblNombre = new JLabel("Nombre");
        lblNombre.setBounds(10, 6, 45, 57);
        lblNombre.setName("lblNombre");
        panel_labels.add(lblNombre);
        
        JLabel lblApellido = new JLabel("Apellido");
        lblApellido.setBounds(10, 51, 45, 57);
        panel_labels.add(lblApellido);
        
        JPanel panel_botonera = new JPanel();
        contentPane.add(panel_botonera, BorderLayout.SOUTH);
        
        panel_botonera.add(btnAceptar);
        
        JPanel panel_header = new JPanel();
        contentPane.add(panel_header, BorderLayout.NORTH);
        
        JLabel lblAgregarAlumno = new JLabel("Agregar Alumno");
        panel_header.add(lblAgregarAlumno);
        
        btnAceptar.addActionListener(this);
        
        this.pack();
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource() == btnAceptar)
        {
            AlumnoDao a = new AlumnoDao();
            Alumno al = new Alumno();
            al.setId(a.MaxID() + 1);
            al.setNombre(Apellido_Alumno.getText() + ", " + Nombre_Alumno.getText());
            
            a.agregarAlumno(al);
            this.dispose();
            
            OBSERVER.setChanged();
            OBSERVER.notifyObservers(al);
        }
    }
    
    public static finalObservable getObserver()
    {
        return OBSERVER;
    }
}

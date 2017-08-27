package ar.com.dbgrid.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import ar.com.dbgrid.dao.FinalesDao;
import ar.com.dbgrid.modelo.ConversorResultSetACDefaultComboBox;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Component;

public class FormularioAgregarFinal extends JFrame implements ActionListener
{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int idAlumno;
    private String Nombre;

    private JPanel contentPane;
	private JTextField textField;
	private JComboBox<String> comboBox = new JComboBox<String>();
	private JButton btnAceptar = new JButton("Aceptar");
	private JButton btnBorrar = new JButton("Borrar");

	public FormularioAgregarFinal(int idAlumno, String Nombre)
	{
		this.idAlumno = idAlumno;
		this.setNombre(Nombre);

		cargarForm();
		
		FinalesDao f = new FinalesDao();
        DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        modelo = ConversorResultSetACDefaultComboBox.llenarCombo(f.mostrarFinales(idAlumno), modelo);
        
        this.comboBox.setModel(modelo);
	}

	
	public void cargarForm() 
	{
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setBounds(100, 100, 472, 233);
		this.setTitle("Agregar Final");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_Materias = new JPanel();
		panel_Materias.setName("Materias");
		contentPane.add(panel_Materias, BorderLayout.WEST);
		
		JLabel lblMaterias = new JLabel("Materias");
		panel_Materias.add(lblMaterias);
		comboBox.setPreferredSize(new Dimension(250, 26));
		comboBox.setMinimumSize(new Dimension(100, 26));
		
		panel_Materias.add(comboBox);
		
		JPanel panel_Notas = new JPanel();
		contentPane.add(panel_Notas, BorderLayout.CENTER);
		panel_Notas.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblNota.setHorizontalAlignment(SwingConstants.CENTER);
		panel_Notas.add(lblNota);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setPreferredSize(new Dimension(8, 20));
		panel_Notas.add(textField);
		textField.setColumns(3);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnAceptar.addActionListener(this);
		
		panel.add(btnAceptar);
		panel.add(btnBorrar);
		
		this.pack();
		this.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
	    Object fuente =  e.getSource();
	    
	    if(fuente == btnAceptar)
	    {
	        System.out.println("Agrega gatooo");
	    }
	}
	
	private int getIdAlumno()
	{
	    return idAlumno;
	}
	
	
	private void setIdAlumno(int idAlumno)
	{
	    this.idAlumno = idAlumno;
	}
	
	
	private String getNombre()
	{
	    return Nombre;
	}
	
	
	private void setNombre(String nombre)
	{
	    Nombre = nombre;
	}


}

package ar.com.dbgrid.vista;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


import ar.com.dbgrid.dao.FinalesDao;
import ar.com.dbgrid.modelo.ConversorResultSetADefaultTableModel;

public class FormularioFinales  extends JFrame  implements ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int idAlumno;
	private String nombre;
	private JTable table = new JTable();
    private JButton agregar = new JButton("Agregar Final");
    private JButton borrar = new JButton("Borrar Final");

    JComboBox<String> combo = new JComboBox<>();
    
	public FormularioFinales(int idAlumno, String nombre) 
	{
		
		this.idAlumno = idAlumno;
		this.setNombre(nombre);
		createUserInterface();
		DefaultTableModel modelo = new DefaultTableModel();
		FinalesDao finalesResultSet = new FinalesDao();
		ConversorResultSetADefaultTableModel.rellena(finalesResultSet.getAllFinlasByAlumno(this.idAlumno), modelo);
		this.table.setModel(modelo);
		
	}

	
	private void createUserInterface() 
	{
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.add(new JScrollPane(this.table));
		this.setTitle("Finales");
		
		JPanel datos = new JPanel();
		datos.add(new JLabel("Legajo: " + this.getIdAlumno() + " - " + this.getNombre()));
		this.add(datos, BorderLayout.NORTH);
		
	    JPanel operaciones = new JPanel();
	    
    	operaciones.add(new JLabel("Operaciones:"));
    	agregar.addActionListener(this);
    	borrar.addActionListener(this);
    	
    	/* Agrego los botones al Formulario */
    	operaciones.add(agregar);
    	operaciones.add(borrar);
    	this.add(operaciones, BorderLayout.SOUTH);
	    
		this.pack();
		this.setVisible(true);
	}
	
	public int getIdAlumno()
	{
		return idAlumno;
	}

	public void setIdAlumno(int idAlumno) 
	{
		this.idAlumno = idAlumno;
	}
	
    @Override
    public void actionPerformed(ActionEvent e)
    {
    	   Object fuente = e.getSource();
    	   
    	   if (fuente==agregar)
    	   {
    		   //JOptionPane.showMessageDialog(null, "Agregar");
    		   
    		   new FormularioAgregarFinal(idAlumno, nombre);
    	   }
    	   
    	   else if (fuente==borrar) 
    	   {
    		   
     		  if (this.table.getSelectedRowCount() == 1) 
     		  {
     			 if (JOptionPane.showConfirmDialog(null, "Seguro desea borrar el final?", "WARNING", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
     			 {
     				 FinalesDao  finales = new FinalesDao();
     				 DefaultTableModel modelo = (DefaultTableModel) this.table.getModel();
     				 int r = finales.borrarFinal(this.getIdAlumno(), (int)modelo.getValueAt(this.table.getSelectedRow(), 0), (BigDecimal)modelo.getValueAt(this.table.getSelectedRow(), 2));
     				 if (r==1) modelo.removeRow(this.table.getSelectedRow());
     			 }
    		  }
    
    	   }
    }


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}	
}

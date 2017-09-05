package ar.com.dbgrid.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;


public class ConversorResultSetACDefaultComboBox
{
    public static DefaultComboBoxModel<String> llenarCombo(final ResultSet rs, final DefaultComboBoxModel<String> modelo)
    {        
        try
        {
            while(rs.next())
            {
                modelo.addElement(rs.getString("DESCRIPCION"));
            }
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    	return modelo;
    }
}

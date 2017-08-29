package ar.com.dbgrid.modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;


public class ConversorResultSetACDefaultComboBox
{
    public static DefaultComboBoxModel<String> llenarCombo(final ResultSet rs, final DefaultComboBoxModel<String> modelo)
    {
        ArrayList<String> lista = new ArrayList<String>();
        listarElementos(rs, lista);
        
    	for (int i = 0; i < lista.size(); i++)
    	{
    		modelo.addElement(lista.get(i));
    	}
    	
    	return modelo;
    }
    
    private static ArrayList<String> listarElementos(ResultSet rs, ArrayList<String> lista)
    {
        try 
        {
            while(rs.next())
            {
                lista.add(rs.getString("DESCRIPCION"));
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return lista;
    }
    
    public static int IDCampo(ResultSet rs, String campo)
    {
        int id = 1;
        
        try
        {
            while(rs.next())
            {
                if(rs.getString(2).equals(campo))
                {
                    return id;
                }
                else
                {
                    id++;
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return id;
    }
    
    public static int contarElementos(final ResultSet rs)
    {
        int cont = 0;
        
        try
        {
            while (rs.next())
            {
                cont++;
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return cont;
    }
}

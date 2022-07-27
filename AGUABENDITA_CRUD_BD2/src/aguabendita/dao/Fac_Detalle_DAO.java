
package aguabendita.dao;

import aguabendita.entity.Fac_Detalle;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

//Data acces objet
public class Fac_Detalle_DAO {
    
    private String mensaje="";

    public String eliminarFacturaDetalleSQL(Connection con, int id){
        
        
        PreparedStatement pst = null;
        String sql = "DELETE FROM FAC_DETALLE WHERE ID_FAC_DETALLE = ? ";
        
        try {
            //Prepara la consulta sql
            pst = con.prepareStatement(sql);
            //Asigna los valores en el script provenientes de el objeto factura fac
            pst.setInt(1, id);
            //Se ejecuta el script
            pst.execute();
            pst.close();
            
            mensaje="Eliminado correctamente";
            
        } catch (Exception e) {
            mensaje="No se pudo eliminar correctamente /n"+e.getMessage();
        }
        return mensaje;
    }
    
    public void listarFacturaDetalle(Connection con,JTable tabla ){
        DefaultTableModel modelo;
        String [] columnas = {"FK_ENCABEZADO","ID","FK_BEBIDA","CANTIDAD","FK_PROMO","TOTAL"};
        modelo = new DefaultTableModel(null,columnas);
        
        String sql = "SELECT FK_ENCABEZADO,ID_FAC_DETALLE,FK_BEBIDA,CANTIDAD,FK_PROMOCION,TOTAL FROM FAC_DETALLE ORDER BY ID_FAC_DETALLE";
        
        String[] filas = new String[6];
        Statement st = null;
        ResultSet rs = null;
        try {
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {                
                for (int i = 0; i < 6; i++) {
                    filas[i] = rs.getString(i+1);
                }
                modelo.addRow(filas);
            }
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puede mostrar la tabla");
        }
    }
    
    public int getMaxID(Connection con){
        int id=0;
        PreparedStatement pst = null;
        ResultSet rs = null;
        String sql = "SELECT MAX(ID_FAC_DETALLE)+1 FROM FAC_DETALLE";
        try {
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                id=rs.getInt(1);
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Error al mostrar el id maximo "+e.getMessage());
        }
        return id;
    }

    public String agregarFacturaDetalle(Connection con, Fac_Detalle fac){
            
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
            int max = getMaxID(con);
            // PreparedStatement pst = null;
        
        try {
            //Prepara la consulta sql
            CallableStatement sql = con.prepareCall("{CALL SP_INSERTAR_FAC_DETALLE (?,?,?,?,?,?)}");

            //Asigna los valores en el script provenientes de el objeto factura fac
            sql.setInt(1, max);
            sql.setInt(2, fac.getCantidad());
            sql.setDouble(3, fac.getTotal());
            sql.setInt(4, fac.getFk_Encabezado());
            sql.setInt(5, fac.getFk_bebida());
            sql.setInt(6, fac.getFk_promocion());
            
            //Se ejecuta el script
            sql.execute();
            sql.close();
            
                mensaje="Guardado correctamente con sp";

        } catch (SQLException e) {
            mensaje="No se pudo guardar correctamente /n"+e.getMessage();
        }
        
        return mensaje;
    }
    
    public String modificarFacturaDetalle(Connection con, Fac_Detalle fac){

        BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            //Prepara la consulta sql
            CallableStatement sql = con.prepareCall("{CALL SP_ACTUALIZAR_FAC_DETALLEP(?,?,?)}");
            //Asigna los valores en el script provenientes de el objeto factura fac
            sql.setInt(1, fac.getIdFac_Detalle());
            sql.setInt(2, fac.getCantidad());
            sql.setDouble(3, fac.getTotal());

            //Se ejecuta el script
            sql.executeQuery();
            sql.close();
            
             mensaje="Modificado correctamente";
            
        } catch (Exception e) {
            mensaje="No se pudo modificar correctamente /n"+e.getMessage();
        }
        return mensaje;
    }

    public String eliminarFacturaDetalle(Connection con, int id){
        
         BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            //Prepara la consulta sql
            CallableStatement sql = con.prepareCall("{CALL SP_ELIMINAR_FAC_DETALLE(?)}");
            //Asigna los valores en el script provenientes de el objeto factura fac
            sql.setInt(1, id);

            //Se ejecuta el script
            sql.executeQuery();
            sql.close();
            
            mensaje="Eliminado correctamente";
            
        } catch (Exception e) {
            mensaje="No se pudo eliminar correctamente /n"+e.getMessage();
        }
        return mensaje;
    }
    


}

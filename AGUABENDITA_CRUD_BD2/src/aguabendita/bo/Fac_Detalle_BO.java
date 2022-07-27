
package aguabendita.bo;

import aguabendita.dao.Fac_Detalle_DAO;
import aguabendita.db.Conexion;
import aguabendita.entity.Fac_Detalle;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

//
public class Fac_Detalle_BO {
    
    private String mensaje = "";
    private Fac_Detalle_DAO fdao = new Fac_Detalle_DAO();
    
    public String agregarFacturaDetalle(Fac_Detalle fac){
        Connection con = Conexion.getConnection();
        try {
            mensaje = fdao.agregarFacturaDetalle(con, fac);
            //con.rollback();
        } catch (Exception e) {
            mensaje = mensaje +" "+ e.getMessage();
        }finally{
            try {
                if (con!=null) {
                    con.close();
                }
            } catch (SQLException e) {
                 mensaje = mensaje +" "+ e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String modificarFacturaDetalle(Fac_Detalle fac){
        Connection conn = Conexion.getConnection();
        try {
            mensaje = fdao.modificarFacturaDetalle(conn, fac);
            //conn.rollback();
        } catch (Exception e) {
            mensaje = mensaje +" "+ e.getMessage();
        }finally{
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                 mensaje = mensaje +" "+ e.getMessage();
            }
        }
        return mensaje;
    }
    
    public String eliminarFacturaDetalle(int id){
          Connection conn = Conexion.getConnection();
        try {
            mensaje = fdao.eliminarFacturaDetalle(conn, id);
           // conn.rollback();
        } catch (Exception e) {
            mensaje = mensaje +" "+ e.getMessage();
        }finally{
            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                 mensaje = mensaje +" "+ e.getMessage();
            }
        }
        return mensaje;
    }
    
    public void listarFacturaDetalle(JTable tabla){
        Connection con = Conexion.getConnection();
        fdao.listarFacturaDetalle(con, tabla);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public int getMaxID(){
        Connection con = Conexion.getConnection();
        int id = fdao.getMaxID(con);
        try {
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return id;
    
    }

}

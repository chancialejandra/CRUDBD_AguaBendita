
package aguabendita.test;

import aguabendita.bo.Fac_Detalle_BO;
import aguabendita.entity.Fac_Detalle;
import aguabendita.view.formFacDetalle;

public class Test {
    Fac_Detalle_BO fbo = new Fac_Detalle_BO();
    Fac_Detalle fac = new Fac_Detalle();
    String mensaje ="";
    
    
    public void testInsertar(){
        fac.setCantidad(1);
        fac.setTotal(5);
        fac.setFk_Encabezado(1);
        fac.setFk_bebida(1);
        fac.setFk_promocion(1);
        mensaje = fbo.agregarFacturaDetalle(fac);
        System.out.println(mensaje);
    }
    
    public void testModificar(int n){
        fac.setIdFac_Detalle(n);
        fac.setCantidad(1);
        fac.setTotal(5);
        fac.setFk_Encabezado(1);
        fac.setFk_bebida(1);
        fac.setFk_promocion(1);
        mensaje = fbo.modificarFacturaDetalle(fac);
        System.out.println(mensaje);
        
    }
    
    public void testEliminar(int n){
        mensaje = fbo.eliminarFacturaDetalle(n);
        System.out.println(mensaje);
    }
    
    public static void main(String[] args) {
        formFacDetalle form = new formFacDetalle();
        form.setVisible(true);
                
    }
    
}

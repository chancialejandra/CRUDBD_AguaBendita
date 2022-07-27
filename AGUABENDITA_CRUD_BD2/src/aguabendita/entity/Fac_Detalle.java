
package aguabendita.entity;


public class Fac_Detalle {
 
    private int idFac_Detalle;
    private int cantidad;
    private double total;
    private int fk_Encabezado;
    private int fk_bebida;
    private int fk_promocion;

    public Fac_Detalle() {
    }

    public Fac_Detalle(int idFac_Detalle, int cantidad, double total, int fk_Encabezado, int fk_bebida, int fk_promocion) {
        this.idFac_Detalle = idFac_Detalle;
        this.cantidad = cantidad;
        this.total = total;
        this.fk_Encabezado = fk_Encabezado;
        this.fk_bebida = fk_bebida;
        this.fk_promocion = fk_promocion;
    }

    public int getIdFac_Detalle() {
        return idFac_Detalle;
    }

    public void setIdFac_Detalle(int idFac_Detalle) {
        this.idFac_Detalle = idFac_Detalle;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getFk_Encabezado() {
        return fk_Encabezado;
    }

    public void setFk_Encabezado(int fk_Encabezado) {
        this.fk_Encabezado = fk_Encabezado;
    }

    public int getFk_bebida() {
        return fk_bebida;
    }

    public void setFk_bebida(int fk_bebida) {
        this.fk_bebida = fk_bebida;
    }

    public int getFk_promocion() {
        return fk_promocion;
    }

    public void setFk_promocion(int fk_promocion) {
        this.fk_promocion = fk_promocion;
    }

    @Override
    public String toString() {
        return "Fac_Detalle{" + "idFac_Detalle=" + idFac_Detalle + ", cantidad=" + cantidad + ", total=" + total + ", fk_Encabezado=" + fk_Encabezado + ", fk_bebida=" + fk_bebida + ", fk_promocion=" + fk_promocion + '}';
    }

    
    
}

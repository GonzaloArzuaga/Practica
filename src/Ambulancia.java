public class Ambulancia  implements Recurso{
    private double facturacion;
    private int tiempoRespuestaMinutos;

    public Ambulancia(double facturacion, int tiempoRespuestaMinutos) {
        this.facturacion = facturacion;
        this.tiempoRespuestaMinutos = tiempoRespuestaMinutos;
    }

    public double getFacturacion() {
        return facturacion;
    }

    public void setFacturacion(double facturacion) {
        this.facturacion = facturacion;
    }

    public int getTiempoRespuestaMinutos() {
        return tiempoRespuestaMinutos;
    }

    public void setTiempoRespuestaMinutos(int tiempoRespuestaMinutos) {
        this.tiempoRespuestaMinutos = tiempoRespuestaMinutos;
    }

    @Override
    public double calculaCosto(){

        if (tiempoRespuestaMinutos>=50) {
            return facturacion = facturacion / 2;
        }else {
            return facturacion;
        }
    }
    @Override
    public String toString() {
        return "Ambulancia: "+"facturacion=" + facturacion ;
    }
}


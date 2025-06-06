public class Bombero implements Recurso{
    private double facturacion;
    private int tiempoRespuestaMinutos;

    public Bombero(double facturacion, int tiempoRespuestaMinutos) {
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
            return  facturacion / 2;
        }else {
            return facturacion;
        }
    }
    @Override
    public String toString() {
        return "Bombero: "+"facturacion=" + facturacion ;
    }
}

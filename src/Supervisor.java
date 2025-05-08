public class Supervisor extends Persona {
    private double facturacionTotal;
    private int resultadoAuditoriaTiempos;

    public Supervisor(String nombre, String apellido, long dni, double facturacionTotal, int resultadoAuditoriaTiempos) {
        super(nombre, apellido, dni);
        this.facturacionTotal = facturacionTotal;
        this.resultadoAuditoriaTiempos = resultadoAuditoriaTiempos;
    }

    public double getFacturacionTotal() {
        return facturacionTotal;
    }

    public void setFacturacionTotal(double facturacionTotal) {
        this.facturacionTotal = facturacionTotal;
    }

    public int getResultadoAuditoriaTiempos() {
        return resultadoAuditoriaTiempos;
    }

    public void setResultadoAuditoriaTiempos(int resultadoAuditoriaTiempos) {
        this.resultadoAuditoriaTiempos = resultadoAuditoriaTiempos;
    }

    public double calculaCostoTotalMensual(Recurso recurso){
        if (recurso instanceof Ambulancia) {
            Ambulancia a = (Ambulancia) recurso;
            facturacionTotal += a.getFacturacion();
        } else if (recurso instanceof Bombero) {
            Bombero b = (Bombero) recurso;
            facturacionTotal += b.getFacturacion();
        } else if (recurso instanceof Policia) {
            Policia p = (Policia) recurso;
            facturacionTotal += p.getFacturacion();
        }
        return facturacionTotal;
    }

    public void tiemposAltos(Recurso recurso) {
        int tiempo = -1;
        if (recurso instanceof Ambulancia) {
            Ambulancia a = (Ambulancia) recurso;
            tiempo = a.getTiempoRespuestaMinutos();
        } else if (recurso instanceof Bombero) {
            Bombero b = (Bombero) recurso;
            tiempo = b.getTiempoRespuestaMinutos();
        } else if (recurso instanceof Policia) {
            Policia p = (Policia) recurso;
            tiempo = p.getTiempoRespuestaMinutos();
        }
        if (tiempo >= 50) {
            System.out.println("Tiempo de respuesta alto: " + tiempo + " minutos.");
            resultadoAuditoriaTiempos+=tiempo;
        }
        System.out.println("Tiempo total de tiempos con tardanza de mayor a 50 min: "+resultadoAuditoriaTiempos);
    }

}

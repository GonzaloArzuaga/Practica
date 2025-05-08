import java.util.ArrayList;

public class Usuario extends Persona{
    private String obraSocial;
    private ArrayList<Recurso>  recurso;
    private double facturaUsuario;

    public Usuario(String nombre, String apellido, long dni, String obraSocial, ArrayList<Recurso> recurso, double facturaUsuario) {
        super(nombre, apellido, dni);
        this.obraSocial = obraSocial;
        this.recurso = recurso;
        this.facturaUsuario = facturaUsuario;
    }

    public String getObraSocial() {
        return obraSocial;
    }

    public void setObraSocial(String obraSocial) {
        this.obraSocial = obraSocial;
    }

    public ArrayList<Recurso> getRecurso() {
        return recurso;
    }

    public void setRecurso(ArrayList<Recurso> recurso) {
        this.recurso = recurso;
    }

    public double getFacturaUsuario() {
        return facturaUsuario;
    }

    public void setFacturaUsuario(double facturaUsuario) {
        this.facturaUsuario = facturaUsuario;
    }


    @Override
    public String toString() {
        return "Usuario:" +
                "obraSocial='" + obraSocial +
                " recurso=" + recurso +
                " facturaUsuario=" + facturaUsuario;
    }
}

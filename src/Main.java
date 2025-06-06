<<<<<<< HEAD
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static Connection conectarBD(String bd){
        Connection conexion;
        String host = "jdbc:mysql:// url del host" ;
        String user = "root";
        String pass = "";


        System.out.println("Conectando...");

        try {
            conexion = DriverManager.getConnection(host+bd, user, pass);
            System.out.println("Conexion Exitosa");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }

        return conexion;
    }

    public static void desconectarBD(Connection cb){
        try {
            cb.close();
            System.out.println("Desconectado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //metodo que se encarga de la conexion a la base de datos  
        Connection bd = conectarBD("prueba");
        //metodo que hace la desconexion con la base de datos
        desconectarBD(bd);

        Hilo hilo0 = new Hilo("Gonzalo");
        Hilo hilo1 = new Hilo("ComandoCloud");
        Hilo hilo2 = new Hilo("Copy&&Paste");
        Hilo hilo3 = new Hilo("David");

        //los hilos comienzan a ejecutarse
        hilo0.start();
        hilo1.start();
        hilo2.start();
        hilo3.start();

        //se interrumpe para demostrar su excepcion
        hilo3.interrupt();

        //el hilo principal espera la finalizacion de los hilos
        hilo0.join();
        hilo1.join();
        hilo2.join();
        hilo3.join();

        System.out.println("\nAqui finaliza el programa");



    }
}
=======
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int tiempoRespuestaMinutos=0;
        double facturaUsuario=0;
        ArrayList<Recurso> recursos = new ArrayList<>();

        Usuario usuario=new Usuario("gonzalo","arzuaga", 44934841, "IOMA", recursos, facturaUsuario);
        Usuario usuario1=new Usuario("gonzalo","arzuaga", 44934841, null, recursos, facturaUsuario);

        //Agreagado de Emergencias
        int tipo=4;

        Scanner leer = new Scanner(System.in);


        do{
            System.out.println("[1]- Ambulancia \n[2]- Policia \n[3]- Bombero\n[0]- Salir\nIngrese el tipo de emergencia:");
            tipo=leer.nextInt();
            System.out.println("Ingrese el tiempo de respuesta:");
            tiempoRespuestaMinutos=leer.nextInt();

            if(tipo ==1){
                recursos.add(new Ambulancia(5000, tiempoRespuestaMinutos));
            } else if (tipo==2) {
                recursos.add(new Policia(500, tiempoRespuestaMinutos));
            } else if (tipo==3) {
                recursos.add(new Bombero(600, tiempoRespuestaMinutos)) ;
            }
        }while (tipo!=0);

        //guarda los servicios utilizados
        usuario.setRecurso(recursos);
        usuario1.setRecurso(recursos);

        Supervisor supervisor= new Supervisor("naza","andrade", 12345678, 0, 0);

        //Etapa de Factura Final
        double totalFactura = 0;

        for (Recurso r : usuario.getRecurso()) {
            double costo = r.calculaCosto();

            if (r instanceof Ambulancia) {
                // ejemplo: descuento si tiene obra social
                if (usuario.getObraSocial()==null) {
                    costo+=1000;
                    System.out.println("Ambulancia usada. Costo: " + costo);
                }else {
                    System.out.println("Ambulancia usada. Costo: " + costo);
                }
            } else if (r instanceof Policia) {
                System.out.println("Policía usada. Costo: " + costo);
            } else if (r instanceof Bombero) {
                System.out.println("Bombero usado. Costo: " + costo);
            }

            totalFactura += costo;
            supervisor.calculaCostoTotalMensual(r);
            supervisor.tiemposAltos(r);
        }
        usuario.setFacturaUsuario(totalFactura);
        System.out.println(usuario.toString());
        System.out.println("Factura total del usuario: $" + usuario.getFacturaUsuario());

    }
}
//i. Si es Ambulancia: $5000
//ii. Si es Policia: $500
//iii. Si es Bombero: $600
>>>>>>> e99a90758a39bc4ac5cba76288f5348ab106a643

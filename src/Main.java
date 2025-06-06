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
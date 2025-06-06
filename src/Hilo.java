public class Hilo  extends Thread{

    private String nombre;

    public Hilo(String nombre) {
        this.nombre = nombre;
    }

    public void run() {
        System.out.println("Cargando...");
        try {
            int x = (int)(Math.random()*5000);
            Thread.sleep(x);
            System.out.println("Soy: "+nombre+"("+x+")");
        }
        catch(Exception ex)
        {
            System.out.println("\n"+getName()+" se interrumpio");
        }
    }
}

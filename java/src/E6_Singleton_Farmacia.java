   
class RegistroOperacionesFarmacia {

    // Variable que almacena la unica instancia
    private static RegistroOperacionesFarmacia instancia;

    // Constructor privado
    private RegistroOperacionesFarmacia() {
        System.out.println("Registro de farmacia inicializado.");
    }

    // Metodo para obtener la instancia unica
    public static synchronized RegistroOperacionesFarmacia getInstance() {
        if (instancia == null) {
            instancia = new RegistroOperacionesFarmacia();
        }
        return instancia;
    }

    // Registrar operaciones
    public void registrarOperacion(String descripcion) {
        System.out.println("Operacion registrada: " + descripcion);
    }
}


// PROGRAMA PRINCIPAL
public class E6_Singleton_Farmacia {

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println(" PATRON SINGLETON - FARMACIA");
        System.out.println(" EQUIPO N°2");
        System.out.println("================================");

        // Primera llamada
        RegistroOperacionesFarmacia registro1 =
                RegistroOperacionesFarmacia.getInstance();

        // Segunda llamada
        RegistroOperacionesFarmacia registro2 =
                RegistroOperacionesFarmacia.getInstance();

        // Demostrar que ambos son el mismo objeto
        System.out.println("\n¿Es el mismo objeto?");
        System.out.println(registro1 == registro2);

        // Registrar desde el primer objeto
        registro1.registrarOperacion("Ingreso de Paracetamol");
        registro1.registrarOperacion("Venta de Ibuprofeno");

        // Registrar desde el segundo objeto
        registro2.registrarOperacion("Actualizacion de inventario");
    }
}



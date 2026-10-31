
import java.util.ArrayList;
import java.util.List;

// ======================================
// CLASE PADRE
// ======================================

abstract class MedicamentoFarmaceutico {

    protected String codigo;
    protected String nombre;
    protected double precio;

    public MedicamentoFarmaceutico(
            String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public abstract void mostrarDetalle();
}


// ======================================
// SUBCLASE 1: GENERICO
// ======================================

class MedicamentoGenerico extends MedicamentoFarmaceutico {

    public MedicamentoGenerico(
            String codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Tipo: Medicamento Generico");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.printf("Precio: S/ %.2f%n", precio);
    }
}


// ======================================
// SUBCLASE 2: COMERCIAL
// ======================================

class MedicamentoComercial extends MedicamentoFarmaceutico {

    public MedicamentoComercial(
            String codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Tipo: Medicamento Comercial");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.printf("Precio: S/ %.2f%n", precio);
    }
}


// ======================================
// SUBCLASE 3: CONTROLADO
// ======================================

class MedicamentoControlado extends MedicamentoFarmaceutico {

    public MedicamentoControlado(
            String codigo, String nombre, double precio) {
        super(codigo, nombre, precio);
    }

    @Override
    public void mostrarDetalle() {
        System.out.println("Tipo: Medicamento Controlado");
        System.out.println("Codigo: " + codigo);
        System.out.println("Nombre: " + nombre);
        System.out.printf("Precio: S/ %.2f%n", precio);
        System.out.println("Requiere receta medica.");
    }
}


// ======================================
// CREADOR ABSTRACTO
// ======================================

abstract class CreadorMedicamentos {

    public abstract MedicamentoFarmaceutico crearMedicamento(
            String tipo, String codigo, String nombre, double precio);
}


// ======================================
// FACTORY METHOD
// ======================================

class FarmaciaFactory extends CreadorMedicamentos {

    @Override
    public MedicamentoFarmaceutico crearMedicamento(
            String tipo, String codigo, String nombre, double precio) {

        switch (tipo.toLowerCase()) {

            case "generico":
                return new MedicamentoGenerico(codigo, nombre, precio);

            case "comercial":
                return new MedicamentoComercial(codigo, nombre, precio);

            case "controlado":
                return new MedicamentoControlado(codigo, nombre, precio);

            default:
                throw new IllegalArgumentException(
                        "Tipo de medicamento no disponible: " + tipo);
        }
    }
}


// ======================================
// PROGRAMA PRINCIPAL
// ======================================

public class E7_FactoryMethod_Farmacia {

    public static void main(String[] args) {

        System.out.println("==================================");
        System.out.println(" FACTORY METHOD - FARMACIA");
        System.out.println(" EQUIPO N°2");
        System.out.println("==================================");

        // Crear la fabrica
        CreadorMedicamentos fabrica = new FarmaciaFactory();

        // El programa principal solicita los objetos a la fabrica
        List<MedicamentoFarmaceutico> medicamentos = new ArrayList<>();

        medicamentos.add(fabrica.crearMedicamento(
                "generico", "MED-001", "Paracetamol", 12.50));

        medicamentos.add(fabrica.crearMedicamento(
                "comercial", "MED-002", "Panadol", 18.00));

        medicamentos.add(fabrica.crearMedicamento(
                "controlado", "MED-003", "Medicamento Especial", 25.00));

        // Recorrer y mostrar los medicamentos
        System.out.println("\n===== MEDICAMENTOS CREADOS =====");

        for (MedicamentoFarmaceutico medicamento : medicamentos) {
            System.out.println("\n------------------------------");
            medicamento.mostrarDetalle();
        }

        System.out.println("\nTotal de medicamentos creados: "
                + medicamentos.size());
    }
}

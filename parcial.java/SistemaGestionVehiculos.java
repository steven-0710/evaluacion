import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//-- abstraccion -> harold :b

abstract class Vehiculo {
   

//-- encapsulamiento    
    private String placa;
    private String marca;
    private int modelo;
    private double precioBase;

  
//-- constructor
    public Vehiculo(String placa, String marca, int modelo, double precioBase) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.precioBase = precioBase;
    }


    // Métodos getters y setters
    public String getPlaca() { return placa; }
    public String getMarca() { return marca; }
    public int getModelo() { return modelo; }
    public double getPrecioBase() { return precioBase; }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

// -- abstarccion

    public abstract double calcularCostoMantenimiento();
//-- polimorfismo clase padre

    public void mostrarInformacion() {
        System.out.println("Placa: " + placa);
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Precio Base: $" + precioBase);
    }
}
// -- herencia clase hija: carro

class Carro extends Vehiculo {
    private int puertas;

    public Carro(String placa, String marca, int modelo, double precioBase, int puertas) {
        super(placa, marca, modelo, precioBase);
        this.puertas = puertas;
    }

    @Override
    public double calcularCostoMantenimiento() {
        return getPrecioBase() * 0.05;
    }


    @Override
    public void mostrarInformacion() {
        System.out.println("\n--- Carro ---");
        super.mostrarInformacion();
        System.out.println("Puertas: " + puertas);
        System.out.println("Costo Mantenimiento: $" + calcularCostoMantenimiento());
    }
}
//--herencia clase hija:moto

class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String placa, String marca, int modelo, double precioBase, int cilindrada) {
        super(placa, marca, modelo, precioBase);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularCostoMantenimiento() {
        return getPrecioBase() * 0.03;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("\n--- Moto ---");
        super.mostrarInformacion();
        System.out.println("Cilindrada: " + cilindrada + "cc");
        System.out.println("Costo Mantenimiento: $" + calcularCostoMantenimiento());
    }
}
 //--herencia clase hija:camion

class Camion extends Vehiculo {
    private double capacidadToneladas;

    public Camion(String placa, String marca, int modelo, double precioBase, double capacidadToneladas) {
        super(placa, marca, modelo, precioBase);
        this.capacidadToneladas = capacidadToneladas;
    }
// -- clase hija 
    @Override
    public double calcularCostoMantenimiento() {
        return getPrecioBase() * 0.08;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("\n--- Camión ---");
        super.mostrarInformacion();
        System.out.println("Capacidad: " + capacidadToneladas + " Toneladas");
        System.out.println("Costo Mantenimiento: $" + calcularCostoMantenimiento());
    }
}

//--abstraccion y encapsulamineto

class GestionVehiculos {
    private List<Vehiculo> listaVehiculos = new ArrayList<>();

    public void agregarVehiculo(Vehiculo v) {
        listaVehiculos.add(v);
        System.out.println("Vehículo agregado exitosamente: " + v.getPlaca());
    }

    public void mostrarVehiculos() {
        if (listaVehiculos.isEmpty()) {
            System.out.println("No hay vehículos registrados.");
        } else {
            for (Vehiculo v : listaVehiculos) {
                v.mostrarInformacion(); 
            }
        }
    }

    public Vehiculo buscarVehiculo(String placa) {
        for (Vehiculo v : listaVehiculos) {
            if (v.getPlaca().equalsIgnoreCase(placa)) {
                return v;
            }
        }
        return null;
    }

    public void eliminarVehiculo(String placa) {
        Vehiculo v = buscarVehiculo(placa);
        if (v != null) {
            listaVehiculos.remove(v);
            System.out.println("Vehículo eliminado con éxito: " + placa);
        } else {
            System.out.println("No se encontró el vehículo con placa: " + placa);
        }
    }
}

public class SistemaGestionVehiculos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestionVehiculos sistema = new GestionVehiculos();
        int opcion;

        do {
            System.out.println("\n====== MENÚ DE GESTIÓN DE VEHÍCULOS ======");
            System.out.println("1. Agregar Carro");
            System.out.println("2. Agregar Moto");
            System.out.println("3. Agregar Camión");
            System.out.println("4. Mostrar todos los vehículos");
            System.out.println("5. Eliminar vehículo por placa");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print("Placa: "); String placaC = sc.nextLine();
                    System.out.print("Marca: "); String marcaC = sc.nextLine();
                    System.out.print("Modelo: "); int modeloC = sc.nextInt();
                    System.out.print("Precio Base: "); double precioC = sc.nextDouble();
                    System.out.print("Número de puertas: "); int puertas = sc.nextInt();
                    sistema.agregarVehiculo(new Carro(placaC, marcaC, modeloC, precioC, puertas));
                    break;

                case 2:
                    System.out.print("Placa: "); String placaM = sc.nextLine();
                    System.out.print("Marca: "); String marcaM = sc.nextLine();
                    System.out.print("Modelo: "); int modeloM = sc.nextInt();
                    System.out.print("Precio Base: "); double precioM = sc.nextDouble();
                    System.out.print("Cilindrada (cc): "); int cil = sc.nextInt();
                    sistema.agregarVehiculo(new Moto(placaM, marcaM, modeloM, precioM, cil));
                    break;

                case 3:
                    System.out.print("Placa: "); String placaCa = sc.nextLine();
                    System.out.print("Marca: "); String marcaCa = sc.nextLine();
                    System.out.print("Modelo: "); int modeloCa = sc.nextInt();
                    System.out.print("Precio Base: "); double precioCa = sc.nextDouble();
                    System.out.print("Capacidad (toneladas): "); double ton = sc.nextDouble();
                    sistema.agregarVehiculo(new Camion(placaCa, marcaCa, modeloCa, precioCa, ton));
                    break;

                case 4:
                    sistema.mostrarVehiculos();
                    break;

                case 5:
                    System.out.print("Ingrese la placa del vehículo a eliminar: ");
                    String placaE = sc.nextLine();
                    sistema.eliminarVehiculo(placaE);
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción no válida.");
                    break;
            }

        } while (opcion != 0);

        sc.close();
    }
}
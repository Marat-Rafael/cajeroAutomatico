package eu.cifpfbmoll.cajeroautomatico;

import static eu.cifpfbmoll.cajeroautomatico.TarjetaDebito.sc;
import java.util.ArrayList;

/**
 *
 * @author Marat Rafael
 */
public abstract class Tarjeta {

    //ATRIBUTOS
    private String nifCliente;
    private String pinCliente;
    private String nombreCliente;
    private String apellidoCliente;

    //CONSTRUCTORES
    //constructor vacio
    public Tarjeta() {
    }

    //constructor con todos atributos
    public Tarjeta(String nifCliente, String pinCliente, String nombreCliente, String apellidoCliente) {
        this.nifCliente = nifCliente;
        this.pinCliente = pinCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }
    //constructor copia

    public Tarjeta(Tarjeta tarjeta) {
        this.nifCliente = tarjeta.nifCliente;
        this.pinCliente = tarjeta.pinCliente;
        this.nombreCliente = tarjeta.nombreCliente;
        this.apellidoCliente = tarjeta.apellidoCliente;
    }

    // GETTER/SETTER
    public String getNifCliente() {
        return nifCliente;
    }

    public String getPinCliente() {
        return pinCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "nifCliente=" + nifCliente + ", pinCliente=" + pinCliente + ", nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + '}';
    }

    public String mostrarTarjeta() {
        String texto = " Nombre cliente: " + this.nombreCliente + "\n Apellido cliente: " + this.getApellidoCliente() + "\n NIF cliente: " + this.getNifCliente();
        return texto;
    }

    public static int comprobarCliente(ArrayList<Tarjeta> listaTarjetas) {

        int posicionCliente = -1;
        boolean confirmadoPin = false;
        boolean confirmadoNif = false;
        System.out.println("Escribe NIF por favor: ");
        String nifComprobar = sc.nextLine();
        System.out.println("Escribe PIN por favor: ");
        String pinComprobar = sc.nextLine();

        for (int i = 0; i < listaTarjetas.size(); i++) {
            if (listaTarjetas.get(i).getNifCliente().equals(nifComprobar)) {
                posicionCliente = i;
                confirmadoNif = true;
            }
            if (listaTarjetas.get(i).getPinCliente().equals(pinComprobar)) {
                confirmadoPin = true;
            }
        }
        if (!confirmadoNif) {
            System.out.println("NIF incorrecto");
            posicionCliente = -1;
        }
        if (!confirmadoPin) {
            System.out.println("PIN incorrecto");
            posicionCliente = -1;
        }
        return posicionCliente;
    }// fin metodo confirmarCliente

    public static double sacarDinero(CajeroAutomatico cajeroAutomatico) {
        double totalDisponible = cajeroAutomatico.dineroDisponible(cajeroAutomatico.getBilletes());
        ArrayList<Tarjeta> listaTarjetas = cajeroAutomatico.getListaTarjetas();

        double dineroSacar = 0;
        int posicionCliente = Tarjeta.comprobarCliente(listaTarjetas);

        if (posicionCliente != -1) {

            if (listaTarjetas.get(posicionCliente) instanceof TarjetaDebito) {
                System.out.println(((TarjetaDebito) (listaTarjetas.get(posicionCliente))).mostrarTarjeta());
                TarjetaDebito tarjetaActual = (TarjetaDebito) listaTarjetas.get(posicionCliente);

                System.out.println("Cuanto dinero desea sacar ? ");
                dineroSacar = sc.nextDouble();
                sc.nextLine();

                if (dineroSacar > totalDisponible) {
                    System.out.println("Cajero automatico no dispone de esta cantidad de dinero");

                }

                if (tarjetaActual.getSaldoDisponible() - dineroSacar < 0) {
                    System.out.println("No tiene saldo suficiente");
                } else {
                    tarjetaActual.setSaldoDisponible(tarjetaActual.getSaldoDisponible() - dineroSacar);
                    System.out.print("Saldo actual es: ");
                    System.out.println(tarjetaActual.getSaldoDisponible());
                }

            }
            if (listaTarjetas.get(posicionCliente) instanceof TarjetaCredito) {
                System.out.println(((TarjetaCredito) (listaTarjetas.get(posicionCliente))).mostrarTarjeta());
                TarjetaCredito tarjetaActual = (TarjetaCredito) listaTarjetas.get(posicionCliente);

                System.out.println("Cuanto dinero desea sacar ? ");
                dineroSacar = sc.nextDouble();
                sc.nextLine();

                if (dineroSacar > totalDisponible) {
                    System.out.println("Cajero automatico no dispone de esta cantidad de dinero");

                }

                if (dineroSacar > tarjetaActual.getSaldoDisponible() + tarjetaActual.getCreditoDisponible()) {
                    System.out.println("No puede sacar este cantidad de dinero");
                    System.out.println("Saldo: " + tarjetaActual.getSaldoDisponible());
                    System.out.println("Credito: " + tarjetaActual.getCreditoDisponible());
                    //System.out.println("Como maximo puede sacar: " + tarjetaActual.getSaldoDisponible() + tarjetaActual.getCreditoDisponible());

                } else if (dineroSacar < tarjetaActual.getSaldoDisponible()) {
                    tarjetaActual.setSaldoDisponible(tarjetaActual.getSaldoDisponible() - dineroSacar);
                    System.out.println("Saldo: " + tarjetaActual.getSaldoDisponible());
                    System.out.println("Credito: " + tarjetaActual.getCreditoDisponible());

                } else if (dineroSacar > tarjetaActual.getSaldoDisponible()
                        && dineroSacar < (tarjetaActual.getSaldoDisponible() + tarjetaActual.getCreditoDisponible())) {

                    tarjetaActual.setSaldoDisponible(0);
                    tarjetaActual.setCreditoDisponible(tarjetaActual.getCreditoDisponible() - (dineroSacar - tarjetaActual.getSaldoDisponible()));
                    System.out.println("Saldo: " + tarjetaActual.getSaldoDisponible());
                    System.out.println("Credito: " + tarjetaActual.getCreditoDisponible());
                }
            }
        }

        return dineroSacar;
    }// fin metodo sacarDinero

}

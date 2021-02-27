package eu.cifpfbmoll.cajeroautomatico;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marat Rafael
 */
public class TarjetaDebito extends Tarjeta {

    public static Scanner sc = new Scanner(System.in);
    // ATRIBUTO
    private double saldoDisponible;

    // CONSTRUCTORES
    // constructor vacio
    public TarjetaDebito() {
    }

    // constructor con todos atributos
    public TarjetaDebito(double saldoDisponible, String nifCliente, String pinCliente, String nombreCliente, String apellidoCliente) {
        super(nifCliente, pinCliente, nombreCliente, apellidoCliente);
        this.saldoDisponible = saldoDisponible;
    }

    //constructor copia
    public TarjetaDebito(TarjetaDebito tarjetaDebito) {
        super(tarjetaDebito.getNifCliente(), tarjetaDebito.getNifCliente(), tarjetaDebito.getNombreCliente(), tarjetaDebito.getApellidoCliente());
        this.saldoDisponible = tarjetaDebito.saldoDisponible;
    }
    // GETTER/SETTER

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    @Override
    public String toString() {
        return super.toString() + "TarjetaDebito{" + "saldoDisponible=" + saldoDisponible + '}';
    }

    @Override
    public String mostrarTarjeta() {
        String hr = "\n**********************************************************\n";
        return hr + super.mostrarTarjeta() + "\n Saldo: " + this.getSaldoDisponible() +hr;
    }


}

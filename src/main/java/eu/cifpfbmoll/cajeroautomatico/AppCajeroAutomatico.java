package eu.cifpfbmoll.cajeroautomatico;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Marat Rafael
 */
public class AppCajeroAutomatico {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        //public TarjetaDebito(double saldoDisponible, String nifCliente, String pinCliente, String nombreCliente, String apellidoCliente) {
        TarjetaCredito tarjeta1 = new TarjetaCredito(100, 0, "1452155g", "1111", "nom1", "appelid1");
        System.out.println(tarjeta1.mostrarTarjeta());

        CajeroAutomatico cajeroAutomatico = new CajeroAutomatico();

        int[][] cargaBilletes = {{500, 10}, {200, 0}, {100, 0}, {50, 27},
        {20, 0}, {10, 18}, {5, 25}};
        CajeroAutomatico micajero = new CajeroAutomatico();
        micajero.setBilletes(cargaBilletes);
        
        TarjetaDebito mitarj1 = new TarjetaDebito(10000,"111","1234", "Jorge", "Lorenzo");
        TarjetaCredito mitarj2 = new TarjetaCredito(5000,10000,"222","1234","Rafa", "Navidad");
        micajero.getListaTarjetas().add(mitarj1);
        micajero.getListaTarjetas().add(mitarj2);
        micajero.setBilletes(cargaBilletes);
        double t = micajero.dineroDisponible(cargaBilletes);
        System.out.println(t);

        cajeroAutomatico.mostrarCajero();

        menuPrincipal(micajero);

    }

    public static void menuPrincipal(CajeroAutomatico cajeroAutomatico) {
        boolean salirMenu = false;
        byte opcion;

        do {
            System.out.println("*** CAJERO AUTOMATICO ****");
            System.out.println("1 - Sacar dinero");
            System.out.println("0 - Salir");
            System.out.println("***************************");
            opcion = sc.nextByte();
            sc.nextLine();
            switch (opcion) {

                case 1:
                    Tarjeta.sacarDinero(cajeroAutomatico);
                    break;
                case 2:
                    
                    break;
                case 0:
                    salirMenu = true;
                    break;
                default:
                    System.out.println("Opciones disponibles 1 y 0");
            }

        } while (!salirMenu);
    }

}

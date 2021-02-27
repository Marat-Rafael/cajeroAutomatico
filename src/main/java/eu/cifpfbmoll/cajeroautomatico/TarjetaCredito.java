package eu.cifpfbmoll.cajeroautomatico;

/**
 *
 * @author Marat Rafael
 */
public class TarjetaCredito extends Tarjeta {

    //ATRIBUTOS
    private double saldoDisponible;
    private double creditoDisponible;

    // CONSTRUCTORES
    // constructor vacio
    public TarjetaCredito() {
    }

    // constructor con todos atributos
    public TarjetaCredito(double saldoDisponible, double creditoDisponible, String nifCliente, String pinCliente, String nombreCliente, String apellidoCliente) {
        super(nifCliente, pinCliente, nombreCliente, apellidoCliente);
        this.saldoDisponible = saldoDisponible;
        this.creditoDisponible = creditoDisponible;
    }

    // constructor copia
    public TarjetaCredito(TarjetaCredito tarjetaCredito) {
        super(tarjetaCredito.getNifCliente(), tarjetaCredito.getPinCliente(), tarjetaCredito.getNombreCliente(), tarjetaCredito.getApellidoCliente());
        this.saldoDisponible = tarjetaCredito.saldoDisponible;
        this.creditoDisponible = tarjetaCredito.creditoDisponible;
    }
    // GETTER/SETTER

    public double getSaldoDisponible() {
        return saldoDisponible;
    }

    public void setSaldoDisponible(double saldoDisponible) {
        this.saldoDisponible = saldoDisponible;
    }

    public double getCreditoDisponible() {
        return creditoDisponible;
    }

    public void setCreditoDisponible(double creditoDisponible) {
        this.creditoDisponible = creditoDisponible;
    }

    @Override
    public String toString() {
        return  super.toString() +" TarjetaCredito{" + "saldoDisponible=" + saldoDisponible + ", creditoDisponible=" + creditoDisponible + '}';
    }

    @Override
    public String mostrarTarjeta() {
        String hr ="\n***********************************************************\n";
        return hr + super.mostrarTarjeta()+"\n Saldo: "+this.getSaldoDisponible() +"\n Credito: "+this.getCreditoDisponible()+hr;
    }
    
    

}

package eu.cifpfbmoll.cajeroautomatico;

import java.util.ArrayList;

/**
 *
 * @author Marat Rafael
 */
public class CajeroAutomatico {

    //ATRIBUTOS
    public int id = 0;
    private int numIDCajeroULT;
    private int numIdCajero = id;
    private int[][] billetes = {{500, 10}, {200, 0}, {100, 0}, {50, 30}, {20, 0}, {10, 20}, {5, 25}};
    private ArrayList <Tarjeta> listaTarjetas = new ArrayList();

    // CONSTRUCTORES
    // constructor vacio
    public CajeroAutomatico() {
    }

    // constructor con todos atributos
    public CajeroAutomatico(int numIDCajeroULT, ArrayList<Tarjeta> listaTarjetas) {
        this.numIDCajeroULT = numIDCajeroULT;
        this.listaTarjetas = listaTarjetas;
    }
    
    // constructor copia
    public CajeroAutomatico(CajeroAutomatico cajeroAutomatico) {
        this.numIDCajeroULT = cajeroAutomatico.numIDCajeroULT;
    }



    // GETTER/SETTER
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumIDCajeroULT() {
        return numIDCajeroULT;
    }

    public void setNumIDCajeroULT(int numIDCajeroULT) {
        this.numIDCajeroULT = numIDCajeroULT;
    }

    public int getNumIdCajero() {
        return numIdCajero;
    }

    public void setNumIdCajero(int numIdCajero) {
        this.numIdCajero = numIdCajero;
    }

    public int[][] getBilletes() {
        return billetes;
    }

    public void setBilletes(int[][] billetes) {
        this.billetes = billetes;
    }

    public ArrayList<Tarjeta> getListaTarjetas() {
        return listaTarjetas;
    }

    public void setListaTarjetas(ArrayList<Tarjeta> listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
    }

    @Override
    public String toString() {
        return "CajeroAutomatico{" + "id=" + id + ", numIDCajeroULT=" + numIDCajeroULT + ", numIdCajero=" + numIdCajero + ", billetes=" + billetes + ", listaTarjetas=" + listaTarjetas + '}';
    }
    

    // hay que repesar bidimensional array
    public void mostrarCajero() {
        for (int i = 0; i < this.getBilletes().length; i++) {
            System.out.println(this.getBilletes()[i][1] + " billetes de " + this.getBilletes()[i][0] + " euro");
        }
    }// fin meodo mostrarCajero
    
//  int[][] cargaBilletes = {{500, 10}, {200, 0}, {100, 0}, {50, 27},{20, 0}, {10, 18}, {5, 25}};
    public double dineroDisponible(int[][] array){
        double total=0;
        double mFila=0;
        for (int i = 0; i < array.length; i++) {
            total += mFila;
            for (int j = 0; j < array[0].length; j++) {
                mFila = array[i][0] *  array[i][1];          
            }
        }       
        return total;
    }// fin metodo dineroDisponible
    
    
}

import java.io.*;
import java.util.*;

public class GuardaOrden {
   private Vector data;
 private double orderTotal;
 
    public GuardaOrden(){
    data = new Vector();
  
    }

    public void agregar(Order camp){
    data.add(camp);
  }

  public Vector cargar() {
    return data;
  }
  public double getOrderTotal() {
        System.out.println(orderTotal);
        return orderTotal;
//    return orderTotal;
  }

    public void limpiar() {
        orderTotal = 0.0;
        System.out.println(orderTotal);
        System.out.println("limpiar");
    }
    void calculo(double orderAmount){

        System.out.println(orderTotal);
  System.out.println("llega1");
  orderTotal = orderTotal + orderAmount;

        System.out.println(orderTotal);
  }

  void calculo(double orderAmount, double dato2){

        System.out.println(orderTotal);
  System.out.println("llega2");
    orderTotal = orderTotal + orderAmount + dato2;

        System.out.println(orderTotal);
  }
  

}

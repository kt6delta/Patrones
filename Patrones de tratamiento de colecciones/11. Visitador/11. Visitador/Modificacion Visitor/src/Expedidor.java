/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maomolina
 */
public class Expedidor {
  private double orderTotal;

  Expedidor() {
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

   
    public double getOrderTotal() {
        System.out.println(orderTotal);
        return orderTotal;
  }

    

      
}

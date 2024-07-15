import java.util.*;

class OrderVisitor implements VisitorInterface {
  private Vector orderObjList;
//  private double orderTotal;
  Expedidor  expedidor = new Expedidor();

  public OrderVisitor() {
    orderObjList = new Vector();
  }
//  public void Agregar(Order camp){
//    orderObjList.add(camp);
//  }
//
//  public Vector recorrido() {
//  return orderObjList;
//  }

  public double visit(NonCaliforniaOrder inp_order) {
  return inp_order.getOrderAmount();
//  expedidor.calculo(inp_order.getOrderAmount());
//    orderTotal = orderTotal + inp_order.getOrderAmount();
  }
  public double visit(CaliforniaOrder inp_order) {
return inp_order.getOrderAmount()+inp_order.getAdditionalTax();
      //  expedidor.calculo(inp_order.getOrderAmount(), inp_order.getAdditionalTax());
//  System.out.println("llega13");
//    orderTotal = orderTotal + inp_order.getOrderAmount() +inp_order.getAdditionalTax();
  }
public double visit(OverseasOrder inp_order) {
return inp_order.getOrderAmount()+inp_order.getAdditionalSH();

      //      expedidor.calculo(inp_order.getOrderAmount(), inp_order.getAdditionalSH());

//  System.out.println("llega14");
//    orderTotal = orderTotal + inp_order.getOrderAmount() +inp_order.getAdditionalSH();
  }
//  public double getOrderTotal() {
//      return expedidor.getOrderTotal();
////    return orderTotal;
//  }
//
//    public void limpiar() {
//        expedidor.limpiar();
//    }
   
}
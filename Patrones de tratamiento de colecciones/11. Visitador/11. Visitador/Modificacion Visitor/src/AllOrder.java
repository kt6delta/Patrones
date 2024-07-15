/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ccastillo
 */
import java.io.*;
import java.util.*;


public class AllOrder implements Iterator{
  private Vector data;
  Enumeration ec;
  Order nextOrden;

  public AllOrder(){

  }

  public AllOrder(Vector dat){
      data = dat;
      ec = data.elements();

  }

  public boolean hasNext() {
    boolean matchFound = false;

    nextOrden = null;

    while (ec.hasMoreElements()) {
      Order tempObj = (Order) ec.nextElement();
      nextOrden = tempObj;
      break;
    }
    return (nextOrden != null);
  }

  public Object next() {
    if (nextOrden == null) {
      throw new NoSuchElementException();
    } else {
      return nextOrden;
    }
  }


  public void remove() {};

}

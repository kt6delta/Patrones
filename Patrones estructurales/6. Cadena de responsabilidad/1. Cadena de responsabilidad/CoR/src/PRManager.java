public class PRManager { //Clase principal

  private BranchManager branchManager;
  private RegionalDirector regionalDirector;
  private VicePresident vicePresident;
  private PresidentCOO coo;

  public static void main(String[] args) {
    PRManager manager = new PRManager();

    manager.createAuthorizationFlow();//Orden de la cadena

    PurchaseRequest request = new PurchaseRequest(1, "Office Supplies",10000); //Crea una peticion
    manager.branchManager.authorize(request);//inicia la cadena de responsabilidad

    request = new PurchaseRequest(2, "HardWare Procurement",175000);//Crea 2da peticion
    manager.branchManager.authorize(request);//inicia la cadena de responsabilidad

    request = new PurchaseRequest(3, "AD Campaign",800000);//Crea 3ra peticion
    manager.branchManager.authorize(request);//inicia la cadena de responsabilidad

  }

  public void createAuthorizationFlow() { //orden de la petición
    branchManager = new BranchManager("Robin");
    regionalDirector = new RegionalDirector("Oscar");
    vicePresident = new VicePresident("Kate");
    coo = new PresidentCOO("Drew");

    branchManager.setNextHandler(regionalDirector);
    regionalDirector.setNextHandler(vicePresident);
    vicePresident.setNextHandler(coo);
  }

}

class PurchaseRequest { //estructura de las peticiones

  private int ID;
  private String description;
  private double amount;

  public PurchaseRequest(int id, String desc, double amt) {
    ID = id;
    description = desc;
    amount = amt;
  }

  public double getAmount() {
    return amount;
  }

  public String toString() {
    return ID + ":" + description;
  }

}

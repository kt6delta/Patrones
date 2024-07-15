import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.sun.java.swing.plaf.windows.*;

public class OrderManager extends JFrame {
  public static final String newline = "\n";
  public static final String GET_TOTAL = "Get Total";
  public static final String CREATE_ORDER = "Create Order";
  public static final String EXIT = "Exit";
  public static final String CA_ORDER = "California Order";
  public static final String NON_CA_ORDER = 
    "Non-California Order";

  public static final String OVERSEAS_ORDER = "Overseas Order";


  private JComboBox cmbOrderType;
  private JTextField txtOrderAmount, txtAdditionalTax,
  txtAdditionalSH;
  private JLabel lblOrderType, lblOrderAmount;
  private JLabel lblAdditionalTax, lblAdditionalSH;
  private JLabel lblTotal, lblTotalValue;

  private OrderVisitor objVisitor;
  private GuardaOrden ordAll;
  public OrderManager() {
    super("Visitor Pattern - Example");

    //Create the visitor instance
    objVisitor = new OrderVisitor();
    ordAll = new GuardaOrden();
    cmbOrderType = new JComboBox();
    cmbOrderType.addItem(OrderManager.CA_ORDER);
    cmbOrderType.addItem(OrderManager.NON_CA_ORDER);
    cmbOrderType.addItem(OrderManager.OVERSEAS_ORDER);

    txtOrderAmount = new JTextField(10);
    txtAdditionalTax = new JTextField(10);
    txtAdditionalSH = new JTextField(10);

    lblOrderType = new JLabel("Order Type:");
    lblOrderAmount = new JLabel("Order Amount:");
    lblAdditionalTax =
      new JLabel("Additional Tax(CA Orders Only):");
    lblAdditionalSH =
      new JLabel("Additional S & H(Overseas Orders Only):");

    lblTotal = new JLabel("Result:");
    lblTotalValue =
      new JLabel("Click Create or GetTotal Button");

    //Create the open button
    JButton getTotalButton =
      new JButton(OrderManager.GET_TOTAL);
    getTotalButton.setMnemonic(KeyEvent.VK_G);
    JButton createOrderButton =
      new JButton(OrderManager.CREATE_ORDER);
    getTotalButton.setMnemonic(KeyEvent.VK_C);
    JButton exitButton = new JButton(OrderManager.EXIT);
    exitButton.setMnemonic(KeyEvent.VK_X);
    ButtonHandler objButtonHandler = new ButtonHandler(this);


    getTotalButton.addActionListener(objButtonHandler);
    createOrderButton.addActionListener(objButtonHandler);
    exitButton.addActionListener(new ButtonHandler());

    //For layout purposes, put the buttons in a separate panel
    JPanel buttonPanel = new JPanel();

    JPanel panel = new JPanel();
    GridBagLayout gridbag2 = new GridBagLayout();
    panel.setLayout(gridbag2);
    GridBagConstraints gbc2 = new GridBagConstraints();
    panel.add(getTotalButton);
    panel.add(createOrderButton);
    panel.add(exitButton);
    gbc2.anchor = GridBagConstraints.EAST;
    gbc2.gridx = 0;
    gbc2.gridy = 0;
    gridbag2.setConstraints(createOrderButton, gbc2);
    gbc2.gridx = 1;
    gbc2.gridy = 0;
    gridbag2.setConstraints(getTotalButton, gbc2);
    gbc2.gridx = 2;
    gbc2.gridy = 0;
    gridbag2.setConstraints(exitButton, gbc2);

    //****************************************************
    GridBagLayout gridbag = new GridBagLayout();
    buttonPanel.setLayout(gridbag);
    GridBagConstraints gbc = new GridBagConstraints();

    buttonPanel.add(lblOrderType);
    buttonPanel.add(cmbOrderType);
    buttonPanel.add(lblOrderAmount);
    buttonPanel.add(txtOrderAmount);
    buttonPanel.add(lblAdditionalTax);
    buttonPanel.add(txtAdditionalTax);
    buttonPanel.add(lblAdditionalSH);
    buttonPanel.add(txtAdditionalSH);
    buttonPanel.add(lblTotal);
    buttonPanel.add(lblTotalValue);

    gbc.insets.top = 5;
    gbc.insets.bottom = 5;
    gbc.insets.left = 5;
    gbc.insets.right = 5;

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gridbag.setConstraints(lblOrderType, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 0;
    gridbag.setConstraints(cmbOrderType, gbc);

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 1;
    gridbag.setConstraints(lblOrderAmount, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 1;
    gridbag.setConstraints(txtOrderAmount, gbc);

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 2;
    gridbag.setConstraints(lblAdditionalTax, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 2;
    gridbag.setConstraints(txtAdditionalTax, gbc);

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 3;
    gridbag.setConstraints(lblAdditionalSH, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 3;
    gridbag.setConstraints(txtAdditionalSH, gbc);

    gbc.anchor = GridBagConstraints.EAST;
    gbc.gridx = 0;
    gbc.gridy = 4;
    gridbag.setConstraints(lblTotal, gbc);
    gbc.anchor = GridBagConstraints.WEST;
    gbc.gridx = 1;
    gbc.gridy = 4;
    gridbag.setConstraints(lblTotalValue, gbc);

    gbc.insets.left = 2;
    gbc.insets.right = 2;
    gbc.insets.top = 40;

    //****************************************************

    //Add the buttons and the log to the frame
    Container contentPane = getContentPane();

    contentPane.add(buttonPanel, BorderLayout.NORTH);
    contentPane.add(panel, BorderLayout.CENTER);
    try {
      UIManager.setLookAndFeel(new WindowsLookAndFeel());
      SwingUtilities.updateComponentTreeUI(
        OrderManager.this);
    } catch (Exception ex) {
      System.out.println(ex);
    }

  }

  public static void main(String[] args) {
    JFrame frame = new OrderManager();

    frame.addWindowListener(new WindowAdapter() {
            @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
          }
        }
                           );

    //frame.pack();
    frame.setSize(500, 400);
    frame.setVisible(true);
  }

  public void setTotalValue(String msg) {
    lblTotalValue.setText(msg);
  }
  public OrderVisitor getOrderVisitor() {
    return objVisitor;
  }
  public GuardaOrden getOrder() {
    return ordAll;
  }

  public String getOrderType() {
    return (String) cmbOrderType.getSelectedItem();
  }
  public String getOrderAmount() {
    return txtOrderAmount.getText();
  }
  public String getTax() {
    return txtAdditionalTax.getText();
  }
  public String getSH() {
    return txtAdditionalSH.getText();
  }

} // End of class OrderManager




class ButtonHandler implements ActionListener {
  OrderManager objOrderManager;
  int i=0,j=0;
 

  public void actionPerformed(ActionEvent e) {
    String totalResult = null;

    if (e.getActionCommand().equals(OrderManager.EXIT)) {
      System.exit(1);
    }
    if (e.getActionCommand().equals(OrderManager.CREATE_ORDER)
        ) {
      OrderVisitor visitor = objOrderManager.getOrderVisitor();
      GuardaOrden orden = objOrderManager.getOrder();
      Vector prueba = new Vector();
      //get input values
      String orderType = objOrderManager.getOrderType();
      String strOrderAmount = objOrderManager.getOrderAmount();
      String strTax = objOrderManager.getTax();
      String strSH = objOrderManager.getSH();

      double dblOrderAmount = 0.0;
      double dblTax = 0.0;
      double dblSH = 0.0;
      if (strOrderAmount.trim().length() == 0) {
        strOrderAmount = "0.0";
      }
      if (strTax.trim().length() == 0) {
        strTax = "0.0";
      }
      if (strSH.trim().length() == 0) {
        strSH = "0.0";
      }

      dblOrderAmount = new Double(strOrderAmount).doubleValue();
      dblTax = new Double(strTax).doubleValue();
      dblSH = new Double(strSH).doubleValue();

      Order order=null;
      if(orderType.equals(OrderManager.CA_ORDER)){
             order=new CaliforniaOrder(dblOrderAmount, dblTax);
//             prueba.add(order);
             orden.agregar(order);
        }
      if(orderType.equals(OrderManager.NON_CA_ORDER)){
             order=new NonCaliforniaOrder(dblOrderAmount);
//             prueba.add(order);
             orden.agregar(order);
      }

      if(orderType.equals(OrderManager.OVERSEAS_ORDER)){
            order=new OverseasOrder(dblOrderAmount, dblSH);
//            prueba.add(order);
            orden.agregar(order);
      }
        objOrderManager.setTotalValue(" Order Created Successfully ");
    }




   //-----------------------------------------------------------------------------------
   //-------------------------------------------------------------------------------------

 if (e.getActionCommand().equals(OrderManager.GET_TOTAL)) {
//       Order order=null;
//       Expedidor expedidor = new Expedidor();
       OrderVisitor visitor = objOrderManager.getOrderVisitor();
       GuardaOrden orden = objOrderManager.getOrder();
       double backup;
//    // accept the visitor instance
        Vector v = (Vector) orden.cargar();
        AllOrder uno = new AllOrder(v);
        orden.limpiar();
    while (uno.hasNext())
        {
        Order temp =(Order) uno.next();
        backup = (double) temp.accept(visitor);
        orden.calculo(backup);
        System.out.println("llamado");
        }
       
       totalResult = new Double(orden.getOrderTotal()).toString();
       totalResult = " Orders Total = " + totalResult;
       objOrderManager.setTotalValue(totalResult);

    }
  }
    


  public ButtonHandler() {
  }
  public ButtonHandler(OrderManager inObjOrderManager) {
    objOrderManager = inObjOrderManager;
  }

} // End of class ButtonHandler


























package ui;

import pos.PointOfSale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;


public class Main {
  private static final int BUTTON_WIDTH = 100;
  private static final int BUTTON_HEIGHT = 100;
  private static final int X0 = 40;
  private static final int Y0 = 60;
  private static final int VERTICAL_SEPARATION = 30;
  private static final int HORIZONTAL_SEPARATION = 60;
  private static final int FRAME_WIDTH = 1000;
  private static final int FRAME_HEIGHT = 600;

  private static int[] position(int row, int col) {
    int[] pos = new int[2];
    pos[0] = X0 + col * (BUTTON_WIDTH + HORIZONTAL_SEPARATION); // horizontal axis
    pos[1] = Y0 + row * (VERTICAL_SEPARATION + BUTTON_HEIGHT); // vertical axis
    return pos;
  }

  private static JButton makeButton(int row, int col, String label) {
    JButton button = new JButton(label);
    // better a Swing button because AWT buttons can't display images
    int[] pos = position(row, col);
    button.setBounds(pos[0], pos[1], BUTTON_WIDTH, BUTTON_HEIGHT);
    return button;
  }

  public static void main(String[] args) {
    Frame frame = new Frame("Point of sale");

    PointOfSale pointOfSale = new PointOfSale();
    JTextField textAmount = new JTextField();
    Mediator mediator = new Mediator(pointOfSale, textAmount);

    // tables
    int numTables = 6;
    int numRowsTables = 4;
    int numColsTables = 2;
    assert numTables <= numRowsTables * numColsTables;
    int nTable = 0;
    for (int row = 0; row < numRowsTables; row++) {
      for (int col = 0; col < numColsTables; col++) {
        if (nTable < numTables) {
          String idTable = "T" + (row + 1) + (col + 1);
          JButton table = makeButton(row, col, idTable);
          table.addActionListener(new TableListener(table, mediator));
          frame.add(table);
          nTable++;
        }
      }
    }

    // commands
    JButton buttonNewSale = makeButton(0, 2, "New sale");
    buttonNewSale.setBackground(Color.CYAN);
    buttonNewSale.addActionListener(new NewSaleListener(mediator));
    frame.add(buttonNewSale);

    JButton buttonReceipt = makeButton(1, 2, "Receipt");
    buttonReceipt.setBackground(Color.YELLOW);
    buttonReceipt.addActionListener(new PrintReceiptListener(mediator));
    frame.add(buttonReceipt);

    JButton buttonPay = makeButton(2, 2, "Pay");
    buttonPay.setBackground(Color.ORANGE);
    buttonPay.addActionListener(new PayListener(mediator));
    frame.add(buttonPay);

    // products
    ArrayList<String> productNames = pointOfSale.getProductNames();
    // from the product names get the names of the images/icons to show in directory images/ and make the
    // corresponding buttonss
    int numProducts = productNames.size();
    int numRowsProducts = 5;
    int numColsProducts = 2;
    assert numProducts <= numRowsProducts * numColsProducts;
    int nProduct = 0;
    for (int row = 0; row < numRowsProducts; row++) {
      for (int col = 0; col < numColsProducts; col++) {
        if (nProduct < numProducts) {
          JButton buttonProduct = makeButton(row, col + 3, "");
          String prodName = productNames.get(nProduct);
          buttonProduct.setIcon(new ImageIcon("./images/" + prodName + ".png"));
          buttonProduct.addActionListener(new ProductListener(prodName, mediator));
          frame.add(buttonProduct);
          nProduct++;
        }
      }
    }

    // enter the amount paid for the current sale of the selected table, press return and
    // then click on the Pay button
    JLabel labelAmount = new JLabel("<html>Amount paid (enter and press Return)</html>");
    int[] posLabel = position(0, 5);
    labelAmount.setBounds(posLabel[0], posLabel[1], BUTTON_WIDTH, BUTTON_HEIGHT);
    frame.add(labelAmount);

    textAmount.setText("0.0");
    int[] posAmount = position(1, 5);
    textAmount.setBounds(posAmount[0], posAmount[1], BUTTON_WIDTH, BUTTON_HEIGHT / 2);
    textAmount.addActionListener(new AmountListener(textAmount, mediator));
    frame.add(textAmount);

    frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    frame.setLayout(null);
    frame.setVisible(true);

    // Using WindowListener for closing the window
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
}

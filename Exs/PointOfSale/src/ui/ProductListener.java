package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductListener implements ActionListener {
  private Mediator mediator;
  private String productName;

  public ProductListener(String productName, Mediator mediator) {
    this.productName = productName;
    this.mediator = mediator;
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    mediator.addLineItem(productName, 1);
    // mediator knows the table and therefore the sale
  }
}

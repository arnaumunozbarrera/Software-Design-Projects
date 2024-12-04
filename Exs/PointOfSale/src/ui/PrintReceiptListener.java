package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintReceiptListener implements ActionListener {
  private Mediator mediator;

  public PrintReceiptListener(Mediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    mediator.printReceipt();
  }
}
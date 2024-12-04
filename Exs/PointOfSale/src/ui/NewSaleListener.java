package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class NewSaleListener implements ActionListener {
  private Mediator mediator;

  public NewSaleListener(Mediator mediator) {
    this.mediator = mediator;
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    mediator.makeNewSale();
  }
}

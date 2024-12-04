package pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class ProductCatalog {
  private ArrayList<ProductSpecification> productSpecifications = new ArrayList<>();

  public ProductCatalog(String fileName) {
    /*
    // We have replaced this by reading names and prices from a text file
    addProductSpecification("Coca-cola", 1.20);
    addProductSpecification("Nestea", 1.50);
    addProductSpecification("Moritz", 1.90);
    addProductSpecification("Aigua de Ribes", 1.10);
    addProductSpecification("Olives Espinaler", 1.90);
    addProductSpecification("Patates Lays", 2.05);
    addProductSpecification("Trina", 1.35);
     */
    String line;
    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
      while ((line = reader.readLine()) != null) {
        String[] s = line.split(":", 2);
        //System.out.println(s[0].trim() + " " + Double.parseDouble(s[1])); // to debug
        addProductSpecification(s[0].trim(), Double.parseDouble(s[1]));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private void addProductSpecification(String name, double price) {
    productSpecifications.add(new ProductSpecification(name, price));
  }

  public ProductSpecification searchByName(String name) {
    for (ProductSpecification ps : productSpecifications) {
      if (ps.getName().equals(name)) {
        return ps;
      }
    }
    System.out.println(name + " not found");
    return null;
  }

  // this is for the user interface, to make the name of the product images to read
  public ArrayList<String> getProductNames() {
    ArrayList<String> names = new ArrayList<>();
    for (ProductSpecification ps : productSpecifications) {
      names.add(ps.getName());
    }
    return names;
  }
}

package pos_creditcard;
import java.util.Collections;
import java.util.List;
import java.security.KeyPair;
import java.util.*;
import java.math.*;


public class Cash {

  private HashMap<Double, Integer> CurrentCash;

  private List<Double> Coins;
  private List<Double> CoinsReverted;

  public Cash(){
    CurrentCash = new HashMap<>();
    Coins = Arrays.asList(0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1.0, 2.0, 5.0, 10.0, 20.0);
    CoinsReverted = Arrays.asList(20.0, 10.0, 5.0, 2.0, 1.0, 0.5, 0.2, 0.1, 0.05, 0.02, 0.01);

    CurrentCash.put(0.01, 5);
    CurrentCash.put(0.02, 5);
    CurrentCash.put(0.05, 5);
    CurrentCash.put(0.1, 5);
    CurrentCash.put(0.2, 5);
    CurrentCash.put(0.5, 5);
    CurrentCash.put(1.0, 5);
    CurrentCash.put(2.0, 5);
    CurrentCash.put(5.0, 2);
    CurrentCash.put(10.0, 2);
    CurrentCash.put(20.0, 2);

    System.out.printf("\nCash box initially loaded with\n");

  }
  public void addCash(double[] bitllets, int[] quantitat){
    int count = 0;
    for(double money : bitllets) {
      int i = CurrentCash.get(money);
      i += quantitat[count];
      CurrentCash.put(money, i);
      int aux = quantitat[count];
      count++;
      System.out.printf("Money added to the cash box: " +  aux + " of " + money + "\n");
    }
  }

  public void addCash(double change){
    HashMap<Double, Integer> addCash = new HashMap<>();
    for(double coin : CoinsReverted){

      int count = (int) (change / coin);

      if( count > 0){
          change = Math.round((change - coin * count) * 100.0)/100.0;
          addCash.put(coin, count);

      }
    }

    for( double key : addCash.keySet()){
      if (addCash.get(key) != null){
        int i = CurrentCash.get(key);
        i += addCash.get(key);
        CurrentCash.put(key, i);
        System.out.printf("Added to cash box: " + addCash.get(key) + " of " + key + "\n");
      }
    }

  }

  public void subCash(HashMap<Double, Integer> rest){
    for( double key : rest.keySet()){
      if(rest.get(key) != null){
        int i = CurrentCash.get(key);
        i -= rest.get(key);
        CurrentCash.put(key, i);
      }
    }
  }

  public void subCash(double change){
    HashMap<Double, Integer> subCash = new HashMap<>();

    for(double coin : CoinsReverted){
      int count = (int) (change / coin);

      if( count > 0){
        change = Math.round((change - coin * count) * 100.0)/100.0;
        subCash.put(coin, count);

      }
    }
    for( double key : subCash.keySet()){
      if (subCash.get(key) != null){
        int i = CurrentCash.get(key);
        i -= subCash.get(key);
        CurrentCash.put(key, i);
        System.out.printf("Rested to cash box: " + subCash.get(key) + " of " + key + "\n");
      }
    }
    System.out.printf("\n");
  }
  public void ChangeGreedy(double totalAmount){
    HashMap<Double, Integer> change = new HashMap<>();
    double aux = totalAmount;
    for(double coins : CoinsReverted){

      int count = (int) (totalAmount / coins);
      if(count > 0){

        if(CurrentCash.get(coins) > count){

          change.put(coins, count);
          totalAmount = Math.round((totalAmount - coins * count) * 100.0)/100.0;


        }

      }
    }

    if(totalAmount > 0){
      System.out.printf("No hi han suficients diners a caixa \n");
    }
    else{
      for (double denomination : Coins) {
        if(change.get(denomination) != null){
          System.out.println(change.get(denomination) + " of " + denomination);
        }
      }
      System.out.printf("\n");
      subCash(aux);

    }

  }

  private double getRandom(){
    int randomInt = (int) (Math.random() * 11);
    return Coins.get(randomInt);
  }

  public void ChangeRandom(double totalAmount){
    int cont = 0;
    HashMap<Double, Integer> change = new HashMap<>();

    while(totalAmount > 0 && cont < 10000){
      double coin = getRandom();
      cont++;
      int count = (int) (totalAmount / coin);
      if (count > 0){
        if(CurrentCash.get(coin) > count) {
          change.put(coin, count);
          totalAmount = Math.round((totalAmount - coin * count) * 100.0)/100.0;

        }
      }

    }

    if(cont<10000){
      for (double denomination : Coins) {
        if(change.get(denomination) != null){
          System.out.println(change.get(denomination) + " of " + denomination);
        }
      }
      System.out.printf("\n");
      subCash(change);
    }
    else{
      System.out.printf("No enough money in the cash box");
    }

  }

  public void printCash(){
    for (double denomination : Coins) {
      System.out.println(CurrentCash.get(denomination) + " of " + denomination);
    }
    System.out.printf("\n");

  }

}

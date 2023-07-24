package it.ires.exam;

import it.ires.exam.exception.NumberNotValidException;

public class PhoneApp {

  public static void main(String[] args) {
    System.out.println("Hello World");
    try {
      Smartphone s1 = new Smartphone("+393713217422", 0.0, "Matteo", 0);
      s1.printSimContentAndCallRegister();
    }catch(NumberNotValidException e){
      System.out.println(e.getMessage());
    }

  }

}

package iterator;

import java.util.Iterator;

public class Main {

  public static void main(String[] args) {

    FibonacciSequence sequence = new FibonacciSequence();
    Iterator<Integer> it = sequence.iterator();

    System.out.println("First 10 Fibonacci numbers:");

    for (int i = 0; i < 10; i++) {
      System.out.print(it.next() + " ");
    }

    System.out.println();
  }
}

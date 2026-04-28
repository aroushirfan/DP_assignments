package iterator;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {

  private int prev = 0;   // F(0)
  private int curr = 1;   // F(1)

  @Override
  public boolean hasNext() {
    return true;
  }

  @Override
  public Integer next() {
    int value = curr;
    int next = prev + curr;
    prev = curr;
    curr = next;
    return value;
  }
}

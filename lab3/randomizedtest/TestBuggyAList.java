package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public void testThreeAddThreeRemove() {
    int[] inputs = {4, 5, 6};
    AListNoResizing<Integer> AList = new AListNoResizing<>();
    BuggyAList<Integer> BList = new BuggyAList<>();
    for (int i : inputs) {
      AList.addLast(i);
      BList.addLast(i);
    }
    for (int i = 0; i < inputs.length; i++) {
      assertEquals(AList.removeLast(), BList.removeLast());
    }
  }

  @Test
  public void randomizedTest() {
    AListNoResizing<Integer> AList = new AListNoResizing<>();
    BuggyAList<Integer> BList = new BuggyAList<>();
    int N = 5000;

    for (int i = 0; i < N; i += 1) {
      int operationNumber = StdRandom.uniform(0, 4);
      if (operationNumber == 0) {
        // addLast
        int randVal = StdRandom.uniform(0, 100);
        AList.addLast(randVal);
        BList.addLast(randVal);
        System.out.println("addLast(" + randVal + ")");
      } else if (operationNumber == 1) {
        // size
        int size = AList.size();
        System.out.println("size: " + size);
        assertEquals(AList.size(), BList.size());
      } else if (operationNumber == 2 && AList.size() > 0) {
        // getLast
        System.out.println("getLast: " + AList.getLast());
        assertEquals(AList.getLast(), BList.getLast());
      } else if (operationNumber == 3 && AList.size() > 0) {
        System.out.println("removeLast: " + AList.getLast());
        assertEquals(AList.removeLast(), BList.removeLast());
      }
    }
  }
}

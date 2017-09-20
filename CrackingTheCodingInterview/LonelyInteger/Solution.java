import java.util.*;

public class Solution {

  public static int getLonelyInteger(int[] a) {
    int lonely = 0;
    for (int i = 0; i < a.length; i++) {
      lonely = lonely ^ a[i];
    }
    return lonely;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int a[] = new int[n];
    for(int a_i=0; a_i < n; a_i++){
      a[a_i] = in.nextInt();
    }
    System.out.println(getLonelyInteger(a));

    in.close();
  }
}

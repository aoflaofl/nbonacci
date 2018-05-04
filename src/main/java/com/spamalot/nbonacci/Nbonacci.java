package com.spamalot.nbonacci;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class Nbonacci {
  public static void main(String[] args) {
    bonacciseries(4, 200);
  }

  public static void nbonnaci(int n, int m) {
    int[] a = new int[m];
    a[n - 1] = 1;

    for (int i = n; i < m; i++) {
      for (int j = i - n; j < i; j++) {
        a[i] = a[i] + a[j];
      }
    }

    for (int i : a) {
      System.out.println(i);
    }
  }

  static void bonacciseries(int n, int m) {
    // Assuming m > n.
    BigInteger[] a = new BigInteger[m];

    for (int i = 0; i < m; i++) {
      a[i] = BigInteger.valueOf(0);
    }
    a[n - 1] = BigInteger.valueOf(1);
    a[n] = BigInteger.valueOf(1);

    // Uses sliding window
    for (int i = n + 1; i < m; i++) {
      a[i] = a[i - 1].multiply(BigInteger.valueOf(2L)).subtract(a[i - n - 1]);
    }
    // Printing result
    for (int i = 0; i < m; i++) {
      System.out.print(a[i] + " ");
      if (i >= n) {

        // bigIntX is a BigInteger
        BigDecimal bigDecX = new BigDecimal(a[i]);
        BigDecimal bigDecY = new BigDecimal(a[i - 1]);

        System.out.print(bigDecX.divide(bigDecY, 40, RoundingMode.HALF_EVEN));
      }
      System.out.println();
    }
  }
}

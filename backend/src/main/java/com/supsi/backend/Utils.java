package com.supsi.backend;

final public class Utils {
  static public int randomCoordinate(int from, int to) {
    return (int) (Math.random() * (to - from) + from);
  }
}

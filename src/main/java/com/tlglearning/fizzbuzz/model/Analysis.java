package com.tlglearning.fizzbuzz.model;

import java.util.EnumSet;
import java.util.Set;

public class Analysis {

  public static final String ILLEGAL_VALUE_FORMAT = "Value was %,d; must be non-negative";

  //below this method will return a set of the ate FIZZ, BUZZ in the State tab... now we are going to implement
  //the return type is what is before Set<State>, so set, we are returning a set of state
  //we are returning a set containing both fizz and buzz value in it or neither of them
  //first we declare a local variable then return it

  /**
   *
   * @param value
   * @return
   * @throws IllegalArgumentException if {@code value < 0}.
   */
  public Set<State> analyze(int value) throws IllegalArgumentException {

    if (value <0) {
      throw new IllegalArgumentException(String.format(ILLEGAL_VALUE_FORMAT, value));
    }

    Set<State> result = EnumSet.noneOf(State.class);    //

    if (value % 3 == 0) {          //%3 mean remainder of 3 for divisible, now saying if the number is divisible by 3 with no remainders it will reply w/FIZZ
      result.add(State.FIZZ);
    }

    if (value % 5 == 0) {
      result.add(State.BUZZ);
    }

    return result;
  }

}

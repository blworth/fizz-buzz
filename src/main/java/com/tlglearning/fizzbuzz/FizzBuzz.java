package com.tlglearning.fizzbuzz;

import com.tlglearning.fizzbuzz.model.Analysis;
import com.tlglearning.fizzbuzz.model.State;
import java.util.Set;

public class FizzBuzz {

  private static final int DEFAULT_UPPER_BOUND = 100;

  public static void main(String[] args) {
    try {
      int upperBound = (args.length > 0) ? Integer.parseInt(args[0]) : DEFAULT_UPPER_BOUND;
      if (upperBound <= 0) {
        throw new IllegalArgumentException();
      }
      Analysis analysis = new Analysis();
      for (int counter = 1; counter <= upperBound;
          counter++) {                // using for loop now to count from 1 to 100
        Set<State> result = analysis.analyze(
            counter);                  //now we add a ternary, when we use this the if/esle has to go or it will duplicate
        System.out.println(result.isEmpty() ? counter
            : result);        //writing boolean expression here, it says if this condition is true we are gonan use the counter otherwise we will print the result

      }
    } catch (IllegalArgumentException e) {
      System.out.printf("Usage: java %1$s [upperBound]%n", FizzBuzz.class.getName());
      System.out.println("Where: upperBound is a positive integer, with a default of 100");
      throw new RuntimeException("FizzBuzz halted!", e);
    } finally {
      System.out.println("Thanks for playing FizzBuzz!");
    }
  }

}

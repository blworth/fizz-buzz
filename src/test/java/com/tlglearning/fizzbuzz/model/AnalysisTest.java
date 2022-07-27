package com.tlglearning.fizzbuzz.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.EnumSet;
import java.util.Set;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

class AnalysisTest {
  static final Set<State> fizzexpected = EnumSet.of(State.FIZZ);
  static final Set<State> neitherexpected = EnumSet.noneOf(State.class);

 final Analysis analysis = new Analysis();

  //or

//  Analysis analysis = new Analysis();
//
//  @BeforeEach
//  void setup() {
//    analysis = new Analysis();
//  }
  @ParameterizedTest
  @ValueSource(ints = {3, 999_999_999})
  void analyze_fizz(int value) {
    assertEquals(fizzexpected, analysis.analyze(value));    //can do it like this with fields above or can do the one below with no fields
  }

  @ParameterizedTest
  @ValueSource(ints = {5, 85, 999_999_985})
  void analyze_buzz(int value) {
    Set<State> expected = EnumSet.of(State.BUZZ);
    assertEquals(expected, analysis.analyze(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 15, 999_999_990})
  void analyze_fizzBuzz(int value) {
    Set<State> expected = EnumSet.of(State.FIZZ, State.BUZZ);
    assertEquals(expected, analysis.analyze(value));
  }

  @ParameterizedTest
  @CsvFileSource(resources = "neither.csv", numLinesToSkip = 1)
  void analyze_neither(int value) {
    assertEquals(neitherexpected, analysis.analyze(value));
  }

  @ParameterizedTest
  @ValueSource(ints = {-1, -3, -5, -15})
  void analyze_negative(int value) {
   assertThrows(IllegalArgumentException.class, new InvalidInvocation(value));
  }

  private class InvalidInvocation implements Executable {

  private final int value;

    public InvalidInvocation( int value) {
      this.value = value;
    }

    @Override
    public void execute() throws Throwable {
      analysis.analyze(value);

    }
  }
}
package fizzbuzz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    private static final int START_INCLUSIVE = 1;
    private static final int END_EXCLUSIVE = 101;
    public static final IntStream INT_STREAM_TO_TEST = IntStream.range(START_INCLUSIVE, END_EXCLUSIVE);

    @ParameterizedTest
    @DisplayName("FizzBuzz should return the string representation of the input when the input is not a multitude of 3 or 5")
    @MethodSource("provideParametersNotAMultitudeOf3Or5")
    public void parseRegularValues(int input, String expected) {
        // Given
        FizzBuzz subjectUnderTest = new FizzBuzz();

        // When
        String actual = subjectUnderTest.parse(input);

        // Then
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> provideParametersNotAMultitudeOf3Or5() {
        return INT_STREAM_TO_TEST.filter((el) -> el % 5!= 0).filter((el) -> el % 3 != 0).mapToObj((el) -> Arguments.of(el, String.valueOf(el)));
    }

    @ParameterizedTest
    @DisplayName("FizzBuzz should return 'fizz' when the input a multiple of 3")
    @MethodSource("provideMultitudeOf3Parameters")
    public void parseFizzOnMultitudeOf3(int input) {
        // Given
        FizzBuzz subjectUnderTest = new FizzBuzz();

        // When
        String actual = subjectUnderTest.parse(input);

        // Then
        assertEquals("fizz", actual);
    }

    private static IntStream provideMultitudeOf3Parameters() {
        return IntStream.range(START_INCLUSIVE, END_EXCLUSIVE).filter((el) -> el % 3 == 0).filter((el) -> el % 5 != 0);
    }

    @ParameterizedTest
    @DisplayName("FizzBuzz should return 'buzz' when the input a multiple of 5")
    @MethodSource("provideMultitudeOf5Parameters")
    public void parseBuzzOnMultitudeOf5(int input) {
        // Given
        FizzBuzz subjectUnderTest = new FizzBuzz();

        // When
        String actual = subjectUnderTest.parse(input);

        // Then
        assertEquals("buzz", actual);
    }

    private static IntStream provideMultitudeOf5Parameters() {
        return IntStream.range(START_INCLUSIVE, END_EXCLUSIVE).filter((el) -> el % 5 == 0).filter((el) -> el % 3 != 0);
    }

    @ParameterizedTest
    @DisplayName("FizzBuzz should return 'fizzbuzz' when the input a multiple of 3 and 5")
    @MethodSource("provideMultitudeOf3And5Parameters")
    public void parseBuzzOnMultitudeOf3and5(int input) {
        // Given
        FizzBuzz subjectUnderTest = new FizzBuzz();

        // When
        String actual = subjectUnderTest.parse(input);

        // Then
        assertEquals("fizzbuzz", actual);
    }

    private static IntStream provideMultitudeOf3And5Parameters() {
        return IntStream.range(START_INCLUSIVE, END_EXCLUSIVE).filter((el) -> el % 5 == 0).filter((el) -> el % 3 == 0);
    }

    @Test
    public void cannotParseNumbersLowerThenOne() {
        // Given
        FizzBuzz subjectUnderTest = new FizzBuzz();

        // Then
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            // When
            subjectUnderTest.parse(START_INCLUSIVE - 1);
        });
    }

    @Test
    public void cannotParseNumbersAbove100() {
        // Given
        FizzBuzz subjectUnderTest = new FizzBuzz();

        // Then
        Assertions.assertThrows(UnsupportedOperationException.class, () -> {
            // When
            subjectUnderTest.parse(END_EXCLUSIVE + 1);
        });
    }
}
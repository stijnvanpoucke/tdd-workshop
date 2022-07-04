package fizzbuzz;

import static java.lang.String.valueOf;

public class FizzBuzz {

    private static final String FIZZ = "fizz";
    private static final String BUZZ = "buzz";

    public String parse(int input) {
        if (input < 1 || input > 100) {
            throw new UnsupportedOperationException();
        }

        if (multitudeOf3(input) && multitudeOf5(input)) {
            return FIZZ + BUZZ;
        }

        if (multitudeOf3(input)) {
            return FIZZ;
        }

        if (multitudeOf5(input)) {
            return BUZZ;
        }

        return valueOf(input);
    }

    private boolean multitudeOf3(int input) {
        return input % 3 == 0;
    }

    private boolean multitudeOf5(int input) {
        return input % 5 == 0;
    }
}
# Test Driven Development Workshop

## Pair Programming
While doing pair programming we have someone to talk with. We've got someone to validate and challenge our ideas with. We can discuss our design decisions upfront with a very short feedback loop. It helps us to learn from each other and to grow faster.

In pair programming, each person takes a turn and takes up one of the two roles:
- Driver: The one who has his hands on the keyboard, focussing the practical things and becoming a shortcut Ninja
- Navigator: Responsible for the design, refactorings, global overview etc...

## Kata 1: FizzBizz
Source: https://github.com/ardalis/kata-catalog/blob/main/katas/FizzBuzz.md

We will use this Kata to get used to Test Driven Pair Programming.

### Use Case

Write a function that takes numbers from 1 to 100 and outputs them as a string, but for multiples of three it returns “Fizz” instead of the number, and for multiples of five it returns “Buzz.” For numbers that are multiples of both three and five, it returns “fizzbuzz.FizzBuzz.

### Instructions: Red, Green, Refactor

<u>**Turn 1:**</u> The Navigator instructs the Driver to write the structure for our first test method; the driver creates the test file, the technical setup etc

Example:
```Java
public class FizzBuzzTest {

    @Test
    @DisplayName("fizzbuzz.FizzBuzz should compile")
    public void todo() {
       new FizzBuzz().parse();
    }
}
```

Now the Driver becomes Navigator and visa versa

<u>**Turn 2:**</u> The (new) Navigator instructs the (new) Driver to create the first subject under test interface so that the test compiles and becomes **green**. 

```Java
public class FizzBuzz {

    public void parse() {

    }
}

```

Then the Navigator instructs the Driver to add a first parameter and an assertions for that parameter in the test.

```Java
public class FizzBuzzTest {

    @Test
    @DisplayName("FizzBuzz should return '1' when the input was 1")
    public void parse1() {
      // Given
      FizzBuzz subjectUnderTest = new FizzBuzz();
  
      // When
      String actual = subjectUnderTest.parse(1);
  
      // Then
      assertEquals("1", actual);
    }
}
```

Driver becomes Navigator and visa versa

<u>**Turn 3:**</u> The (new) Navigator instructs the (new) Driver to make the test **green** again by doing the most simples thing possible, just return the expected value.

```Java
public class FizzBuzz {

    public String parse(int input) {
        return "1";
    }
}
```

Then the Navigator instructs the Driver to create a second test with a second parameter.

```Java
public class FizzBuzzTest {

    @Test
    @DisplayName("FizzBuzz should return '1' when the input was 1")
    public void parse1() {
        // Given
        FizzBuzz subjectUnderTest = new FizzBuzz();

        // When
        String actual = subjectUnderTest.parse(1);

        // Then
        assertEquals("1", actual);
    }    
    
    @Test
    @DisplayName("FizzBuzz should return '2' when the input was 2")
    public void parse2() {
        // Given
        FizzBuzz subjectUnderTest = new FizzBuzz();

        // When
        String actual = subjectUnderTest.parse(2);

        // Then
        assertEquals("2", actual);
    }
}
```

Driver becomes Navigator and visa versa

<u>**Turn 4:**</u> The (new) Navigator instructs the (new) Driver to make the test **green** again by doing the most simples thing possible, by using an if statement. 

```Java
public class FizzBuzz {

    public String parse(int input) {
        if (input == 1) {
            return "1";
        }
        return "2";
    }
}
```

Then the Navigator instructs the Driver to create a third test with a third 'non fizzbuzz' parameter `4`.

```Java
public class FizzBuzzTest {

    @Test
    @DisplayName("FizzBuzz should return '1' when the input was 1")
    public void parse1() {
        // Given
        FizzBuzz subjectUnderTest = new FizzBuzz();

        // When
        String actual = subjectUnderTest.parse(1);

        // Then
        assertEquals("1", actual);
    }

    @Test
    @DisplayName("FizzBuzz should return '2' when the input was 2")
    public void parse2() {
        // Given
        FizzBuzz subjectUnderTest = new FizzBuzz();

        // When
        String actual = subjectUnderTest.parse(2);

        // Then
        assertEquals("2", actual);
    }

    @Test
    @DisplayName("FizzBuzz should return '4' when the input was 4")
    public void parse4() {
        // Given
        FizzBuzz subjectUnderTest = new FizzBuzz();

        // When
        String actual = subjectUnderTest.parse(4);

        // Then
        assertEquals("4", actual);
    }
}
```

The Navigator should now again instruct the driver to make the test green again by doing the most simple thing.

```Java
public class FizzBuzz {

    public String parse(int input) {
        if (input == 1) {
            return "1";
        } else if (input == 2) {
            return "2";
        }
        return "4";
    }
}
```

And now it becomes time to introduce Refactoring in our Red / Green Loop. *Tip* Use the Rule of Three, to defer duplication until there is enough evidence and amply to DRY principle. 

Driver becomes Navigator and visa versa

<u>**Turn 5, 6, 7:**</u> No it's time to continue without detailed instruction, start implementing the special cases. Return Fizz for multiples of three, Buzz on multiples of five and FuzzBuzz in with a combination of both.

<u>**Additional Challenge:**</u> Refactor your tests to use Parameterized Tests

In the end all input values ranging from 1 to 100 should be tested, but what happens when the input value is outside this range? We cannot just cross our fingers and expect the user of our class to respect our boundaries. Looking for all these important exceptional cases is called **Triangulation**

<u>**Refactor again:**</u> Look again if there is more stuff to refactor, look for magic constants, extracting methods to make the code more readable etc etc.... run the test after every refactor, the test should stay green every time.  If not, revert the refactor.

### Some great habits
- A test should test one thing only
- Give your tests meaningful names
  - Avoid technical names
  - Avoid leaking implementation details
  - Avoid writing technical tests; you should test behaviors
- Always see the test fail for the right season
- Ensure you have meaningful feedback from the failing test


## Kata 2: Fibonacci
Source: https://github.com/islomar/tcr-workshop/blob/master/Fibonacci-kata.md

Switch pairs with another pairing team and use what you've learned in this second Kata:

Write some code to generate the Fibonacci number for the nth position. Example: int Fibonacci(int position). The first Fibonacci numbers in the sequence are: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34.

## Kata 3: Stats Calculator
Source: https://github.com/roaslin/stats-calculator-kata-27-07-2019

Your task is to process a sequence of integer numbers to determine the following statistics:

```text
- minimum value
- maximum value
- number of elements in the sequence
- average value
```

For example: [6, 9, 15, -2, 92, 11]

```text
- minimum value = -2
- maximum value = 92
- number of elements in the sequence = 6
- average value = 21.833333
```


### Resources
- Agile Technical Practices Distilled: A learning journey in technical practices and principles of software design -  Marco Consolaro, Alessandro Di Gioia, Pedro M. Santos (**This book was the main source of this workshop**)
- Unit Testing Principles, Practices, and Patterns
- Pragmatic Unit Testing in Java 8 with JUnit
- Test Driven Development. By Example - Kent Beck
- The Clean Coder
- Many others...
package com.stackroute;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MathServiceTest {

    private final String VALID_MESSAGE = "square should return valid square for valid input";
    private MathService mathService;

    @BeforeEach
    public void setup(){
        mathService = new MathService();
    }

    @AfterEach
    public void teardown(){
        mathService = null;
    }

    public static Stream<Arguments> testDataProvider(){
        return Stream.of(
                Arguments.arguments(2,4),
                Arguments.arguments(5,25),
                Arguments.arguments(6,36)
        );
    }

    @Tag("smoke")
    //can have multiple tags
    @Order(3)
    @Test
    public void testingIfMathServiceIsInstantiated(){
        Assertions.assertNotNull(new MathService());
    }

    @Order(2)
    @ParameterizedTest(name = "Test Execution = {index} with test data {0} and {1}")
    //@ValueSource() only able to pass one value per execution, not efficient
//    @CsvSource(value = {"2,4", "3,9", "-4,16", "5,25"})
//    @CsvFileSource(resources = "/test-data.csv", numLinesToSkip = 1)
    @MethodSource("testDataProvider")
    public void givenValidIntegerSquareShouldReturnValidSquare(int input, int expected){
//        int input = 2;
//        int expected = 4;
        int actual = mathService.square(input);
        Assertions.assertEquals(expected, actual, VALID_MESSAGE);
    }

//    @Test
//    public void givenValidIntegerSquareShouldReturnValidSquareScenario2(){
//        int input = 3;
//        int expected = 9;
//        int actual = mathService.square(input);
//        Assertions.assertEquals(expected, actual, VALID_MESSAGE);
//    }

//    @Tag("smoke")
    @Order(1)
    @Test
    public void givenValidDoubleSquareShouldReturnValidSquare(){
        //MathService mathService = new MathService();
        double input = 2;
        double expected = 4;
        double actual = mathService.square(input);
        Assertions.assertEquals(expected, actual, VALID_MESSAGE);
        //mathService = null;
    }

}

//csvsource
//csvfilesource
//methodsource must creare static method

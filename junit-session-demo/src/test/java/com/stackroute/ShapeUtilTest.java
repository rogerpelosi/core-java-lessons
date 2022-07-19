package com.stackroute;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ShapeUtilTest {

    @InjectMocks
    //dependent on mocks
    private ShapeUtil shapeUtil;

    @Mock
    //need mock for dependency for unit testing
    private MathService mathService;

    @Test
    public void testCircleAreaForValidRadius(){
//        mathService = new MathService();
//        shapeUtil = new ShapeUtil(mathService);

        //subbing default value (0/0.0)
        Mockito.when(mathService.square(Mockito.anyInt())).thenReturn(4);
        int input = 2;
        double expected = 12.56;

        double actual = shapeUtil.circleArea(input);

        Assertions.assertEquals(expected, actual);

        //limits invocation to one time to verify
        Mockito.verify(mathService, Mockito.times(1)).square(Mockito.anyInt());
    }

    //verify if exceptions are thrown or not
    //assertions
    //will use hamcrest in future -- write test cases in more meaningful and declarative way
}

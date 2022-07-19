package com.stackroute;

public class ShapeUtil {

    //making shapeutil to depend on mathhservice
    private MathService mathService;

    public ShapeUtil(MathService mathService) {
        this.mathService = mathService;
    }

    public double circleArea(int radius){
        System.out.println("Circle area is invoked");
        //invokes mock and returns default value 0
        //message inside square doesnt execute bc it is a mock

        return 3.14 * mathService.square(radius);
    }

}

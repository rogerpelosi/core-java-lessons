package org.example;

public class OuterClass {

    /*
    //usually contains data and methods
    //classes usually have default or public clarifiers
    //inner classes can have any access bc it is considered a class member
    */
    private int outerClassProperty;

    //assign value to member in constructor itself
    public OuterClass(int outerClassProperty){
        this.outerClassProperty = outerClassProperty;
    }

    public int getOuterClassProperty() {
        return outerClassProperty;
    }
    public void setOuterClassProperty(int outerClassProperty) {
        this.outerClassProperty = outerClassProperty;
    }

    public OuterClass(){}

    public void outerShow(){
        System.out.println("OuterClass Property: " + outerClassProperty);
        //method local inner class example
        class A{}
        A a = new A();
    }

   public static class InnerClass{

        //static belongs to class vs instance, created only once during class loading time itself


        //inner class can access private properties of the outer class
        //outer class cannot access private properties of the inner class


       private int innerClassProperty;

       public InnerClass(int innerClassProperty){
           //this refers to inner not outer
           this.innerClassProperty = innerClassProperty;
       }

       public InnerClass(){}

       public int getInnerClassProperty() {return innerClassProperty;}
       public void setInnerClassProperty(int innerClassProperty) {
           this.innerClassProperty = innerClassProperty;
       }

       public void innerShow(){
           System.out.println("Inner Class Property: " + innerClassProperty);

           //outproperty is nonstatic member, cannot access nonstatic when itself is static
           //when i access outerclassprop here, it does not yet exist bc it hasnt been instantiated yet
           //System.out.println("Outer Class Property From Inner Class: " + outerClassProperty);
       }
   }
}

//inner class modifiers
/*
private class InnerClass{}
protected class InnerClass{}
public class InnerClass{}
class InnerClass{} (default)
 */

//NONSTATIC EXAMPLE-------------------
/*

public class OuterClass {

    /*
    //usually contains data and methods
    //classes usually have default or public clarifiers
    //inner classes can have any access bc it is considered a class member

private int outerClassProperty;

    //assign value to member in constructor itself
    public OuterClass(int outerClassProperty){
        this.outerClassProperty = outerClassProperty;
    }

    public int getOuterClassProperty() {
        return outerClassProperty;
    }
    public void setOuterClassProperty(int outerClassProperty) {
        this.outerClassProperty = outerClassProperty;
    }

    public OuterClass(){}

    public void outerShow(){
        System.out.println("OuterClass Property: " + outerClassProperty);
    }


  // public class //InnerClass{

        //static belongs to class vs instance

        /*
        inner class can access private properties of the outer class
        outer class cannot access private properties of the inner class


    private int innerClassProperty;

    public InnerClass(int innerClassProperty){
        //this refers to inner not outer
        this.innerClassProperty = innerClassProperty;
    }

    public InnerClass(){}

    public int getInnerClassProperty() {return innerClassProperty;}
    public void setInnerClassProperty(int innerClassProperty) {
        this.innerClassProperty = innerClassProperty;
    }

    public void innerShow(){
        System.out.println("Inner Class Property: " + innerClassProperty);
        System.out.println("Outer Class Property From Inner Class: " + outerClassProperty);
    }
}
 */

//STATIC EXAMPLE-----------
/*
public class OuterClass {

    /*
    //usually contains data and methods
    //classes usually have default or public clarifiers
    //inner classes can have any access bc it is considered a class member

private int outerClassProperty;

    //assign value to member in constructor itself
    public OuterClass(int outerClassProperty){
        this.outerClassProperty = outerClassProperty;
    }

    public int getOuterClassProperty() {
        return outerClassProperty;
    }
    public void setOuterClassProperty(int outerClassProperty) {
        this.outerClassProperty = outerClassProperty;
    }

    public OuterClass(){}

    public void outerShow(){
        System.out.println("OuterClass Property: " + outerClassProperty);
    }

public static class InnerClass{

    //static belongs to class vs instance, created only once during class loading time itself


    //inner class can access private properties of the outer class
    //outer class cannot access private properties of the inner class


    private int innerClassProperty;

    public InnerClass(int innerClassProperty){
        //this refers to inner not outer
        this.innerClassProperty = innerClassProperty;
    }

    public InnerClass(){}

    public int getInnerClassProperty() {return innerClassProperty;}
    public void setInnerClassProperty(int innerClassProperty) {
        this.innerClassProperty = innerClassProperty;
    }

    public void innerShow(){
        System.out.println("Inner Class Property: " + innerClassProperty);

        //outproperty is nonstatic member, cannot access nonstatic when itself is static
        //when i access outerclassprop here, it does not yet exist bc it hasnt been instantiated yet
        //System.out.println("Outer Class Property From Inner Class: " + outerClassProperty);
    }
}
}
 */

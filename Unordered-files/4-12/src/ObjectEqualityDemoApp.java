public class ObjectEqualityDemoApp {

    public static void main(String[] args )
    {
        System.out.println("Object Equality");

        //difference in memory mngmt --> will it recreate same string again, or will it use the one already in memory
        //String one = "Deepan";
        //String two = new String("Deepan");

        String one = new String("Deepan");
        //create one object in heap, two object instances with same value
        String two = new String("Deepan");
        //they are pointing to differing objects, same value

        System.out.println(one == two); //false because they are pointing to reference points
        System.out.println(one.equals(two)); //compares the value themselves
    }

}

//reference equality --> ==
//custom equality --> .equals() method

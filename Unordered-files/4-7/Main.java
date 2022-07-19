package JavaTasks4_7;
public class Main {

    public static void main(String[] args) 
    {

        Employee eObj = new Employee();
        eObj.setEmpName("LOL");

        System.out.println(eObj.getEmpName());
        //OR-------------------------
        String hi = eObj.getEmpName();
        System.out.println(hi);

    }
    
}

package org.example.designpatterns;

public class DesignPatternApp {

    public static void main(String[] args) {
        System.out.println("Design Pattern App");
        System.out.println("^^^^^^^^^^^^^^^^^^");

        MyRuntime rt1 = MyRuntime.getMyRuntime();
        MyRuntime rt2 = MyRuntime.getMyRuntime();

        //returns same global instance because of singleton design pattern implemented
        System.out.println(rt1 == rt2);

        Employee emp = new Employee(100, "rog", 60000);
        Employee empClone = emp.clone();

        System.out.println(emp);
        System.out.println(empClone);

        //it is a copy, but references diff memory location, not equal
        System.out.println(emp == empClone);

        MobilePlatform android = new Android();
        android.runMobileApps();

        ComputerPlatform windows = new Windows();
        windows.runComputerApps();

        //want to invoke impl provided by android in windows
        //by creating adapter interface windows to invoke type android
        ComputerPlatform windowsAd = new AndroidAdapter(new Android());
        windowsAd.runComputerApps();
    }
}

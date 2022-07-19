package org.example.designpatterns;

public class Windows implements ComputerPlatform{
    @Override
    public void runComputerApps() {
        System.out.println("Running Computer Apps");
    }
}

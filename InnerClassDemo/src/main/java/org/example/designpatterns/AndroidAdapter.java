package org.example.designpatterns;

public class AndroidAdapter implements ComputerPlatform{

    private MobilePlatform mobile;

    //this constructor is passed android object
    public AndroidAdapter(MobilePlatform mobile) {
        this.mobile = mobile;
    }

    @Override
    public void runComputerApps() {
        mobile.runMobileApps();
    }
}

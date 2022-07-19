package JavaTasks4_7;

public class Employee {

    private int empId;
    private String empName;
    private double empSal;
    private String empAddress;


    public int getEmpId() {return empId;}
    public void setEmpId(int empId) {this.empId = empId;}

    public String getEmpName() {return empName;}
    public void setEmpName(String empName) {this.empName = empName;}

    public double getEmpSal() {return empSal;}
    public void setEmpSal(double empSal) {this.empSal = empSal;}

    public String getEmpAddress() {return empAddress;}
    public void setEmpAddress(String empAddress) {this.empAddress = empAddress;}
    
}

//employee id and sal shouldnt be accessible to outer world / other classes
//employee name and address should be accessible to other classes 

//different access specifiers supported by java:
//--> public: access to any classes
//--> private: access to only that class itself
//--> protected: member is only accessible to subclasses
//--> default: NOT a keyword, if no access specifier is assigned it goes to default(same package default behaves like public, scope limit is package itself though)
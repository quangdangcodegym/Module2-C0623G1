import java.time.LocalDate;
import java.util.List;

public class Employee {
    protected long id;
    protected String fullName;
    protected LocalDate birthDay;
    protected String phone;
    protected String email;
    protected int employeeType;
    public static int employeeCount;

    static {
        employeeCount = 0;
    }

    public void showInfo(){
        System.out.printf("%10s | %20s | %20s | %10s | %30s | %10s \n", this.getId(), this.getFullName(),
                this.getBirthDay(), this.getPhone(), this.getEmail(), this.getNameEmployeeType());
    }

    List<Certificate> certificates;

    public Employee() {
    }

    public Employee(long id, String fullName, LocalDate birthDay,
                    String phone, String email, int employeeType, List<Certificate> certificates) {
        this.id = id;
        this.fullName = fullName;
        this.birthDay = birthDay;
        this.phone = phone;
        this.email = email;
        this.employeeType = employeeType;
        this.certificates = certificates;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmployeeType() {
        return employeeType;
    }

    public String getNameEmployeeType(){
        String strType = "";
        switch (employeeType) {
            case 0:
                strType = "Experience";
                break;
            case 1:
                strType = "Fresher";
                break;
            case 2:
                strType = "Intern";
                break;
        }
        return strType;
    }
    public void setEmployeeType(int employeeType) {
        this.employeeType = employeeType;
    }




    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }
}

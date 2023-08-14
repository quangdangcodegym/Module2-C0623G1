import java.time.LocalDate;
import java.util.List;

public class Experience extends Employee{
    private int expInYear;
    private String proSkill;

    public Experience() {

    }

    public Experience(long id, String fullName, LocalDate birthDay, String phone, String email, int employeeType,
                      List<Certificate> certificates, int expInYear, String proSkill) {
        super(id, fullName, birthDay, phone, email, employeeType, certificates);
        this.expInYear = expInYear;
        this.proSkill = proSkill;
    }

    public int getExpInYear() {
        return expInYear;
    }

    public void setExpInYear(int expInYear) {
        this.expInYear = expInYear;
    }

    public String getProSkill() {
        return proSkill;
    }

    public void setProSkill(String proSkill) {
        this.proSkill = proSkill;
    }
}

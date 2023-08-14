import java.time.LocalDate;
import java.util.List;

public class Fresher extends Employee{
    private LocalDate graduationDate;
    private String graduationRank;
    private String education;

    public Fresher() {
    }

    public Fresher(LocalDate graduationDate, String graduationRank, String education) {
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public Fresher(long id, String fullName, LocalDate birthDay, String phone, String email,
                   int employeeType, List<Certificate> certificates,
                   LocalDate graduationDate, String graduationRank, String education) {
        super(id, fullName, birthDay, phone, email, employeeType, certificates);
        this.graduationDate = graduationDate;
        this.graduationRank = graduationRank;
        this.education = education;
    }

    public LocalDate getGraduationDate() {
        return graduationDate;
    }

    public void setGraduationDate(LocalDate graduationDate) {
        this.graduationDate = graduationDate;
    }

    public String getGraduationRank() {
        return graduationRank;
    }

    public void setGraduationRank(String graduationRank) {
        this.graduationRank = graduationRank;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }
}

public class PrintUtils {
    public void toStringEmployee(Employee eplItem) {
        System.out.printf("%10s | %20s | %20s | %10s | %30s | %10s \n", eplItem.getId(), eplItem.getFullName(),
                eplItem.getBirthDay(), eplItem.getPhone(), eplItem.getEmail(), eplItem.getNameEmployeeType());
    }
}

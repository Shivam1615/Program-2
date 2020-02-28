/**
 * @author Shivam Patel
 * @author Kevin Shah
 */
public class Instate extends Student {
    private int funds;

    public Instate(String fname, String lname, int credit, int funds) {
        super(fname, lname, credit);
        this.funds = funds;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "$" + this.tuitionDue();
    }

    @Override
    public int tuitionDue() {
        int tuition = 0;

        // Part-time students
        if (this.credit < 12) {
            tuition = (Student.Instate_PerCost * this.credit) + Student.UniversityFee_PartTime;
        } else if (this.credit >= 12) { // Full-time students
            if (this.credit >= 15) {
                tuition = (Student.Instate_PerCost * 15) + Student.UniversityFee_FullTime - this.funds;
            } else {
                tuition = (Student.Instate_PerCost * this.credit) + Student.UniversityFee_FullTime - this.funds;
            }
        }

        return tuition;
    }

    public static void main(String[] args) {

        Instate student = new Instate("John", "Smith", 17, 1000);

        System.out.println(student.toString());
        System.out.println(student.tuitionDue());

    }

}

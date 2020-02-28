
/**
 * @author Shivam Patel
 * @author Kevin Shah
 */
public class Outstate extends Student {
    private boolean tristate;

    public Outstate(String fname, String lname, int credit, boolean tristate) {
        super(fname, lname, credit);
        this.tristate = tristate;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "$" + this.tuitionDue();
    }

    @Override
    public int tuitionDue() {
        int tuition = 0;

        if (this.credit < 12) {
            if (this.tristate == true) {
                tuition = this.credit * (Student.Outstate_PerCost) + Student.UniversityFee_PartTime;
            } else if (this.tristate == false) {
                tuition = (Student.Outstate_PerCost * this.credit) + Student.UniversityFee_PartTime;
            }
        } else if (this.credit >= 12) {
            if (this.credit >= 15) {
                if (this.tristate == true) {
                    tuition = 15 * (Student.Outstate_PerCost - 200) + Student.UniversityFee_FullTime;
                } else if (this.tristate == false) {
                    tuition = (Student.Outstate_PerCost * 15) + Student.UniversityFee_FullTime;
                }
            } else {
                if (this.tristate == true) {
                    tuition = this.credit * (Student.Outstate_PerCost - 200) + Student.UniversityFee_FullTime;
                } else if (this.tristate == false) {
                    tuition = (Student.Outstate_PerCost * this.credit) + Student.UniversityFee_FullTime;
                }
            }
        }
        return tuition;

    }

    public static void main(String[] args) {

        Outstate student = new Outstate("John", "White", 12, true);

        System.out.println(student.toString());

        System.out.println(student.tuitionDue());

    }

}

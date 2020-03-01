
/**
 * This class overrides the toString and the tuitionDue of the Student class to
 * obtain information about an Out of State student.
 * 
 * @author Shivam Patel
 * @author Kevin Shah
 */
public class Outstate extends Student {
    private boolean tristate;

    /**
     * This constructor initializes the first name, last name, number of credits,
     * and whether student is in the tristate area.
     * 
     * @param fname
     * @param lname
     * @param credit
     * @param tristate
     */
    public Outstate(String fname, String lname, int credit, boolean tristate) {
        super(fname, lname, credit);
        this.tristate = tristate;
    }

    /**
     * This toString method overrides the student class toString in order to show
     * tuition for out of state student.
     */
    @Override
    public String toString() {
        return super.toString() + " tuition due: " + "$" + this.tuitionDue();
    }

    /**
     * This method computes the tuition amount of an out of state student and
     * overrides the abstract method of the student class.
     */
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

    /**
     * This testbed main method tests all of the methods and constructor to ensure
     * its correctness.
     * 
     * @param args
     */
    public static void main(String[] args) {

        Outstate student = new Outstate("John", "White", 17, true);
        Outstate student2 = new Outstate("King", "Kong", 14, false);
        Outstate student3 = new Outstate("John", "McCain", 9, true);
        Outstate student4 = new Outstate("Donald", "Trump", 12, false);

        System.out.println(student.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());
        System.out.println(student4.toString());

        System.out.println(student.tuitionDue());
        System.out.println(student2.tuitionDue());
        System.out.println(student3.tuitionDue());
        System.out.println(student4.tuitionDue());

    }

}

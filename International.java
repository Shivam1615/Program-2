/**
 * @author Shivam Patel
 * @author Kevin Shah
 */
public class International extends Student {
    private boolean exchange;

    public International(String fname, String lname, int credit, boolean exchange) {
        super(fname, lname, credit);
        this.exchange = exchange;
    }

    @Override
    public String toString() {
        return super.toString() + " " + "$" + this.tuitionDue();
    }

    @Override
    public int tuitionDue() {
        int tuition = 0;

        if (this.credit < 12) {
            if (this.exchange == true) {
                tuition = Student.UniversityFee_PartTime + Student.International_Student_Fee;
            } else if (this.exchange == false) {
                tuition = (Student.International_PerCost * this.credit) + Student.UniversityFee_PartTime
                        + Student.International_Student_Fee;
            }
        } else if (this.credit >= 12) {
            if (this.credit >= 15) {
                if (this.exchange == true) {
                    tuition = Student.UniversityFee_FullTime + Student.International_Student_Fee;
                } else if (this.exchange == false) {
                    tuition = (Student.International_PerCost * 15) + Student.UniversityFee_FullTime
                            + Student.International_Student_Fee;
                }
            } else {
                if (this.exchange == true) {
                    tuition = Student.UniversityFee_FullTime + Student.International_Student_Fee;
                } else if (this.exchange == false) {
                    tuition = (Student.International_PerCost * this.credit) + Student.UniversityFee_FullTime
                            + Student.International_Student_Fee;
                }
            }
        }
        return tuition;

    }

    public static void main(String[] args) {

        International student = new International("Mary", "Yang", 17, true);

        System.out.println(student.toString());
        System.out.println(student.tuitionDue());

    }

}

/**
 * 
 * This class overrides toString, tuitionDue and includes testbed main class to
 * test all of the methods of an international student.
 * 
 * @author Shivam Patel
 * @author Kevin Shah
 */
public class International extends Student {
    private boolean exchange;

    /**
     * This constructor initializes the first name, last name, number of credits,
     * and exchange variable.
     * 
     * @param fname
     * @param lname
     * @param credit
     * @param exchange
     */
    public International(String fname, String lname, int credit, boolean exchange) {
        super(fname, lname, credit);
        this.exchange = exchange;
    }

    /**
     * This toString() method overrides the toString() method of the Student class
     * to include tuition amount of an international student.
     */
    @Override
    public String toString() {
        return super.toString() + " tuition due: " + "$" + this.tuitionDue();
    }

    /**
     * This tuitionDue() is overriding the abstract method of the Student class to
     * compute how much tuition the international student has to pay.
     */
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

    /**
     * This testbed main method tests all of the constructors and all of the methods
     * of the class.
     * 
     * @param args
     */
    public static void main(String[] args) {

        International student = new International("Mary", "Yang", 17, true);
        International student2 = new International("Dhanush", "Gandham", 9, false);
        International student3 = new International("Ken", "Liang", 12, false);
        International student4 = new International("Ken", "Liang", 13, true);

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

public class Instate extends Student {
    private int funds;

    public Instate(String fname, String lname, int credit, int funds) {
        super(fname, lname, credit);
        this.funds = funds;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.funds;
    }

    @Override
    public int tuitionDue() {
        int costPerCredit = 433;
        int UniversityFee = 0;
        int storage = 0;

        // Part-time students
        if (this.credit < 12) {
            UniversityFee = 846;
            storage = (costPerCredit * this.credit) + UniversityFee;
        } else if (this.credit >= 12) { // Full-time students
            UniversityFee = 1441;
            if (this.credit >= 15) {
                storage = (costPerCredit * 15) + UniversityFee - this.funds;
            } else {
                storage = (costPerCredit * this.credit) + UniversityFee - this.funds;
            }
        }

        return storage;
    }

    public static void main(String[] args) {

        Instate student = new Instate("John", "Smith", 17, 1000);

        System.out.println(student.toString());
        System.out.println(student.tuitionDue());

    }

}

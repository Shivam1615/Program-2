
public class Outstate extends Student {
    private boolean tristate;

    public Outstate(String fname, String lname, int credit, boolean tristate) {
        super(fname, lname, credit);
        this.tristate = tristate;
    }

    @Override
    public String toString() {
        return super.toString() + " " + tristate;
    }

    @Override
    public int tuitionDue() {
        int UniversityFee = 0;
        int costPerTuition = 756;
        int storage = 0;

        if (this.credit < 12) {
            UniversityFee = 846;
            if (this.tristate == true) {
                storage = this.credit * (costPerTuition - 200) + UniversityFee;
            } else if (this.tristate == false) {
                storage = (costPerTuition * this.credit) + UniversityFee;
            }
        } else if (this.credit >= 12) {
            UniversityFee = 1441;
            if (this.credit >= 15) {
                if (this.tristate == true) {
                    storage = 15 * (costPerTuition - 200) + UniversityFee;
                } else if (this.tristate == false) {
                    storage = (costPerTuition * 15) + UniversityFee;
                }
            } else {
                if (this.tristate == true) {
                    storage = this.credit * (costPerTuition - 200) + UniversityFee;
                } else if (this.tristate == false) {
                    storage = (costPerTuition * this.credit) + UniversityFee;
                }
            }
        }
        return storage;

    }

    public static void main(String[] args) {

        Outstate student = new Outstate("John", "White", 12, true);

        System.out.println(student.toString());

        System.out.println(student.tuitionDue());

    }

}

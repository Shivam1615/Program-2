public class International extends Student {
    private boolean exchange;

    public International(String fname, String lname, int credit, boolean exchange) {
        super(fname, lname, credit);
        this.exchange = exchange;
    }

    @Override
    public String toString() {
        return super.toString() + " " + this.exchange;
    }

    @Override
    public int tuitionDue() {
        int UniversityFee = 0;
        int costPerTuition = 945;
        int storage = 0;
        int International_Fee = 350;

        if (this.credit < 12) {
            UniversityFee = 846;
            if (this.exchange == true) {
                storage = UniversityFee + International_Fee;
            } else if (this.exchange == false) {
                storage = (costPerTuition * this.credit) + UniversityFee + International_Fee;
            }
        } else if (this.credit >= 12) {
            UniversityFee = 1441;
            if (this.credit >= 15) {
                if (this.exchange == true) {
                    storage = UniversityFee + International_Fee;
                } else if (this.exchange == false) {
                    storage = (costPerTuition * 15) + UniversityFee + International_Fee;
                }
            } else {
                if (this.exchange == true) {
                    storage = UniversityFee + International_Fee;
                } else if (this.exchange == false) {
                    storage = (costPerTuition * this.credit) + UniversityFee + International_Fee;
                }
            }
        }
        return storage;

    }

    public static void main(String[] args) {

        International student = new International("Mary", "Yang", 17, true);

        System.out.println(student.toString());
        System.out.println(student.tuitionDue());

    }

}
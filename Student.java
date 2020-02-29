
/**
 * @author Shivam Patel
 * @author Kevin Shah
 */
public abstract class Student implements Comparable {
	private String fname;
	private String lname;
	protected int credit;

	public static final int Instate_PerCost = 433;
	public static final int Outstate_PerCost = 756;
	public static final int International_PerCost = 945;
	public static final int UniversityFee_PartTime = 846;
	public static final int UniversityFee_FullTime = 1441;
	public static final int International_Student_Fee = 350;

	public Student(String fname, String lname, int credit) { // constructor
		this.fname = fname.toLowerCase();
		this.lname = lname.toLowerCase();
		this.credit = credit;
	}

	// must implement compareTo method because Student class implements the
	// Comparable Interface
	// return 0 if fname and lname of the two students are equal,
	// return -1 if this fname and lname is < obj’s, return 1 if this fname and
	// lname is > obj’s
	// Hint: use the .equals and compareToIgnoreCase methods of the String class to
	// compare fname
	// and lname; names are not case-sensitive
	public int compareTo(Object obj) {
		if(obj isinstanceof Student){
			Student student = (Student) obj;
			if (this.fname.equals(student.fname) && this.lname.equals(student.lname)) {
				return 0;
			}

			if (this.fname.compareToIgnoreCase(student.fname) < 0 
			    && this.lname.compareToIgnoreCase(student.lname) < 0) {
				return -1;
			}

			if (this.fname.compareToIgnoreCase(student.fname) > 0 
			    && this.lname.compareToIgnoreCase(student.lname) > 0) {
				return 1;
			}
		}

		return -1;
	}

	// return a string with fname, lname and credit hours; subclasses will be using
	// this method.
	public String toString() {
		return this.fname + " " + this.lname + " " + this.credit;
	}

	// compute the tuition due; concrete implementation is required in the
	// subclasses.
	public abstract int tuitionDue();

}

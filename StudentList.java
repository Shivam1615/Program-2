
public class StudentList {
    private final int NOT_FOUND = -1;
    private final int GROW_SIZE = 4;
    private Student[] students;
    private int numStudents;

    public StudentList() {
        students = new Student[GROW_SIZE];
        numStudents = 0;
    }

    private void grow() {
        Student[] resizedStudentList = new Student[GROW_SIZE * numStudents];
        for (int i = 0; i < numStudents; i++) {
            resizedStudentList[i] = students[i];
        }
        students = resizedStudentList;
    }

    private int find(Student s) {
        for (int i = 0; i < numStudents; i++) {
            if (students[i].compareTo(s) == 0)
                return i;
        }
        return NOT_FOUND;
    }

    public boolean isEmpty() {
        return numStudents == 0;
    }

    public boolean contains(Student s) {
        for (int i = 0; i < numStudents; i++) {
            if (students[i].compareTo(s) == 0)
                return true;
        }
        return false;
    }

    public void add(Student s) {
        if (numStudents == students.length)
            grow();
        students[numStudents] = s;
        numStudents++;
    }

    public boolean remove(Student s) {
        int indexToRemove = find(s);
        if (indexToRemove == NOT_FOUND)
            return false;

        // Swap the index to remove with the last item in the array.
        students[indexToRemove] = students[numStudents - 1];
        students[numStudents - 1] = null;

        numStudents--;
        return true;
    }

    public void print() {
        for (int i = 0; i < numStudents; i++) {
            System.out.println(students[i].toString());
        }
    }
}

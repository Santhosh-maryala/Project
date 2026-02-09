class Student {

    private int id;
    private String name;
    private int marks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String calculateGrade() {
        if (marks >= 80)
            return "A";
        else if (marks >= 60)
            return "B";
        else if (marks >= 40)
            return "C";
        else
            return "Fail";
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {

        Student st = new Student();
        st.setId(11);
        st.setName("Ram Charan");
        st.setMarks(95);
        
        System.out.println("ID: " + st.getId());
        System.out.println("Name: " + st.getName());
        System.out.println("Marks: " + st.getMarks());
        System.out.println("Grade: " + st.calculateGrade());
      
    }
}

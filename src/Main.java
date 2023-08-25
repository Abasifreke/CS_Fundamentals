import java.util.*;
import java.util.stream.Collectors;

class Student {

    private long studentId;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private String address;
    private String gender;
    private Date birthdate;
    private Date admissionDate;
    private long rollNumber;
    private String curriculumName;

    public Student(long studentId,
            String userName,
            String password,
            String studentName,
            String fatherName,
            String email,
            String phone,
            String address,
            String gender,
            Date birthdate,
            Date admissionDate,
            long rollNumber,
            String curriculumName) {
        this.studentId = studentId;
        this.userName = userName;
        this.password = password;
        this.lastName = fatherName;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.gender = gender;
        this.birthdate = birthdate;
        this.admissionDate = admissionDate;
        this.rollNumber = rollNumber;
        this.curriculumName = curriculumName;
    }

    public long getStudentId() {
        return studentId;
    }

    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public long getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(long rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getCurriculumName() {
        return curriculumName;
    }

    public void setCurriculumName(String curriculumName) {
        this.curriculumName = curriculumName;
    }

    public void editStudent(List<Student> universityStudents, Student student) {
        universityStudents.forEach((uniStudent) -> {
            if (uniStudent.studentId == student.studentId) {
                uniStudent = student;
            }
        });
    }

    public String toString() {
        return "(Student: \n" +
                "studentId = " + this.studentId + "\n" +
                "userName = " + this.userName + "\n" +
                "password = " + this.password + "\n" +
                "firstName = " + this.firstName + "\n" +
                "lastName = " + this.lastName + "\n" +
                "email = " + this.email + "\n" +
                "phone = " + this.phone + "\n" +
                "address = " + this.address + "\n" +
                "gender = " + this.gender + "\n" +
                "birthdate = " + this.birthdate + "\n" +
                "admissionDate = " + this.admissionDate + "\n" +
                "rollNumber = " + this.rollNumber + "\n" +
                "curriculumName = " + this.curriculumName + ")";
    }

}

class University {

    public List<Student> students = new ArrayList<>();

    public void addStudent(Student s) {
        students.add(s);
    }

    public Student getStudent(long studentId) {
        return students
                .stream()
                .filter(student -> student.getStudentId() == studentId)
                .findFirst()
                .orElse(null);
    }

    public List<Student> searchStudent(String studentNamePrefix) {
        return students
                .stream()
                .filter(student -> student.getUserName().startsWith(studentNamePrefix))
                .collect(Collectors.toList());
    }

    public boolean deleteStudent(long studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId() == studentId) {
                students.remove(i);
                return true;
            }
        }

        return false;
    }

}

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // List<Student> universityStudents = new ArrayList<>();
        // universityStudents.add(new Student());
        // universityStudents.add(new Student(
        // 123, "username", "testName", "testPwd", "testfather", "email@email.com",
        // "+12345",
        // "123 toronto", "Male", 4, new Date(), 999, "testCurriculum"));

        Student student1 = new Student(
                123, "username", "testName", "testPwd", "testfather", "email@email.com",
                "+12345",
                "123 toronto", "Male", new Date(0), new Date(), 999, "testCurriculum");
        Student student2 = new Student(
                34342, "username2", "testName", "wewzwfasf", "testfather", "email@email.com",
                "+235353213",
                "were toronto", "Male", new Date(0), new Date(), 999, "testCurriculum");

        University university = new University();
        university.addStudent(student1);
        university.addStudent(student2);

        System.out.println(university.students);
        System.out.println("Getting student------\n" + university.getStudent(123));
        System.out.println("Deleting student------\n" + university.deleteStudent(123));
        System.out.println("Seaching student------\n" + university.searchStudent("usernam"));

        System.out.println(university.students);

    }
}

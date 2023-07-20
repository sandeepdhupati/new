import java.util.List;
public interface StudentRepository {
    List<Student> getAllStudents();
    Student getStudentById(int studentId);
    Student addStudent(Student student);
    int addStudents(List<Student> students);
    void updateStudent(Student student);
    void deleteStudent(int studentId);
}
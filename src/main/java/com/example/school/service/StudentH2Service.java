import java.util.List;

public class StudentH2Service {
    private final StudentRepository studentRepository;
    
    public StudentH2Service(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public List<Student> getAllStudents() {
        return studentRepository.getAllStudents();
    }
    
    public Student getStudentById(int studentId) {
        return studentRepository.getStudentById(studentId);
    }
    
    public Student addStudent(Student student) {
        return studentRepository.addStudent(student);
    }
    
    public int addStudents(List<Student> students) {
        return studentRepository.addStudents(students);
    }
    
    public void updateStudent(Student student) {
        studentRepository.updateStudent(student);
    }
    
    public void deleteStudent(int studentId) {
        studentRepository.deleteStudent(studentId);
    }
}

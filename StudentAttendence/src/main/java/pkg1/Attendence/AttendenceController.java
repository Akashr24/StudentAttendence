package pkg1.Attendence;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


@Controller
@RequestMapping()
public class AttendenceController {

    @Autowired
    private AttendanceRepo attendanceRepository;

    @PostMapping("/StudentAttendence/Add")
    public String markAttendance(@RequestParam String studentId) {
        AttendanceEntity attendance = new AttendanceEntity();
        attendance.setStudentId(studentId);
        attendance.setTimestamp(LocalDateTime.now());
        attendanceRepository.save(attendance);
        return "Attendance marked for student: " + studentId;
    }

    
}



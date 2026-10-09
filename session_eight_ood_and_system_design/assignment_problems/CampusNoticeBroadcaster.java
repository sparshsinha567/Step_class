import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

// Implement: The Campus Notice Broadcaster
public class CampusNoticeBroadcaster {

    public interface NotificationChannel {
        String getChannelName();
        void send(Student student, Notice notice);
    }

    public static class EmailChannel implements NotificationChannel {
        @Override
        public String getChannelName() {
            return "Email";
        }

        @Override
        public void send(Student student, Notice notice) {
            System.out.printf("[Email → %s] %s.%n", student.getName(), notice.getTitle());
        }
    }

    public static class SmsChannel implements NotificationChannel {
        @Override
        public String getChannelName() {
            return "SMS";
        }

        @Override
        public void send(Student student, Notice notice) {
            System.out.printf("[SMS → %s] %s.%n", student.getName(), notice.getTitle());
        }
    }

    public static class AppChannel implements NotificationChannel {
        @Override
        public String getChannelName() {
            return "App";
        }

        @Override
        public void send(Student student, Notice notice) {
            System.out.printf("[App → %s] %s.%n", student.getName(), notice.getTitle());
        }
    }

    public static class WhatsAppChannel implements NotificationChannel {
        @Override
        public String getChannelName() {
            return "WhatsApp";
        }

        @Override
        public void send(Student student, Notice notice) {
            System.out.printf("[WhatsApp → %s] %s.%n", student.getName(), notice.getTitle());
        }
    }

    public static class Student {
        private final String name;
        private final String department;
        private final List<NotificationChannel> preferredChannels;

        public Student(String name, String department, NotificationChannel... channels) {
            this.name = Objects.requireNonNull(name).trim();
            this.department = Objects.requireNonNull(department).trim();
            this.preferredChannels = new ArrayList<>(Arrays.asList(channels));
        }

        public String getName() {
            return name;
        }

        public String getDepartment() {
            return department;
        }

        public List<NotificationChannel> getPreferredChannels() {
            return Collections.unmodifiableList(preferredChannels);
        }

        public void addChannel(NotificationChannel channel) {
            if (channel != null && !preferredChannels.contains(channel)) {
                preferredChannels.add(channel);
            }
        }
    }

    public static class Notice {
        private final String title;
        private final Set<String> targetDepartments;

        public Notice(String title, String... departments) {
            this.title = (title != null) ? title.trim() : "";
            this.targetDepartments = new LinkedHashSet<>();
            if (departments != null) {
                for (String dept : departments) {
                    if (dept != null && !dept.trim().isEmpty()) {
                        this.targetDepartments.add(dept.trim());
                    }
                }
            }
        }

        public String getTitle() {
            return title;
        }

        public Set<String> getTargetDepartments() {
            return Collections.unmodifiableSet(targetDepartments);
        }

        public boolean isValid() {
            return !title.isEmpty() && !targetDepartments.isEmpty();
        }
    }

    public static class NoticeBoard {
        private final List<Student> students = new ArrayList<>();

        public void registerStudent(Student student) {
            if (student != null) {
                students.add(student);
            }
        }

        public boolean postNotice(Notice notice) {
            if (notice == null || !notice.isValid()) {
                if (notice == null || notice.getTitle().isEmpty()) {
                    System.out.println("Cannot post notice: Notice title is required.");
                } else if (notice.getTargetDepartments().isEmpty()) {
                    System.out.println("Cannot post notice: At least one target department is required.");
                }
                return false;
            }

            String depts = String.join(", ", notice.getTargetDepartments());
            System.out.printf("Notice '%s' posted to %s.%n", notice.getTitle(), depts);

            for (Student student : students) {
                if (notice.getTargetDepartments().contains(student.getDepartment())) {
                    for (NotificationChannel channel : student.getPreferredChannels()) {
                        channel.send(student, notice);
                    }
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        NotificationChannel email = new EmailChannel();
        NotificationChannel app = new AppChannel();
        NotificationChannel sms = new SmsChannel();

        Student asha = new Student("Asha", "CSE", email, app);
        Student ravi = new Student("Ravi", "ECE", sms);

        NoticeBoard noticeBoard = new NoticeBoard();
        noticeBoard.registerStudent(asha);
        noticeBoard.registerStudent(ravi);

        Notice notice1 = new Notice("Lab Closed Tomorrow", "CSE");
        noticeBoard.postNotice(notice1);

        Notice notice2 = new Notice("Fee Deadline Extended", "CSE", "ECE");
        noticeBoard.postNotice(notice2);

        Notice notice3 = new Notice("Sports Day");
        noticeBoard.postNotice(notice3);
    }
}

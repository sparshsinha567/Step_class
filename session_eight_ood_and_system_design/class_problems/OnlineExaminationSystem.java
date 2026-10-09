import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OnlineExaminationSystem {

    public abstract static class Question {
        private final String id;
        private final String text;
        private final int points;

        public Question(String id, String text, int points) {
            this.id = Objects.requireNonNull(id, "Question ID cannot be null").trim();
            this.text = Objects.requireNonNull(text, "Question text cannot be null").trim();
            this.points = points;
        }

        public String getId() {
            return id;
        }

        public String getText() {
            return text;
        }

        public int getPoints() {
            return points;
        }

        public abstract boolean evaluate(String studentAnswer);
    }

    public static class MultipleChoiceQuestion extends Question {
        private final String correctAnswer;

        public MultipleChoiceQuestion(String id, String text, int points, String correctAnswer) {
            super(id, text, points);
            this.correctAnswer = Objects.requireNonNull(correctAnswer, "Answer cannot be null").trim();
        }

        @Override
        public boolean evaluate(String studentAnswer) {
            return studentAnswer != null && this.correctAnswer.equalsIgnoreCase(studentAnswer.trim());
        }
    }

    public static class TrueFalseQuestion extends Question {
        private final boolean correctAnswer;

        public TrueFalseQuestion(String id, String text, int points, boolean correctAnswer) {
            super(id, text, points);
            this.correctAnswer = correctAnswer;
        }

        @Override
        public boolean evaluate(String studentAnswer) {
            if (studentAnswer == null) return false;
            return Boolean.parseBoolean(studentAnswer.trim().toLowerCase()) == this.correctAnswer;
        }
    }

    public static class ShortAnswerQuestion extends Question {
        private final String expectedKeyword;

        public ShortAnswerQuestion(String id, String text, int points, String expectedKeyword) {
            super(id, text, points);
            this.expectedKeyword = Objects.requireNonNull(expectedKeyword).trim().toLowerCase();
        }

        @Override
        public boolean evaluate(String studentAnswer) {
            return studentAnswer != null && studentAnswer.trim().toLowerCase().contains(expectedKeyword);
        }
    }

    public static class Student {
        private final String name;

        public Student(String name) {
            this.name = Objects.requireNonNull(name, "Name cannot be null").trim();
        }

        public String getName() {
            return name;
        }
    }

    public static class Examination {
        private final String title;
        private final List<Question> questions;

        public Examination(String title) {
            this.title = Objects.requireNonNull(title, "Title cannot be null").trim();
            this.questions = new ArrayList<>();
        }

        public void addQuestion(Question q) {
            questions.add(q);
        }

        public String getTitle() {
            return title;
        }

        public List<Question> getQuestions() {
            return questions;
        }

        public int getMaxMarks() {
            int sum = 0;
            for (Question q : questions) {
                sum += q.getPoints();
            }
            return sum;
        }
    }

    public static class Attempt {
        private final Student student;
        private final Examination examination;
        private final Map<String, String> answers;
        private boolean submitted;

        public Attempt(Student student, Examination examination) {
            this.student = Objects.requireNonNull(student);
            this.examination = Objects.requireNonNull(examination);
            this.answers = new LinkedHashMap<>();
            this.submitted = false;
            System.out.printf("%s started by %s.%n", examination.getTitle(), student.getName());
        }

        public boolean recordAnswer(String questionId, String answer) {
            if (submitted) {
                System.out.println("Cannot change answers for a submitted examination.");
                return false;
            }
            answers.put(questionId, answer);
            System.out.println("Answer recorded for " + questionId + ".");
            return true;
        }

        public void submit() {
            if (submitted) {
                System.out.println("Examination already submitted.");
                return;
            }
            this.submitted = true;

            int totalScore = 0;
            StringBuilder resultSummary = new StringBuilder();
            List<Question> qList = examination.getQuestions();

            for (int i = 0; i < qList.size(); i++) {
                Question q = qList.get(i);
                String studentAns = answers.get(q.getId());
                boolean isCorrect = q.evaluate(studentAns);
                int awarded = isCorrect ? q.getPoints() : 0;
                totalScore += awarded;

                if (i > 0) {
                    resultSummary.append(", ");
                }
                resultSummary.append(String.format("%s: %s (%d points)",
                        q.getId(), isCorrect ? "Correct" : "Incorrect", awarded));
            }

            System.out.printf("%s submitted by %s. Result: %s. Total score: %d/%d.%n",
                    examination.getTitle(), student.getName(), resultSummary.toString(), totalScore, examination.getMaxMarks());
        }
    }

    public static void main(String[] args) {
        Examination examA = new Examination("Exam A");
        examA.addQuestion(new MultipleChoiceQuestion("Question 1", "Select prime: A) 4 B) 6 C) 7 D) 9", 5, "C"));
        examA.addQuestion(new TrueFalseQuestion("Question 2", "Java supports multiple inheritance for classes", 5, false));

        Student s1 = new Student("Student 1");
        Attempt attempt = new Attempt(s1, examA);

        attempt.recordAnswer("Question 1", "C");
        attempt.recordAnswer("Question 2", "True");
        attempt.submit();
        attempt.recordAnswer("Question 1", "B");
    }
}

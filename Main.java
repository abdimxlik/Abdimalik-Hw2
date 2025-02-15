package application;

import java.util.Scanner;

/**
 * The Main class provides a console-based interface for managing questions and answers.
 * It demonstrates CRUD operations and input validation.
 */
public class Main {
    private static Questions questions = new Questions();
    private static Answers answers = new Answers();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Create Question\n2. Read Question\n3. Update Question\n4. Delete Question");
            System.out.println("5. Create Answer\n6. Read Answers\n7. Update Answer\n8. Delete Answer\n9. Search Questions\n10. Search Answers\n11. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createQuestion();
                    break;
                case 2:
                    readQuestion();
                    break;
                case 3:
                    updateQuestion();
                    break;
                case 4:
                    deleteQuestion();
                    break;
                case 5:
                    createAnswer();
                    break;
                case 6:
                    readAnswers();
                    break;
                case 7:
                    updateAnswer();
                    break;
                case 8:
                    deleteAnswer();
                    break;
                case 9:
                    searchQuestions();
                    break;
                case 10:
                    searchAnswers();
                    break;
                case 11:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private static void createQuestion() {
        System.out.print("Enter question ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter title: ");
        String title = scanner.nextLine();
        System.out.print("Enter description: ");
        String description = scanner.nextLine();
        System.out.print("Enter tags (comma-separated): ");
        String[] tags = scanner.nextLine().split(",");

        Question question = new Question(id, title, description, tags);
        questions.addQuestion(question);
        System.out.println("Question created successfully.");
    }

    private static void readQuestion() {
        System.out.print("Enter question ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        Question question = questions.getQuestion(id);
        if (question != null) {
            System.out.println(question);
        } else {
            System.out.println("Question not found.");
        }
    }

    private static void updateQuestion() {
        System.out.print("Enter question ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new title: ");
        String title = scanner.nextLine();
        System.out.print("Enter new description: ");
        String description = scanner.nextLine();
        System.out.print("Enter new tags (comma-separated): ");
        String[] tags = scanner.nextLine().split(",");

        if (questions.updateQuestion(id, title, description, tags)) {
            System.out.println("Question updated successfully.");
        } else {
            System.out.println("Question not found.");
        }
    }

    private static void deleteQuestion() {
        System.out.print("Enter question ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (questions.deleteQuestion(id)) {
            System.out.println("Question deleted successfully.");
        } else {
            System.out.println("Question not found.");
        }
    }

    private static void createAnswer() {
        System.out.print("Enter answer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter question ID: ");
        int questionId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter answer text: ");
        String text = scanner.nextLine();

        Answer answer = new Answer(id, questionId, text);
        answers.addAnswer(answer);
        System.out.println("Answer created successfully.");
    }

    private static void readAnswers() {
        System.out.print("Enter question ID: ");
        int questionId = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<Answer> answersForQuestion = answers.getAnswersForQuestion(questionId);
        if (answersForQuestion.isEmpty()) {
            System.out.println("No answers found for this question.");
        } else {
            for (Answer a : answersForQuestion) {
                System.out.println(a);
            }
        }
    }

    private static void updateAnswer() {
        System.out.print("Enter answer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new text: ");
        String text = scanner.nextLine();

        if (answers.updateAnswer(id, text)) {
            System.out.println("Answer updated successfully.");
        } else {
            System.out.println("Answer not found.");
        }
    }

    private static void deleteAnswer() {
        System.out.print("Enter answer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (answers.deleteAnswer(id)) {
            System.out.println("Answer deleted successfully.");
        } else {
            System.out.println("Answer not found.");
        }
    }

    private static void searchQuestions() {
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();

        List<Question> result = questions.searchQuestions(query);
        if (result.isEmpty()) {
            System.out.println("No questions found.");
        } else {
            for (Question q : result) {
                System.out.println(q);
            }
        }
    }

    private static void searchAnswers() {
        System.out.print("Enter search query: ");
        String query = scanner.nextLine();

        List<Answer> result = answers.searchAnswers(query);
        if (result.isEmpty()) {
            System.out.println("No answers found.");
        } else {
            for (Answer a : result) {
                System.out.println(a);
            }
        }
    }
}
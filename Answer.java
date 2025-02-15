package application;

/**
 * The Answer class represents an answer entity in the system.
 * It contains the answer's details such as ID, question ID, and text.
 */
public class Answer {
    private int id;
    private int questionId;
    private String text;

    // Constructor to initialize a new Answer object
    public Answer(int id, int questionId, String text) {
        this.id = id;
        this.questionId = questionId;
        this.text = text;
    }

    // Getters and Setters
    public int getId() { return id; }
    public int getQuestionId() { return questionId; }
    public String getText() { return text; }

    public void setText(String text) { this.text = text; }

    @Override
    public String toString() {
        return "Answer ID: " + id + "\nQuestion ID: " + questionId + "\nText: " + text;
    }
}
package application;

/**
 * The Question class represents a question entity in the system.
 * It contains the question's details such as ID, title, description, and tags.
 */
public class Question {
    private int id;
    private String title;
    private String description;
    private String[] tags;

    // Constructor to initialize a new Question object
    public Question(int id, String title, String description, String[] tags) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.tags = tags;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String[] getTags() { return tags; }

    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setTags(String[] tags) { this.tags = tags; }

    @Override
    public String toString() {
        return "Question ID: " + id + "\nTitle: " + title + "\nDescription: " + description + "\nTags: " + String.join(", ", tags);
    }
}
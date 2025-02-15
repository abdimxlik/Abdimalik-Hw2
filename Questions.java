package application;

import java.util.ArrayList;
import java.util.List;

/**
 * The Questions class manages a list of Question objects.
 * It supports CRUD operations for questions.
 */
public class Questions {
    private List<Question> questionList;

    // Constructor to initialize the list of questions
    public Questions() {
        questionList = new ArrayList<>();
    }

    // Add a new question
    public void addQuestion(Question question) {
        questionList.add(question);
    }

    // Get a question by ID
    public Question getQuestion(int id) {
        for (Question q : questionList) {
            if (q.getId() == id) {
                return q;
            }
        }
        return null; // Question not found
    }

    // Update a question
    public boolean updateQuestion(int id, String title, String description, String[] tags) {
        Question question = getQuestion(id);
        if (question != null) {
            question.setTitle(title);
            question.setDescription(description);
            question.setTags(tags);
            return true;
        }
        return false; // Question not found
    }

    // Delete a question
    public boolean deleteQuestion(int id) {
        Question question = getQuestion(id);
        if (question != null) {
            questionList.remove(question);
            return true;
        }
        return false; // Question not found
    }

    // Get all questions
    public List<Question> getAllQuestions() {
        return questionList;
    }

    // Search questions by title or tag
    public List<Question> searchQuestions(String query) {
        List<Question> result = new ArrayList<>();
        for (Question q : questionList) {
            if (q.getTitle().contains(query) || String.join(", ", q.getTags()).contains(query)) {
                result.add(q);
            }
        }
        return result;
    }
}
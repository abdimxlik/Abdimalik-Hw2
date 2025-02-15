package application;

import java.util.ArrayList;
import java.util.List;

/**
 * The Answers class manages a list of Answer objects.
 * It supports CRUD operations for answers.
 */
public class Answers {
    private List<Answer> answerList;

    // Constructor to initialize the list of answers
    public Answers() {
        answerList = new ArrayList<>();
    }

    // Add a new answer
    public void addAnswer(Answer answer) {
        answerList.add(answer);
    }

    // Get answers for a specific question
    public List<Answer> getAnswersForQuestion(int questionId) {
        List<Answer> result = new ArrayList<>();
        for (Answer a : answerList) {
            if (a.getQuestionId() == questionId) {
                result.add(a);
            }
        }
        return result;
    }

    // Update an answer
    public boolean updateAnswer(int id, String text) {
        for (Answer a : answerList) {
            if (a.getId() == id) {
                a.setText(text);
                return true;
            }
        }
        return false; // Answer not found
    }

    // Delete an answer
    public boolean deleteAnswer(int id) {
        Answer answerToRemove = null;
        for (Answer a : answerList) {
            if (a.getId() == id) {
                answerToRemove = a;
                break;
            }
        }
        if (answerToRemove != null) {
            answerList.remove(answerToRemove);
            return true;
        }
        return false; // Answer not found
    }

    // Search answers by text
    public List<Answer> searchAnswers(String query) {
        List<Answer> result = new ArrayList<>();
        for (Answer a : answerList) {
            if (a.getText().contains(query)) {
                result.add(a);
            }
        }
        return result;
    }
}
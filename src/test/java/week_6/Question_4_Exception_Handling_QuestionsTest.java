package week_6;

import org.junit.Test;

import static org.junit.Assert.*;


public class Question_4_Exception_Handling_QuestionsTest {
    
    @Test(timeout = 3000)
    public void checkAnswerFilledIn() {
        
        // All this does is test that the student wrote at least something.
        // The actual grades for this will assessed by the instructor.
        
        Question_4_Exception_Handling_Questions q4 = new Question_4_Exception_Handling_Questions();
        
        assertTrue("Answer question 1. The actual grade for this will assessed by the instructor. ", q4.q1_pros_of_checked_exceptions.length() > 15);
        assertTrue("Answer question 2. The actual grade for this will assessed by the instructor. ", q4.q2_cons_of_checked_exceptions.length() > 15);
        assertTrue("Answer question 3. The actual grade for this will assessed by the instructor. ", q4.q3_your_opinion_on_java_having_checked_and_unchecked_exceptions.length() > 15);
        
        for (String answer : q4.q4_why_is_it_better_to_anticipate_and_prevent_errors) {
            assertTrue("Answer question 4 with at least 2 reasons. The actual grade for this will assessed by the instructor. ", answer.length() > 15);
        }
    }
    
}
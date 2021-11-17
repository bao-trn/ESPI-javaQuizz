import questions.QCM;
import questions.Question;
import questions.RC;
import questions.VF;

public class Main {

    public static void main(String[] args){
        Question<String> testQCM = new QCM<>("Sport",2,"1");
        Question<Boolean> testVF = new VF<>("dance",1,true);
        Question<String> testRC = new RC<>("art",3,"This is a short text");



        testQCM.setQuestion("first choice","second choice","third choice");
        testVF.setQuestion("Am I bald?");
        testRC.setQuestion("Describe yourself in 10 words");

        testQCM.displayTheme();
        testQCM.displayQuestion();
        testQCM.displayDifficulty();
        testQCM.displayAnswer();

        testVF.displayTheme();
        testVF.displayQuestion();
        testVF.displayDifficulty();
        testVF.displayAnswer();

        testRC.displayTheme();
        testRC.displayQuestion();
        testRC.displayDifficulty();
        testRC.displayAnswer();


    }

}

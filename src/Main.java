import Questions.QCM;
import Questions.Question;
import Questions.RC;
import Questions.VF;

public class Main {

    public static void main(String[] args){
        Question testQCM = new QCM("Sport",2,"1");
        Question testVF = new VF("dance",1,true);
        Question testRC = new RC("art",3,"This is a short text");



        ((QCM) testQCM).addQCMchoices("first choice","second choice","third choice");
        ((VF) testVF).setQuestion("Am I bald?");
        ((RC) testRC).setQuestion("Describe yourself in 10 words");

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

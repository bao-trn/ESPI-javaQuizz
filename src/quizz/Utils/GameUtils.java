package quizz.Utils;

import quizz.constants.themeConstants;
import quizz.joueurs.Player;
import quizz.joueurs.Players;
import quizz.questions.QCM;
import quizz.questions.Question;
import quizz.questions.RC;
import quizz.questions.VF;
import quizz.theme.Themes;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


public class GameUtils {

    public static void initPlayers(Players players){
        for (int i = 0; i < 20; i++){
            players.addPlayer(new Player());
        }
    }

    public static void initThemes(Themes<Object> themes){
        for (int i = 0; i < 10; i++){
            themes.addTheme(themeConstants.values()[i].name());
        }
    }

    public static void initQuestions(Themes<Object> themes){
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 2; j++) {
                themes.addQuestion(themeConstants.values()[i].name(), new QCM<>(themeConstants.values()[i].name(),1, "1"));
                themes.addQuestion(themeConstants.values()[i].name(), new VF<>(themeConstants.values()[i].name(),1, "1"));
                themes.addQuestion(themeConstants.values()[i].name(), new RC<>(themeConstants.values()[i].name(),1, "1"));
                themes.addQuestion(themeConstants.values()[i].name(), new QCM<>(themeConstants.values()[i].name(),2, "2"));
                themes.addQuestion(themeConstants.values()[i].name(), new VF<>(themeConstants.values()[i].name(),2, "2"));
                themes.addQuestion(themeConstants.values()[i].name(), new RC<>(themeConstants.values()[i].name(),2, "2"));
                themes.addQuestion(themeConstants.values()[i].name(), new QCM<>(themeConstants.values()[i].name(),3, "3"));
                themes.addQuestion(themeConstants.values()[i].name(), new VF<>(themeConstants.values()[i].name(),3, "3"));
                themes.addQuestion(themeConstants.values()[i].name(), new RC<>(themeConstants.values()[i].name(),3, "3"));
            }

        }
    }

    public static void initTruncatedThemes(Themes<Object> themes, Themes<Object> truncatedThemes, int bound){
        while (truncatedThemes.getThemes().size() < bound) {
            String randomTheme = themeConstants.values()[RandomUtils.selectRandom(themes.getThemes().size())].name();
            if (!truncatedThemes.getThemes().containsKey(randomTheme)){
                truncatedThemes.addTheme(randomTheme);
            }
        }
    }

    public static void playerAction(Players players, List<Question<Object>> diffQuestions, int questionsPerPlayer){
        for (int i = 0; i < players.getSelectedPlayers().size(); i++){
            Player currentPlayer = players.getSelectedPlayers().get(i);
            Question<Object> randomQuestion = diffQuestions.get(RandomUtils.selectRandom(diffQuestions.size()));

            for (int j = 0; j < questionsPerPlayer; j++){
                String questionForPlayer = randomQuestion.getQuestionBody() + System.lineSeparator() +randomQuestion.getQuestionChoice();

                //display question and compute player's answer
                System.out.println(questionForPlayer);
                System.out.println("Player [" + currentPlayer.getId() + "] ANSWER :");
                if (randomQuestion.getAnswer().equals(currentPlayer.userInput())){
                    currentPlayer.setScore(currentPlayer.getScore()+2);
                    System.out.println("Correct Answer! +2 points awarded, your current score is : " + currentPlayer.getScore());

                }else{
                    System.out.println("Wrong answer! Correct answer was " + randomQuestion.getAnswer() + " your current score is : " + currentPlayer.getScore());
                }
                //ensures a new question is selected
                Question<Object> newRandomQuestion = diffQuestions.get(RandomUtils.selectRandom(diffQuestions.size()));
                if (!newRandomQuestion.equals(randomQuestion)){
                    randomQuestion = newRandomQuestion;
                }
            }

        }
    }
























    public static int getMaxScore(Players players){
        int max = 0;
        List<Player> listPlayer = players.getSelectedPlayers();
        for (int i = 0; i < listPlayer.size(); i++){
            if (listPlayer.get(i).getScore() >= max){
                max = listPlayer.get(i).getScore();
            }
        }
        return max;
    }

    public static List<Player> getWinners(Players players, int maxScore){
        List<Player> listPlayer = players.getSelectedPlayers();
        List<Player> listWinner = new ArrayList<>();
        for (int i = 0; i < listPlayer.size(); i++){
            if (listPlayer.get(i).getScore() == maxScore){
                listPlayer.get(i).setState("winner");
                listWinner.add(listPlayer.get(i));
            }
        }
        return listWinner;
    }

    public static Player getLoser(Players players){
        int min = 999;
        Player loser = null;
        List<Player> listPlayer = players.getSelectedPlayers();
        for (int i = 0; i < listPlayer.size(); i++){
            if (listPlayer.get(i).getScore() <= min){
                min = listPlayer.get(i).getScore();
                loser = listPlayer.get(i);
            }
        }
        return loser;
    }


    public static void resetQuestionList(List<Question<Object>> list){
        list.forEach(x -> list.remove(x));
    }

    public static void resetQuestionList(LinkedList<Question<Object>> list){
        list.forEach(x -> list.remove(x));
    }

}

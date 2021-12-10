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

    public static void initPlayers(Players players) {
        for (int i = 0; i < 20; i++) {
            players.addPlayer(new Player());
        }
    }

    public static void initThemes(Themes<Object> themes) {
        for (int i = 0; i < 10; i++) {
            themes.addTheme(themeConstants.values()[i].name());
        }
    }

    public static void initQuestions(Themes<Object> themes) {
        for (String themeName : themes.getThemes().keySet()) {
            themes.addQuestion(themeName, new QCM<>(themeName, 1, "1"));
            themes.addQuestion(themeName, new VF<>(themeName, 1, "1"));
            themes.addQuestion(themeName, new RC<>(themeName, 1, "1"));
            themes.addQuestion(themeName, new QCM<>(themeName, 2, "2"));
            themes.addQuestion(themeName, new VF<>(themeName, 2, "2"));
            themes.addQuestion(themeName, new RC<>(themeName, 2, "2"));
            themes.addQuestion(themeName, new QCM<>(themeName, 3, "3"));
            themes.addQuestion(themeName, new VF<>(themeName, 3, "3"));
            themes.addQuestion(themeName, new RC<>(themeName, 3, "3"));

        }
    }

    public static void initAll(Themes<Object> themes, Themes<Object> truncated, Players players) {
        initPlayers(players);
        initThemes(themes);
        initTruncatedThemes(themes, truncated, themes.getThemes().size());
        initQuestions(truncated);
        players.selectPlayers();
    }

    public static List<Question<Object>> fetchQuestionsOfDifficulty(List<Question<Object>> source, List<Question<Object>> output, int difficulty) {
        for (Question<Object> question : source) {
            if (question.getDifficulty() == difficulty) {
                output.add(question);
            }
        }
        return output;
    }

    public static void initTruncatedThemes(Themes<Object> themes, Themes<Object> truncatedThemes, int bound) {
        while (truncatedThemes.getThemes().size() < bound) {
            String randomTheme = themeConstants.values()[RandomUtils.selectRandom(themes.getThemes().size())].name();
            if (!truncatedThemes.getThemes().containsKey(randomTheme)) {
                truncatedThemes.addTheme(randomTheme);
            }
        }
    }

    public static void initSelectedThemes(Themes<Object> themes, String t1, String t2, String t3) {
        themes.addTheme(t1);
        themes.addTheme(t2);
        themes.addTheme(t3);
    }

    public static void playerAction(Player player, List<Question<Object>> diffQuestions, int difficulty) {
        int scoreIncrement = 2;
        if (difficulty == 2){
            scoreIncrement = 3;
        } else if (difficulty == 3){
            scoreIncrement = 5;
        }
        Question<Object> randomQuestion = diffQuestions.get(RandomUtils.selectRandom(diffQuestions.size()));

        String questionForPlayer = randomQuestion.getQuestionBody() + System.lineSeparator() + randomQuestion.getQuestionChoice();

        //display question and compute player's answer
        System.out.println(questionForPlayer);
        System.out.println("Player [" + player.getId() + "] ANSWER :");
        if (randomQuestion.getAnswer().equals(player.userInput())) {
            player.setScore(player.getScore() + scoreIncrement);
            System.out.println("Correct Answer! "+ scoreIncrement +"points awarded, your current score is : " + player.getScore());

        } else {
            System.out.println("Wrong answer! Correct answer was " + randomQuestion.getAnswer() + " your current score is : " + player.getScore());
        }
        //ensures a new question is selected
        Question<Object> newRandomQuestion = diffQuestions.get(RandomUtils.selectRandom(diffQuestions.size()));
        if (!newRandomQuestion.equals(randomQuestion)) {
            randomQuestion = newRandomQuestion;
        }

    }

    public static String checkUserInput(Themes<Object> themes, Player player) {
        while (true) {
            String currentUserInput = player.userInput();
            if (themes.getThemes().containsKey(currentUserInput)) {
                return currentUserInput;
            } else {
                System.out.println("Wrong input, please select one of the remaining themes (Case Sensitive)");
                System.out.print("Try again : ");
            }
        }
    }

    public static int getMaxScore(Players players) {
        int max = 0;
        List<Player> listPlayer = players.getSelectedPlayers();
        for (int i = 0; i < listPlayer.size(); i++) {
            if (listPlayer.get(i).getScore() >= max) {
                max = listPlayer.get(i).getScore();
            }
        }
        return max;
    }

    public static List<Player> getWinners(Players players, int maxScore) {
        List<Player> listPlayer = players.getSelectedPlayers();
        List<Player> listWinner = new ArrayList<>();
        for (int i = 0; i < listPlayer.size(); i++) {
            if (listPlayer.get(i).getScore() == maxScore) {
                listPlayer.get(i).setState("winner");
                listWinner.add(listPlayer.get(i));
            }
        }
        return listWinner;
    }

    public static Player getLoser(Players players) {
        int min = 999;
        Player loser = null;
        List<Player> listPlayer = players.getSelectedPlayers();
        for (int i = 0; i < listPlayer.size(); i++) {
            if (listPlayer.get(i).getScore() <= min) {
                min = listPlayer.get(i).getScore();
                loser = listPlayer.get(i);
            }
        }
        return loser;
    }
}


package quizz.theme;

import quizz.Utils.RandomUtils;
import quizz.constants.themeConstants;
import quizz.questions.Question;

import java.lang.reflect.Array;
import java.util.*;

public class Themes<T> {
    LinkedHashMap<String , LinkedList<Question<T>>> themeMap = new LinkedHashMap<>();
    HashMap <Integer, String> indexMap = new HashMap<>();
    int themesSize;

    public void addTheme(String name) {
        themeMap.put(name, new LinkedList<>());
        indexMap.put(themesSize, name);
        themesSize++;
    }

    public void deleteQuestion(String theme, int index) {
        themeMap.get(theme).remove(index);
    }

    /**
     * Adds to the theme a question that has to be initialized before
     * @param theme
     * @param question
     */
    public void addQuestion(String theme, Question<T> question){
        themeMap.get(theme).add(question);
    }

    public Map<String, LinkedList<Question<T>>> getThemes(){
        return themeMap;
    }

    /**
     * displays index and the theme associated with it
     */
    public void displayThemesAndIndex(){
        for (int i = 0; i < themesSize; i++){
            System.out.println("Index " + i + " : " + indexMap.get(i));
        }
    }

}

package quizz.theme;

import quizz.questions.Question;

import java.util.*;

public class Themes<T> {
    LinkedHashMap<String , LinkedList<Question<T>>> themeMap = new LinkedHashMap<>();
    int themesSize;

    public void addTheme(String name) {
        themeMap.put(name, new LinkedList<>());
        themesSize++;
    }

    public Map<String, LinkedList<Question<T>>> getThemes(){
        return themeMap;
    }

    public void addQuestion(String theme, Question<T> question){
        themeMap.get(theme).add(question);
    }





}

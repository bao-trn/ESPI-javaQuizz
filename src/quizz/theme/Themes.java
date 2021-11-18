package quizz.theme;

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

    public void addQuestion(String theme, Question<T> question){
        themeMap.get(theme).add(question);
    }

    public Map<String, LinkedList<Question<T>>> getThemes(){
        return themeMap;
    }

    public void displayThemesAndIndex(){
        for (int i = 0; i < themesSize; i++){
            System.out.println("Index : " + i + " " + indexMap.get(i));
        }
    }

    public ArrayList<Integer> selectFiveRandomThemes(){
        ArrayList<Integer> randomIndexArray= new ArrayList<Integer>();
        Random random = new Random();
        for (int i = 0; i < themesSize; i++){
            if (i == 5){
                break;
            }
            int myRandom = random.nextInt(themesSize);
            if (!randomIndexArray.contains(myRandom)){
                randomIndexArray.add(myRandom);
            }
        }
        return randomIndexArray;
    }


}

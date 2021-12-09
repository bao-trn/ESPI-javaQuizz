package quizz.Utils;

import quizz.constants.themeConstants;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomUtils {


    public static int selectRandom(int bound){
        Random random = new Random();
        return random.nextInt(bound);
    }

    public List<String> selectRandomThemes(int bound){
        ArrayList<Integer> randomIndexArray= new ArrayList<>();
        ArrayList<String> indexToTheme = new ArrayList<>();
        while(randomIndexArray.size() < bound) {
            int myRandom = RandomUtils.selectRandom(10);
            if (!randomIndexArray.contains(myRandom)){
                randomIndexArray.add(myRandom);
                indexToTheme.add(themeConstants.values()[myRandom].toString());
            }
        }
        return indexToTheme;
    }
}

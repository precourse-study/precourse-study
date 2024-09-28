package baseball.util;

import baseball.validation.InputValidator;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class UserUtil {

    public List<Integer> setUserNum() {
        List<Integer> userNum = new ArrayList<>();
        String[] input = Console.readLine().split("");

        InputValidator inputValidator = new InputValidator();
        inputValidator.validate(input);

        convertToIntegerList(input, userNum);

        return userNum;
    }

    private void convertToIntegerList(String[] input, List<Integer> userNum) {
        for(String s : input) {
            userNum.add(Integer.parseInt(s));
        }
    }

}

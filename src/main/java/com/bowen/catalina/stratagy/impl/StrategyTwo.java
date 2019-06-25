package com.bowen.catalina.stratagy.impl;

import com.bowen.catalina.constants.KeyNum;
import com.bowen.catalina.constants.OutputText;
import com.bowen.catalina.stratagy.Strategy;

public class StrategyTwo implements Strategy {


    public String generateOutputText(int targetNum) {
        StringBuilder stringBuilder = new StringBuilder(4); // enough for most cases and minimize memory footprints
        String targetNumInStr = String.valueOf(targetNum);

        if (targetNum % KeyNum.THREE == 0 || targetNumInStr.contains(KeyNum.THREE_STR)) {
            stringBuilder.append(OutputText.FIZZ);
        }

        if (targetNum % KeyNum.FIVE == 0 || targetNumInStr.contains(KeyNum.FIVE_STR)) {
            stringBuilder.append(OutputText.BUZZ);
        }

        return stringBuilder.length() > 0 ? stringBuilder.toString() : String.valueOf(targetNum);
    }
}

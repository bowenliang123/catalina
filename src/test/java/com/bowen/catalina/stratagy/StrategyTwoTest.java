package com.bowen.catalina.stratagy;

import com.bowen.catalina.executor.StrategyExecutor;
import com.bowen.catalina.stratagy.impl.StrategyTwo;
import org.junit.Before;
import org.junit.Test;
import com.bowen.catalina.util.HelpMessageUtil;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class StrategyTwoTest {

    private StrategyExecutor strategyExecutor;

    @Before
    public void prepareStrategy() {
        this.strategyExecutor = new StrategyExecutor(new StrategyTwo());
    }

    @Test
    public void executeFullLoopAndOutput() {
        this.strategyExecutor.loopAndOutput(100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void executeLoopWithZero() {
        this.strategyExecutor.loopAndOutput(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void executeLoopWithNegative() {
        this.strategyExecutor.loopAndOutput(-1);
    }


    @Test
    public void testGenerateMsg() {

        IntStream.rangeClosed(1, 100)
                .forEach(i -> {
                    // execute
                    String resultStr = this.strategyExecutor.generateText(i);


                    // conditions & assertions
                    String numStr = String.valueOf(i);
                    boolean flag1 = i % 3 == 0 || numStr.contains("3");
                    boolean flag2 = i % 5 == 0 || numStr.contains("5");

                    if (flag1 && flag2) {
                        assertEquals(HelpMessageUtil.getHelpMsg(i), "FizzBuzz", resultStr);
                    } else if (flag1) {
                        assertEquals(HelpMessageUtil.getHelpMsg(i), "Fizz", resultStr);
                    } else if (flag2) {
                        assertEquals(HelpMessageUtil.getHelpMsg(i), "Buzz", resultStr);
                    }

                });
    }

    private String getHelpMessageWithNum(int i) {
        return "inputNum:" + i;
    }
}
package com.bowen.catalina.stratagy;

import com.bowen.catalina.executor.StrategyExecutor;
import com.bowen.catalina.stratagy.impl.StrategyOne;
import org.junit.Before;
import org.junit.Test;
import com.bowen.catalina.util.HelpMessageUtil;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class StrategyOneTest {

    private StrategyExecutor strategyExecutor;

    @Before
    public void prepareStrategy() {
        this.strategyExecutor = new StrategyExecutor(new StrategyOne());
    }

    @Test
    public void executeNormalFullLoopAndOutput() {
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
                    // execution
                    String resultStr = this.strategyExecutor.generateText(i);

                    // conditions & assertions
                    if (i % 3 == 0 && i % 5 == 0) {
                        assertEquals(HelpMessageUtil.getHelpMsg(i), "FizzBuzz", resultStr);
                    } else if (i % 3 == 0) {
                        assertEquals(HelpMessageUtil.getHelpMsg(i), "Fizz", resultStr);
                    } else if (i % 5 == 0) {
                        assertEquals(HelpMessageUtil.getHelpMsg(i), "Buzz", resultStr);
                    }

                });
    }


}
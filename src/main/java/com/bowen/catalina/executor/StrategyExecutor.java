package com.bowen.catalina.executor;


import com.bowen.catalina.stratagy.Strategy;

import java.util.stream.IntStream;


/**
 * The executor for calculating and ouput
 * adapting to different strategy with same loop execution framework
 * <p>
 * author: Bowen Liang
 * date: 2019-06-25
 */
public class StrategyExecutor {

    // changeable strategy
    private Strategy strategy;

    public StrategyExecutor(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * generate and print out the whole list of output message
     * from 1 to maxNum
     *
     * @param maxNum maxNum number no less than 1
     */
    public void loopAndOutput(int maxNum) {
        // guard checking: check the input parameter no less than the starting number 1
        if (maxNum < 1) {
            throw new IllegalArgumentException("invalid maxNum parameter below 1.");
        }

        // loop every number with IntStream, for better readability and less possible mistakes
        // or just... for (int i = 1; i <= maxNum; i++) {
        IntStream.rangeClosed(1, maxNum)
                .forEach(i -> {
                    String text = generateText(i);
                    System.out.println(text);
                });
    }


    /**
     * generate result using preset strategy
     *
     * @param targetNum target number no less than 1
     * @return
     */
    public String generateText(int targetNum) {
        // guard checking: check the input number no less than the starting number 1
        if (targetNum < 1) {
            throw new IllegalArgumentException("invalid max parameter below 1.");
        }

        if (this.strategy == null) {
            throw new RuntimeException("no preset strategy in this executor");
        }

        return this.strategy.generateOutputText(targetNum);
    }
}

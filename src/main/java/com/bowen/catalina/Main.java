package com.bowen.catalina;

import com.bowen.catalina.executor.StrategyExecutor;
import com.bowen.catalina.stratagy.impl.StrategyOne;
import com.bowen.catalina.stratagy.impl.StrategyTwo;

public class Main {

    /**
     * mini program entrance
     *
     * @param args
     */
    public static void main(String[] args) {
        StrategyExecutor executorForStage1 = new StrategyExecutor(new StrategyOne());
        executorForStage1.loopAndOutput(100);

        StrategyExecutor executorForStage2 = new StrategyExecutor(new StrategyTwo());
        executorForStage2.loopAndOutput(100);
    }
}

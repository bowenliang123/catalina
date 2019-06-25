package com.bowen.catalina;

import com.bowen.catalina.stratagy.StrategyOneTest;
import com.bowen.catalina.stratagy.StrategyTwoTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        StrategyOneTest.class,      // unit test for stage 1
        StrategyTwoTest.class       // unit test for stage 2
})
public class StrategyTestSuite {
}

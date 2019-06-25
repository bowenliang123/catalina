package com.bowen.catalina.stratagy;

public interface Strategy {

    /**
     * Generate output text for target number
     * @param targetNum Target Number
     * @return output message text
     */
    String generateOutputText(int targetNum);
}

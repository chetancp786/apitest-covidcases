package com.collectapi.utils;

import net.bytebuddy.utility.RandomString;
import org.apache.log4j.PropertyConfigurator;

import java.util.Random;

/**
 * Utility methods to use when needed i.e generating random string and number
 */

public class TestUtils {

    //Configuring log4j for generating logs
    public TestUtils(){
        PropertyConfigurator.configure(System.getProperty("user.dir")+"/src/test/java/resources/propertyfile/log4j2.properties");

    }

    public static String getRandomValue(){
        Random random = new Random();
        int randomInt = random.nextInt(100000);
        return Integer.toString(randomInt);
    }

    public static String getRandomText() {
        String rndText;
        RandomString rnd = new RandomString(10);
        return rndText = rnd.nextString();
    }
}

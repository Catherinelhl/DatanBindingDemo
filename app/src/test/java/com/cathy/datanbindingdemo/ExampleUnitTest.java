package com.cathy.datanbindingdemo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect()
    {
//        assertEquals(4, 2 + 2);
        System.out.println("this is a test.....");
        try {
            second();
        }catch (Exception e){
            System.out.println(e.getMessage());

        }
    }
    private void second(){
        System.out.println("second");
        first();
    }

    public void first(){
        throw new RuntimeException("RuntimeException");
    }
}
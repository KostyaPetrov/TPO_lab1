package ru.konstantinpetrov;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SinusFunctionTest {

    private SinusFunction sinusFunction;

    @BeforeEach
    void setUp(){
        sinusFunction=new SinusFunction();
    }

    @Test
    void testSineExpansionTruth(){
        assertAll(
                () -> assertEquals(-1, sinusFunction.sineExpansion(5,10))
        );
    }

    @Test
    void testSineExpansionFalse(){
        assertAll(
                () -> assertNotEquals(1, sinusFunction.sineExpansion(5,10))
        );
    }

    @Test
    void getFact(){
        assertAll(
                () -> assertEquals(3628800, sinusFunction.getFact(10))
        );
    }


}

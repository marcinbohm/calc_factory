package com.mb.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(MockitoJUnitRunner.class)
public class NumericUtilTest {

    @Test
    public void isNumeric() {
        assertTrue(NumericUtil.isNumeric("3"));
    }

    @Test
    public void isNotNumeric() {
        assertFalse(NumericUtil.isNumeric("da"));
    }
}
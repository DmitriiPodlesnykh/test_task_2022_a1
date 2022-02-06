package com.auto1.task;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Before;

import static com.auto1.task.TestDataConstants.TEST_EXIST_SECRET_VALUE;

public class NumberKeyStorageTest extends TestCase {

    private NumberKeyStorage sut;

    @Before
    public void setUp() {
        sut = new NumberKeyStorage();
    }

    public void testAdd_validKey_saveValue() {
        Object result = sut.add(10, TEST_EXIST_SECRET_VALUE);

        Assert.assertTrue(sut.getSecret(10).isPresent());
        //Assert.assertEquals(TEST_EXIST_SECRET_VALUE, result);
    }
}
package com.auto1.task;


import com.auto1.task.exception.InvalidKeyInputException;
import com.auto1.task.model.Secret;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;

import static com.auto1.task.TestDataConstants.TEST_EXIST_SECRET_VALUE;
import static org.junit.Assert.assertTrue;

public class StorageTest {

    private static final String TEST_NOT_EXIST_KEY = "TEST_NOT_EXIST_KEY";
    private static final String TEST_EXIST_KEY = "mY-cUsTom-kEy";
    private static final String TEST_EXIST_KEY_UPPER_CASE = TEST_EXIST_KEY.toUpperCase(Locale.ROOT);
    private static final String TEST_TOO_LONG_KEY = "TEST_TOO_LONG_KEYTEST_TOO_LO_KEY";

    private Storage sut;

    @Before
    public void setUp() {
        sut = new Storage();
    }

    @Test
    public void testGenerateKey_returnDiffKeys() {
        String first = sut.generateKey();
        String second = sut.generateKey();

        Assert.assertNotEquals(first, second);

        Map<Object, Object> a = null;
        a.map
    }

    @Test(expected = InvalidKeyInputException.class)
    public void testAdd_moreThan20Length_throwException() {
        sut.add(TEST_TOO_LONG_KEY, TEST_EXIST_SECRET_VALUE);
    }

    @Test(expected = InvalidKeyInputException.class)
    public void testAdd_blankKey_throwException() {
        sut.add("", TEST_EXIST_SECRET_VALUE);
    }

    @Test
    public void testGetSecret_notExistKey_returnEmptyOptional() {
        assertTrue(sut.getSecret(TEST_NOT_EXIST_KEY).isEmpty());
    }

    @Test
    public void testGetSecret_existKey_returnSecret() {
        sut.add(TEST_EXIST_KEY, TEST_EXIST_SECRET_VALUE);

        assertTrue(sut.getSecret(TEST_EXIST_KEY).isPresent());
    }

    @Test
    public void testGetSecret_caseInsensitiveKey_returnSecret() {
        sut.add(TEST_EXIST_KEY_UPPER_CASE, TEST_EXIST_SECRET_VALUE);

        assertTrue(sut.getSecret(TEST_EXIST_KEY).isPresent());
    }
}
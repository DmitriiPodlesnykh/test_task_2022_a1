package com.auto1.task;

import com.auto1.task.exception.InvalidKeyInputException;
import com.auto1.task.model.Secret;
import org.apache.commons.lang3.StringUtils;


public class NumberKeyStorage extends Storage{

    public Object add(Integer key, Secret secret) {
        if (key == null) {
            throw new InvalidKeyInputException("more than 20!!!");
        }
        return addGeneral(key, secret);
    }
}

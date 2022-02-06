package com.auto1.task;

import com.auto1.task.exception.InvalidKeyInputException;
import com.auto1.task.model.Secret;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public class Storage {

    protected final Map<Object, Secret> storageMap = new HashMap<>();

    public String generateKey(){
        return RandomStringUtils.random(10);
    }

    public Object add(String key, Secret secret) {
        if (StringUtils.isBlank(key) || key.length() > 20) {
            throw new InvalidKeyInputException("more than 20!!!");
        }
        return addGeneral(key.toUpperCase(Locale.ROOT), secret);
    }


    public Optional<Secret> getSecret(Object key) {
        if (key instanceof String) {
            String keyString = (String) key;
            return Optional.ofNullable(storageMap.get(keyString.toUpperCase(Locale.ROOT)));
        } else if (key instanceof Integer) {
            return Optional.ofNullable(storageMap.get(key));
        }
        throw new RuntimeException();
    }

    protected Object addGeneral(Object key, Secret secret) {
        return storageMap.put(key, secret);
    }
}

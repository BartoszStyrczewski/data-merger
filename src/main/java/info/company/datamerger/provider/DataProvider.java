package info.company.datamerger.provider;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public interface DataProvider<D> {

    static DataProvider<Integer> randomInt() {
        return () -> new Random().nextInt(10);
    }

    static DataProvider<String> randomString() {
        return () -> RandomStringUtils.random(5, true, false);
    }

    D get();
}

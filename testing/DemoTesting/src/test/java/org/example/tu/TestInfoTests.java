package org.example.tu;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class TestInfoTests {
    private Logger logger = Logger.getLogger(TestInfoTests.class.getName());

    private List<Integer> integers = Arrays.asList(1,2,3,4,5,6,7,8,9);

    @BeforeEach
    void beforeEachTest(TestInfo testInfo, RepetitionInfo repetitionInfo) {
        logger.info(String.format("Repetition %d/%d for %s", repetitionInfo.getCurrentRepetition(), repetitionInfo.getTotalRepetitions(), testInfo.getTestMethod().get().getName()));
    }

    @RepeatedTest(value = 9)
    void repeatTest() {

    }
}

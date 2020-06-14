package ru.netology.service;

import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

class CashbackHackServiceTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/data.csv", numLinesToSkip = 1)
    void amountNotEqualsZero(int amount, int expected) {
        CashbackHackService cashbackHackService = new CashbackHackService();
        if (amount <= 0) {
            assertThrows(IllegalArgumentException.class, () -> cashbackHackService.remain(0));
        }

        else {
            int actual = cashbackHackService.remain(amount);
            assertEquals(expected, actual);
        }
    }
}

// https://claudeleloup.developpez.com/tutoriels/access/calcul-du-code-iban/#LII

package org.example.iban;

import org.example.iban.models.Iban;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_METHOD)
public class IbanTests {

    @Nested
    class ValidBbanArguments {
        @Test
        @DisplayName("Valid arguments, valid BBAN")
        public void validBban() {
            assertDoesNotThrow(()->{Iban iban = new Iban("377080141235");},"Invalid account number.");
        }
    }

    @Nested
    class InvalidBbanArguments {
        @Test
        @DisplayName("Invalid characters caused by a letter")
        void invalidCharactersCausedByLetter() {
            assertEquals("Invalid characters.", assertThrows(IllegalArgumentException.class, ()->{Iban iban = new Iban("37708014123A");}).getMessage());
        }

        @Test
        @DisplayName("Invalid characters caused by a space")
        void invalidCharactersCausedBySpace() {
            assertEquals("Invalid characters.", assertThrows(IllegalArgumentException.class, ()->{Iban iban = new Iban("377080 141235");}).getMessage());
        }

        @Test
        @DisplayName("Invalid characters caused by +")
        void invalidCharactersCausedByOperation() {
            assertEquals("Invalid characters.", assertThrows(IllegalArgumentException.class, ()->{Iban iban = new Iban("377080+41235");}).getMessage());
        }

        @Test
        @DisplayName("BBAN too short")
        void invalidBbanTooShort() {
            assertEquals("Invalid account number. BBAN account number too short.", assertThrows(IllegalArgumentException.class, ()->{Iban iban = new Iban("37708014123");}).getMessage());
        }

        @Test
        @DisplayName("BBAN too long")
        void invalidBbanTooLong() {
            assertEquals("Invalid account number. BBAN account number too long.", assertThrows(IllegalArgumentException.class, ()->{Iban iban = new Iban("3770801412356");}).getMessage());
        }

        @Test
        @DisplayName("Invalid BBAN")
        void invalidBban() {
            assertEquals("Invalid account number.", assertThrows(IllegalArgumentException.class, ()->{Iban iban = new Iban("377080141234");}).getMessage());
        }
    }

    @Nested
    class InvalidIbanArguments {
        @Test
        @DisplayName("Invalid characters caused by a letter")
        void invalidCharactersCausedByLetter() {
            assertEquals("Invalid characters.", assertThrows(IllegalArgumentException.class, ()->{Main.verifyIban("BE5737708014123A");}).getMessage());
        }

        @Test
        @DisplayName("Invalid characters caused by a space")
        void invalidCharactersCausedBySpace() {
            assertEquals("Invalid characters.", assertThrows(IllegalArgumentException.class, ()->{Main.verifyIban("BE57 77080141235");}).getMessage());
        }

        @Test
        @DisplayName("Invalid characters caused by +")
        void invalidCharactersCausedByOperation() {
            assertEquals("Invalid characters.", assertThrows(IllegalArgumentException.class, ()->{Main.verifyIban("BE5737708+141235");}).getMessage());
        }

        @Test
        @DisplayName("IBAN too short")
        void invalidBbanTooShort() {
            assertEquals("Invalid argument. Iban too short.", assertThrows(IllegalArgumentException.class, ()->{Main.verifyIban("BE5737708014123");}).getMessage());
        }

        @Test
        @DisplayName("IBAN too long")
        void invalidBbanTooLong() {
            assertEquals("Invalid argument. Iban too long.", assertThrows(IllegalArgumentException.class, ()->{Main.verifyIban("BE573770801412356");}).getMessage());
        }

        @Test
        @DisplayName("Wrong country code")
        void invalidBbanWrongCountryCode() {
            assertEquals("Invalid argument. Wrong country code.", assertThrows(IllegalArgumentException.class, ()->{Main.verifyIban("CL57377080141235");}).getMessage());
        }
    }

    @Nested
    class Methods {
        @Test
        @DisplayName("getIban() method success")
        void getIbanSuccess() {
            assertEquals("BE57377080141235", new Iban("377080141235").getIban());
        }

        @Test
        @DisplayName("calculateControl() method success")
        void calculateControlSuccess() {
            assertEquals("57", Iban.calculateControl("377080141235"));
        }

        @Test
        @DisplayName("calculateControl() method fail")
        void calculateControlFail() {
            assertNotEquals("58", Iban.calculateControl("377080141235"));
        }

        @Test
        @DisplayName("verifyIban() method success")
        void verifyIbanSuccess() {
            assertEquals(true, Main.verifyIban("BE57377080141235"));
        }

        @Test
        @DisplayName("verifyIban() method fail")
        void verifyIbanFail() {
            assertEquals(false, Main.verifyIban("BE57377080141234"));
        }
    }
}

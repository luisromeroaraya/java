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
    class ValidArguments {
        @Test
        @DisplayName("Valid arguments, valid BBAN")
        public void validBban() {
            assertDoesNotThrow(()->{Iban iban = new Iban("377080141235");},"Invalid account number.");
        }
    }

    @Nested
    class InvalidArguments {
        @Test
        @DisplayName("Invalid characters caused by a letter")
        void invalidCharactersCausedByLetter() {
            assertEquals("Invalid characters.", assertThrows(IllegalArgumentException.class, ()->{Iban iban = new Iban("37708014123A");}).getMessage());
        }

        @Test
        @DisplayName("Invalid characters caused by a space")
        void invalidCharactersCausedBySpace() {
            assertEquals("Invalid characters.", assertThrows(IllegalArgumentException.class, ()->{Iban iban = new Iban("377080 41235");}).getMessage());
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
        @DisplayName("verifyIban() method success")
        void verifyIbanSuccess() {
            assertEquals(true, Main.verifyIban("BE57377080141235"));
        }
    }
}

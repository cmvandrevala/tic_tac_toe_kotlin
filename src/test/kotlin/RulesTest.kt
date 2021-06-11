import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RulesTest {
    @Test
    fun whenALedgerHasNoMoves_thenTheGameIsInProgress() {
        val ledger = Ledger();
        val rules = Rules(ledger);
        Assertions.assertFalse(rules.gameOver());
    }

    @Test
    fun whenALedgerHasTheMaximumNumberOfMoves_thenTheGameIsOver() {
        val ledger = Ledger();
        for (i in 1..9) {
            ledger.append(LedgerEntry("name", i));
        }
        val rules = Rules(ledger);
        Assertions.assertTrue(rules.gameOver());
    }

    @Test
    fun whenThereIsAWinner_thenTheGameIsOver() {
        val ledger = Ledger();
        for (i in 1..3) {
            ledger.append(LedgerEntry("name", i));
        }
        val rules = Rules(ledger);
        Assertions.assertTrue(rules.gameOver());
    }

    @Test
    fun whenThereIsNoWinner_thenTheRulesReturnsNoWinner() {
        val ledger = Ledger();
        val rules = Rules(ledger);
        Assertions.assertNull(rules.winner());
    }

    @Test
    fun whenAPlayerHasThreeMarksInARowInTheTopRow_thenTheyWinTheGame() {
        val ledger = Ledger();
        for (i in 1..3) {
            ledger.append(LedgerEntry("name", i));
        }
        val rules = Rules(ledger);
        Assertions.assertEquals("name", rules.winner());
    }

    @Test
    fun whenAPlayerHasThreeMarksInARowInTheMiddleRow_thenTheyWinTheGame() {
        val ledger = Ledger();
        for (i in 4..6) {
            ledger.append(LedgerEntry("craig", i));
        }
        val rules = Rules(ledger);
        Assertions.assertEquals("craig", rules.winner());
    }

    @Test
    fun whenAPlayerHasThreeMarksInARowInTheBottomRow_thenTheyWinTheGame() {
        val ledger = Ledger();
        for (i in 7..9) {
            ledger.append(LedgerEntry("anna", i));
        }
        val rules = Rules(ledger);
        Assertions.assertEquals("anna", rules.winner());
    }

    @Test
    fun whenAPlayerHasThreeMarksInTheLeftColumn_thenTheyWinTheGame() {
        val ledger = Ledger();
        for (i in listOf(1, 4, 7)) {
            ledger.append(LedgerEntry("anna", i));
        }
        val rules = Rules(ledger);
        Assertions.assertEquals("anna", rules.winner());
    }

    @Test
    fun whenAPlayerHasThreeMarksInTheMiddleColumn_thenTheyWinTheGame() {
        val ledger = Ledger();
        for (i in listOf(2, 5, 8)) {
            ledger.append(LedgerEntry("anna", i));
        }
        val rules = Rules(ledger);
        Assertions.assertEquals("anna", rules.winner());
    }

    @Test
    fun whenAPlayerHasThreeMarksInTheRightColumn_thenTheyWinTheGame() {
        val ledger = Ledger();
        for (i in listOf(3, 6, 9)) {
            ledger.append(LedgerEntry("anna", i));
        }
        val rules = Rules(ledger);
        Assertions.assertEquals("anna", rules.winner());
    }

    @Test
    fun whenAPlayerHasThreeMarksInTheLeftDiagonal_thenTheyWinTheGame() {
        val ledger = Ledger();
        for (i in listOf(1, 5, 9)) {
            ledger.append(LedgerEntry("anna", i));
        }
        val rules = Rules(ledger);
        Assertions.assertEquals("anna", rules.winner());
    }

    @Test
    fun whenAPlayerHasThreeMarksInTheRightDiagonal_thenTheyWinTheGame() {
        val ledger = Ledger();
        for (i in listOf(3, 5, 7)) {
            ledger.append(LedgerEntry("anna", i));
        }
        val rules = Rules(ledger);
        Assertions.assertEquals("anna", rules.winner());
    }

    @Test
    fun whenTwoPlayersHaveMadeMultipleMoves_thenTheWinnerIsReturned() {
        val ledger = Ledger();
        for (i in 7..9) {
            ledger.append(LedgerEntry("A", i));
        }
        for (i in 1..2) {
            ledger.append(LedgerEntry("B", i));
        }
        val rules = Rules(ledger);
        Assertions.assertEquals("A", rules.winner());
    }
}
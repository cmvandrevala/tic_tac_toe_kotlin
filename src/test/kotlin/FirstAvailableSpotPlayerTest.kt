import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FirstAvailableSpotPlayerTest {
    @Test
    fun whenNoMovesHaveBeenMade_thenItMovesInCellOne() {
        val ledger = Ledger();
        val player = FirstAvailableSpotPlayer(ledger);
        Assertions.assertEquals(1, player.move());
    }

    @Test
    fun whenCellOneHasBeenTaken_thenItMovesInCellTwo() {
        val ledger = Ledger();
        ledger.append(LedgerEntry("x",1))
        val player = FirstAvailableSpotPlayer(ledger);
        Assertions.assertEquals(2, player.move());
    }

    @Test
    fun whenCellFiveHasBeenTaken_thenItMovesInCellOne() {
        val ledger = Ledger();
        ledger.append(LedgerEntry("x",5))
        val player = FirstAvailableSpotPlayer(ledger);
        Assertions.assertEquals(1, player.move());
    }

    @Test
    fun whenAPlayerNameIsSpecified_thenYouCanRetrieveTheName() {
        val ledger = Ledger()
        val player = FirstAvailableSpotPlayer(ledger, "Some Name");
        Assertions.assertEquals("Some Name", player.name());
    }
}
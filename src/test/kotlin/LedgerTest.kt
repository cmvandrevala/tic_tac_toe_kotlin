import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LedgerTest {
    @Test
    fun whenALedgerIsCreated_thenItHasNoMoves() {
        val ledger = Ledger();
        Assertions.assertEquals(0, ledger.moveCount());
    }

    @Test
    fun whenASingleMoveIsMade_thenItHasOneMove() {
        val ledger = Ledger();
        ledger.append(LedgerEntry(playerName = "Name", cell = 5));
        Assertions.assertEquals(1, ledger.moveCount());
    }

    @Test
    fun whenALedgerHasNoEntries_thenItReturnsAnEmptyListOfMarkedSpots() {
        val ledger = Ledger();
        var emptyMap = HashMap<String, List<Int>>();
        Assertions.assertEquals(emptyMap, ledger.moves());
    }

    @Test
    fun whenALedgerHasOneEntry_thenItReturnsOnePlayerNameWithOneMarkedCell() {
        val ledger = Ledger();
        ledger.append(LedgerEntry(playerName = "Name", cell = 6));
        var output = HashMap<String, List<Int>>();
        output.put("Name", listOf(6));
        Assertions.assertEquals(output, ledger.moves());
    }

    @Test
    fun whenALedgerHasTwoEntries_thenItReturnsTwoPlayerNamesWithTwoMarkedCells() {
        val ledger = Ledger();
        ledger.append(LedgerEntry(playerName = "Name 1", cell = 1));
        ledger.append(LedgerEntry(playerName = "Name 2", cell = 7));
        var output = HashMap<String, List<Int>>();
        output.put("Name 1", listOf(1));
        output.put("Name 2", listOf(7));
        Assertions.assertEquals(output, ledger.moves());
    }

    @Test
    fun whenALedgerHasManyEntriesForOnePlayer_thenItReturnsThePlayerNamesWithMultipleMarkedCells() {
        val ledger = Ledger();
        ledger.append(LedgerEntry(playerName = "Name", cell = 1));
        ledger.append(LedgerEntry(playerName = "Name", cell = 2));
        var output = HashMap<String, List<Int>>();
        output.put("Name", listOf(1, 2));
        Assertions.assertEquals(output, ledger.moves());
    }
}
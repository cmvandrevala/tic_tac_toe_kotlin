import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class GameTest {
    @Test
    fun whenAGameCreatedWithTwoFirstAvailableSpotPlayers_thenItPlaysThroughToAWinner() {
        var ledger = Ledger();
        var playerOne = FirstAvailableSpotPlayer(ledger);
        var playerTwo = FirstAvailableSpotPlayer(ledger);
        var game = Game(ledger, playerOne, playerTwo);
        game.play();
        Assertions.assertEquals(playerOne.name(), game.winner());
    }

    @Test
    fun whenAGameCreatedWithTwoComputerPlayers_thenItPlaysThroughToAWinner() {
        var ledger = Ledger();
        var playerOne = RandomPlayer(3);
        var playerTwo = FirstAvailableSpotPlayer(ledger);
        var game = Game(ledger, playerOne, playerTwo);
        game.play();
        Assertions.assertEquals(playerTwo.name(), game.winner());
    }
}
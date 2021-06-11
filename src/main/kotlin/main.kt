fun main(args: Array<String>) {
    val ledger = Ledger();
    val playerOne = FirstAvailableSpotPlayer(ledger, "Player 1");
    val playerTwo = FirstAvailableSpotPlayer(ledger, "Player 2");
    val game = Game(ledger, playerOne, playerTwo);
    game.play();
}
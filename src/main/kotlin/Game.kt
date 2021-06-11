class Game {
    private var ledger: Ledger
    private var rules: Rules
    private var playerOne: Player
    private var playerTwo: Player
    private var currentPlayer: Player

    constructor(ledger: Ledger, playerOne: Player, playerTwo: Player) {
        this.ledger = ledger
        this.rules = Rules(ledger)
        this.playerOne = playerOne
        this.playerTwo = playerTwo
        this.currentPlayer = playerOne
    }

    fun play() {
        if (rules.gameOver()) {
            println("Winner: " + winner())
        } else {
            val entry = LedgerEntry(this.currentPlayer.name(), this.currentPlayer.move())
            this.ledger.append(entry)
            swapPlayers()
            println("Current Moves: " + this.ledger.moves())
            this.play()
        }
    }

    fun winner(): String {
        return rules.winner() ?: ""
    }

    fun swapPlayers() {
        if (this.currentPlayer == playerOne) {
            this.currentPlayer = playerTwo
        } else {
            this.currentPlayer = playerOne
        }
    }
}
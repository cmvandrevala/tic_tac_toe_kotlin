class Rules {
    private var boardSize: Int;
    private var ledger: Ledger;

    constructor(ledger: Ledger = Ledger()) {
        this.ledger = ledger;
        this.boardSize = 9;
    }

    fun gameOver(): Boolean {
        return drawGame() || winner() != null;
    }

    fun winner(): String? {
        for (move in ledger.moves()) {
            if (containsWinningCombo(move.value)) {
                return move.key;
            }
        }
        return null;
    }

    private fun drawGame(): Boolean {
        return this.ledger.moveCount() >= this.boardSize;
    }

    private fun containsWinningCombo(cells: List<Int>): Boolean {
        for (pattern in winningPatterns()) {
            if (cells.containsAll(pattern)) {
                return true;
            }
        }
        return false;
    }

    private fun winningPatterns(): List<List<Int>> {
        return listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9), listOf(1, 4, 7), listOf(2, 5, 8), listOf(3, 6, 9), listOf(1, 5, 9), listOf(3, 5, 7));
    }
}
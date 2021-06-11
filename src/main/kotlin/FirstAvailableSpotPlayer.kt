class FirstAvailableSpotPlayer : Player {
    private var ledger: Ledger;
    private var name: String;

    constructor(ledger: Ledger, name: String = "First Spot") {
        this.ledger = ledger;
        this.name = name;
    }

    override fun move(): Int {
        return move(1);
    }

    private fun move(cell: Int = 1): Int {
        return if (takenCells().contains(cell)) {
            move(cell + 1);
        } else {
            cell;
        }
    }

    override fun name(): String {
        return this.name;
    }

    private fun takenCells(): List<Int> {
        return ledger.moves().map { it.value }.flatten();
    }
}
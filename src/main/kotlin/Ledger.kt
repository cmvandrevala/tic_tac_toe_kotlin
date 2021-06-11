class Ledger {
    private var entries: MutableList<LedgerEntry> = mutableListOf();

    fun moveCount(): Int {
        return entries.size;
    }

    fun append(entry: LedgerEntry) {
        entries.add(entry);
    }

    fun moves(): HashMap<String, List<Int>> {
        var moves = HashMap<String, List<Int>>();
        for(playerName in playerNames()) {
            moves.put(playerName, movesAssociatedWithPlayerName(playerName));
        }
        return moves;
    }

    private fun playerNames(): List<String> {
        return entries.map { it.playerName }.distinct();
    }

    private fun movesAssociatedWithPlayerName(playerName: String): List<Int> {
        return entries.filter { it.playerName == playerName }.map { it.cell };
    }
}
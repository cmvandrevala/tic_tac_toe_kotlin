import kotlin.random.Random

class RandomPlayer : Player {
    private var random: Random;

    constructor(seed: Int) {
        this.random = Random(seed);
    }

    override fun move(): Int {
        return this.random.nextInt(1, 9);
    }

    override fun name(): String {
        return "Random";
    }
}
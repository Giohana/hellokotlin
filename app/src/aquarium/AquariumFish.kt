package aquarium

abstract class AquariumFish {
    abstract val color: String
}

class Shark: AquariumFish() {
    override val color = "cinza"

    override fun eat() {
        println("pescar e comer peixe")
    }
}

class Peixe: AquariumFish() {
    override val color = "dourado"
    override fun eat(){
        println("muita alga")
    }
}

interface FishAction {
    fun eat()
}

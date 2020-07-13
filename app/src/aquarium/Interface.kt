package aquarium

interface AquariumAction {
    fun eat()
    fun jump()
    fun clean()
    fun catchFish()
    fun swim() {
        println("nadando")
    }

}

interface  FishAction {
    fun eat()
}

abstract class AquariumFish: FishAction {
    abstract val color: String
    override fun eat() = println("yum")
}

fun main(args: Array<String>){
    delegate()
}

fun delegate() {
    val pleco = Peixe()
    println("Peixe tem cor ${pleco.color}")
    pleco.eat()
}

interface FishColor {
    val color: String
}

class Peixe(fishColor: FishColor = GoldColor):
        FishAction by PrintingFishAction("muita alga")
        FishColor by fishColor

object GoldColor: FishColor {
    override val color = "dourado"
}

object RedColor: FishColor{
    override val color = "red"
}

class PrintingFishAction(val food: String): FishAction {
    override fun eat() {
        println(food)
    }
}
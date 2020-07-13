
fun String.hasSpace() = find { it == '' } != null
}

fun extensionsExample() {
    "Tem espaço ainda?".hasSpace()
}

open class AquariumPlant(val color: String, private val size: Int)
class GreenLeafyPlant(size: Int): AquariumPlant("verde", size)
fun AquariumPlant.isRed() = color == "Vermelho"

fun AquariumPlant.isBig() = size > 50

fun AquariumPlant.print()= println("AquariumPlant")

fun GreenLeafyPlant.print()= println("GreenLeafyPlant")

fun staticExample(){
    val plant = GreenLeafyPlant(size = 50)
    plant.print()

    val aquariumPlant: AquariumPlant = plant
    aquariumPlant.print()
}

val AquariumPlant.isGreen: Boolean
    get() = color == "Green"

fun propertyExample(){
    val plant = AquariumPlant("verde", 50)
    plant.isGreen
}

fun AquariumPlant?.pull(){
    this?.apply{
        println("removendo $this")
    }
}

fun nullableExample() {
    val plant: AquariumPlant? = null
    plant.pull()
}
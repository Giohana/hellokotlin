package aquarium.Decoration

fun main(args: Array<String>) {
    makeDecorations()
}

fun makeDecorations() {
    val d1 = Decorations("Granito")
    println(d1)

    val d2 = Decorations("ardosia")
    println(d2)

    val d3 = Decorations("ardosia")
    println(d3)

    println(d1.equals(d2))
    println(d3.equals(d2))

    val d4: Decorations = d3.copy()
    println(d3)
    println(d4)

    val d5 = Decorations2("crystal", "madeira", "bolhas")
    println(d5)

    val(rock: kotlin.String, wood: String, diver: String) = d5
    println(rock)
    println(wood)
    println(diver)
}

data class Decorations(val rocks: String) {}

data class Decorations2(val rocks: String, val woods: String, val diver: String){

}



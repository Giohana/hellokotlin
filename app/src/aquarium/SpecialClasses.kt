package aquarium

object MobyDickWhale {
    val author = "Herman Melville"
    fun jump(){
    }
}

enum class Color(val rgb: Int){
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF)
}

//sealed - boa para chamar e detectar erro na api de rede
sealed class Seal

class LeaoMarinho: Seal()
class Morsa: Seal()

fun matchSeal(seal: Seal): String {
    return when(seal) {
        is morsa -> "morsa"
        is leaoMarinho -> "Leao Marinho"
    }
}
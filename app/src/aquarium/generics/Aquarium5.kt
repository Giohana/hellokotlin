fun main(args: Array<String>) {
    fishExamples()

}

data class Fish(val name: String)

fun fishExemples() {
    val fish = Fish("cleber")

    //inline um objeto é criado a cada chamada para myWith
    myWith(fish.name, object : Function1<String, Unit>){
        override fun invoke(name: String) {
            name.capitalize()
        }
    }

    //com inline, nenhum objeto é criado e o corpo lambda é incorporado aqui
    fish.name.capitalize()
}

inline fun myWith(name: String, block: String.() -> Unit) {
    name.block()
}
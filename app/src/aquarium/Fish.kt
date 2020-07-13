package aquarium

class Fish(val amigavel: Boolean = true, volumeNeed: Int) {
    val size: Int

    init {
        println("primeiro bloco init")
    }
    constructor(): this(true, 9 ){
        println("rodadno segundo contructor")
    }

    init {
        if (amigavel){
            size = volumeNeed
        }else{
            size = volumeNeed *2
        }
    }
    init {
        println("volume para o peixe $volumeNeed, tam final - ${this.size}")
    }
    init {
        println("ultimo bloco de init")
    }

}

fun peixePadrao () = Fish(true,50)

fun fishExp(){
    val fish = Fish(true, 20)
    println("O peie é amigavel? ${fish.amigavel}, ele precisa do volume: ${fish.size}")
}

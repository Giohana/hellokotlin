package aquarium

fun man(arg: Array<String>){
    buildAquarium()
}

fun buildAquarium(){
    val myAquarium = Aquarium()
    println("Length: ${myAquarium.length}" +
            "width: ${myAquarium.width}" +
            "height: ${myAquarium.height}")

    myAquarium.height = 80

    println("height: ${myAquarium.height} cm")
    println("Volume: ${myAquarium.volume} litros")

    val peqAquario = Aquarium(length= 20, width= 15, height = 30)
    println("aquario pequeno: ${peqAquario.volume} litros")

    val myAquarium2 = Aquarium(numerodePeixe = 9)

    println("pequeno aquarium 2: ${myAquarium2.volume} litros com " +
        "length ${myAquarium2.length} " +
        "width ${myAquarium2.width} " +
        "heigth ${myAquarium2.height} "
    )

}

fun feedFish(fish: FishAction) {
    fish.eat()
}

fun makeFish() {
    val shark = Shark()
    val pleco = Peixe()

    println("Tubarao: ${shark.color} \n Peixe: ${pleco.color}")
    shark.eat()
    pleco.eat()
}
package aquarium

fun main(args: Array<String>) {
    val testList: List<int> = listOf(11,12,13,14,15,16,17,18,19,20)

    println(testList.reserved())
}

fun reverseList(list: List<Int>): List<Int> {
    val result: MutableList<Int> = mutableListOf<Int>()
    for(i:Int in 0..list.size-i-1){
        result.add(list[list.size-i-1])
    }
    return result
}

fun reverseListAgain(list: List<Int>): List<Int> {
    val result: MultableList<int> = mutableListOf<Int>()
    for(i:int in list.size -1 downTo 0) {
        result.add(list.get(i))
    }
    return result
}

////////////////////////////////////////////////////////////////////////////////////////////////////
fun main(args: Array<String>) {
    val symptoms: MutableList<String> = mutableListOf("maxhas brancas",
                                                      "manchas vermelhas",
                                                      "não comendo",
                                                      "inchado",
                                                      "boiando")

    symptoms.add("fungo branco")
    symptoms.remove("fungo branco")

    symptoms.contains("vermelhas") //false
    symptoms.contains("manchas vermelhas") // true

    println(symptoms.subList(4, symptoms.size))

    listOf(1,5,3).sum()
    listOf("a", "b", "cc").sumBy {it.length}
}

////////////////////////////////////////////////////////////////////////////////////////////////////

fun main(args: Array<String>) {
    val cures: Map<String, String> = mapOf("manchas brancas" to "Ich", "machas vermelhas" to "hole disease")

    println(cures.get("manchas brancas"))
    println(cures.["manchas brancas"])

    println(cures.getOrDefault("boiando", "desculpa, eu não sei"))

    cures.getOrElse("boiando"){"Não tem cura para isso"}

    val invertory: MutableMap<String, Int> = mutableMapOf("rede" to 1)
    invertory.put("lavador de taque", 3)
    invertory.remove("rede")
}





















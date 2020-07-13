import java.util.*

//##################################################################################################
// SISTEMA DE UM AQUARIO
fun main(args: Array<String>) {
    println("ola, ${args[0]}")
    feedthefish()

    var bubbles = 0
    while(bubbles < 50){
        bubbles++
    }

    repeat(2){
        println("Um peixe esta nadando")
    }

}

fun swim() {

}

fun eagerExample(){
    val decorations = listOf ("pedra", "planta", "casa", "bamboo", "ruby")
    val eager = decorations.filter { it[0] == 'p' }
    println(eager)
}

fun shouldChangeWater(
    day: String,
    temperature: Int = 22,
    dirty: Int = 20) : Boolean{

    fun isTooHot(temperature: Int) = temperature > 30
    fun isDirty(dirty: Int) = dirty >30
    fun isSunday(day: String) = day == "Sunday"

    return when {
        isTooHot(temperature) > 30 -> true
        isDirty(dirty) > 30 -> true
        isSunday(day) == "Sunday" -> true
        else -> false
    }
}

var dirty = 20
val waterfilter: (Int)-> Int = {dirty -> dirty/2}
fun feedFish (dirty: Int) = dirty + 10
fun updateDirty(dirty: Int, operation: (Int) -> Int): {
    return operation(dirty)
}
fun dirtyProcessor() {
    dirty = updateDirty(dirty, waterfilter)
    dirty = updateDirty(dirty, ::feedFish)
    dirty = upadateDirty(dirty, {dirty -> dirty + 50})
}


fun getDirtySensorReading() = 20

fun feedthefish(){
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    if(shouldChangeWater(day)) {
        println("Troque a agua hoje")
    }
    dirtyProcessor()

    swin(50, speed="slow")

    shouldChangeWater(day,20,50)
    shouldChangeWater(day)
    shouldChangeWater(day,dirty = 50)
}

fun swin(time: Int, speed: String = "fast"){
    println("nadando $speed")
}

fun randomDay(): String {
    val week = listOf("Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo")
    return week[Random().nextInt(7)]
}


fun fishFood(day : String) : String {
    var food = "comendo"

    when (day){
        "Segunda" -> "Flocos"
        "Terça" -> "palitos"
        "Quarta" -> "ração"
        "Quinta" -> "farelo"
        "Sexta" -> "granulado"
        "Sabado" -> "plankton"
        "Domingo" -> "mosquitoes"
        else -> "comendo"
    }
    return food
}




//##################################################################################################
// EXERCICIO COM FILTER

val spices = listOf("curry", "pepper", "cayenne", "ginger", "red curry", "green curry", "red pepper" )

// classificando curry pelo tamanho da string
println(spices.filter { it.contains("curry") }.sortedBy { it.length })

// filtrando os que começam com 'c' e terminam com 'e'
println(spices.filter{it.startsWith('c')}.filter{it.endsWith('e')})
//ou "spices.filter { {it.startsWith('c') && it.endsWith('e') }"

// os 3 primeiros começando com 'c'
spices.take(3).filter{it.startsWith('c')}


//##################################################################################################
//EXERCICIOS COM LAMBDA
val rollDice = { Random().nextInt(12) + 1}

val rollDice = { sides: Int ->
    Random().nextInt(sides) + 1
}

val rollDice0 = { sides: Int ->
    if (sides == 0) 0
    else Random().nextInt(sides) + 1
}

val rollDice2: (Int) -> Int = { sides ->
    if (sides == 0) 0
    else Random().nextInt(sides) + 1
}

gamePlay(rollDice2(4))
fun gamePlay(diceRoll: Int){
    println(diceRoll)
}

//##################################################################################################
// ESPECIARIAS
// CLASSES

class SimpleSpice {
    var nome= "curry"
    var picancia = "suave"

    var heat : Int
        get() {return 5}
}

val simpleSpice = SimpleSpice()
println("nome ${simpleSpice.nome}, picancia ${simpleSpice.heat}")

class Spice(var name: String, val picancante: String = "suave") {
    private val heat: Int
        get() {
            return when(picancante){
                "suave" -> 1
                "medio" -> 3
                "picante" -> 5
                "muito picante" -> 7
                "extremante picante" -> 10
                else -> 0
            }
        }
}

val spices1 = listOf(
    Spice("curry", "suave"),
    Spice("papper", "medio"),
    Spice("cayenne", "picante"),
    Spice("ginger", "suave"),
    Spice("red curry", "media"),
    Spice("greem curry", "suave"),
    Spice("hot papper", "extremante picante")
)

val spice = Spice("cayanne", "picante")
val spicelist = spices1.filter { it.heat < 5 }

fun makeSalt() = Spice("Salt")

// INTERFACES ABSTRATO

class Curry(name: String, spiciness: String,
            color: #333333; SpiceColor = YellowSpiceColor) : Spice(name, spiciness), Grinder, SpiceColor by color {

    override fun prepareSpice() {
        grind()
    }
}

interface SpiceColor {
    val color: String
}

object YellowSpiceColor : SpiceColor {
    override val color = "Yellow"
}

val mySpice = Curry("yellow curry", "mild")
println(mySpice.color)

abstract class Spice (val name: String, val spiciness: String = "mild", color: SpiceColor): SpiceColor by color

data class SpiceContainer(var spice: Spice) {
    val label = spice.name
}

val spiceCabinet = listOf(SpiceContainer(Curry("Yellow Curry", "mild")),
    SpiceContainer(Curry("Red Curry", "medium")),
    SpiceContainer(Curry("Green Curry", "spicy")))

for(element in spiceCabinet) println(element.label)

enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF),
    YELLOW(0XFFFF00)
}
interface SpiceColor {
    val color: Cor
}

object YellowSpiceColor : SpiceColor {
    override val color = Color.YELLOW
}
//##################################################################################################
// HERANÇA

open class Book(val titulo: String, val autor: String){
    private var currentPage = 1

    open fun readPage(){
        currentPage++
    }
}

class EBook(titulo: String, autor: String, var format: String = "texto"): Book(titulo, autor){
    private var palavrasread = 0

    override  fun readpage() {
        palavrasread = palavrasread + 250
    }
}

class Books(val title: String, val author: String, val year: Int) {

    fun getTitleAuthor(): Pair<String, String> {
        return (title to author)
    }

    fun getTitleAuthorYear(): Triple<String, String, Int> {
        return Triple(title, author, year)
    }
}

fun main(args: Array<String>) {

    val book = Books("Romeo e Julieta", "William Shakespeare", 1597)
    val bookTitleAuthor = book.getTitleAuthor()
    val bookTitleAuthorYear = book.getTitleAuthorYear()

    println("Seu livro ${bookTitleAuthor.first} de ${bookTitleAuthor.second}")

    println("Seu livro ${bookTitleAuthorYear.first} " +
            "de ${bookTitleAuthorYear.second} escrito em ${bookTitleAuthorYear.third}")

}

val moreBooks = mapOf<String, String>("Wilhelm Tell" to "Schiller")
moreBooks.getOrElse("Jungle Book") { "Kipling" }
moreBooks.getOrElse("Hamlet") { "Shakespeare" }
println(moreBooks)

const val MAX_NUMBER_BOOKS = 20

fun canBorrow(hasBooks: Int): Boolean {
    return (hasBooks <= MAX_NUMBER_BOOKS)
}

object Constants {
    const val BASE_URL = "http://www.turtlecare.net/"
}

fun printUrl() {
    println(Constants.BASE_URL + title + ".html")
}

companion object {
    val BASE_URL = "https://s.ftcdn.net/v2013/pics/all/curated/RKyaEDwp8J7JKeZWQPuOVWvkUjGQfpCx_cover_580.jpg?r=1a0fc22192d0c808b8bb2b9bcfbf4a45b1793687"
}

fun Book.weight() : Double { return (pages * 1.5) }

fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0

class Puppy() {
    fun playWithBook(book: Book) {
        book.tornPages(Random().nextInt(12))
    }
}

fun Book.weight() : Double { return (pages * 1.5) }
fun Book.tornPages(torn: Int) = if (pages >= torn) pages -= torn else pages = 0
class Puppy() {
    fun playWithBook(book: Book) {
        book.tornPages(Random().nextInt(12))
    }
}
val puppy = Puppy()
val book = Book("Oliver Twist", "Charles Dickens", 1837, 540)

while (book.pages > 0) {
    puppy.playWithBook(book)
    println("${book.pages} left in ${book.title}")
}
println("Sad puppy, no more pages in ${book.title}. ")


//##################################################################################################
// CLASSES GENERICAS

open class BaseBuildingMaterial() {
    open val numberNeeded = 1
}

class Wood : BaseBuildingMaterial() {
    override val numberNeeded = 4
}

class Brick : BaseBuildingMaterial() {
    override val numberNeeded = 8
}

class Building<T: BaseBuildingMaterial>(val buildingMaterial: T) {

    val baseMaterialsNeeded = 100
    val actualMaterialsNeeded = buildingMaterial.numberNeeded * baseMaterialsNeeded

    fun build() {
        println(" $actualMaterialsNeeded ${buildingMaterial::class.simpleName} requiritado")
    }
}

fun main(args: Array<String>) {
    Building(Wood()).build()
}

<<<<<<<<<<<<< Dia aleatorios >>>>>>
        import java.util.*

fun main(args: Array<String>) {
    println("ola, ${args[0]}")
    feedthefish()
}

fun shouldChangeWater(
    day: String,
    temperature: Int = 22,
    dirty: Int = 20) : Boolean{
    return true
}

fun feedthefish(){
    val day = randomDay()
    val food = fishFood(day)
    println("Today is $day and the fish eat $food")
    if(shouldChangeWater(day)) {
        println("Troque a agua hoje")
    }
    swin(50, speed="slow")

    shouldChangeWater(day,20,50)
    shouldChangeWater(day)
    shouldChangeWater(day,dirty = 50)
}

fun swin(time: Int, speed: String = "fast"){
    println("nadando $speed")
}

fun randomDay(): String {
    val week = listOf("Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sabado", "Domingo")
    return week[Random().nextInt(7)]
}


fun fishFood(day : String) : String {
    var food = "comendo"

    when (day){
        "Segunda" -> "Flocos"
        "Terça" -> "palitos"
        "Quarta" -> "ração"
        "Quinta" -> "farelo"
        "Sexta" -> "granulado"
        "Sabado" -> "plankton"
        "Domingo" -> "mosquitoes"
        else -> "comendo"
    }
    return food
}

<<<<<<<<<<< Que dia é hoje? >>>>>
        import java.util.*

fun main(args: Array<String>) {
    dayOfWeek()
}

fun dayOfWeek(){
    println("que dia é hoje")
    var dia = Calendar.getInstance().get(Calendar.DAY_OF_WEEK)
    println(when(dia){
        1 -> "Domingo"
        2 -> "Segunda"
        3 -> "Terça"
        4 -> "Quarta"
        5 -> "Quinta"
        6 -> "Sexta"
        7 -> "Sabado"
        else -> "ERROR"
    })
}

<<<<<<<< Temperatura do aquario >>>>>>>
        import java.util.*

fun main(args: Array<String>) {
    println("Hello, ${args[0]}")

    val isunit = println("isto é uma expressao")
    println(isunit)

    val temperature = 10
    val ishot = if(temperature>50) true else false
    println(ishot)

    val mensage = "Voce esta ${if (temperature>50) "com frio" else "bem"} peixe"
    println(mensage)
}

<<<<<<<<<<<<< frases aniversario >>>>>>
        import java.util.*

fun main(args: Array<String>) {
    println("Sua frase é: ${getFortuneCookie()}")
    getFortuneCookie()
}


}
fun getFortuneCookie(): String {
val frases = listOf("You will have a great day!",
"Things will go well for you today.",
"Enjoy a wonderful day of success.",
"Be humble and all will turn out well.",
"Today is a good day for exercising restraint.",
"Take it easy and enjoy life!",
"Treasure your friends because they are your greatest fortune.")

print("Entre com o seu aniversario: ")
val birthday = readLine()?.toIntOrNull() ?: 1

return frases[birthday.rem(frases.size)]

}

<<<<<<<<<<<<< capacidade aquario>>>>>>
fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
return (tankSize * if (hasDecorations) 0.8 else 1.0) >= (currentFish.sum() + fishSize)
}


fun main(args: Array<String>) {
var fortune: String
for (i in 1..10) {
fortune = getFortune()
println("\nYour fortune is: $fortune")
if (fortune.contains("Take it easy")) break
}
}

<<<<<<<<<<<<<<< codigo 5 >>>>>>>>>>>
fun main(args: Array<String>) {
var fortune: String
for (i in 1..10) {
fortune = getFortune(getBirthday())
println("\nYour fortune is: $fortune")
if (fortune.contains("Take it easy")) break;
}
}

fun getBirthday(): Int {
print("\nEnter your birthday: ")
return readLine()?.toIntOrNull() ?: 1
}

fun getFortune(birthday: Int): String {
val fortunes = listOf("You will have a great day!",
"Things will go well for you today.",
"Enjoy a wonderful day of success.",
"Be humble and all will turn out well.",
"Today is a good day for exercising restraint.",
"Take it easy and enjoy life!",
"Treasure your friends, because they are your greatest fortune.")
val index = when (birthday) {
in 1..7 -> 4
28, 31 -> 2
else -> birthday.rem(fortunes.size)
}
return fortunes[index]
}

<<<<<<<<<<<< codigo 7 >>>>>>>>>>>>>>>>>>

fun main(args: Array<String>) {
println(whatShouldIDoToday("happy", "sunny"))
println(whatShouldIDoToday("sad"))
print("How do you feel?")
println(whatShouldIDoToday(readLine()!!))
}

fun isVeryHot (temperature: Int) = temperature > 35
fun isSadRainyCold (mood: String, weather: String, temperature: Int) =
mood == "sad" && weather == "rainy" && temperature == 0
fun isHappySunny (mood: String, weather: String) = mood == "happy" && weather == "sunny"
fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24) : String {
return when {
isVeryHot(temperature) -> "go swimming"
isSadRainyCold(mood, weather, temperature) -> "stay in bed"
isHappySunny(mood, weather) -> "go for a walk"
else -> "Stay home and read."
}
}

// com repeat
fun main(args: Array<String>) {
var fortune: String = ""
repeat (10) {
fortune = getFortune(getBirthday())
println("\nYour fortune is: $fortune")
if (fortune.contains("Take it easy")) break;
}
}
//com while
fun main(args: Array<String>) {
var fortune: String = ""
while (!fortune.contains("Take it easy")) {
fortune = getFortune(getBirthday())
println("\nYour fortune is: $fortune")
}
}

//break

fun labels() {
    loop@ for(i :int in 1..100){
        for(j :int in 1..100){
            if(i>10) break@loop
        }
    }
}
enum class Direction {
    NORTH, EAST, WEST, SOUTH, START, END
}

class Game {
    var path = mutableListOf<Direction>(Direction.START)
    val north = { path.add(Direction.NORTH) }
    val south = { path.add(Direction.SOUTH) }
    val east = { path.add(Direction.EAST) }
    val west = { path.add(Direction.WEST) }
    val end = { path.add(Direction.END); println("Game Over: $path"); path.clear(); false }
}

fun main(args: Array<String>) {
    val game = Game()
    println(game.path)
    game.north()
    game.south()
    game.east()
    game.west()
    game.end()
    println(game.path)
}

fun move(where: () -> Boolean ) {
    where.invoke()
}

fun makeMove(command:String?) {
    if (command.equals("n")) move(north)
    else if (command.equals("s")) move(south)
    else if (command.equals("e")) move(east)
    else if (command.equals("w")) move(west)
    else move(end)
}

while (true) {
    print("Enter a direction: n/s/e/w: ")
    game.makeMove(readLine())
}
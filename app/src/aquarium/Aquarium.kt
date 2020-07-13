package aquarium
import kotlin.math.PI

class Aquarium (var length: Ont = 100, var heigth: Int = 40, var width: Int = 20) {

    open val volume : Int
        get() = width * heigth * length / 1000
        set(value) {heigth = (value * 1000) / (width * length)}

    open var water = volume = 0.0
    constructor(numerodePeixe: Int): this(){
        val water: Int = numerodePeixe = 2000 //cm^3
        val tanque: Double = water + water * 0,1
        heigth = (tanque / (length * width)).toInt()
    }
}

class tanquecilindrico(): Aquarium(){
    override var water = volume * 0.8

    override var volume: Int
        get() = (width * heigth * length / 1000 * PI).toInt()
        set(value) {
            heigth = (value * 1000) / (width * length)
        }
}




/* CLASSES
 + public- Default
 + private- File
 + internal- Module
 + protected- Inside Class(subclasses podem ver)
 */
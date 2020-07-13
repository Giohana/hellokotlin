
open class WaterSupply(var needsProcessed: Boolean)

class TapWater : WaterSupply(true){
    fun addChemicalCleaners(){
        needsProcessed= false
    }
}

class FishStoreWater :  WaterSupply(false)

class LakeWater : WaterSupply(true) {
    fun filter() {
        needsProcessed = false
    }

}

class Aquarium<T: WaterSupply>(val waterSupply: T) {
    fun addwater(cleaner: Cleaner<T>) {
        if(waterSupply.needsProcessed) {
           cleaner.clear(waterSupply)
        }
        println("adicione agua para $waterSupply")
    }
}

interface Cleaner<in T: WaterSupply> {
    fun clean(waterSupply: <T>)
}


class TapWaterCleaner: Cleaner<TapWater>{
    override fun clean(waterSupply: TapWater){
        waterSupply.addChemicalCleaners()
    }
}

fun addItemTo{aquarium: Aquarium<WaterSupply} = println("item added")

fun genericExample() {
    val aquarium = Aquarium<TapWater> = Aquarium(TapWater())
    aquarium.waterSupply.addChemicalCleaners()

    val aquarium4 : Aquarium<LakeWater> = Aquarium(LakeWater())
    aquarium4.waterSupply.filter()
    aquarium4.addwater()

    val aquarium = Aquarium("string")

    val cleaner = TapWaterCleaner()
    val aquarium5: Aquarium<TapWater> = Aquarium(TapWater())
    aquarium5.addwater(cleaner)
    aquarium5.hasWaterSupplyOfType<TapWater>()  //true
    aquarium5.waterSupply.isOfType<LakeWater>()  // false
}

class Building<out T: BaseBuildingMaterial>(val buildingMaterial: T)

// funcoes genericas
inline fun <reified R: WaterSupply> Aquarium<*>.hasWaterSupplyOfType() = waterSupply is R

fun <T: WaterSupply> isWaterClean(aquarium: Aquarium<T>) {
    println("a agua do aquario esta limpa: ${aquarium.waterSupply.needsProcessed}")
}

inline fun <reified T: WaterSupply> WaterSupply.isOfType() = this is T

fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) {
    if (building.actualMaterialsNeeded < 500) println("Small building")
    else println("large building")
}
isSmallBuilding(Building(Brick()))
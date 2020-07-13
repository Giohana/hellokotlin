//anotações

@file: JvmName("InteropFish")

class InteropFish {
    companion object {
        @JvmStatic fun interop(){

        }
    }
}

@ImAPlant class plant {
    fun trim(){}
    fun fertilize() {}

    @get:OnGet
    val isGrowing: Boolean = true

    @set:OnSet
    var needsFood: Boolean = false

}

annotation class ImAPlant

@Target(AnnotationTarget.PROPERTY_GETTER)
annotation class OnGet

@Target(AnnotationTarget.PROPERTY_SETTER)
annotation class OnSet

fun reflections() {
    val classObj: KClass<Plant> = Plant::class

    for(annotation:Annotation in classObj.annotations){
        println(annotation.annotationClass.simpleName)
    }

    val annotated: ImAPlant? = classObj.findAnnotation<ImAPlant>()

    annotated?.apply {
        println("Encontrou uma anotação de planta!")
    }
}
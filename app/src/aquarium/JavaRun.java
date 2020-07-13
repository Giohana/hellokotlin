interface Runnable {
    fun run()
}

interface Callable<T> {
    fun call(): T
}

public class JavaRun {

    public static void runNow(Runnable runnable) {
        runnable.run();
    }
}

fun example(){
    val runnable = object: Runnable {
        override fun() {
            println("eu sou runnable")
        }
    }
    JavaRun.runNow(runnable);
}

fun exaplee() {
    JavaRun.runNow{
        println("passando lambda para runnable")
    }
}
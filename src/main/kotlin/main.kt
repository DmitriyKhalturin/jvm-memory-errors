import kotlin.random.Random

fun testStack(i: Int) {
    println("Iteration $i")

    val j = i + 1

    testStack(j)
}

private const val STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-"

fun testMemory() {
    val list  = mutableListOf<Data>()

    while (true) {
        val data = Data()
        list.add(data)

        println("Array size: ${list.size}")
    }
}

private const val STACK_OVERFLOW_ARG = "--stack-overflow"
private const val OUT_OF_MEMORY_ARG = "--out-of-memory"

fun main(args: Array<String>) {
    println("Start test...")

    if (args.contains(STACK_OVERFLOW_ARG)) try {
        testStack(0)
    } catch (e: StackOverflowError) {
        // TODO: try handle this error
    }

    if (args.contains(OUT_OF_MEMORY_ARG)) try {
        testMemory()
    } catch (e: OutOfMemoryError) {
        // TODO: try handle this error
    }
}

class Data {
    // TODO: try create value without last byte
    private val memory: String = STRING + Random.nextBytes(1)
}

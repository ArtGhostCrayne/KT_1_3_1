fun main(args: Array<String>) {

    val seconds: Int = 5 * 60 * 60

    println("был(а) в сети " + agoToText(seconds))

}

fun agoToText(seconds: Int): String {
    return when (seconds) {
        in 0..60 -> "только что"
        in 61..3600 -> (seconds / 60).toString() + numeral(seconds / 60, 1) + " назад"
        in 3601..24 * 60 * 60 -> (seconds / 3600).toString() + numeral(seconds / 3600, 2) + " назад"
        in 24 * 60 * 60 + 1..2 * 24 * 60 * 60 -> "вчера"
        in 2 * 24 * 60 * 60 + 1..3 * 24 * 60 * 60 -> "позавчера"
        else -> "давно"
    }
}

fun numeral(count: Int, type: Int): String {
    var num = count % 100
    if (num > 19) {
        num = num % 10;
    }
    val result = when (type) {
        1 ->
            when (num) {
                1 -> " минуту"
                in 2..4 -> " минуты"
                else -> " минут"
            }

        2 ->
            when (num) {
                1 -> " час"
                in 2..4 -> " часа"
                else -> " часов"
            }

        else -> " "
    }
    return result
}
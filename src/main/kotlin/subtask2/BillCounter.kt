package subtask2

class BillCounter {

    // The output could be "Bon Appetit" or the string with number(e.g "10")
    fun calculateFairlySplit(bill: IntArray, k: Int, b: Int): String {

        // подсчитываем сумму "общака" деленного пополам за исключением одного аллегенного продукта
        val sum = (bill.sum() - bill[k]) / 2

        // сверяем расчеты била и предпологаемой сумы Анны
        return when {
            sum == b -> "Bon Appetit"
            sum < b -> (b-sum).toString()
            else -> "Anna wins"
        }
    }
}

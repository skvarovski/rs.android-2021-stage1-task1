package subtask1

class HappyArray {

    fun convertToHappy(sadArray: IntArray): IntArray {
        // копируем массив для модификаций
        val resultList = sadArray.toMutableList()

        // проходим по копии массива в реверсе
        for (i in resultList.size - 3 downTo 0) {
            // в случае выявления условия (по задаче) удаляем по нужному индексу плохое число
            if (resultList[i+2] + resultList[i] < resultList[i+1]) {
                resultList.removeAt(i+1)
            }
        }

        // возращаем результат в требуемом формате
        return resultList.toIntArray()
    }
}

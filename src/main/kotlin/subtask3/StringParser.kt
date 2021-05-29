package subtask3

class StringParser {

    fun getResult(inputString: String): Array<String> {

        // создаём результирующий список
        val result: MutableList<String> = mutableListOf()

        // функция обработки поступающих слов с поиском глубины открытых и закрытых
        fun searchOpenClosedBracket(s: String, open: Char, close: Char): String? {
            var depth: Int = 1
            s.forEachIndexed{ i, c ->
                if (c == open) ++depth
                if (c == close) --depth
                // как только открытые_тэги == закрытым_тегам => возращаем строку по индексу
                if (depth == 0) return s.take(i)
            }
            return null
        }


        // Проходим посимвольно строчки c текущим индексом и проверяем встречающий символ
        inputString.forEachIndexed { index, char ->
            // Добавим в переменную результат "функции обработки", когда встретился стартовый тэг
            val currentString: String? = when (char) {
                // если встретился необходимый тэг, то запускаем функцию с параметрами
                // передавая по остаточному оставшуюся часть строки и параметрами поиска
                '(' -> searchOpenClosedBracket(inputString.drop(index+1),'(',')')
                '[' -> searchOpenClosedBracket(inputString.drop(index + 1 ),'[',']')
                '<' -> searchOpenClosedBracket(inputString.drop( index + 1),'<','>')
                else -> null
            }
            // добавляем результат, если он есть
            if (currentString != null) result.add(currentString)

        }

        //возвращаем результат конвертируя в массив строк
        return result.toTypedArray()

    }
}

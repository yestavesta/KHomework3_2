fun main() {
    // println(feeCalculate(transactionSum = 100))
}

fun feeCalculate(cardType: String = "VK Pay", previousTransactionsSum: Int = 0, transactionSum: Int): Int {
    var result = -1
    val maestroAndMasterCardFeeStartLimit = 75_000
    val maestroAndMasterCardFeePercentage = 0.006
    val maestroAndMaterCardFeeExtra = 20

    val visaAndMirFeePercentage = 0.0075
    val visaAndMirFeeMinFee = 35

    val cardDayLimit = 150_000
    val cardMonthLimit = 600_000

    val vkPayDayLimit = 15_000
    val vkPayMonthLimit = 40_000

    when (cardType) {
        "VK Pay" -> {
            if (previousTransactionsSum + transactionSum <= vkPayMonthLimit && transactionSum <= vkPayDayLimit)
                result = 0
            else println("Превышен лимит переводов")
        }

        else -> {
            if (previousTransactionsSum + transactionSum <= cardMonthLimit && transactionSum <= cardDayLimit) {
                when (cardType) {
                    "Mastercard", "Maestro" -> {
                        if (previousTransactionsSum + transactionSum <= maestroAndMasterCardFeeStartLimit) result = 0
                        else result =
                            (transactionSum * maestroAndMasterCardFeePercentage).toInt() + maestroAndMaterCardFeeExtra
                    }

                    "Visa", "Мир" -> {
                        val preResult = (transactionSum * visaAndMirFeePercentage).toInt()
                        if (preResult > visaAndMirFeeMinFee) result = preResult
                        else result = visaAndMirFeeMinFee
                    }
                }
            } else println("Превышен лимит переводов")
        }
    }
    return result
}
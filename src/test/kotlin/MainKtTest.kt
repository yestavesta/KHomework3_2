import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun feeCalculateStandardParameters() {

        val result = feeCalculate(transactionSum = 100)
        assertEquals(0, result)
    }

    @Test
    fun feeCalculateVKPaySuccess() {
        val cardType = "VK Pay"
        val transactionSum = 10_000
        val result = feeCalculate(cardType, transactionSum = transactionSum)
        assertEquals(0, result)
    }

    @Test
    fun feeCalculateVKPayDailyLimitExceeded() {
        val cardType = "VK Pay"
        val transactionSum = 16_000
        val result = feeCalculate(cardType, transactionSum = transactionSum)
        assertEquals(-1, result)
    }

    @Test
    fun feeCalculateVKPayMonthlyLimitExceeded() {
        val cardType = "VK Pay"
        val previousTransactionsSum = 35_000
        val transactionSum = 6_000
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(-1, result)
    }

    @Test
    fun feeCalculateMaestroNoFee() {
        val cardType = "Maestro"
        val transactionSum = 10_000
        val result = feeCalculate(cardType, transactionSum = transactionSum)
        assertEquals(0, result)
    }

    @Test
    fun feeCalculateMastercardNoFee() {
        val cardType = "Mastercard"
        val transactionSum = 10_000
        val result = feeCalculate(cardType, transactionSum = transactionSum)
        assertEquals(0, result)
    }

    @Test
    fun feeCalculateMaestroWithFee() {
        val cardType = "Maestro"
        val transactionSum = 10_000
        val previousTransactionsSum = 70_000
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(80, result)
    }

    @Test
    fun feeCalculateMastercardWithFee() {
        val cardType = "Mastercard"
        val transactionSum = 10_000
        val previousTransactionsSum = 70_000
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(80, result)
    }

    @Test
    fun feeCalculateMaestroDailyLimitExceeded() {
        val cardType = "Maestro"
        val transactionSum = 160_000
        val previousTransactionsSum = 70_000
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(-1, result)
    }

    @Test
    fun feeCalculateMastercardDailyLimitExceeded() {
        val cardType = "Mastercard"
        val transactionSum = 160_000
        val previousTransactionsSum = 70_000
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(-1, result)
    }

    @Test
    fun feeCalculateMaestroMonthlyLimitExceeded() {
        val cardType = "Maestro"
        val transactionSum = 5_000
        val previousTransactionsSum = 599_000
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(-1, result)
    }

    @Test
    fun feeCalculateMastercardMonthlyLimitExceeded() {
        val cardType = "Mastercard"
        val transactionSum = 5_000
        val previousTransactionsSum = 599_000
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(-1, result)
    }

    @Test
    fun feeCalculateVisaWithFee() {
        val cardType = "Visa"
        val transactionSum = 10_000
        val previousTransactionsSum = 70_000
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(75, result)
    }

    @Test
    fun feeCalculateMirWithFee() {
        val cardType = "Мир"
        val transactionSum = 10_000
        val previousTransactionsSum = 70_000
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(75, result)
    }

    @Test
    fun feeCalculateVisaMinFee() {
        val cardType = "Visa"
        val transactionSum = 150
        val previousTransactionsSum = 0
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(35, result)
    }

    @Test
    fun feeCalculateMirMinFee() {
        val cardType = "Мир"
        val transactionSum = 150
        val previousTransactionsSum = 0
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(35, result)
    }

    @Test
    fun feeCalculateVisaDailyLimitExceeded() {
        val cardType = "Visa"
        val transactionSum = 151_000
        val previousTransactionsSum = 0
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(-1, result)
    }

    @Test
    fun feeCalculateMirDailyLimitExceeded() {
        val cardType = "Мир"
        val transactionSum = 151_000
        val previousTransactionsSum = 0
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(-1, result)
    }

    @Test
    fun feeCalculateVisaMonthlyLimitExceeded() {
        val cardType = "Visa"
        val transactionSum = 100_000
        val previousTransactionsSum = 550_000
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(-1, result)
    }

    @Test
    fun feeCalculateMirMonthlyLimitExceeded() {
        val cardType = "Мир"
        val transactionSum = 100_000
        val previousTransactionsSum = 550_000
        val result = feeCalculate(cardType, previousTransactionsSum, transactionSum)
        assertEquals(-1, result)
    }
}
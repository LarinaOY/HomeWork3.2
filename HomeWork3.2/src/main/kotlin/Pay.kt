fun main() {
    transferPayment("vkPay", 1000, 1000)
    transferPayment("mir", 1000, 1000)
    transferPayment("mir", 1000, 5000)
    transferPayment("visa", 1000, 1000)
    transferPayment("visa", 1000, 5000)
    transferPayment("mastercard", 5000, 5000)
    transferPayment("mastercard", 5000, 75000)
    transferPayment("maestro", 5000, 5000)
    transferPayment("maestro", 5000, 75000)


}

fun transferPayment(cardType: String, previousTransfers: Int, transfer: Int) {
    when {
        cardType == "vkPay" -> println("Сумма перевода составит " + transfer + " рублей Комиссия составит 0 коп.")
    }
    if (cardType == "mir" || cardType == "visa") {
        val commisionMirVisa = ((transfer * 100 * 0.0075) * 100).toInt() / 100
        if (commisionMirVisa >= 3500) {
            println("Сумма перевода составит " + transfer + " Комиссия составит " + commisionMirVisa + " коп.")
        } else println(" Сумма перевода составит " + transfer + " Коммисия составит " + 3500 + " коп.")
    }
    if (cardType == "mastercard" || cardType == "maestro") {
        val transferInMonth = ((previousTransfers + transfer) * 100).toInt()
        val commisionMaestroMastercard = (((transfer * 100 * 0.006) * 100).toInt() / 100) + 2000
        when {
            transferInMonth <= 7_500_000 -> println("Сумма перевода составит " + transfer + " рублей Комиссия составит 0 коп.")
            transferInMonth > 7_000_000 -> println("Сумма перевода составит " + transfer + " Комиссия составит " + commisionMaestroMastercard + " коп.")
        }
    }
}



















package com.example.lazy_evaluation_delegadoy_by

class Cart {
    val paymentConfig by lazy { Cart.loadAndPreparePaymentConfig() }

    fun checkout() {
        if (paymentConfig["type"] == "card") {
            // Do something
        }
    }

    companion object {
        fun loadAndPreparePaymentConfig(): Map<String, String> {
            println("Very Expansive Operation!!!!!.")
            return mapOf("currency" to "eur", "type" to "card")
        }
    }

}

fun main(args: Array<String>) {
    val cart = Cart()

    cart.checkout()
    cart.checkout()
}
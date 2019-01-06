package tk.pavi2410.aipro.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onInitialize()
    }

    abstract fun onInitialize()

    fun setTitleBarText(text: String) {
        print(text)
    }
}
package tk.pavi2410.aipro

import tk.pavi2410.aipro.core.Screen

class Screen1 : Screen() {
    override fun onInitialize() {
        print("Screen Initialized!")
        setTitleBarText("hello")
    }

    override fun onBackPressed() {
        super.onBackPressed()
        print("Back Pressed!")
    }
}
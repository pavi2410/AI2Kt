<p align="center">
  <img alt="AI2Kt" src="https://user-images.githubusercontent.com/28837746/196346557-c0b5f27b-8e08-4083-9510-5b6ad34fd42f.png" />
</p>

# AI2Kt

Framework to write Android apps in Kotlin with App Inventor-like experience.

## Philosophy

App Inventor is a great tool that enables anyone build an Android app without any prior programming knowledge. However, this still requires coding with a visual programming paradigm. This has helped many expand their horizons into the world of coding (including myself :P). So, why not help them further "graduate" to a more professional app development tool so that they can pursue their career or to support their business as it grows.

## Goal

This project was an experimentation to test Kotlin's DSL capabilities to mimick App Inventor block API. The core value of this project is to build a framework that can be a replacement for using App Inventor itself. This shouldn't require users to build a native Android app from scratch. Instead, users can easily replicate their blocks line-by-line (this part can be automated using code generation though)

## Architecture

- `core` "SDK" is an Android library module that provides the runtime and a set of components just as the `components` module found in the App Inventor sources.

  - `Screen`: This represents a single screen, equivalent to a `Form`
  
    > A Screen can either map one-to-one with an Android activity or we can use a single-activity architecture which is the norm these days.
  - `components` package hosts a set of components that mirrors from App Inventor ones.
  
  - UI is defined in XML files that replicate how its designed with App Inventor's form designer. (Note: This can now be switched to declarative UI within Kotlin code using Compose)
  
  - `Blocks`:
  
    - `event`: This is implemented using abstract methods.
    
    - `property`: This is a setter/getter pair.
    
    - `method`: This is a method defined under a component class.
    
    - `procedure`: This is a Kotlin function.
    
- `app` module is an example Android app module that depends on the `core` module.

## Example Screen (tentative)

```kt
class Screen1 : Screen(R.layout.screen1) { // Screen definition
    
    val Label1: Label by view              // get view references using Kotlin delegates
    val Button1: Button by view
    
    val count = 0                          // sort-of-a-global-variable

    override fun onInitialize() {          // Screen events are abstract methods
    
        val Notifier1 = Notifier()         // Instantiate non-visible components here
        
        Button1.onClick {                  // Component events are instance methods
        
           count++                         // update global variable anywhere
           
           Label1.Text = "Count " + count  // Propert setter
           
           if (count `equals to` 3) {      // Easy to translate logical and mathematical blocks using the power of Kotlin
           
               Notifier1.toast("Fizz")     // Method call on a non-visible compoent
           
           } else if (count == 5) {
           
               Notifier.toast("Buzz")      // Non-visible compoents can be single-instanced, where possible
           
           }
        }
    }
}
```

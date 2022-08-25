# ProcessDeath

Simple app to demonstrate various ways to retain and restore values between process death.

To perform process death, put the app in the background and then in the terminal issue this command:

`adb shell am kill com.realityexpander.processdeath`

Then open the app again, and all but the last button values should be restored.

Note: Unfortunately in the latest version of Android Studio, the "terminate application" button is now missing... why was it removed?

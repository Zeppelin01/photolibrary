# photolibrary
Android Application that queries IMDB movie data using OMDB API.

# Build APK
To build the APK, open a command line and navigate to the root of your project directory. To initiate a debug build, invoke the assembleDebug task:

    gradlew assembleDebug
    
This creates an APK named app-debug.apk in PhotoGallery/app/build/outputs/apk/debug. The file is already signed with the debug key and aligned with zipalign, so you can immediately install it on a device.

# Deply App to the Emulator
Once you have an Android Virtual Device (AVD), start the Android Emulator and install your app as follows:
1.	In a command line, navigate to android_sdk/tools/ and start the emulator by specifying your AVD:
2.	
    emulator -avd avd_name
    
If you're unsure of the AVD name, execute emulator -list-avds.
2.	Now you can install your app using either one of the Gradle install tasks mentioned in the section about how to build a debug APK or the 'adb' tool.
Note:If the APK is built using a developer preview SDK (if the targetSdkVersion is a letter instead of a number), you must include the -t option with the install command to install a test APK.
Navigate to the directory where the App is compiled and issue the command below:

    adb install path/to/app-debug.apk



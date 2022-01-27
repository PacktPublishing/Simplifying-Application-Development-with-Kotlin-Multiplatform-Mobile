# Simplifying Application Development with Kotlin Multiplatform Mobile

<a href="https://www.packtpub.com/product/simplifying-application-development-with-kotlin-multiplatform-mobile/9781801812580"><img src="https://static.packt-cdn.com/products/9781801812580/cover/smaller" alt="Simplifying Application Development with Kotlin Multiplatform Mobile" height="256px" align="right"></a>

This is the code repository for [DIY Microcontroller Projects for Hobbyists](https://www.packtpub.com/product/simplifying-application-development-with-kotlin-multiplatform-mobile/9781801812580), published by Packt.

**Write robust native applications for iOS and Android efficiently**

## What is this book about?
Sharing code between platforms can help developers gain a competitive edge, and Kotlin Multiplatform Mobile (KMM) offers a sensible way to do it. KMM helps mobile teams share code between Android and iOS in a flexible way, leaving room for native development.

This book covers the following exciting features:
* Get acquainted with the multiplatform approach and KMM's competitive edge
* Understand how Kotlin Multiplatform works under the hood
* Get up and running with the Kotlin language quickly in the context of Swift
* Find out how to share code between Android and iOS
* Explore tips and best practices in KMM to increase app development efficiency
* Discover adoption tips to integrate KMM into existing or new production apps

If you feel this book is for you, get your [copy](https://www.amazon.com/Simplifying-Application-Development-Kotlin-Multiplatform/dp/1801812586) today!


## Instructions and Navigations
All of the code is organized into folders. For example, Chapter05.

The code will look like the following:
```
android {
    compileSdkVersion(30)
   sourceSets["main"].manifest.srcFile
    ("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(23)
        targetSdkVersion(30)
    }
}
```

**Following is what you need for this book:**
This book is for native Android and iOS developers who want to build high-quality apps using an efficient development process. Knowledge of the framework and the languages used is necessary, that is, Android with Java or Kotlin and iOS with Objective-C or Swift. For Swift developers, the book assumes no knowledge of Kotlin as this will be covered in the context of Swift.

With the following software and hardware list you can run all code files present in the book (Chapter 1-10).

### Software and Hardware List
| Chapter | Software/Hardware required | OS required |
| -------- | ------------------------------------ | ----------------------------------- |
| 1-10 | Android Studio Artic Fox | Windows, Mac OS X, and Linux |
| 1-10 | Android Studio KMM Plugin| Windows, Mac OS X, and Linux |


We also provide a PDF file that has color images of the screenshots/diagrams used in this book. [Click here to download it](https://static.packt-cdn.com/downloads/9781801812580_ColorImages.pdf).

### Related products
* How to Build Android Apps with Kotlin [[Packt]](https://www.packtpub.com/product/how-to-build-android-apps-with-kotlin/9781838984113) [[Amazon]](https://www.amazon.com/Build-Android-Apps-Kotlin-hands/dp/1838984119)

* Android UI Development with Jetpack Compose [[Packt]](https://www.packtpub.com/product/architecting-high-performance-embedded-systems/9781789955965?utm_source=github&utm_medium=repository&utm_campaign=9781789955965) [[Amazon]](https://www.amazon.com/Android-Development-Jetpack-Compose-declarative-dp-1801812160/dp/1801812160/ref=mt_other?_encoding=UTF8&me=&qid=)


## Get to Know the Author
**Róbert Nagy**
is a Senior Android Developer at Octopus Energy. He is an Android and Kotlin developer with a Bachelor of Science in Computer Science. He has designed, developed, and maintained multiple sophisticated Android apps ranging from 100K+ downloads to 10M+ in the financial, IoT, health, social, and energy industries. Some projects that he has been a part of include a social platform for kids, a lightning system controller, and Bloom and Wild.

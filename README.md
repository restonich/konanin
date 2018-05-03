# Konanin
Project aiming to integrate [Kotlin/Native compiler](https://github.com/JetBrains/kotlin-native) in Kotlin program.

Prerequisites:
*   OpenJDK 8 (`tools.jar` required)

VM options for Run:

    -ea
    -Xmx3G
    -Djava.library.path=dist/konan/nativelib
    -Dkonan.home=dist
    -Dfile.encoding=UTF-8
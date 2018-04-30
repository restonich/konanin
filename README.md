# Konanin
Project aiming to integrate [Kotlin/Native compiler](https://github.com/JetBrains/kotlin-native) in Kotlin program.

Prerequisites:
*   OpenJDK 8 (`tools.jar` required)
*   [Latest release](https://github.com/JetBrains/kotlin-native/releases) of Kotlin/Native compiler in `dist/` directory in the root of the project
*   Include JAR's from `dist/konan/lib/` to project dependencies

VM options for Run:

    -ea
    -Xmx3G
    -Djava.library.path=/path/to/project/dist/konan/nativelib
    -Dkonan.home=/path/to/project/dist
    -Dfile.encoding=UTF-8
import java.io.File
import java.util.concurrent.TimeUnit
import org.jetbrains.kotlin.cli.utilities.main as KonanMain



fun String.runCommand(workingDir: File) {
  ProcessBuilder(*split(" ").toTypedArray())
    .directory(workingDir)
    .redirectOutput(ProcessBuilder.Redirect.INHERIT)
    .redirectError(ProcessBuilder.Redirect.INHERIT)
    .start()
    .waitFor(60, TimeUnit.MINUTES)
}

fun main(args: Array<String>) {

  val prog: String
  var reqInp = true

  menu@ while (true) {
    print("Select program to test:\n" +
            "1. echo\n" +
            "2. hello\n" +
            "> ")
    val sel = readLine()?.toInt()

    when (sel) {
      1 -> {
        println("Creating echo program...")
        prog = "echo"
        KonanMain(arrayOf("konanc", "src/echo.kt", "-o", "echo.kexe"))
        break@menu
      }
      2 -> {
        println("Making Kotlin/Native more welcoming...")
        prog = "hello"
        reqInp = false
        KonanMain(arrayOf("konanc", "src/hello.kt", "-o", "hello.kexe"))
        break@menu
      }
      null -> {
        println("Incorrect input")
        continue@menu
      }
    }
  }

  if (reqInp) {
    print("> ${prog} ")
    val prog_input = readLine()
    "./${prog}.kexe ${prog_input}".runCommand(File("."))
  }
  else "./${prog}.kexe".runCommand(File("."))
}
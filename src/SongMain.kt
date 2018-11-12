import java.io.File

class SongMain {
    companion object {
        @JvmStatic fun main(args: Array<String>) {
            val songCollection = SongCollection()

            inputLoop@ while(true) {
                println("========Select action========\n" +
                        "0. Quit\n" +
                        "1. Get collection size\n" +
                        "2. Search for title\n" +
                        "3. Search for artist\n" +
                        "4. Add from file\n" +
                        "5. Save to file\n" +
                        "6. Add one song\n" +
                        "7. Remove one song\n" +
                        "8. Show\n" +
                        "Enter choice: ")

                val choiceInput: Int? = readLine()?.toInt()

                when(choiceInput) {
                    0 -> break@inputLoop // Quit
                    1 -> { // Get collection size
                        println(songCollection.size)
                    }
                    2 -> { // Search for title
                        println("Enter title: ")
                        val title: String = readLine() ?: ""

                        songCollection.searchByTitle(title)
                    }
                    3 -> { // Search for artist
                        println("Enter artist: ")
                        val artist: String = readLine() ?: ""

                        songCollection.searchByArtist(artist)
                    }
                    4 -> { // Add from file
                        println("Enter file name: ")

                        val fileName: String? = readLine()
                        val file = File(fileName)

                        songCollection.addFromFile(file)
                    }
                    5 -> { // Save to file
                        println("Enter file name: ")

                        val fileName: String? = readLine()
                        val file = File(fileName)

                        songCollection.writeToFile(file)
                    }
                    6 -> { // Add one song
                        println("Enter title: ")
                        val title: String = readLine() ?: ""

                        println("Enter artist: ")
                        val artist: String = readLine() ?: ""

                        songCollection.addOneSong(title, artist)
                    }
                    7 -> { // Remove one song
                        println("Enter position: ")
                        val position: Int = readLine()?.toInt()!!

                        val result = songCollection.delete(position)
                        println(result)
                    }
                    8 -> { // Show
                        println("Enter start position: ")
                        val startPosition: Int = readLine()?.toInt()!!

                        println("Enter end position: ")
                        val endPosition: Int = readLine()?.toInt()!!

                        songCollection.show(startPosition, endPosition)
                    }
                }
            }
        }
    }
}
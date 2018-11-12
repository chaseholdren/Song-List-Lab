import java.io.*

class SongCollection {
    var songs: ArrayList<Song> = arrayListOf()

    val size : Int
        get() = this.songs.count()

    fun addFromFile(file: File) {
        if(!file.isFile) {
            println("Could not find that file.")
            return
        }
        file.inputStream().bufferedReader().use { reader ->
            val songsInFileCount = reader.readLine().toInt()

            for(i in 0 until songsInFileCount) {
                val title = reader.readLine().toString()
                val artist = reader.readLine().toString()
                this.songs.add(Song(title, artist))
            }
        }
    }

    fun writeToFile(file: File) {
        file.bufferedWriter().use { writer ->

            writer.write(this.songs.size.toString())
            writer.newLine()

            this.songs.forEach{song ->
                writer.write(song.title)
                writer.newLine()
                writer.write(song.artist)
                writer.newLine()
            }
        }
    }

    fun addOneSong(title: String, artist: String) {
        this.songs.add(Song(title, artist))
    }

    fun delete(position: Int): String {
        try {
            this.songs.removeAt(position)
        } catch(e: IndexOutOfBoundsException) {
            return "A song does not exist at that position."
        }

        return "Song deleted successfully."
    }

    fun searchByTitle(key: String) {
        val songMatches = this.songs.filter { song -> song.title.contains(key) }

        for(i in 0 until songMatches.size) {
            val songMatch = songMatches[i]
            println(songMatch.title + " - " + songMatch.artist)
        }
    }

    fun searchByArtist(key: String) {
        val songMatches = this.songs.filter { song -> song.artist.contains(key) }

        for(i in 0 until songMatches.size) {
            val songMatch = songMatches[i]
            println(songMatch.title + " - " + songMatch.artist)
        }
    }

    fun show(start: Int, end: Int) {
        val safeStart = Math.max(start, 0)
        val safeEnd = Math.min(end, this.songs.size-1)

        for(i in safeStart until safeEnd) {
            val song = this.songs[i]
            println(song.title + " - " + song.artist)
        }
    }
}
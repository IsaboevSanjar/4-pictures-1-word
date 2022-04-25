package uz.sanjar.a4pics1word.model

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import uz.sanjar.a4pics1word.lib.DbHelper

class Database private constructor(context: Context?) : DbHelper(context, "4pics1word.db") {
    @get:SuppressLint("Range")
    val dictionary: ArrayList<WordGame>
        get() {
            val dictionaries: ArrayList<WordGame> = ArrayList<WordGame>()
            val query = "SELECT * FROM game"
            val cursor: Cursor = mDataBase.rawQuery(query, null)
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                val game1 = cursor.getInt(cursor.getColumnIndex("game1"))
                val game2 = cursor.getInt(cursor.getColumnIndex("game2"))
                val game3 = cursor.getInt(cursor.getColumnIndex("game3"))
                val game4 = cursor.getInt(cursor.getColumnIndex("game4"))

                val dictionary = WordGame(game1, game2, game3, game4)
                dictionaries.add(dictionary)
                cursor.moveToNext()
            }
            return dictionaries
        }


    @get:SuppressLint("Range")
    val game2: ArrayList<WordGame>
        get() {
            val dictionaries: ArrayList<WordGame> = ArrayList<WordGame>()
            val query = "SELECT * FROM WORDS where game2=1"
            val cursor: Cursor = mDataBase.rawQuery(query, null)
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                val game1 = cursor.getInt(cursor.getColumnIndex("game1"))
                val game2 = cursor.getInt(cursor.getColumnIndex("game2"))
                val game3 = cursor.getInt(cursor.getColumnIndex("game3"))
                val game4 = cursor.getInt(cursor.getColumnIndex("game4"))

                val dictionary = WordGame(game1, game2, game3, game4)
                dictionaries.add(dictionary)
                cursor.moveToNext()
            }
            return dictionaries
        }

    @get:SuppressLint("Range")
    val game3: ArrayList<WordGame>
        get() {
            val dictionaries: ArrayList<WordGame> = ArrayList<WordGame>()
            val query = "SELECT * FROM WORDS where game3=1"
            val cursor: Cursor = mDataBase.rawQuery(query, null)
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                val game1 = cursor.getInt(cursor.getColumnIndex("game1"))
                val game2 = cursor.getInt(cursor.getColumnIndex("game2"))
                val game3 = cursor.getInt(cursor.getColumnIndex("game3"))
                val game4 = cursor.getInt(cursor.getColumnIndex("game4"))

                val dictionary = WordGame(game1, game2, game3, game4)
                dictionaries.add(dictionary)
                cursor.moveToNext()
            }
            return dictionaries
        }

    @get:SuppressLint("Range")
    val game4: ArrayList<WordGame>
        get() {
            val dictionaries: ArrayList<WordGame> = ArrayList<WordGame>()
            val query = "SELECT * FROM WORDS where game4=1"
            val cursor: Cursor = mDataBase.rawQuery(query, null)
            cursor.moveToFirst()
            while (!cursor.isAfterLast) {
                val game1 = cursor.getInt(cursor.getColumnIndex("game1"))
                val game2 = cursor.getInt(cursor.getColumnIndex("game2"))
                val game3 = cursor.getInt(cursor.getColumnIndex("game3"))
                val game4 = cursor.getInt(cursor.getColumnIndex("game4"))

                val dictionary = WordGame(game1, game2, game3, game4)
                dictionaries.add(dictionary)
                cursor.moveToNext()
            }
            return dictionaries
        }

    companion object {
        var database: Database? = null
            private set

        fun init(context: Context?) {
            if (database == null) {
                database = Database(context)
            }
        }
    }
}
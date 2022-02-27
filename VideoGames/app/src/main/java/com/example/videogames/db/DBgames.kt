package com.example.videogames.db

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import com.example.videogames.model.Game

class DBgames(context: Context?) : DBHelper(context) {
    //Aquí va el código para el CRUD
    val context = context

    fun insertGame(title: String, genre: String, developer: String):Long {
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase
        var id: Long = 0

        try {
            val values = ContentValues()

            values.put("title", title)
            values.put("genre", genre)
            values.put("developer", developer)

            id = db.insert(TABLE_GAMES, null, values)
        } catch (e: Exception) { //Manejo de la excepción
        } finally {
            db.close()
        }

        return id
    }

    fun getGames():ArrayList<Game>{
        val dbHelper=DBHelper(context)
        val db = dbHelper.writableDatabase

        var listGame= ArrayList<Game>()
        var gameTmp: Game? = null
        var cursorGame: Cursor? =null


        cursorGame = db.rawQuery("SELECT * FROM $TABLE_GAMES", null)

        if(cursorGame.moveToFirst()){
            do{
                gameTmp = Game(cursorGame.getInt(0), cursorGame.getString(1), cursorGame.getString(2), cursorGame.getString(3))
                listGame.add(gameTmp)
            }while(cursorGame.moveToNext())
        }

        cursorGame.close()

        return listGame
    }

    fun getGame(id:Int):Game?{
        //abriendo base
        val dbHelper=DBHelper(context)
        val db = dbHelper.writableDatabase
        //

        var game:Game?=null
        var cursorGames: Cursor?=null

        //query
        cursorGames = db.rawQuery("SELECT * FROM $TABLE_GAMES WHERE id = $id LIMIT 1", null)

        if(cursorGames.moveToFirst()){
            game = Game(cursorGames.getInt(0), cursorGames.getString(1), cursorGames.getString(2), cursorGames.getString(3))
        }

        cursorGames.close()

        return game

    }

    fun updateGames(id:Int, title: String, genre: String, developer: String): Boolean {
        var banderaCorrecto = false
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase

        try {
            db.execSQL("UPDATE $TABLE_GAMES SET title = '$title', genre = '$genre', developer = '$developer' WHERE id = $id")
            banderaCorrecto = true
        } catch (e: Exception) {

        } finally {
            db.close()
        }

        return banderaCorrecto
    }

    fun deleteGames(id:Int):Boolean{
        var banderaCorrecto = true
        val dbHelper = DBHelper(context)
        val db = dbHelper.writableDatabase

        try {
            db.execSQL("DELETE FROM $TABLE_GAMES WHERE id = $id")
            banderaCorrecto = true
        } catch (e: Exception) {

        } finally {
            db.close()
        }

        return banderaCorrecto
    }


    }


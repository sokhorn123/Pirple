package com.learn.projectbootcamday1

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import com.learn.projectbootcamday1.model.TodoItem

class DatabaseOperations(context: Context) :
        SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        const val DATABASE_NAME = "TodoItems.db"
        const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        // call this to create table for our sqlite
        db?.execSQL(DatabaseInfor.SQL_CREATE_TABLE_QUERY)
        // this mean that if db not= null we will create this table otherwise dont.
    }


    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DatabaseInfor.SQL_DELETE_TABLE_QUERY)
        onCreate(db) // after delete we wil create this database again
    }

    //Bootcamp Day 4
    override fun onDowngrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        onUpgrade(db, oldVersion, newVersion)
    }

    // add item into database
    fun addItem(dbo: DatabaseOperations, item: TodoItem) {
        val db = dbo.writableDatabase // to write value into database
        val itemName = item.name
        val istemUrgent = item.isUrgent
        val itemUrgent = if (istemUrgent) 1 else 0
        val itemDate = item.date.toString()

        val contentValues = ContentValues()
        contentValues.put(DatabaseInfor.TableInfo.COLUMN_ITEM_NAME, itemName)
        contentValues.put(DatabaseInfor.TableInfo.COLUMN_ITEM_URGENCY, itemUrgent)
        contentValues.put(DatabaseInfor.TableInfo.COLUMN_ITEM_DATE, itemDate)

//        db.execSQL("INSERT INTO ${DatabaseInfor.TableInfo.TABLE_NAME} VALUE ()".toString())

        // this will insert the hold of our content
        db.insert(DatabaseInfor.TableInfo.TABLE_NAME, null, contentValues)
    }

    fun getAll(dbo: DatabaseOperations): Cursor {
        val db = dbo.readableDatabase // read from database.
        //  read all of this value
        val projection = arrayOf(
                BaseColumns._ID,
                DatabaseInfor.TableInfo.COLUMN_ITEM_NAME,
                DatabaseInfor.TableInfo.COLUMN_ITEM_URGENCY,
                DatabaseInfor.TableInfo.COLUMN_ITEM_DATE
        )
        val selection = null
        val selectionArg = null
        val sortOrder = null

        // this will read all data from our database
        val cursor = db.query(
                DatabaseInfor.TableInfo.TABLE_NAME,
                projection,
                selection,
                selectionArg,
                null,
                null,
                sortOrder
        )
        return cursor
    }

    // update item from our databse
    fun update(dbo: DatabaseOperations, oldItemTodo: TodoItem, newItemTodo: TodoItem) {

        val db = dbo.writableDatabase // to write value into database
        val itemName = newItemTodo.name
        val istemUrgent = newItemTodo.isUrgent
        val itemUrgent = if (istemUrgent) 1 else 0
        val itemDate = newItemTodo.date.toString()

        val contentValues = ContentValues()
        contentValues.put(DatabaseInfor.TableInfo.COLUMN_ITEM_NAME, itemName)
        contentValues.put(DatabaseInfor.TableInfo.COLUMN_ITEM_URGENCY, itemUrgent)
        contentValues.put(DatabaseInfor.TableInfo.COLUMN_ITEM_DATE, itemDate)
        // condition for our update database
        val selection = "${DatabaseInfor.TableInfo.COLUMN_ITEM_NAME} like ? "
        val selctionArg = arrayOf(oldItemTodo.name)

        db.update(DatabaseInfor.TableInfo.TABLE_NAME, contentValues, selection, selctionArg)
    }

    fun deleteItem(dbo: DatabaseOperations, todoItem: TodoItem) {
        val db = dbo.writableDatabase

        // condition
        val selection = "${DatabaseInfor.TableInfo.COLUMN_ITEM_NAME} like ?"
        val selectionArg = arrayOf(todoItem.name)

        val delete = db.delete("${DatabaseInfor.TableInfo.TABLE_NAME}",
                selection, selectionArg)
    }
}

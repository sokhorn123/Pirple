package com.learn.projectbootcamday1

import android.provider.BaseColumns

object DatabaseInfor {
    // this query use to  create table in sql
    const val SQL_CREATE_TABLE_QUERY = "CREATE TABLE ${TableInfo.TABLE_NAME} ( " +
            "${BaseColumns._ID} INTERGER PRIMARY KEY, " +
            "${TableInfo.COLUMN_ITEM_NAME} TEXT , " +
            "${TableInfo.COLUMN_ITEM_URGENCY} INTERGER , " +
            "${TableInfo.COLUMN_ITEM_DATE} TEXT)"

    // this will delete table if it exists in the system , to do this to avoid duplicate input
    const val SQL_DELETE_TABLE_QUERY = "DROP TABLE IF EXISTS ${TableInfo.TABLE_NAME}"

    // table info for creating database
    object TableInfo : BaseColumns {
        const val TABLE_NAME = "todoItemTable"
        const val COLUMN_ITEM_NAME = "itemName"
        const val COLUMN_ITEM_URGENCY = "itemUrgency"
        const val COLUMN_ITEM_DATE = "itemDate"
    }
}


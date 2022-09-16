package com.mikeschvedov.ifood.construction

import android.os.Environment


// ------ next up ----- //


//------ don't forget ----- //
//Todo: added daily date as string , and when clicked on, the date picker will appear and the search button

// ------ big features ----- //
//Todo: add app widget
//Todo: Leave the weight fragment and chart to the end, it is a feature that is optional in the future
//Todo: feature to back up the database file or print all data to file

// ------ optimization ----- //
// Todo: combine both unit/gram edit texts

// ------ bug fixes ----- //
// Todo: when we click on the x and remove the query, we are stuck with the unit/grams layout insead of returning to the list
// Todo: when we press back button in home just quit app
// Todo: clear qeury when leaving add entry fragment


// Worked on Lately:
//Ordered list by hours
//Now we can delete entries when clicked on.
//Added 'Total daily calories' to top of home fragment.
//Save entries using dynamic dates (not hardcoded like now)


/*
private fun copyFile() {
    try {
        val sd: File = Environment.getExternalStorageDirectory()
        val data: File = Environment.getDataDirectory()
        if (sd.canWrite()) {
            val currentDBPath: String = getDatabasePath("photex_db").getAbsolutePath()
            val backupDBPath = "photex_db.db"
            //previous wrong  code
            // **File currentDB = new File(data,currentDBPath);**
            // correct code
            val currentDB = File(currentDBPath)
            val backupDB = File(sd, backupDBPath)
            if (currentDB.exists()) {
                val src: FileChannel = FileInputStream(currentDB).getChannel()
                val dst: FileChannel = FileOutputStream(backupDB).getChannel()
                dst.transferFrom(src, 0, src.size())
                src.close()
                dst.close()
            }
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
*/

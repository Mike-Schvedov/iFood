package com.mikeschvedov.ifood.data.local_data.hardcoded

import com.mikeschvedov.ifood.R

class FoodArchive {
    companion object{

        var foodDataList = arrayListOf<FoodSaved>(
            //א
            FoodSaved("אבוקדו", 160, R.drawable.avocado, false, 0, FoodCategory.DEFAULT),
            FoodSaved("אגס", 59, R.drawable.pear, false, 0 ,FoodCategory.DEFAULT),
            FoodSaved("אגס נאשי / אסיאתי", 50, R.drawable.pearnashi, false, 0 ,FoodCategory.DEFAULT),
            FoodSaved("אורז", 130, R.drawable.rice, false, 0,FoodCategory.DEFAULT),
            FoodSaved("אפרסמון", 70, R.drawable.persimmon, false, 0,FoodCategory.DEFAULT),
            FoodSaved("אפרסק", 40, R.drawable.peach, false, 0,FoodCategory.DEFAULT),
            FoodSaved("אקסל", 0, R.drawable.xl, true, 120,FoodCategory.DEFAULT),
            //ב
            FoodSaved("ביג מאק (ללא רוטב)", 0, R.drawable.bigmac, true, 350,FoodCategory.DEFAULT),
            FoodSaved("ביצה", 155, R.drawable.egg, false, 0,FoodCategory.DEFAULT),
            FoodSaved("בננה", 90, R.drawable.banana, false, 0,FoodCategory.DEFAULT),
            FoodSaved("בצל", 32, R.drawable.onion, false, 0,FoodCategory.DEFAULT),
            FoodSaved("בצל ירוק", 32, R.drawable.scallion, false, 0,FoodCategory.DEFAULT),
            FoodSaved("בשר כללי (טחון, בקר)", 250, R.drawable.beef, false, 0,FoodCategory.DEFAULT),
            //ג
            FoodSaved("גבינה בולגרית 5%", 140, R.drawable.bulgarian_five, false, 0,FoodCategory.DEFAULT), //highest 140
            FoodSaved("גבינה בולגרית 16%", 200, R.drawable.bulgarian_five, false, 0,FoodCategory.DEFAULT),
            FoodSaved("גבינה צהובה מופחתת 9%", 200, R.drawable.cheese, false, 0,FoodCategory.DEFAULT),
            FoodSaved("גבינה צהובה עמק 28%", 350, R.drawable.emeqcheese, false, 0,FoodCategory.DEFAULT),
            FoodSaved("גויאבה", 70, R.drawable.guiava, false, 0,FoodCategory.DEFAULT),
            FoodSaved("ג'ל ריצה", 0, R.drawable.gel, true, 100,FoodCategory.DEFAULT),
            FoodSaved("גמבה", 31, R.drawable.bellpeper, false, 0,FoodCategory.DEFAULT),
            FoodSaved("גרעיני חמנייה עם קליפה", 300, R.drawable.sunflower, false, 0,FoodCategory.DEFAULT),
            //ד
            FoodSaved("דג מלרוזה", 85, R.drawable.marloza, false, 0,FoodCategory.DEFAULT),
            FoodSaved("דג סלומון", 210, R.drawable.salmon, false, 0,FoodCategory.DEFAULT),
            //ה
            FoodSaved("המבורגגר אנגוס", 300, R.drawable.angus, false, 0,FoodCategory.DEFAULT),
            //ו
            FoodSaved("תרכיז ויטמינצ\'יק", 352, R.drawable.vitaminchic, false, 0,FoodCategory.DEFAULT),
            //ז
            FoodSaved("זיתים שחורים (ללא גלעין)", 171, R.drawable.blackolive, false, 0,FoodCategory.DEFAULT),
            //ח
            FoodSaved("חומוס", 200, R.drawable.humus, false, 0,FoodCategory.DEFAULT),
            FoodSaved("חזה עוף", 170, R.drawable.chicken_breast, false, 0,FoodCategory.DEFAULT),
            FoodSaved("חזה עוף בקוקוס", 170, R.drawable.chikencoconut, false, 0,FoodCategory.DEFAULT),
            FoodSaved("חזרת", 70, R.drawable.hazeret, false, 0,FoodCategory.DEFAULT),
            FoodSaved("חיטה מבושלת", 150, R.drawable.wheat, false, 0,FoodCategory.DEFAULT),
            FoodSaved("חלב", 60, R.drawable.milk, false, 0,FoodCategory.DEFAULT),
            FoodSaved("חמאה", 734, R.drawable.butter, false, 0,FoodCategory.DEFAULT),
            //ט
            FoodSaved("טונה אדומה", 130, R.drawable.redtuna, false, 0,FoodCategory.DEFAULT),
            FoodSaved("טונה במים", 100, R.drawable.tuna, false, 0,FoodCategory.DEFAULT),
            FoodSaved("טונה בשמן", 150, R.drawable.tuna, false, 0,FoodCategory.DEFAULT),
            //י
            FoodSaved("יין אדום", 85, R.drawable.wine, false, 0,FoodCategory.DEFAULT),
            //כ

            //ל
            FoodSaved("לאבנה 11%", 144, R.drawable.labane, false, 0,FoodCategory.DEFAULT),
            FoodSaved("לחם שיפון מלא", 220, R.drawable.bead, false, 0,FoodCategory.DEFAULT),
            FoodSaved("לחם פרנה", 280, R.drawable.frena, false, 0,FoodCategory.DEFAULT),
            //מ
            FoodSaved("מיני מק-רויאל (ללא רוטב)", 0, R.drawable.minimc, true, 200,FoodCategory.DEFAULT),
            FoodSaved("מלפפון", 15, R.drawable.cucumber, false, 0,FoodCategory.DEFAULT),
            FoodSaved("מלון", 35, R.drawable.melon, false, 0,FoodCategory.DEFAULT),
            FoodSaved("ממרח כבד", 170, R.drawable.patte, false, 0,FoodCategory.DEFAULT),
            FoodSaved("ממרח סלומון", 210, R.drawable.patte, false, 0,FoodCategory.DEFAULT),
            FoodSaved("מנה חמה בולונז", 0, R.drawable.manahama, true, 230,FoodCategory.DEFAULT),
            FoodSaved("מעדן GO", 0, R.drawable.maadango, true, 110,FoodCategory.DEFAULT),
            FoodSaved("מעדן הגולן", 0, R.drawable.golan, true, 168,FoodCategory.DEFAULT),
            FoodSaved("מק-רויאל (ללא רוטב)", 0, R.drawable.mcroyal, true, 450,FoodCategory.DEFAULT),
            //נ
            FoodSaved("נאצוס", 480, R.drawable.nacho, false, 0,FoodCategory.DEFAULT),
            FoodSaved("נישנושים", 491, R.drawable.nishnushim, false, 0,FoodCategory.DEFAULT),
            FoodSaved("נישנושים זעתר", 522, R.drawable.nishnushimzaatar, false, 0,FoodCategory.DEFAULT),

            FoodSaved("נקטרינה", 44, R.drawable.nectarine, false, 0,FoodCategory.DEFAULT),
            FoodSaved("נקניקיות", 200, R.drawable.sausage, false, 0,FoodCategory.DEFAULT),
            FoodSaved("נקניקיות פיקולינו רוסיות", 500, R.drawable.pikolini, false, 0,FoodCategory.DEFAULT),
            FoodSaved("נקניקיות גבינה מעושנת", 350, R.drawable.smokedcheesenaknik, false, 0,FoodCategory.DEFAULT),
            //ס
            FoodSaved("סוכר", 400, R.drawable.sugar, false, 0,FoodCategory.DEFAULT),

            FoodSaved("סלט טונה", 114, R.drawable.tunasalad, false, 0,FoodCategory.DEFAULT),
            //ע
            FoodSaved("עגבניות שרי", 18, R.drawable.cherry_tomato, false, 0,FoodCategory.DEFAULT),
            FoodSaved("עגבנייה", 18, R.drawable.tomatoes, false, 0,FoodCategory.DEFAULT),
            FoodSaved(" ענבים", 70, R.drawable.grapes, false, 0,FoodCategory.DEFAULT),

            //פ
            FoodSaved("פוטטו [מקדונלדס]", 190, R.drawable.potatos_mcdonalds, false, 0,FoodCategory.DEFAULT),
            FoodSaved("פיתה", 250, R.drawable.pita, false, 0,FoodCategory.DEFAULT),
            FoodSaved("פירכיות", 370, R.drawable.pirhit, false, 0,FoodCategory.DEFAULT),

            FoodSaved("פלאפל", 330, R.drawable.falafel, false, 0,FoodCategory.DEFAULT),
            FoodSaved("פסטה", 150, R.drawable.pasta, false, 0,FoodCategory.DEFAULT),
            FoodSaved("פתית", 380, R.drawable.patit, false, 0,FoodCategory.DEFAULT),
            //צ

            //ק
            FoodSaved("קטשופ", 110, R.drawable.ketshup, false, 0,FoodCategory.DEFAULT),
            FoodSaved("קולורבי", 27, R.drawable.kolorabi, false, 0,FoodCategory.DEFAULT),
            FoodSaved("קוסקוס", 120, R.drawable.kuskus, false, 0,FoodCategory.DEFAULT),
            FoodSaved("קליליות", 372, R.drawable.kliliot, false, 0,FoodCategory.DEFAULT),
            FoodSaved("קלמנטינה/מנדרינה", 53, R.drawable.mandarin, false, 0,FoodCategory.DEFAULT),
            FoodSaved("קפה עם חלב", 60, R.drawable.coffee, false, 0,FoodCategory.DEFAULT),
            //ר
            FoodSaved("רוטב אלף האיים לייט", 186, R.drawable.thousandlite, false, 0,FoodCategory.DEFAULT),
            FoodSaved("רוטב בולונז", 200, R.drawable.bolonez, false, 0,FoodCategory.DEFAULT),
            FoodSaved("רוטב עגבניות/ירקות", 40, R.drawable.totato_sauce, false, 0,FoodCategory.DEFAULT),
            FoodSaved("ריזיקה/כללי", 100, R.drawable.general, false, 0,FoodCategory.DEFAULT),
            FoodSaved("ריצה/אימון", -100, R.drawable.run, false, 0,FoodCategory.DEFAULT),
            //ש
            FoodSaved("שווארמה הודו", 200, R.drawable.shawarma, false, 0,FoodCategory.DEFAULT),
            FoodSaved("שמן קנולה", 830, R.drawable.kanola, false, 0,FoodCategory.DEFAULT),
            FoodSaved("שמן זית", 822, R.drawable.olive_oil, false, 0,FoodCategory.DEFAULT),
            FoodSaved("שניצלונים קופאים", 240, R.drawable.schnitselonim, false, 0,FoodCategory.DEFAULT),
            FoodSaved("שניצל מטוגן", 300, R.drawable.schnitzel, false, 0,FoodCategory.DEFAULT),

            //ת
            FoodSaved("תירס", 90, R.drawable.corn, false, 0,FoodCategory.DEFAULT),
            FoodSaved("תפוח אדמה/פירה", 93, R.drawable.potato, false, 0,FoodCategory.DEFAULT),
            )

    }
}
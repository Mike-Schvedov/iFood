package com.mikeschvedov.ifood.data.local_data.hardcoded

import com.mikeschvedov.ifood.R

class FoodArchive {
    companion object{

        var foodDataList = arrayListOf<FoodSaved>(
            //א
            FoodSaved("אבוקדו", 160, R.drawable.avocado, false, 0),
            FoodSaved("אגס", 59, R.drawable.pear, false, 0),
            FoodSaved("אורז", 130, R.drawable.rice, false, 0),
            FoodSaved("אקסל", 0, R.drawable.xl, true, 120),
            //ב
            FoodSaved("ביג מאק (ללא רוטב)", 0, R.drawable.bigmac, true, 350),
            FoodSaved("ביצה", 155, R.drawable.egg, false, 0),
            FoodSaved("בצל", 32, R.drawable.onion, false, 0),
            FoodSaved("בצל ירוק", 32, R.drawable.scallion, false, 0),
            FoodSaved("בשר כללי (טחון, בקר)", 250, R.drawable.beef, false, 0),
            //ג
            FoodSaved("גבינה בולגרית 5%", 140, R.drawable.bulgarian_five, false, 0), //highest 140
            FoodSaved("גבינה צהובה מופחתת 9%", 200, R.drawable.cheese, false, 0),
            FoodSaved("ג'ל ריצה", 0, R.drawable.gel, true, 100),
            FoodSaved("גמבה", 31, R.drawable.bellpeper, false, 0),
            //ד

            //ה

            //ו
            FoodSaved("תרכיז ויטמינצ\'יק", 352, R.drawable.vitaminchic, false, 0),
            //ז
            FoodSaved("זיתים שחורים (ללא גלעין)", 171, R.drawable.blackolive, false, 0),
            //ח
            FoodSaved(" חזה עוף", 170, R.drawable.chicken_breast, false, 0),
            FoodSaved("חלב", 60, R.drawable.milk, false, 0),
            //ט
            FoodSaved(" טונה במים", 100, R.drawable.tuna, false, 0),
            FoodSaved(" טונה בשמן", 150, R.drawable.tuna, false, 0),
            //י

            //כ

            //ל
            FoodSaved("לאבנה 11%", 144, R.drawable.labane, false, 0),
            FoodSaved("לחם שיפון מלא", 220, R.drawable.bead, false, 0),
            //מ
            FoodSaved("מיני מק-רויאל (ללא רוטב)", 0, R.drawable.minimc, true, 200),
            FoodSaved("מלפפון", 15, R.drawable.cucumber, false, 0),
            FoodSaved("מלון", 35, R.drawable.melon, false, 0),
            FoodSaved("מנה חמה בולונז", 0, R.drawable.manahama, true, 230),
            FoodSaved("מעדן GO", 0, R.drawable.maadango, true, 110),
            FoodSaved("מעדן הגולן", 0, R.drawable.golan, true, 168),
            FoodSaved("מק-רויאל (ללא רוטב)", 0, R.drawable.mcroyal, true, 450),
            //נ
            FoodSaved("נישנושים", 491, R.drawable.nishnushim, false, 0),
            //ס
            FoodSaved(" סלומון", 200, R.drawable.salmon, false, 0),
            FoodSaved("סלט טונה", 114, R.drawable.tunasalad, false, 0),
            //ע
            FoodSaved("עגבניות שרי", 18, R.drawable.cherry_tomato, false, 0),
            FoodSaved("עגבנייה", 18, R.drawable.tomatoes, false, 0),
            FoodSaved(" ענבים", 70, R.drawable.grapes, false, 0),

            //פ
            FoodSaved("פתית", 380, R.drawable.patit, false, 0),
            FoodSaved("פוטטו [מקדונלדס]", 190, R.drawable.potatos_mcdonalds, false, 0),
            //צ

            //ק
            FoodSaved("קפה עם חלב", 60, R.drawable.coffee, false, 0),
            //ר
            FoodSaved("רוטב עגבניות/ירקות", 40, R.drawable.totato_sauce, false, 0),
            FoodSaved("ריזיקה/כללי", 100, R.drawable.general, false, 0),
            FoodSaved("ריצה/אימון", -100, R.drawable.run, false, 0),
            //ש
            FoodSaved("שמן קנולה", 830, R.drawable.kanola, false, 0),
            FoodSaved("שמן זית", 822, R.drawable.olive_oil, false, 0),
            //ת
            FoodSaved("תירס", 116, R.drawable.corn, false, 0),
            FoodSaved("תפוח אדמה/פירה", 93, R.drawable.potato, false, 0),
        )

    }
}
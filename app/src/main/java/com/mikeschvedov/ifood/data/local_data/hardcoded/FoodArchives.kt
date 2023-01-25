package com.mikeschvedov.ifood.data.local_data.hardcoded

import com.mikeschvedov.ifood.R

class FoodArchive {
    companion object{

        var foodDataList = arrayListOf<FoodSaved>(
            //א
            FoodSaved(name = "אבוקדו", calPer100gr = 160, imageID = R.drawable.avocado, asUnit = false, caloriesPerUnit = 0, category = FoodCategory.VEGETABLE, carbPer100gr = 8 , proteinPer100gr = 2, fatPer100gr = 15),
            FoodSaved(name = "אגס", calPer100gr =59, imageID = R.drawable.pear, asUnit = false, caloriesPerUnit = 0 ,category =  FoodCategory.FRUIT),
            FoodSaved(name = "אגס נאשי / אסיאתי", calPer100gr =50, imageID = R.drawable.pearnashi, asUnit = false, caloriesPerUnit = 0 ,category =  FoodCategory.FRUIT),
            FoodSaved(name = "אורז", calPer100gr =130, imageID = R.drawable.rice, asUnit = false, caloriesPerUnit = 0,category =  FoodCategory.GRAIN),
            FoodSaved(name = "אפונה (גרגירים)", calPer100gr =84, imageID = R.drawable.peas, asUnit = false, caloriesPerUnit = 0,category =  FoodCategory.VEGETABLE, carbPer100gr = 14 , proteinPer100gr = 5, fatPer100gr = 0),
            FoodSaved(name = "אפונה (תרמילים)", calPer100gr =42, imageID = R.drawable.peas_pods, asUnit = false, caloriesPerUnit = 0,category =  FoodCategory.VEGETABLE , carbPer100gr = 7 , proteinPer100gr = 2, fatPer100gr = 0),
            FoodSaved(name = "אפרסמון", calPer100gr =70, imageID = R.drawable.persimmon, asUnit = false, caloriesPerUnit = 0,category =  FoodCategory.FRUIT),
            FoodSaved(name = "אפרסק", calPer100gr =40, imageID = R.drawable.peach, asUnit = false, caloriesPerUnit = 0,category =  FoodCategory.FRUIT),
            FoodSaved(name = "אקסל", calPer100gr =0, imageID = R.drawable.xl, asUnit = true, caloriesPerUnit = 120,category =  FoodCategory.DRINK),
            //ב
            FoodSaved(name = "ביג מאק (ללא רוטב)", calPer100gr = 0, imageID = R.drawable.bigmac, asUnit = true, caloriesPerUnit = 350,category =  FoodCategory.JUNKFOOD),
            FoodSaved(name = "ביטר לימון", calPer100gr = 46, imageID = R.drawable.bitterlemon, asUnit = false, caloriesPerUnit = 0,category =  FoodCategory.DRINK, carbPer100gr = 12 , proteinPer100gr = 0, fatPer100gr = 0),
            FoodSaved(name = "בייגלה סניידרס שברים", calPer100gr = 473, imageID = R.drawable.sniders, asUnit = false, caloriesPerUnit = 0,category =  FoodCategory.SNACK, carbPer100gr = 53 , proteinPer100gr = 7, fatPer100gr = 25),
            FoodSaved(name = "ביצה", calPer100gr = 155, imageID = R.drawable.egg, asUnit = false, caloriesPerUnit = 0,category =  FoodCategory.MEAT, carbPer100gr = 1 , proteinPer100gr = 13, fatPer100gr = 11),
            FoodSaved(name = "בירה ווינשטפנר (חצי ליטר)", calPer100gr = 0, imageID = R.drawable.weinshtefen, asUnit = true, caloriesPerUnit = 215,category =  FoodCategory.ALCOHOL),
            FoodSaved(name = "בננה", calPer100gr = 90, imageID = R.drawable.banana, asUnit = false, caloriesPerUnit = 0,category =  FoodCategory.FRUIT),
            FoodSaved(name = "בצל", calPer100gr = 32, imageID = R.drawable.onion, asUnit = false, caloriesPerUnit = 0,category =  FoodCategory.VEGETABLE),
            FoodSaved(name = "בצל ירוק", calPer100gr = 32, imageID = R.drawable.scallion, asUnit = false, caloriesPerUnit = 0,category =  FoodCategory.VEGETABLE, carbPer100gr = 7 , proteinPer100gr = 2, fatPer100gr = 0),
            FoodSaved(name = "בשר טחון  30% (לאחר בישול) ", calPer100gr = 250, imageID = R.drawable.beef, asUnit = false, caloriesPerUnit = 0,category =  FoodCategory.MEAT, carbPer100gr = 0 , proteinPer100gr = 25, fatPer100gr = 15),
            //ג
            FoodSaved(name = "גבינה בולגרית 5%", calPer100gr = 140, imageID = R.drawable.bulgarian_five, asUnit = false, caloriesPerUnit = 0, category = FoodCategory.DAIRY), //highest 140
            FoodSaved(name = "גבינה בולגרית 16%", calPer100gr = 200, imageID = R.drawable.bulgarian_five, asUnit = false, caloriesPerUnit = 0, category = FoodCategory.DAIRY),
            FoodSaved(name = "גבינה צהובה מופחתת 9%", calPer100gr = 200, imageID = R.drawable.cheese, asUnit = false, caloriesPerUnit = 0, category = FoodCategory.DAIRY),
            FoodSaved(name = "גבינת מוצרלה 21%", calPer100gr = 280, imageID = R.drawable.emeqcheese, asUnit = false, caloriesPerUnit = 0, category = FoodCategory.DAIRY, carbPer100gr = 1 , proteinPer100gr = 22, fatPer100gr = 21),
            FoodSaved(name = "גבינה צהובה נועם 22%", calPer100gr = 300, imageID = R.drawable.emeqcheese, asUnit = false, caloriesPerUnit = 0, category = FoodCategory.DAIRY, carbPer100gr = 0 , proteinPer100gr = 25, fatPer100gr = 22),
            FoodSaved(name = "גבינה צהובה עמק 28%", calPer100gr = 350, imageID = R.drawable.emeqcheese, asUnit = false, caloriesPerUnit = 0, category = FoodCategory.DAIRY),
            FoodSaved(name = "גבינת פרמזן", calPer100gr = 431, imageID = R.drawable.emeqcheese, asUnit = false, caloriesPerUnit = 0, category = FoodCategory.DAIRY, carbPer100gr = 4 , proteinPer100gr = 30, fatPer100gr = 30),
            FoodSaved(name = "גויאבה", calPer100gr =70, imageID = R.drawable.guiava, asUnit = false, caloriesPerUnit = 0, category = FoodCategory.FRUIT),
            FoodSaved(name = "ג'ל ריצה", calPer100gr =0, imageID = R.drawable.gel, asUnit = true, caloriesPerUnit = 100,category = FoodCategory.OTHER),
            FoodSaved(name = "גמבה", calPer100gr =31, imageID = R.drawable.bellpeper, asUnit = false,caloriesPerUnit = 0,category = FoodCategory.VEGETABLE),
            FoodSaved(name = "גרעיני חמנייה עם קליפה", calPer100gr =300, imageID = R.drawable.sunflower, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.SNACK, carbPer100gr = 10 , proteinPer100gr = 10, fatPer100gr = 25),
            //ד
            FoodSaved(name = "דג מלרוזה", calPer100gr =85, imageID = R.drawable.marloza, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.FISH),
            FoodSaved(name = "דג סלומון", calPer100gr =210, imageID = R.drawable.salmon, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.FISH),
            //ה
            FoodSaved(name = "המבורגר אנגוס", calPer100gr =300, imageID = R.drawable.angus, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.MEAT),
            //ו
            FoodSaved(name = "תרכיז ויטמינצ\'יק", calPer100gr =352, imageID = R.drawable.vitaminchic, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.DRINK),
            //ז
            FoodSaved(name = "זיתים שחורים (ללא גלעין)", calPer100gr =171, imageID = R.drawable.blackolive, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.VEGETABLE),
            //ח
            FoodSaved(name = "חומוס", calPer100gr =200, imageID = R.drawable.humus, asUnit = false,caloriesPerUnit =  0,category = FoodCategory.LEGUME),
            FoodSaved(name = "חזה עוף", calPer100gr =170, imageID = R.drawable.chicken_breast, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.MEAT),
            FoodSaved(name = "חזה עוף בקוקוס", calPer100gr =170, imageID = R.drawable.chikencoconut, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.COOKED_MEAL),
            FoodSaved(name = "חזרת", calPer100gr =70, imageID = R.drawable.hazeret, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.CONDIMENT),
            FoodSaved(name = "חיטה מבושלת", calPer100gr =150, imageID = R.drawable.wheat, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.GRAIN),
            FoodSaved(name = "חלב", calPer100gr =60, imageID = R.drawable.milk, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.DAIRY, carbPer100gr = 5 , proteinPer100gr = 3, fatPer100gr = 3),
            FoodSaved(name = "חלב כחוש ומרוכז", calPer100gr =320, imageID = R.drawable.kahush, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.SWEET, carbPer100gr = 58 , proteinPer100gr = 7, fatPer100gr = 8),
            FoodSaved(name = "חמאה", calPer100gr =734, imageID = R.drawable.butter, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.DAIRY, carbPer100gr = 0 , proteinPer100gr = 0, fatPer100gr = 81),
            //ט
            FoodSaved(name = "טונה אדומה", calPer100gr =130, imageID = R.drawable.redtuna, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.FISH),
            FoodSaved(name = "טונה במים", calPer100gr =100, imageID = R.drawable.tuna, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.FISH),
            FoodSaved(name = "טונה בשמן", calPer100gr =150, imageID = R.drawable.tuna, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.FISH, carbPer100gr = 0 , proteinPer100gr = 26, fatPer100gr = 4),
            //י
            FoodSaved(name = "יין אדום", calPer100gr =85, imageID = R.drawable.wine, asUnit = false,caloriesPerUnit =  0,category = FoodCategory.ALCOHOL),
            //כ
            FoodSaved(name = "כוסמת", calPer100gr =92, imageID = R.drawable.kosemet, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.LEGUME),

            //ל
            FoodSaved(name = "לאבנה 11%", calPer100gr =155, imageID = R.drawable.labane, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.DAIRY, carbPer100gr = 2 , proteinPer100gr = 12, fatPer100gr = 11),
            FoodSaved(name = "לזניה", calPer100gr =200, imageID = R.drawable.general, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.COOKED_MEAL, carbPer100gr = 8 , proteinPer100gr = 12, fatPer100gr = 12),
            FoodSaved(name = "לחם שיפון מלא", calPer100gr =220, imageID = R.drawable.bead, asUnit = false,caloriesPerUnit =  0,category = FoodCategory.GRAIN),
            FoodSaved(name = "לחם פרנה", calPer100gr =280, imageID = R.drawable.frena, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.GRAIN),
            FoodSaved(name = "לחמניות המבורגר", calPer100gr =350, imageID = R.drawable.buns, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.GRAIN),
            //מ
            FoodSaved(name = "מיונז לייט", calPer100gr =290, imageID = R.drawable.mayolite, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.CONDIMENT),

            FoodSaved(name = "מיני מק-רויאל (ללא רוטב)", calPer100gr =0, imageID = R.drawable.minimc, asUnit = true, caloriesPerUnit = 200,category = FoodCategory.JUNKFOOD),
            FoodSaved(name = "מלפפון", calPer100gr =15, imageID = R.drawable.cucumber, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.VEGETABLE, carbPer100gr = 3 , proteinPer100gr = 0, fatPer100gr = 0),
            FoodSaved(name = "מלון", calPer100gr =35, imageID = R.drawable.melon, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.FRUIT),
            FoodSaved(name = "ממולאים", calPer100gr =150, imageID = R.drawable.memulaim, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.COOKED_MEAL),
            FoodSaved(name = "ממרח כבד", calPer100gr =170, imageID = R.drawable.patte, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.MEAT),
            FoodSaved(name = "ממרח סלומון", calPer100gr =210, imageID = R.drawable.patte, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.FISH),
            FoodSaved(name = "מנה חמה בולונז", calPer100gr =0, imageID = R.drawable.manahama, asUnit = true, caloriesPerUnit = 230,category = FoodCategory.JUNKFOOD),
            FoodSaved(name = "מעדן GO", calPer100gr =0, imageID = R.drawable.maadango,asUnit =  true, caloriesPerUnit = 110,category = FoodCategory.DAIRY, carbPerUnit = 8, proteinPerUnit = 20, fatPerUnit = 0),
            FoodSaved(name = "מעדן הגולן", calPer100gr =0, imageID = R.drawable.golan,asUnit =  true, caloriesPerUnit = 168,category = FoodCategory.SWEET),
            FoodSaved(name = "מעדן WOW", calPer100gr =0, imageID = R.drawable.wow,asUnit =  true, caloriesPerUnit = 135,category = FoodCategory.DAIRY, carbPerUnit = 15, proteinPerUnit = 10, fatPerUnit = 4),
            FoodSaved(name = "מק-רויאל (ללא רוטב)", calPer100gr =0, imageID = R.drawable.mcroyal, asUnit = true, caloriesPerUnit = 450,category = FoodCategory.JUNKFOOD),
            FoodSaved(name = "משקה חומץ Sourhead", calPer100gr =0, imageID = R.drawable.sourhead,asUnit =  true, caloriesPerUnit = 150,category = FoodCategory.DRINK, carbPerUnit = 35, proteinPerUnit = 0, fatPerUnit = 0),
            //נ
            FoodSaved(name = "נאצוס", calPer100gr =480, imageID = R.drawable.nacho, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.SNACK),
            FoodSaved(name = "נישנושים", calPer100gr =491, imageID = R.drawable.nishnushim,asUnit =  false, caloriesPerUnit = 0,category = FoodCategory.SNACK),
            FoodSaved(name = "נישנושים זעתר", calPer100gr =522, imageID = R.drawable.nishnushimzaatar, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.SNACK),

            FoodSaved(name = "נקטרינה", calPer100gr =44, imageID = R.drawable.nectarine, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.FRUIT),
            FoodSaved(name = "נקניקיות", calPer100gr =200, imageID = R.drawable.sausage, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.MEAT),
            FoodSaved(name = "נקניקיות פיקולינו רוסיות", calPer100gr =500, imageID = R.drawable.pikolini, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.MEAT, carbPer100gr = 6 , proteinPer100gr = 23, fatPer100gr = 41),
            FoodSaved(name = "נקניקיות גבינה מעושנת", calPer100gr =350, imageID = R.drawable.smokedcheesenaknik, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.DAIRY),
            //ס
            FoodSaved(name = "סוכר", calPer100gr =400, imageID = R.drawable.sugar, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.SWEET),
            FoodSaved(name = "סופגנייה", calPer100gr =400, imageID = R.drawable.sufgania, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.SWEET),

            FoodSaved(name = "סלט טונה", calPer100gr =114, imageID = R.drawable.tunasalad,asUnit =  false, caloriesPerUnit = 0,category = FoodCategory.FISH),
            //ע
            FoodSaved(name = "עגבניות שרי", calPer100gr =18, imageID = R.drawable.cherry_tomato, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.VEGETABLE, carbPer100gr = 4 , proteinPer100gr = 0, fatPer100gr = 0),
            FoodSaved(name = "עגבנייה", calPer100gr =18, imageID = R.drawable.tomatoes, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.VEGETABLE),
            FoodSaved(name = " ענבים", calPer100gr =70, imageID = R.drawable.grapes, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.FRUIT),

            //פ
            FoodSaved(name = "פוטטו [מקדונלדס]", calPer100gr =190, imageID = R.drawable.potatos_mcdonalds, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.VEGETABLE),
            FoodSaved(name = "פומלה / אשכולית", calPer100gr =40, imageID = R.drawable.pomela, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.FRUIT),
            FoodSaved(name = "פיתה", calPer100gr =250, imageID = R.drawable.pita, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.GRAIN),
            FoodSaved(name = "פירכיות", calPer100gr =370, imageID = R.drawable.pirhit, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.GRAIN),

            FoodSaved(name = "פלאפל", calPer100gr =330, imageID = R.drawable.falafel, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.JUNKFOOD),
            FoodSaved(name = "פסטה מבושלת", calPer100gr =160, imageID = R.drawable.pasta, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.GRAIN, carbPer100gr = 32 , proteinPer100gr = 5, fatPer100gr = 0),
            FoodSaved(name = "פתית", calPer100gr =380, imageID = R.drawable.patit, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.GRAIN),
            //צ
            FoodSaved(name = "צימיצורי", calPer100gr =130, imageID = R.drawable.chimichuri, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.CONDIMENT),
            FoodSaved(name = "צנון", calPer100gr =16, imageID = R.drawable.general, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.VEGETABLE, carbPer100gr = 3 , proteinPer100gr = 0, fatPer100gr = 0),
            //ק
            FoodSaved(name = "קבנוס", calPer100gr =325, imageID = R.drawable.kabanos,asUnit =  false, caloriesPerUnit = 0,category = FoodCategory.MEAT, carbPer100gr = 5 , proteinPer100gr = 20, fatPer100gr = 25),
            FoodSaved(name = "קטשופ", calPer100gr =110, imageID = R.drawable.ketshup, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.CONDIMENT),
            FoodSaved(name = "קוטג 5%", calPer100gr = 97, imageID = R.drawable.general, asUnit = false, caloriesPerUnit = 0, category = FoodCategory.DAIRY, carbPer100gr = 3 , proteinPer100gr = 10, fatPer100gr = 5),
            FoodSaved(name = "קולורבי", calPer100gr =27, imageID = R.drawable.kolorabi, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.VEGETABLE),
            FoodSaved(name = "קוסקוס", calPer100gr =120, imageID = R.drawable.kuskus, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.GRAIN),
            FoodSaved(name = "קליליות", calPer100gr =372, imageID = R.drawable.kliliot, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.GRAIN, carbPer100gr = 86 , proteinPer100gr = 6, fatPer100gr = 1),
            FoodSaved(name = "קלמנטינה/מנדרינה", calPer100gr =53, imageID = R.drawable.mandarin, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.FRUIT),
            FoodSaved(name = "קפה עם חלב", calPer100gr =60, imageID = R.drawable.coffee, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.DAIRY, carbPer100gr = 5 , proteinPer100gr = 3, fatPer100gr = 3),
            //ר
            FoodSaved(name = "רוטב אלף האיים לייט", calPer100gr =186, imageID = R.drawable.thousandlite, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.CONDIMENT),
            FoodSaved(name = "רוטב בולונז", calPer100gr =200, imageID = R.drawable.bolonez, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.MEAT),
            FoodSaved(name = "רוטב עגבניות/ירקות", calPer100gr =40, imageID = R.drawable.totato_sauce, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.VEGETABLE),
            FoodSaved(name = "ריזיקה/כללי", calPer100gr =100, imageID = R.drawable.general, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.DEFAULT),
            FoodSaved(name = "ריצה/אימון", calPer100gr =-100, imageID = R.drawable.run, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.DEFAULT),
            FoodSaved(name = "רוטב על בסיס שמנת לבישול", calPer100gr =160, imageID = R.drawable.shamenet, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.DAIRY, carbPer100gr = 4 , proteinPer100gr = 3, fatPer100gr = 15),
            //ש
            FoodSaved(name = "שווארמה הודו", calPer100gr =200, imageID = R.drawable.shawarma, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.MEAT),
            FoodSaved(name = "שמן קנולה", calPer100gr =830, imageID = R.drawable.kanola, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.OTHER),
            FoodSaved(name = "שמן זית", calPer100gr =882, imageID = R.drawable.olive_oil, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.OTHER, carbPer100gr = 0 , proteinPer100gr = 0, fatPer100gr = 100),
            FoodSaved(name = "שמנת חמוצה 15%", calPer100gr =159, imageID = R.drawable.hamutza, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.DAIRY),

            FoodSaved(name = "שניצלונים קופאים", calPer100gr =240, imageID = R.drawable.schnitselonim,asUnit =  false, caloriesPerUnit = 0,category = FoodCategory.MEAT),
            FoodSaved(name = "שניצל מטוגן", calPer100gr =300, imageID = R.drawable.schnitzel, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.MEAT),

            //ת
            FoodSaved(name = "תירס", calPer100gr =90, imageID = R.drawable.corn,asUnit =  false, caloriesPerUnit = 0,category = FoodCategory.VEGETABLE, carbPer100gr = 19 , proteinPer100gr = 3, fatPer100gr = 1),
            FoodSaved(name = "תפוח אדמה/פירה", calPer100gr =93, imageID = R.drawable.potato, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.VEGETABLE),
            FoodSaved(name = "תפוציפס - חומץ מלח", calPer100gr =535, imageID = R.drawable.saltvinegar, asUnit = false, caloriesPerUnit = 0,category = FoodCategory.SNACK, carbPer100gr = 53 , proteinPer100gr = 5, fatPer100gr = 33),
            )

    }
}
package catsOfClaire.data

import catsOfClaire.model.Cats
import catsOfClaire.ui.theme.*

object PuppyAdoptionRepo {

    fun getCatsList() = listOf(
        Cats(1, "LuLu", "catImages/item_image_lulu.jpg", LuluHairColor),
        Cats(2, "DD", "catImages/item_image_dd.jpg", DdHairColor),
        Cats(3, "LaLa", "catImages/item_image_lala.png", LaLaHairColor),
        Cats(4, "TT", "catImages/item_image_tt.jpg", TtHairColor),
        Cats(5, "ChuChu", "catImages/item_image_chuchu.jpg", ChuChuHairColor),
        Cats(6, "CoCo", "catImages/item_image_coco.jpg", CocoHairColor),
        Cats(7, "MoMo", "catImages/item_image_momo.png", MomoHairColor)
    )
}

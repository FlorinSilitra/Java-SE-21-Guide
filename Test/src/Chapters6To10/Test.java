package Chapters6To10;

import java.util.ArrayList;

public class Test {

    public static void main(String[] args)
    {
        var favorites = new ArrayList<String>();
        favorites.add("Apples");

        var zebra = new Animal(favorites);  // Caller still has access to favorites
        System.out.println(zebra.getFavoriteFoodsItem(0));  // [Apples]

        favorites.clear();
        favorites.add("Chocolate Chip Cookies");
        System.out.println(zebra.getFavoriteFoodsItem(0));  // [Chocolate Chip Cookies]
    }
}

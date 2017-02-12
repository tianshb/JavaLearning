package com.crow.Enumeration;

/**
 * Created by CrowHawk on 17/2/12.
 */

public class EnumTest {
    public static void main(String[] args) {
        EnumCoin obcerse = EnumCoin.OBCERSE;
        System.out.println("The other side of the Obcerse is " + obcerse.enumNext().toString());
    }
}

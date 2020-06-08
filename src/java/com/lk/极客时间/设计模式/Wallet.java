package com.lk.极客时间.设计模式;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Description:
 *
 * @author likai
 * @date 2019-11-13 16:43
 */
public class Wallet {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public static void main(String[] args){

        List<Wallet> wallets = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            Wallet wallet = new Wallet();
            wallet.setId("id_"+i);
            wallet.setName("na_" + i);
            wallets.add(wallet);
        }
         }
}

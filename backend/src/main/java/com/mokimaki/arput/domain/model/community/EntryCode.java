package com.mokimaki.arput.domain.model.community;

import lombok.Getter;

import java.util.Random;

@Getter
public class EntryCode {
    private final String entryCode;

    public EntryCode(String entryCode) {
        this.entryCode = entryCode;
    }

    public EntryCode() {
        Random r = new Random();
        String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder str = new StringBuilder();
        int len = 10; // 生成する文字列の長さ
        for (int i = 0; i < len; i++) {
            str.append(alphabet.charAt(r.nextInt(alphabet.length())));
        }

        this.entryCode = str.toString();
    }
}

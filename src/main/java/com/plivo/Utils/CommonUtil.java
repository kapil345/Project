package com.plivo.Utils;

import java.util.HashMap;

public class CommonUtil {

    public HashMap<String, String> data = new HashMap<>();

    public void saveNumbers(String number1, String number2) {
        data.put("src", number1);
        data.put("dst", number2);
    }

    public HashMap<String, String> getNumbers() {
        return data;
    }
}

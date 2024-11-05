package com.ghouse.beamer.util;

import java.util.HashMap;
import java.util.Map;

public class StringUtil {
    private static final Map<Character, String> SPECIAL_CHARACTERS = createSpecialCharacterMap();

    public static String replaceSpecialCharactersWithNames(String input) {
        StringBuilder output = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (SPECIAL_CHARACTERS.containsKey(ch)) {
                output.append(" "+SPECIAL_CHARACTERS.get(ch)+" ");
            } else {
                output.append(ch);
            }
        }

        return output.toString();
    }

    private static Map<Character, String> createSpecialCharacterMap() {
        Map<Character, String> specialCharacterMap = new HashMap<>();
        specialCharacterMap.put('-', "dash");
        specialCharacterMap.put('.', "dot");
        specialCharacterMap.put(',', "comma");
        specialCharacterMap.put('!', "ExclamationMark");
        specialCharacterMap.put('@', "AtSign");
        specialCharacterMap.put('#', "Hash");
        specialCharacterMap.put('$', "Dollar");
        specialCharacterMap.put('%', "Percent");
        return specialCharacterMap;
    }
}

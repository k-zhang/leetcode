package com.algomind.leetcode.easy;

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        var words = s.split("\\s");
        return words[words.length - 1].length();
    }

    public int lengthOfLastWord2(String s) {
        var trimmed = s.trim();
        var compactSentence = trimmed.replaceAll("\\s+", " ");
        var lastSpaceIndex = compactSentence.lastIndexOf(" ");
        var lastWord = compactSentence.substring(lastSpaceIndex + 1);
        return lastWord.length();
    }
}

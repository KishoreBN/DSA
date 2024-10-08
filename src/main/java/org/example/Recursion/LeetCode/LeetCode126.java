package org.example.Recursion.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LeetCode126 {
    static int minLength = Integer.MAX_VALUE;
    public static void main(String[] args) {
        List<String> wordList = new ArrayList<>(List.of("si","go","se","cm","so","ph","mt","db","mb","sb","kr","ln","tm","le","av","sm","ar","ci","ca","br","ti","ba","to","ra","fa","yo","ow","sn","ya","cr","po","fe","ho","ma","re","or","rn","au","ur","rh","sr","tc","lt","lo","as","fr","nb","yb","if","pb","ge","th","pm","rb","sh","co","ga","li","ha","hz","no","bi","di","hi","qa","pi","os","uh","wm","an","me","mo","na","la","st","er","sc","ne","mn","mi","am","ex","pt","io","be","fm","ta","tb","ni","mr","pa","he","lr","sq","ye"));
        System.out.println(findLadders("qa", "sq", wordList));
    }

    static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
//        for(int i=0; i<wordList.size(); i++){
//            if(endWord.equals(wordList.get(i))){
//                wordList.remove(i);
//                wordList.add(endWord);
//            }
//        }
        helper(endWord, new ArrayList<>(List.of(beginWord)), wordList, 0, result);
        return result;
    }

    static void helper(String endWord, List<String> processed, List<String> wordList, int index, List<List<String>> result){
        if(processed.get(processed.size() - 1).equals(endWord)){
            if(processed.size() < minLength){
                result.clear();
                result.add(new ArrayList<>(processed));
                minLength = processed.size();
            } else if(processed.size() == minLength){
                result.add(new ArrayList<>(processed));
            }
            return;
        }
        if(processed.size() > minLength){
            return;
        }
        for(int i=0; i<wordList.size(); i++){
            String str = wordList.get(i);
            if(compareCharacters(processed.get(processed.size() - 1), wordList.get(i)) == 1){
                processed.add(wordList.get(i));
                wordList.remove(i);
                helper(endWord, processed, wordList, index + 1, result);
                processed.remove(processed.size() - 1);
                wordList.add(i,str);
            }
        }
    }

    static int compareCharacters(String str1, String str2){
        int count = 0;
        for(int i=0; i<str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                count++;
            }
        }
        return count;
    }
}

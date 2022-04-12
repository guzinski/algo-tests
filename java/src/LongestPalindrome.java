import java.util.*;
import java.util.stream.Collectors;

public class LongestPalindrome {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        String result = longestPalindrome("thelviymgkeddreyviespjsyqwmbmnlwzjhdokfzrczvreiagayofwvhecskjqlqzodtozvzozqyiwfsjyrinrmgfyhplybonzuvmxxyihmggwiuccplqjtgschmieoexvtewbsjqzkzapfxpzhgjtbmlchevohmxnbattphvobptnhmcoihcaimchurqpucxapojgszpopdvsfahwidiyxlpjfhdkcoewzvlmaebudtovnvcuadykhhmwfpilqfdvnseiitokcbuxmhwukrdxwvtgztczrwcsydqwosnktronibiplbljrcpinqorbhxrwjonnqeniebrksjkcmbvjnuwdedoenqmrcxayqbzmlpbubnfnkkqnuljtchaeijcmfpyuxkgfssoqliqmhowtbmcvzkqbanxhowjjejexxlihwwhilxxejejjwohxnabqkzvcmbtwohmqilqossfgkxuypfmcjieahctjlunqkknfnbubplmzbqyaxcrmqneodedwunjvbmckjskrbeineqnnojwrxhbroqnipcrjlblpibinortknsowqdyscwrzctzgtvwxdrkuwhmxubckotiiesnvdfqlipfwmhhkydaucvnvotdubeamlvzweockdhfjplxyidiwhafsvdpopzsgjopaxcupqruhcmiachiocmhntpbovhpttabnxmhovehclmbtjghzpxfpazkzqjsbwetvxeoeimhcsgtjqlpccuiwggmhiyxxmvuznobylphyfgmrniryjsfwiyqzozvzotdozqlqjkscehvwfoyagaiervzcrzfkodhjzwlnmbmwqysjpseivyerddekgmyivleht");

        long time = (System.currentTimeMillis() - start);
        System.out.println(result);
        System.out.println("Execution time: "+ time);
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        if (s.length() == 1) return s;
        if (s.length() == 2) return String.valueOf(s.charAt(0));
        char[] letters = s.toCharArray();
        long longest = 0;
        Deque<Character> queue = new ArrayDeque<>();
        List<String> palindromics = new ArrayList<>();
        for (char current : letters) {
            if (!queue.contains(current)) {
                queue.add(current);
                palindromics.add(String.valueOf(current));
            } else {
                queue.add(current);
                String palindromic = checkPalindromic(new ArrayDeque<>(queue), longest);
                if (!palindromic.isEmpty()) {
                    if (palindromic.length() > longest) {
                        longest = palindromic.length();
                    }
                    palindromics.add(palindromic);
                }
            }
        }
        // return palindromics.toString();
        return palindromics
                .stream()
                .max(Comparator.comparing(String::length))
                .orElse("");
    }

    private static String checkPalindromic(Deque<Character> queue, long longest) {
        String s = queue.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        char last = queue.getLast();
        long count = queue
                .stream()
                .filter(c -> c == last)
                .count();
        if (queue.getFirst() != queue.getLast()) {
            s = s.substring(s.indexOf(queue.getLast()));
        }
        while (count > 2 && s.length() > longest) {
            String reverse = new StringBuilder(s).reverse().toString();
            if (reverse.equals(s)) {
                return s;
            }
            s = s.substring(s.indexOf(queue.getLast(), 1));
            count--;
        }
        String reverse = new StringBuilder(s).reverse().toString();

        if (reverse.equals(s)) {
            return s;
        } else {
            return "";
        }
    }


}

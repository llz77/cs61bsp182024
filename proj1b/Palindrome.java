
public class Palindrome {


    public Deque<Character> wordToDeque(String word) {
        Deque<Character> res = new LinkedListDeque<>();
        int wordlength = word.length();
        for (int i = 0; i < wordlength; i++) {
            res.addLast(word.charAt(i));
        }
        return res;
    }

    public boolean isPalindrome(String word) {
        if (word == null || word.length() <= 1) {
            return true;
        }
        int wordlength = word.length();
        Deque worddeque = wordToDeque(word);
//        for (int i = 0; i < wordlength / 2; i++) {
//            if (word.charAt(i) != word.charAt(wordlength-i-1)) {
//                return false;
//            }
//        }
        for (int i = 0; i < wordlength / 2; i++) {
            if (worddeque.get(i) != worddeque.get(wordlength-i-1)) {
                return false;
            }
            worddeque.removeFirst();
            worddeque.removeLast();
        }
        return true;
    }





}

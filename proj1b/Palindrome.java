public class Palindrome {
    public Deque<Character> wordToDeque(String word){
//        Deque<Character> wordInDeque = new ArrayDeque<>();
        Deque<Character> wordInDeque = new LinkedListDeque<Character>();
        for (int i = 0; i < word.length(); i++) {
            wordInDeque.addLast(word.charAt(i));
        }
        return wordInDeque;
    }

    public boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));
    }

    private boolean isPalindrome(Deque<Character> wordInDeque) {
        while (wordInDeque.size() > 1) {
            return wordInDeque.removeFirst() == wordInDeque.removeLast() && isPalindrome(wordInDeque);
            // linked list deque may occur error
        }
        return true;
    }

/*//    off-by-1 palindrome
    public boolean isPalindrome(String word, CharacterComparator cc) {
        OffByOne obo = new OffByOne();
        return isPalindrome(wordToDeque(word), obo);
    }

    private boolean isPalindrome(Deque<Character> wordInDeque, OffByOne obo) {
        while (wordInDeque.size() > 1) {
            char a = wordInDeque.removeFirst();
            char b = wordInDeque.removeLast();
            return obo.equalChars(a, b) && isPalindrome(wordInDeque, obo);
        }
        return true;
    }*/

    // off-by-1 palindrome , transfer CC to use the method
    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindrome(wordToDeque(word), cc);
    }

    private boolean isPalindrome(Deque<Character> wordInDeque, CharacterComparator cc) {
        while (wordInDeque.size() > 1) {
            char a = wordInDeque.removeFirst();
            char b = wordInDeque.removeLast();
            return cc.equalChars(a, b) && isPalindrome(wordInDeque, cc);
        }
        return true;
    }

}

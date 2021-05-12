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

}

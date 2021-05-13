import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(palindrome.isPalindrome("a"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("aa"));
        assertTrue(palindrome.isPalindrome("noon"));
        assertTrue(palindrome.isPalindrome("racecar"));
        assertFalse(palindrome.isPalindrome("horse"));
        assertFalse(palindrome.isPalindrome("aaab"));
        assertFalse(palindrome.isPalindrome("Aa"));
    }

    // check if palindrome off-by-one
    @Test
    public void testIsPalindromeObo() {
        OffByOne obo = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake",obo));
        assertTrue(palindrome.isPalindrome("ab",obo));
        assertTrue(palindrome.isPalindrome("a",obo));
        assertFalse(palindrome.isPalindrome("kind", obo));
        assertFalse(palindrome.isPalindrome("noon", obo));
    }

    // check if palindrome off-by-n
    @Test
    public void testIsPalindromeObn() {
        OffByN offBy5 = new OffByN(5);
        assertTrue(palindrome.isPalindrome("afaf", offBy5));
        assertTrue(palindrome.isPalindrome("bgbg", offBy5));
        assertFalse(palindrome.isPalindrome("affa", offBy5));
        assertFalse(palindrome.isPalindrome("gbgd", offBy5));
    }
}     //Uncomment this class once you've created your Palindrome class.
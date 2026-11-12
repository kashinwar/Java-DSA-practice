
import java.util.*;
public class letter_combination_ofa_phoneno {
    

class Solution {

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), phone, result);

        return result;
    }

    public void backtrack(String digits, int index,
                          StringBuilder current,
                          String[] phone,
                          List<String> result) {

        // Base case: combination is complete
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters for the current digit
        String letters = phone[digits.charAt(index) - '0'];

        // Try every possible letter
        for (int i = 0; i < letters.length(); i++) {

            current.append(letters.charAt(i));

            backtrack(digits, index + 1, current, phone, result);

            // Remove the last character (backtracking)
            current.deleteCharAt(current.length() - 1);
        }
    }
}

}


// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any order.

// A mapping of digits to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.


 

// Example 1:

// Input: digits = "23"
// Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
// Example 2:

// Input: digits = "2"
// Output: ["a","b","c"]
 

// Constraints:

// 1 <= digits.length <= 4
// digits[i] is a digit in the range ['2', '9'].
/* Longest Common Prefix
 * Given a set of strings, find the longest common prefix among them.
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 * All given inputs are in lowercase letters a-z.
 */


public class LCP{
    public static void main(String[] args) {
        System.out.println("RUNNING");
        String[] words = {"flower","flow","flight"};
        
        if(words == null || words.length == 0){
            System.out.println("");
            return;
        }

        String firstWord = words[0]; //basis of all words
        int count = 0;
        
        for(int i = 0; i < firstWord.length(); i++){ //letter position
            char firstWordLetter = firstWord.charAt(i);
            for(int j = 1; j < words.length; j++){ //other word comparison
                
                if(i >= words[j].length()){
                    return; // return if too short
                }
                
                char secondWordLetter = words[j].charAt(i);

                if(firstWordLetter != secondWordLetter){
                    System.out.println(firstWord.substring(0,count));
                    return; // stop of mismatch   
                }
            }
            count++;
        }

        System.out.println(firstWord.substring(0,count));

    }   
}
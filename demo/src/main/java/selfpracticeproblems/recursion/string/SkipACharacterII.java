package selfpracticeproblems.recursion.string;

public class SkipACharacterII {

    static void main(String[] args) {
        String s = "baccad";
        //System.out.println(skipCharacter("", s, 'a'));
        System.out.println(skipCharacter(s,'a'));
        System.out.println(skipApple("bccddappleijk"));
    }

    static String skipCharacter(String processed, String unprocessed, char a) {
        if (unprocessed.isEmpty()) {
            return processed;
        }

        char charAt0 = unprocessed.charAt(0);
        if (charAt0 == a) {
            return skipCharacter(processed, unprocessed.substring(1), a);
        }
//        StringBuilder sb = new StringBuilder(processed);
//        sb.append(charAt0);
        return skipCharacter(processed+charAt0, unprocessed.substring(1), a);
    }

    static String skipCharacter(String string, char a) {
       if (string.isEmpty()){
           return "";
       }
       if (string.charAt(0)==a){
           return skipCharacter(string.substring(1),a);
       }
       return  string.charAt(0) + skipCharacter(string.substring(1),a);

    }

    static String skipApple(String string) {
        if (string.isEmpty()){
            return "";
        }
        if (string.startsWith("apple")){
            return skipApple(string.substring(5));
        }
        return  string.charAt(0) + skipApple(string.substring(1));

    }

    static String skipAppNotApple(String string) {
        if (string.isEmpty()){
            return "";
        }
        if (string.startsWith("app") && !string.startsWith("apple")){
            return skipAppNotApple(string.substring(3));
        }
        return  string.charAt(0) + skipAppNotApple(string.substring(1));

    }
}

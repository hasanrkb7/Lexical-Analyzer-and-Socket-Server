import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class lab3 {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int patternCnt = sc.nextInt();
        String [] pattern = new String[patternCnt];
        for(int i = 0; i < patternCnt; i++){
            pattern[i] = sc.next();
        }
        int tokenCnt = sc.nextInt();
        String [] token = new String[tokenCnt];
        for(int i = 0; i < tokenCnt; i++){
            token[i] = sc.next();
        }
        for(int i = 0; i < tokenCnt; i++){
            int patternIndex = 0;
            boolean flag = true;
            for(int j=0;j<patternCnt;j++){
                if(isMatch(token[i], pattern[j])){
                    patternIndex = j+1;
                    flag = false;
                    break;
                }
            }
            if(flag){
                System.out.println("NO, 0");
            }
            else{
                System.out.println("YES, " + patternIndex);
            }
        }
    }
    static boolean isMatch(String token, String pattern){
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(token);
        return m.find();
    }
}
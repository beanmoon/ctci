package chapter9_1;

/**
 * Created by bean on 12/20/14.
 */
public class code1_4 {
    public void replaceSpaces(char[] str, int length){
        int i = 0, spaceCount = 0;
        for(; i<length; i++){
            if(str[i] == ' ')
                spaceCount++;
        }
        int oldLength = length;
        length = length + spaceCount*2;
        str[length--] = '\0';
        for(i=oldLength-1; i>=0; i--){
            if(str[i] == ' '){
                str[length--] = '0';
                str[length--] = '2';
                str[length--] = '%';
            }else{
                str[length--] = str[i];
            }
        }

    }
    public static void main(String[] args){
        code1_4 code1_4 = new code1_4();
        char[] hello = new char[100];
        char[] hello2 = "hello world".toCharArray();
        for(int i = 0; i<hello2.length; i++)
            hello[i] = hello2[i];

        code1_4.replaceSpaces(hello, 11);
        System.out.println(hello);

    }
}

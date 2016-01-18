/**
 * Created by fangyi on 17/01/2016.
 */
public class BaseConversion {
    public static boolean[] denaryToBinary(int num){
        boolean[] binary = new boolean[3];
        binary[0] = num % 2 != 0;
        binary[1] = (num / 2) % 2 != 0;
        binary[2] = num >= 4;
        return binary;
    }

    public static int binaryToDenary (boolean[] binary){
        int denary = 0;
        for (int i = 0; i < binary.length; i++) {
            if (binary[i]) {
                denary += 2 ^ i;
            }
        }
        return denary;
    }

}

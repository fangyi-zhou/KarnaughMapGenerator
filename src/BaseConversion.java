class BaseConversion {
    static boolean[] decimalToBinary(int num){
        boolean[] binary = new boolean[3];
        binary[0] = num % 2 != 0;
        binary[1] = (num / 2) % 2 != 0;
        binary[2] = num >= 4;
        return binary;
    }
}

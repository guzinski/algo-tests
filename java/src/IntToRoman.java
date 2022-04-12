public class IntToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(638));
    }

    public static String intToRoman(int num) {
        int mTimes = num/1000;
        num = num%1000;
        int cTimes = num/100;
        num = num%100;
        int xTimes = num/10;
        num = num%10;
        int iTimes = num;

        return buildRoman("M", "", "", mTimes)
                +buildRoman("C", "D", "M", cTimes)
                +buildRoman("X", "L", "C", xTimes)
                +buildRoman("I", "V", "X", iTimes);
    }

    private static String buildRoman(String lesser, String greater, String bigger, int times) {
        if (times == 0) return "";
        if (times == 1) return lesser;
        if (times == 2) return lesser+lesser;
        if (times == 3) return lesser+lesser+lesser;
        if (times == 4) return lesser+greater;
        if (times == 5) return greater;
        if (times == 6) return greater+lesser;
        if (times == 7) return greater+lesser+lesser;
        if (times == 8) return greater+lesser+lesser+lesser;
        if (times == 9) return lesser+bigger;
        return "";
    }

}

public class countCharOccurrence {

    public static void main(String[] args) {
        String input = "aacbccbAA123@#$%";
        printCharacterCount(input);
    }

    public static void printCharacterCount(String str) {
        int[] charCount = new int[256];

        for (char ch : str.toCharArray()) {
            charCount[ch]++;
        }

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > 0) {
                System.out.println((char) i + "=" + charCount[i]);
            }
        }
    }
    
}

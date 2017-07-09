public String reverseStr(String s, int k) {
    char[] newString = s.toCharArray();
    for (int i=0;i<newString.length;i+=2k) {
        int maxNum = Math.min(res.length-1, i+k-1);
        for (int h=i;h<=(i+maxNum)/2;h++) {
            char temp = newString[h];
            newString[h] = newString[i+maxNum-h];
            newString[i+maxNum-h]= temp;
        }
    }
    return new String(newString);
}

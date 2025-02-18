
// TC : O(1)
// SC : O(1)

package S30_Codes.Strings_3;

class IntegerToEnglishWords {
    String[] below_20 = {
            "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
            "Eighteen", "Nineteen"
    };

    String[] tens = {
            "", "", "Twenty",  "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"
    };

    String[] suffix = { "", "Thousand", "Million", "Billion", "Trillion"};

    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        StringBuilder result = new StringBuilder();
        int sufixIdx = 0;

        while(num > 0){
            int triplet = num%1000;
            if(triplet != 0){
                StringBuilder tempRes = new StringBuilder(helper(triplet).trim()).append(" ").append(suffix[sufixIdx]).append(" ").append(result);
                result = tempRes;
            }
            sufixIdx++;
            num = num/1000;
        }
        return result.toString().trim();
    }

    private String helper(int num){
        if(num < 20)
            return below_20[num];

        else if(num < 100)
            return tens[num/10] + " " + below_20[num%10];

        else{
            return below_20[num/100] + " Hundred "+ helper(num%100);
        }
    }
}
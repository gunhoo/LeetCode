class Solution {
    public String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        String[] string = date.split(" ");
        return sb.append(string[2]).append(convertMonth(string[1])).append(convertDay(string[0])).toString();
        
    }
    
    private String convertMonth(String month){
        if(month.equals("Jan")) return "-01-";
        if(month.equals("Feb")) return "-02-";
        if(month.equals("Mar")) return "-03-";
        if(month.equals("Apr")) return "-04-";
        if(month.equals("May")) return "-05-";
        if(month.equals("Jun")) return "-06-";
        if(month.equals("Jul")) return "-07-";
        if(month.equals("Aug")) return "-08-";
        if(month.equals("Sep")) return "-09-";
        if(month.equals("Oct")) return "-10-";
        if(month.equals("Nov")) return "-11-";
        return "-12-";
    }
    
    private String convertDay(String day){
        if(day.length() == 3) return "0"+day.substring(0,1);
        return day.substring(0,2);
    }
}
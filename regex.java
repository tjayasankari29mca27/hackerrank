

//Write your code here
class MyRegex {
    // Regex logic: 
    // (0-99 OR 000-099 OR 100-199 OR 200-249 OR 250-255)
    String octet = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";
    
    // Pattern: octet.octet.octet.octet
    public String pattern = octet + "\\." + octet + "\\." + octet + "\\." + octet;
}

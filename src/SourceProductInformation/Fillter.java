package SourceProductInformation;

public class Fillter {
    public static String splitPrice(String price){
        if(price.length() > 11){
            price = price.substring(8, 18);
        }
        price = price.replaceAll("\\.", "");
        price = price.replaceAll("₫", "");
        price = price.replaceAll("<", "");
        price = price.replaceAll("/", "");
        return price;
    }
    public static String filterColor(String name, String link){
        name = name.toUpperCase();
        link = link.toUpperCase();
        boolean redCondition = name.contains("RED") || name.contains("ĐỎ") || link.contains("RED") || link.contains("ĐỎ");
        boolean yellowCondition = name.contains("YELLOW") || name.contains("VÀNG") || link.contains("YELLOW") || link.contains("VÀNG");
        boolean silverCondition = name.contains("SILVER") || name.contains("BẠC") || link.contains("SILVER") || link.contains("BẠC");
        boolean blackCondition = name.contains("BLACK") || name.contains("ĐEN") || link.contains("BLACK") || link.contains("ĐEN");
        boolean blueCondition = name.contains("BLUE") || name.contains("XANH") || link.contains("BLUE") || link.contains("XANH");
        boolean whiteCondition = name.contains("WHITE") || name.contains("TRẮNG") || link.contains("WHITE") || link.contains("TRẮNG");
        boolean purpleCondition = name.contains("PURPLE") || name.contains("TÍM") || link.contains("PURPLE") || link.contains("TÍM");
        boolean grayCondition1 = name.contains("GRAY") || link.contains("GRAY");
        boolean grayCondition2 = name.contains("GREY") || name.contains("XÁM") || link.contains("GREY") || link.contains("XÁM");
        boolean pinkCondition = name.contains("PINK") || name.contains("HỒNG") || link.contains("PINK") || link.contains("HỒNG");
        boolean goldCondition = name.contains("GOLD") || link.contains("GOLD");
        boolean greenCondition = name.contains("GREEN") || link.contains("GREEN");
        if(redCondition){
            return "Red";
        }
        else if(yellowCondition){
            return "Yellow";
        }
        else if(silverCondition){
            return "Silver";
        }
        else if(blackCondition){
            return "Black";
        }
        else if(blueCondition){
            return "Blue";
        }
        else if(whiteCondition){
            return "White";
        }
        else if(purpleCondition){
            return "Purple";
        }
        else if(grayCondition1 || grayCondition2){
            return "Grey";
        }
        else if(pinkCondition){
            return "Pink";
        }
        else if(goldCondition){
            return "Gold";
        }
        else if(greenCondition){
            return "Green";
        }
        else
            return "no color";
    }
    public static String filterBrand(String name){
        name = name.toUpperCase();
        if(name.contains("SAM")){
            return "Samsung";
        }
        else if(name.contains("PANA")){
            return "Panasonic";
        }
        else if(name.contains("LG")){
            return "LG";
        }
        else if(name.contains("SHARP")){
            return "Sharp";
        }
        else if(name.contains("MIDEA")){
            return "Midea";
        }
        else if(name.contains("HITACHI")){
            return "Hitachi";
        }
        else if(name.contains("ELEC")){
            return "Electrolux";
        }
        else if(name.contains("AQUA")){
            return "Aqua";
        }
        else if(name.contains("TOSHI")){
            return "Toshiba";
        }
        else if(name.contains("NOKIA")){
            return "Nokia";
        }
        else if(name.contains("SONY")){
            return "Sony";
        }
        else if(name.contains("MASST")){
            return "Masstel";
        }
        else if(name.contains("WIKO")){
            return "Wiko";
        }
        else if(name.contains("XIAOM")){
            return "Xiaomi";
        }
        else if(name.contains("HUAW")){
            return "Huawei";
        }
        else if(name.contains("ITEL")){
            return "iTel";
        }
        else if(name.contains("MOTORO")){
            return "Motorola";
        }
        else if(name.contains("OPPO")){
            return "Oppo";
        }
        else if(name.contains("BLACKBE")){
            return "BlackBerry";
        }
        else if(name.contains("GALAXY")){
            return "Samsung";
        }
        else if(name.contains("HONOR")){
            return "Honor";
        }
        else if(name.contains("HTC")){
            return "HTC";
        }
        else if(name.contains("COOLPA")){
            return "Coolpad";
        }
        else if(name.contains("MOBII")){
            return "Mobiistar";
        }
        else if(name.contains("ZTE")){
            return "ZTE";
        }
        else if(name.contains("VIVO")){
            return "Vivo";
        }
        else if(name.contains("REALM")){
            return "Realme";
        }
        else if(name.contains("IPHON")){
            return "iPhone";
        }
        else if(name.contains("HUAW")){
            return "Huawei";
        }
        else if(name.contains("HP")){
            return "HP";
        }
        else if(name.contains("DELL")){
            return "Dell";
        }
        else if(name.contains("MSI")){
            return "MSI";
        }
        else if(name.contains("BOSCH")){
            return "Bosch";
        }
        else if(name.contains("ASUS")){
            return "Asus";
        }
        else if(name.contains("LENOVO")){
            return "Lenovo";
        }
        else if(name.contains("ACER")){
            return "Acer";
        }
        else if(name.contains("MACBOOK")){
            return "Apple Macbook";
        }
        else if(name.contains("MICROS")){
            return "Microsort";
        }
        return "No brand";
    }
    public static String filterSize(String brand, String name){
        String result = null;
        brand = brand.toUpperCase();
        name = name.toUpperCase();
        if( brand.contains("APPLE")){
            result = "," + "13.3'";
        }
        else if(name.contains("ENVY")){
            result = "," + "13'";
        }
        else if(name.contains(" 15-")){
            result = "," + "15'";
        }
        else
            result = "," + "14'";
        return result;
    }
    public static String filterType(String price, String name){
        String result = null;
        name = name.toUpperCase();
        if( name.contains("ĐỨNG")){
            result = "," + "upper door";
        }
        else if(name.contains("NGANG")){
            result = "," + "front door";
        }
        else if( Integer.parseInt(price) >= 7000000){
            result = "," + "front door";
        }
        else {
            result = "," + "upper door";
        }
        return result;
    }
}

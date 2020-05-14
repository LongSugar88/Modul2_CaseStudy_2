package SourceProductInformation;

public class ClawRun {
    public static void main(String[] args) throws InterruptedException {

        String [] washingMachinePico = {
                "https://pico.vn/may-giat-nhom-72.html", "https://pico.vn/may-giat-nhom-72.html?&pageIndex=2",
                "https://pico.vn/may-giat-nhom-72.html?&pageIndex=3"
        };
        String [] mobilePhonePico = {
                "https://pico.vn/dien-thoai-di-dong-nhom-75.html", "https://pico.vn/dien-thoai-di-dong-nhom-75.html?&pageIndex=2",
                "https://pico.vn/dien-thoai-di-dong-nhom-75.html?&pageIndex=3", "https://pico.vn/dien-thoai-di-dong-nhom-75.html?&pageIndex=4"
        };
        String [] laptopPico = {
                "https://pico.vn/may-tinh-xach-tay-nhom-58.html", "https://pico.vn/may-tinh-xach-tay-nhom-58.html?&pageIndex=2",
                "https://pico.vn/may-tinh-xach-tay-nhom-58.html?&pageIndex=3"
        };
        String [] washingMachineMediamart = {
                "https://mediamart.vn/may-giat/", "https://mediamart.vn/may-giat/?trang=2",
                "https://mediamart.vn/may-giat/?trang=3", "https://mediamart.vn/may-giat/?trang=4",
                "https://mediamart.vn/may-giat/?trang=5"
        };
        String [] mobilePhoneMediamart = {
                "https://mediamart.vn/smartphones/", "https://mediamart.vn/smartphones/?trang=2",
                "https://mediamart.vn/smartphones/?trang=3", "https://mediamart.vn/smartphones/?trang=4",
                "https://mediamart.vn/smartphones/?trang=5", "https://mediamart.vn/smartphones/?trang=6",
                "https://mediamart.vn/smartphones/?trang=7", "https://mediamart.vn/smartphones/?trang=8",
                "https://mediamart.vn/smartphones/?trang=9", "https://mediamart.vn/smartphones/?trang=10",
                "https://mediamart.vn/smartphones/?trang=11", "https://mediamart.vn/smartphones/?trang=12"
        };
        String [] laptopMediamart = {
                "https://mediamart.vn/laptop/", "https://mediamart.vn/laptop/?trang=2",
                "https://mediamart.vn/laptop/?trang=3","https://mediamart.vn/laptop/?trang=4",
                "https://mediamart.vn/laptop/?trang=5","https://mediamart.vn/laptop/?trang=6",
                "https://mediamart.vn/laptop/?trang=7","https://mediamart.vn/laptop/?trang=8",
                "https://mediamart.vn/laptop/?trang=9"
        };
        ClawPicoProduct clawPicoProduct = null;
        ClawPicoProduct clawPicoProduct1 = null;
        ClawPicoProduct clawPicoProduct2 = null;
        ClawMediamartProduct clawMediamartProduct = null;
        ClawMediamartProduct clawMediamartProduct1 = null;
        ClawMediamartProduct clawMediamartProduct2 = null;
        for ( String element: washingMachinePico) {
            clawPicoProduct = new ClawPicoProduct(element,"D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "WashingMachine", "Pico00", false, true, false  );
            clawPicoProduct.start();
        }
        for ( String element: mobilePhonePico) {
            clawPicoProduct1 = new ClawPicoProduct(element,"D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "MobilePhone", "Pico00", true, false, false  );
            clawPicoProduct1.start();
        }
        for ( String element: laptopPico) {
            clawPicoProduct2 = new ClawPicoProduct(element,"D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "Laptop", "Pico00", true, false, true  );
            clawPicoProduct2.start();
        }

        clawPicoProduct.join();
        clawPicoProduct1.join();
        clawPicoProduct2.join();

        for ( String element: washingMachineMediamart) {
            clawMediamartProduct = new ClawMediamartProduct(element,"D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "WashingMachine", "MediaMart00", false, true, false  );
            clawMediamartProduct.start();
        }
        for ( String element: mobilePhoneMediamart) {
            clawMediamartProduct1 = new ClawMediamartProduct(element,"D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "MobilePhone", "MediaMart00", true, false, false  );
            clawMediamartProduct1.start();
        }
        for ( String element: laptopMediamart) {
            clawMediamartProduct2 = new ClawMediamartProduct(element,"D:\\CodeGYM Course\\Modul_2\\Week4\\CaseStudy_2\\src\\SourceProductInformation\\Product.txt", "Laptop", "MediaMart00", true, false, true  );
            clawMediamartProduct2.start();
        }
    }
}

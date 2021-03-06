package SourceProductInformation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WriteProductInfomationClawMainMenu {

    @Test
    void splitPrice1() {
        String example = "<strong>28.900.000₫</strong>";
        String expect = "28900000";
        String result = Fillter.splitPrice(example);
        assertEquals(expect, result);
    }
    @Test
    void splitPrice2() {
        String example = "<strong>13.990.000₫</strong>";
        String expect = "13990000";
        String result = Fillter.splitPrice(example);
        assertEquals(expect, result);
    }
    @Test
    void splitPrice3() {
        String example = "25.900.000₫";
        String expect = "25900000";
        String result = Fillter.splitPrice(example);
        assertEquals(expect, result);
    }
    @Test
    void splitPrice4() {
        String example = "10.990.000₫";
        String expect = "10990000";
        String result = Fillter.splitPrice(example);
        assertEquals(expect, result);
    }
}
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class J00020mTest {

    J00020m j00020m = new J00020m();

    @Test
    public void isNumber() {
        Assert.assertTrue(j00020m.isNumber(".2e81"));
        Assert.assertTrue(j00020m.isNumber("46.e3"));
        Assert.assertTrue(j00020m.isNumber("53.5e93"));
        Assert.assertTrue(j00020m.isNumber("1 "));
        Assert.assertTrue(j00020m.isNumber("2"));
        Assert.assertTrue(j00020m.isNumber("0089"));
        Assert.assertTrue(j00020m.isNumber("-0.1"));
        Assert.assertTrue(j00020m.isNumber("+3.14"));
        Assert.assertTrue(j00020m.isNumber("4."));
        Assert.assertTrue(j00020m.isNumber("-.9"));
        Assert.assertTrue(j00020m.isNumber("2e10"));
        Assert.assertTrue(j00020m.isNumber("-90E3"));
        Assert.assertTrue(j00020m.isNumber("3e+7"));
        Assert.assertTrue(j00020m.isNumber("+6e-1"));
        Assert.assertTrue(j00020m.isNumber("-123.456e789"));
        Assert.assertTrue(j00020m.isNumber("1. "));
        Assert.assertTrue(j00020m.isNumber("+100"));
        Assert.assertTrue(j00020m.isNumber("5e2"));
        Assert.assertTrue(j00020m.isNumber("-123"));
        Assert.assertTrue(j00020m.isNumber("3.1416"));
        Assert.assertTrue(j00020m.isNumber("-1E-16"));
        Assert.assertTrue(j00020m.isNumber("0123"));
        Assert.assertFalse(j00020m.isNumber("12e"));
        Assert.assertFalse(j00020m.isNumber("1a3.14"));
        Assert.assertFalse(j00020m.isNumber("1.2.3"));
        Assert.assertFalse(j00020m.isNumber("+-5"));
        Assert.assertFalse(j00020m.isNumber("12e+5.4"));
        Assert.assertFalse(j00020m.isNumber("e"));
        Assert.assertFalse(j00020m.isNumber("."));
        Assert.assertFalse(j00020m.isNumber("+e"));
        Assert.assertFalse(j00020m.isNumber("+."));
        Assert.assertFalse(j00020m.isNumber(".."));
        Assert.assertFalse(j00020m.isNumber("ee"));
        Assert.assertFalse(j00020m.isNumber("1e"));
        Assert.assertFalse(j00020m.isNumber("e1"));
        Assert.assertFalse(j00020m.isNumber("4e+"));
        Assert.assertFalse(j00020m.isNumber("4.+"));
        Assert.assertFalse(j00020m.isNumber("4.-"));
        Assert.assertFalse(j00020m.isNumber("99e2.5"));
        Assert.assertFalse(j00020m.isNumber("--6"));
        Assert.assertFalse(j00020m.isNumber("-+3"));
        Assert.assertFalse(j00020m.isNumber("95a54e53"));
        Assert.assertFalse(j00020m.isNumber(".e1"));
    }
}
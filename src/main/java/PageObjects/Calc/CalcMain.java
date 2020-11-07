package PageObjects.Calc;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalcMain {

    @FindBy(name = "One")
    public WebElement btn_one;

    @FindBy(name = "Two")
    public WebElement btn_two;

    @FindBy(name = "Three")
    public WebElement btn_three;

    @FindBy(name = "Four")
    public WebElement btn_four;

    @FindBy(name = "Five")
    public WebElement btn_five;

    @FindBy(name = "Six")
    public WebElement btn_six;

    @FindBy(name = "Seven")
    public WebElement btn_seven;

    @FindBy(name = "Eight")
    public WebElement btn_eight;

    @FindBy(name = "Nine")
    public WebElement btn_nine;

    @FindBy(name = "Clear")
    public WebElement btn_clear;

    @FindBy(name = "Equals")
    public WebElement btn_equals;

    @FindBy(name = "Plus")
    public WebElement btn_plus;

    @FindBy(name = "Minus")
    public WebElement btn_minus;

    @FindBy(xpath = "//*[@AutomationId='CalculatorResults']")
    public WebElement txt_result;
}

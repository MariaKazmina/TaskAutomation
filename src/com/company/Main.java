package com.company;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        // write your code here
        String link = "https://msk.tele2.ru/tariff/my-conversation";
        String valuePrice = "200";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");     //чтобы не было всплывающего окна
        WebDriver driver = new ChromeDriver(options);       // Create a new instance of the Chrome driver
        driver.get("https://msk.tele2.ru/");
        driver.manage().window().maximize();    //открытие в полноэкранном режиме
        Thread.sleep(3000);
        WebElement searchElem = driver.findElement(By.className("search"));   //нажимаем на Поиск
        searchElem.click();
        Thread.sleep(3000);
        WebElement inputSearch = driver.findElement(By.id("search-text"));   //нажимаем на поисковую строку
        inputSearch.click();
        inputSearch.sendKeys("Мой");             //вводим текст
        Thread.sleep(3000);
        //ищем нужный тариф
        WebElement mineElem = driver.findElement(By.xpath("//*[@class='global-results']//*[@class='result-line line0']//*[@class='result-content violet-style']//*[@class='recently-tariffs']/div[3]"));
        //*[@class='']//h5//span[text()='Тариф"Мой разговор"']

        mineElem.click();
        Thread.sleep(3000);
        //возвращаем цену
        WebElement rValue = driver.findElement(By.xpath("//*[@class='price-wrap ']/span[@class='price']"));
        String rValuePrice = rValue.getText();
        // System.out.println(valueE);
        //возвращаем ссылку на текущую страницу
        String mineTalk = driver.getCurrentUrl();
        //  System.out.println(mineTalk);
        if (link.equals(mineTalk)) {                 //если результаты равны
            System.out.println("Return result: " + mineTalk + "  Expected result: " + link);
        }

        if(valuePrice.equals(rValuePrice)){
            System.out.println("Return result: " + rValuePrice + "  Expected result: " + valuePrice);
        }

        System.out.println("Successfully opened the website");
        driver.quit();
        //Thread.sleep(5000);  //

    }
}

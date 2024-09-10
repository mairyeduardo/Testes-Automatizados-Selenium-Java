package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class ElementosPessoaFisicaPage {

    static WebDriver driver;

    public ElementosPessoaFisicaPage(WebDriver driver) {
        this.driver = driver;
    }

    public void preencherCampoDataNascimento(String date) {
        WebElement dataNascimento = driver.findElement(By.id("date"));
        dataNascimento.sendKeys(date);
    }

    public void preencherCampoCpf(String cpf){
        WebElement CPF = driver.findElement(By.id("document"));
        CPF.sendKeys(cpf);
    }

    public void verificarSeMensagemDeErroCPFEstaVisivel(){
        WebElement mensagemErro = driver.findElement(By.xpath("//span[contains(text(), \"CPF inválido\")]"));
        mensagemErro.getText();
        mensagemErro.isDisplayed();
    }



}

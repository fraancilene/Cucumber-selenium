package br.com.fcsilva.steps;

import io.cucumber.java.pt.*;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InserirContasSteps {

    private WebDriver driver = new ChromeDriver();

    @Dado("que estou acessando a aplicação")
    public void queEstouAcessandoAAplicação() {
        driver.get("https://seubarriga.wcaquino.me/login");

    }
    @Quando("informo o usuário {string}")
    public void informoOUsuário(String string) {
        driver.findElement(By.id("email")).sendKeys("fran@silva");

    }

    @Quando("a senha {string}")
    public void aSenha(String string) {
        driver.findElement(By.id("senha")).sendKeys("123456");
    }


    @Quando("seleciono entrar")
    public void selecionoEntrar() {
        driver.findElement(By.className("btn")).click();

    }
    @Então("visualizo a página inicial")
    public void visualizoAPáginaInicial() {

        WebElement texto = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        Assert.assertEquals("Bem vindo, Fran!", texto.getText());

    }
    @Quando("seleciono contas")
    public void selecionoContas() {
        driver.findElement(By.linkText("Contas")).click();


    }
    @Quando("seleciono adicionar")
    public void selecionoAdicionar() {
        driver.findElement(By.linkText("Adicionar")).click();


    }
    @Quando("informo a Conta {string}")
    public void informoAConta(String conta) {
        driver.findElement(By.id("nome")).sendKeys(conta);

    }
    @Quando("seleciono salvar")
    public void selecionoSalvar() {
        driver.findElement(By.className("btn")).click();

    }
    @Então("a conta é inserida")
    public void aContaÉInserida() {
        WebElement texto = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        Assert.assertEquals("Conta adicionada com sucesso!", texto.getText());

    }


}

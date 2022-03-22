package br.com.fcsilva.steps;

import io.cucumber.java.After;
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
    @Quando("informo a conta {string}")
    public void informoAConta(String string) {
        driver.findElement(By.id("nome")).sendKeys(string);

    }
//    @Quando("informo a conta Conta de Teste")
//    public void informoAContaContaDeTeste() {
//        driver.findElement(By.id("nome")).sendKeys("Conta de Teste");
//    }


    @Quando("seleciono salvar")
    public void selecionoSalvar() {
        driver.findElement(By.className("btn")).click();

    }
    @Então("a conta é inserida")
    public void aContaÉInserida() {
        WebElement texto = driver.findElement(By.xpath("//div[@class='alert alert-success']"));
        Assert.assertEquals("Conta adicionada com sucesso!", texto.getText());

    }

    @Então("vou notificar que o nome da conta é obrigatório")
    public void souNotificarQueONomeDaContaÉObrigatório() {
        WebElement texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']"));
        Assert.assertEquals("Informe o nome da conta", texto.getText());
    }

    @Então("sou notificado que já existe uma conta com esse nome")
    public void souNotificadoQueJáExisteUmaContaComEsseNome() {
        String texto = driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText();
        Assert.assertEquals("Já existe uma conta com esse nome!", texto);

    }

    @Então("recebo a mensagem {string}")
    public void receboAMensagem(String string) {
        String texto = driver.findElement(By.xpath("//div[starts-with(@class, 'alert alert-' )]")).getText();
        Assert.assertEquals(string, texto);

    }


    // gancho - Hook
    @After
    public void fecharBrowser(){
        driver.quit();
    }



}

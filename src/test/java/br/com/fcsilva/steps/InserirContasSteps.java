package br.com.fcsilva.steps;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.*;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

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

    // tirando screeshots para evidências
    @After(order = 1) // ordem de execução
    public void screenchot(Scenario cenario) throws IOException {
        // tirando screenshot
        File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        // salvando o screenshot
        FileUtils.copyFile(file, new File("target/screenshots/" +cenario.getId()+ ".jpg"));


    }


    // gancho - Hook
    @After (order = 0) // ultimo a ser executado
    public void fecharBrowser(){
        driver.quit();
    }



}

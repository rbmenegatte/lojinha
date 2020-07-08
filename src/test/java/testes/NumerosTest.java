package testes;

import numeros.Numeros;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumerosTest {

    private Numeros numeros;

    @Before
    public void setUp(){
        //**Numeros numeros = new Numeros();
        numeros = new Numeros();
    }

    @Test
        public void testValidarSeUmNumeroEUmaUnidade() {
            //Vou utilizar o método eUmaUnidade passando o valor 9, que trata-se de uma unidade
            //**Numeros numeros = new Numeros();
            boolean eUnidade = numeros.eUmaUnidade(9);

            //vou validar que a resposta é verdadeira
            Assert.assertTrue(eUnidade);
    }

    @Test
    public void testValidarSeUmNumeroNaoEUmaUnidade() {
        //Vou utilizar o método eUmaUnidade passando o valor 10, que não trata-se de uma unidade
        //**Numeros numeros = new Numeros();
        boolean eUnidade = numeros.eUmaUnidade(10);

        //vou validar que a resposta é falsa
        Assert.assertFalse(eUnidade);
    }

}
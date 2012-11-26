/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioCliente;

/**
 * @(#)ValidateMail.java
 * 
 * Adaptado por Antonio Pereira em 03.12.2007. Versão experimental.
 * 
 * Classe com método estático para validar emails.
 */
 
public class ValidateMail {
 
/**
 * Método para verificar a validade de um e-mail. 
 * Verifica nomes de e-mail do tipo: 
 *   "nome@dominio.ext", "nome.apelido@dominio.ext" 
 *   ou "nome.apelido@subdominio.dominio.ext".
 * Implementado com as potencialidades da classe String e através de uma 
 * expressão regular. A expressão regular é dividida em 4 partes:
 * 
 * Parte 1: "^[\\w-]+(\\.[\\w-]+)*" - verifica o "nome.apelido".
 * O acento circunflexo (^) indica o início da String. 
 * A expressão "[\\w-]+" indica a gama de caracteres permitida para o primeiro 
 * carácter do nome do utilizador [a-zA-Z_0-9-] e o símbolo (+) indica que pelo 
 * menos um carácter é obrigatório. 
 * A expressão "(\\.[\\w-]+)*" acrescenta o ponto (.) como carácter possível e o
 * asterisco (*) final indica a possibilidade, mas não obrigatoriedade, de mais
 * caracteres. Não é válido colocar dois pontos seguidos nem o ponto no final.
 * 
 * Parte 2: "@" - O símbolo @ é exactamente o que parece - o símbolo obrigatório
 * de e-mail.
 *  
 * Parte 3: "[A-Za-z0-9]+(\\.[\\w-]+)*" - Esta expressão controla a validação do 
 * "subdominio.dominio" e as regras são as semelhantes às da parte 1. Indica 
 * explicitamente que o primeiro carácter após o símbolo "@" tem de ser letra 
 * ou número.
 * 
 * Parte 4: "(\\.[A-Za-z]{2,6})$" - O carácter "$" indica fim de String e esta 
 * expressão controla a extensão do domínio. Tem um tamanho indicado entre 
 * chavetas. Obriga o campo "ext" a ter apenas letras e um comprimento entre 
 * 2 e 6 caracteres: engloba todas as extensões de domínios válidos conhecidos 
 * mas não os valida.
 *
 * @param email e-mail a validar
 * @return true se o e-mail é válido; false caso contrário
 */
    public static boolean isValidEmailAddress(String email) {
        String regex = "^[\\w-]+(\\.[\\w-]+)*@"
                + "[A-Za-z0-9]+(\\.[\\w-]+)*(\\.[A-Za-z]{2,6})$";
        return email.matches(regex);
    }
 
  
}

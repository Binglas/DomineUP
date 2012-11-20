/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package LogicaNegocioCliente;

/**
 * Trata das seleção de linguagem
 * @author Luciano,João
 */
public class Language {
    public String language;
     Language(String lang ) { this.language = lang; }

    static final private Language INSTANCE = new Language("resources/English_en_GB_EURO");
    static public Language getInstance() { return INSTANCE; }
    
    public void SetLanguagePT(){
        language="resources/Portugues_pt_PT_EURO";
    }

    public void SetLanguageEN(){
        language="resources/English_en_GB_EURO";
        
    }
     public String GetLanguage(){
        return language;
    }

}

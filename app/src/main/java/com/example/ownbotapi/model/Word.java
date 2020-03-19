
package com.example.ownbotapi.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Word {

    @SerializedName("definitions")
    @Expose
    private static List<Definition> definitions = null;
    @SerializedName("word")
    @Expose
    private String word;
    @SerializedName("pronunciation")
    @Expose
    private String pronunciation;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Word() {
    }

    /**
     * 
     * @param pronunciation
     * @param definitions
     * @param word
     */
    public Word(List<Definition> definitions, String word, String pronunciation) {
        super();
        this.definitions = definitions;
        this.word = word;
        this.pronunciation = pronunciation;
    }

    public List<Definition> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definition> definitions) {
        this.definitions = definitions;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

}


package com.example.ownbotapi.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Definition {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("definition")
    @Expose
    private String definition;
    @SerializedName("example")
    @Expose
    private Object example;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("emoji")
    @Expose
    private Object emoji;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Definition() {
    }

    /**
     * 
     * @param emoji
     * @param imageUrl
     * @param definition
     * @param type
     * @param example
     */
    public Definition(String type, String definition, Object example, String imageUrl, Object emoji) {
        super();
        this.type = type;
        this.definition = definition;
        this.example = example;
        this.imageUrl = imageUrl;
        this.emoji = emoji;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public Object getExample() {
        return example;
    }

    public void setExample(Object example) {
        this.example = example;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Object getEmoji() {
        return emoji;
    }

    public void setEmoji(Object emoji) {
        this.emoji = emoji;
    }

}

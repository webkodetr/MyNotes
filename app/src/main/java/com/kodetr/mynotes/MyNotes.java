package com.kodetr.mynotes;

public class MyNotes {
    private String id;
    private String image;
    private String title;
    private String desc;

    public MyNotes(String id, String image, String title, String desc) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.desc = desc;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}

package com.structure;

import java.util.Objects;

public class Letter {
    private String receiver;
    private String title;
    private String text;

    public Letter(String receiver, String title, String text) {
        this.receiver = receiver;
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }


    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        Letter letter = (Letter) object;
        return receiver.equals(letter.receiver) && title.equals(letter.title) && text.equals(letter.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(receiver, title, text);
    }

    @Override
    public String toString() {
        return "Letter{" +
                "receiver='" + receiver + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}

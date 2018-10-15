package com.dung.jsoup;

public class Holoscop {
    private String horoscop;
    private String title;
    private String conten;
    private String avatar;
    private String coverUrl;

    public Holoscop() {
    }

    public Holoscop(String horoscop, String title, String conten, String avatar, String coverUrl) {
        this.horoscop = horoscop;
        this.title = title;
        this.conten = conten;
        this.avatar = avatar;
        this.coverUrl = coverUrl;
    }

    public String getHoroscop() {
        return horoscop;
    }

    public void setHoroscop(String horoscop) {
        this.horoscop = horoscop;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConten() {
        return conten;
    }

    public void setConten(String conten) {
        this.conten = conten;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}

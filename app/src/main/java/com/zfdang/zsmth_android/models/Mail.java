package com.zfdang.zsmth_android.models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zfdang on 2016-3-15.
 */
public class Mail implements Parcelable {
    public String url;
    public String title;
    public String author;
    public String date;
    public boolean isNew;

    public boolean isCategory;
    public String category;

    public Mail(String categoryName) {
        isCategory = true;
        category = categoryName;
    }

    public Mail() {
        isCategory = false;
    }

    @Override
    public String toString() {
        return "Mail{" +
                "author='" + author + '\'' +
                ", url='" + url + '\'' +
                ", title='" + title + '\'' +
                ", date='" + date + '\'' +
                ", isNew=" + isNew +
                ", isCategory=" + isCategory +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.url);
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeString(this.date);
        dest.writeByte(isNew ? (byte) 1 : (byte) 0);
        dest.writeByte(isCategory ? (byte) 1 : (byte) 0);
        dest.writeString(this.category);
    }

    protected Mail(Parcel in) {
        this.url = in.readString();
        this.title = in.readString();
        this.author = in.readString();
        this.date = in.readString();
        this.isNew = in.readByte() != 0;
        this.isCategory = in.readByte() != 0;
        this.category = in.readString();
    }

    public static final Parcelable.Creator<Mail> CREATOR = new Parcelable.Creator<Mail>() {
        @Override
        public Mail createFromParcel(Parcel source) {
            return new Mail(source);
        }

        @Override
        public Mail[] newArray(int size) {
            return new Mail[size];
        }
    };
}
package com.example.bundle;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    private String mBookName;
    private String mAuthor;
    private int mPublishTime;
    private Boolean isBook;

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            //如果元素数据是list类型的时候需要： lits = new ArrayList<?> in.readList(list);
            //否则会出现空指针异常.并且读出和写入的数据类型必须相同.如果不想对部分关键字进行序列化,可以使用transient关键字来修饰以及static修饰.
            Book book = new Book();
            book.mBookName = in.readString();
            book.mAuthor = in.readString();
            book.mPublishTime = in.readInt();

            book.isBook = in.readByte()==1 ? true:false;
            return book;
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getBookName() {
        return mBookName;
    }

    public void setBookName(String mBookName) {
        this.mBookName = mBookName;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String mAuthor) {
        this.mAuthor = mAuthor;
    }

    public int getPublishTime() {
        return mPublishTime;
    }

    public void setPublishTime(int mPublishTime) {
        this.mPublishTime = mPublishTime;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mBookName);
        dest.writeString(mAuthor);
        dest.writeInt(mPublishTime);
        //parelable 不能传输ｂｏｏｌｅａｎ值，改为ｉｎｔ或者其他都可以
        dest.writeByte((byte)(isBook?1:0));

    }
}

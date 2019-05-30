package ru.ivanova.githubclient.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by Irina Ivanova on 22.04.19.
 */
public class Repository implements Parcelable {
    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_BIG = 1;
    public static final int TYPE_FEATURED = 2;

    public long id;
    public String name;
    public String url;
    public int stargazers_count;
    public int forks_count;
    public String full_name;
    public int open_issues_count;
    public int forks;
    public int open_issues;
    public int watchers;
    public String language;
    public Date created_at;
    public Date updated_at;
    public String description;

    public Repository() {
    }

    protected Repository(Parcel in) {
        id = in.readLong();
        name = in.readString();
        url = in.readString();
        stargazers_count = in.readInt();
        forks_count = in.readInt();
        full_name = in.readString();
        open_issues_count = in.readInt();
        forks = in.readInt();
        open_issues = in.readInt();
        watchers = in.readInt();
        language = in.readString();
        description = in.readString();
    }

    public static final Creator<Repository> CREATOR = new Creator<Repository>() {
        @Override
        public Repository createFromParcel(Parcel in) {
            return new Repository(in);
        }

        @Override
        public Repository[] newArray(int size) {
            return new Repository[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(name);
        dest.writeString(url);
        dest.writeInt(stargazers_count);
        dest.writeInt(forks_count);
        dest.writeString(full_name);
        dest.writeInt(open_issues_count);
        dest.writeInt(forks);
        dest.writeInt(open_issues);
        dest.writeInt(watchers);
        dest.writeString(language);
        dest.writeString(description);
    }
}

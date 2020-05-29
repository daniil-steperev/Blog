package com.example.springoblog.domain.util;

import com.example.springoblog.domain.User;

public abstract class MessageHelper {
    public static String getAuthorName(User author) {
        return author != null ? author.getUsername() : "<none>";
    }
}

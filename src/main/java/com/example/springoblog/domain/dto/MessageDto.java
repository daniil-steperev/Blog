package com.example.springoblog.domain.dto;

import com.example.springoblog.domain.Message;
import com.example.springoblog.domain.User;
import com.example.springoblog.domain.util.MessageHelper;

public class MessageDto {
    private Long id;
    private String text;
    private String tag;
    private User author;
    private String filename;
    private Long likes;
    private Boolean meLiked;

    public MessageDto(Message message, Long likes, Boolean meLiked) {
        this.id = message.getId();
        this.text = message.getText();
        this.tag = message.getTag();
        this.author = message.getAuthor();
        this.filename = message.getFilename();
        this.likes = likes;
        this.meLiked = meLiked;
    }

    public String getAuthorName() {
        return MessageHelper.getAuthorName(author);
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public User getAuthor() {
        return author;
    }

    public String getFilename() {
        return filename;
    }

    public Long getLikes() {
        return likes;
    }

    public Boolean getMeLiked() {
        return meLiked;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                ", author=" + author +
                ", likes=" + likes +
                ", meLiked=" + meLiked +
                '}';
    }
}
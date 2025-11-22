package com.Blog_backend.utils;

public class SlugUtil {
    public static String toSlug(String s) {
        if (s == null) return null;
        return s.toLowerCase().replaceAll("[^a-z0-9]+","-").replaceAll("(^-|-$)","");
    }
}
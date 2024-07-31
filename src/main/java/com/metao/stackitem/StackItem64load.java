package com.metao.stackitem;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class StackItem64load {

    static SetStack loadFile (final InputStream in) throws IOException {
        final String rawJson = new String(in.readAllBytes(), StandardCharsets.UTF_8);
        final Gson gson = new Gson();
        return gson.fromJson(rawJson, SetStack.class);
    }
    public static class SetStack {
        public String[] ItemName;
        public Integer[] ItemStack;
    }


}

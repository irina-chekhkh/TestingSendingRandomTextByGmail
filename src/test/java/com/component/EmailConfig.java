package com.component;

import com.ResourcesDataReader;

public class EmailConfig {
    private static final ResourcesDataReader reader = new ResourcesDataReader("email-data");

    public static String getEmail(){
        return reader.getData("email");
    }

    public static String getPassword(){
        return reader.getData("password");
    }

    public static String getReceiverEmail(){
        return reader.getData("receiver");
    }
}

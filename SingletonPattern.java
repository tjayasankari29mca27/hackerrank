import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.lang.reflect.*;


class Singleton{
    // 1. Private static variable to hold the single instance
    private static Singleton instance;
    
    // 2. Public String instance variable
    public String str;

    // 3. Private constructor to prevent instantiation from other classes
    private Singleton() {}

    // 4. Static method to return the single instance
    public static Singleton getSingleInstance() {
        // Lazy initialization: create the instance only when first requested
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}


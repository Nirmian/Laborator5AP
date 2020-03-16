package com.company;

import java.awt.*;
import java.io.*;
import java.net.URI;

public class CatalogUtil {

    public static void save(Catalog catalog) throws IOException {
        try {
            FileOutputStream fos = new FileOutputStream(catalog.getPath());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(catalog);
            fos.close();
        }
        catch(IOException exception) {
            exception.printStackTrace();
        }
    }

    public static Catalog load(String path) throws InvalidCatalogException {
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Catalog catalog = (Catalog) ois.readObject();
            fis.close();
            return catalog;
        }
        catch(IOException | ClassNotFoundException exception) {
            exception.printStackTrace();
        }
        finally {
            return null;
        }
    }

    public static void view(Document doc) {
        try {
            Desktop desktop = Desktop.getDesktop();
            desktop.browse(URI.create(doc.getLocation()));
        }
        catch(IOException | NullPointerException exception) {
            exception.printStackTrace();
        }
    }
}

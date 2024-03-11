package crudPackage;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public abstract class CRUD {//abstract class CRUD
    public abstract void create(File file, Scanner scanner) throws IOException;//create method dalam abstract class

    public abstract void read(File file) throws IOException;//read method dalam abstract class

    public abstract void update(File file, Scanner scanner) throws IOException;//update method dalam abstract class

    public abstract void delete(File file, Scanner scanner) throws IOException;//delete method dalam abstract class
}

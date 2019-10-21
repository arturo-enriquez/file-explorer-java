package CRUD;

import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;

public class Directory {

    private int id;
    private Path path;
    private File file;
    private ArrayList<strFile> list = new ArrayList<strFile>();
    private int nextId;
    
    
    public Directory(Path path) {
        this.path = path;
        this.file = path.toFile();
    }
    
    // Get next ID
    public int getNextId(){
        this.nextId++;
        return nextId;
    }

    public boolean loadFiles() {
        File[] files = this.path.toFile().listFiles();
        nextId = 0;
        for (File file: files) {
            int id = this.getNextId();
            list.add(new strFile(id, file));
        }
        return (files.length < 1) ? false : true;
    }
    
    public int getId() {
        return id;
    }

    public Path getPath() {
        return path;
    }
    public void setPath(Path path) {
        this.path = path;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
    public String getName() {
        return file.getName();
    }
    
    public ArrayList<strFile> getList() {
        return list;
    }
    

    // CRUD
    public int indexId(int id) {
        int i = 0;
        for (strFile x : list) {
            if (x.getId() == id) return i;
            i++;
        }
        return -1;
    }
    
    public boolean exitsId(int id){
        return (indexId(id) != -1);
    }
    
    // Create
    public boolean add(strFile file) {
        if (file == null) return false;
        list.add(file);
        return true;
    }
    // Read
    public strFile findId(int id){
        for (strFile x : list){
            if (x.getId() == id) return x;
        }
        return null;
    }
    // Update
    public boolean update(strFile file) {
        if (!exitsId(nextId)) return false;
        int index = indexId(file.getId());
        list.set(index, file);
        return true;
    }
    // Delete
    public boolean delete(int id) throws IOException {
        if (!exitsId(nextId)) return false;
        int index = indexId(id);
        list.remove(index);
        // delete file
        try {
            Files.deleteIfExists(findId(index).getPath());
        } catch (NoSuchFileException  e) {
            System.out.println("No such file/directory exists"); 
        } catch (DirectoryNotEmptyException  e) {
            System.out.println("Directory is not empty."); 
        } catch(IOException e) { 
            System.out.println("Invalid permissions."); 
        } 
        System.out.println("Deletion successful."); 
        return true;
    }
    
}

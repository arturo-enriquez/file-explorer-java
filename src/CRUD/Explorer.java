package CRUD;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Explorer {

    private Path home = Paths.get(System.getProperty("user.home"));//+"\\pictures"
    private ArrayList<Directory> list = new ArrayList<Directory>();
    
    private int nextId;

    public Explorer(Path home) {
        this.home = home;
    }
    public Explorer() {
    }
    
    // Get next ID
    public int getNextId(){
        this.nextId++;
        return nextId;
    }

    public Path getHome() {
        return home;
    }
    public void setHome(Path home) {
        this.home = home;
    }

    public ArrayList<Directory> getList() {
        return list;
    }
    
    
    public int indexId(int id) {
        int i = 0;
        for (Directory x : list) {
            if (x.getId() == id) return i;
            i++;
        }
        return -1;
    }
    
    public boolean exitsId(int id){
        return (indexId(id) != -1);
    }
    
    // Create
    public boolean add(Directory dir) {
        if (dir == null) return false;
        list.add(dir);
        
        return true;
    }
    // Read
    public Directory findId(int id){
        for (Directory x : list){
            if (x.getId() == id) return x;
        }
        return null;
    }
    // Update
    public boolean update(Directory dir) {
        if (!exitsId(nextId)) return false;
        int index = indexId(dir.getId());
        list.set(index, dir);
        return true;
    }
    // Delete
    public boolean delete(int id) {
        if (!exitsId(nextId)) return false;
        int index = indexId(id);
        list.remove(index);
        return true;
    }

}

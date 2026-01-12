import java.util.List;

public class Folder extends FileSystem{
    private String name = "";
    private int size = 0;
    private List<FileSystem> items = new java.util.ArrayList<FileSystem>();
    public Folder(String name,int size){
        this.name = name;
        this.size = size;
    }
    @Override
    public  void addFile(FileSystem file ){
        items.add(file);
    }

    @Override
    public void ls(int indent){
        getName(indent);
        for(FileSystem item: items){
            item.ls(indent + 2);
        }
    }

    public FileSystem cd(String name,int indent){
        for(FileSystem item: items){
            if(item.getName(0).equals(name)){
                return item;
            }
        }
        return null;
    }
    public void Openall(int indent){

            getName(indent);
            for(FileSystem item: items){
                item.Openall(indent + 2);
            }
    }

    public String getName(int indent){
        for(int i=0;i<indent;i++){
            System.out.print(" ");
        }
        System.out.println("+ "+ this.name );
        return this.name;
    }

    public int getsize(){
        int total = 0;
        for(FileSystem item: items){
            total += item.getsize();
        }
        return total;
    }
}

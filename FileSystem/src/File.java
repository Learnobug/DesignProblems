public class File extends FileSystem {
    private String name = "";
    private int size = 0;
    public File(String name,int size){
        this.name = name;
        this.size = size;
    }
    @Override
    public  void addFile(FileSystem file){
        System.out.println("Not a Directory");
    }


    @Override
    public void ls(int indent){
        getName(indent);
    }

    public FileSystem cd(String name,int indent){
        return null;
    }
    public void Openall(int indent){
         getName(indent);
    }

    public String getName(int indent){
        for(int i=0;i<indent;i++){
            System.out.print(" ");
        }
        System.out.println(this.name);
        return  this.name;
    }

    public int getsize(){
        return this.size;
    }
}

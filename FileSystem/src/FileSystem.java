public abstract class FileSystem {

    public abstract void addFile(FileSystem file);
    public abstract void ls(int indent);
    public abstract FileSystem cd(String name,int indent);
    public abstract void Openall( int indent);
    public abstract String getName(int ident);
    public abstract int getsize();

}

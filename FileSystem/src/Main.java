
//Composite Design Pattern Example: File System
void main() {
    FileSystem root = new Folder("root",0);
    FileSystem home = new Folder("home",0);
    FileSystem user = new Folder("user",0);
    FileSystem file1 = new File("file1.txt",100);
    FileSystem file2 = new File("file2.txt",200);
    FileSystem file4 = new File("file4.txt",400);
    FileSystem docs = new Folder("docs",0);
    home.addFile(file1);
    home.addFile(file2);
    root.addFile(home);
    root.addFile(user);
    docs.addFile(file4);
    user.addFile(docs);
    FileSystem file3 = new File("file3.txt",300);
    root.addFile(file3);


    root.Openall(0);
    System.out.println(root.getsize());
}

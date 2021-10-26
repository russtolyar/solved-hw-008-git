//package hw009;
//
//import org.apache.logging.log4j.core.util.FileUtils;
//
//import java.io.File;
//import java.io.IOException;
//
//public class ReadIO {
////    https://manybooks.net/book/134558/read#epubcfi(/6/4[item5]!/4/52/1:0)
//
//    public static void main(String[] args) {
//        try {
//            //Using FileUtils
//            usingFileUtils();
//        } catch(IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    public static void usingFileUtils() throws IOException {
//        //get the file object
//        File file = FileUtils.getFile("input.txt");
//
//        //get the temp directory
//        File tmpDir = FileUtils.getTempDirectory();
//
//        System.out.println(tmpDir.getName());
//
//        //copy file to temp directory
//        FileUtils.copyFileToDirectory(file, tmpDir);
//
//        //create a new file
//        File newTempFile = FileUtils.getFile(tmpDir, file.getName());
//
//        //get the content
//        String data = FileUtils.readFileToString(newTempFile, Charset.defaultCharset());
//
//        //print the content
//        System.out.println(data);
//    }
//}

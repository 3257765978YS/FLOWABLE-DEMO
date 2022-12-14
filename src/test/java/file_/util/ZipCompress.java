package file_.util;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompress {
    private String zipFileName;      // 目的地Zip文件
    private String sourceFileName;   //源文件（带压缩的文件或文件夹）

    public ZipCompress(String zipFileName, String sourceFileName) {
        this.zipFileName = zipFileName;
        this.sourceFileName = sourceFileName;
    }

    public void zip() throws Exception {
        //File zipFile = new File(zipFileName);
        System.out.println("压缩中...");

        //创建zip输出流
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));

        //创建缓冲输出流
        BufferedOutputStream bos = new BufferedOutputStream(out);

        File sourceFile = new File(sourceFileName);

        //调用函数
        compress(out, bos, sourceFile, sourceFile.getName());

        bos.close();
        out.close();
        System.out.println("压缩完成");

    }

    public void compress(ZipOutputStream out, BufferedOutputStream bos, File sourceFile, String base) throws Exception {
        //如果路径为目录（文件夹）
        if (sourceFile.isDirectory()) {

            //取出文件夹中的文件（或子文件夹）
            File[] flist = sourceFile.listFiles();

            if (flist.length == 0)//如果文件夹为空，则只需在目的地zip文件中写入一个目录进入点
            {
                System.out.println(base + "/");
                out.putNextEntry(new ZipEntry(base + "/"));
            } else//如果文件夹不为空，则递归调用compress，文件夹中的每一个文件（或文件夹）进行压缩
            {
                for (int i = 0; i < flist.length; i++) {
                    compress(out, bos, flist[i], base + "/" + flist[i].getName());
                }
            }
        } else//如果不是目录（文件夹），即为文件，则先写入目录进入点，之后将文件写入zip文件中
        {
            out.putNextEntry(new ZipEntry(base));
            FileInputStream fos = new FileInputStream(sourceFile);
            BufferedInputStream bis = new BufferedInputStream(fos);
            int tag;
            System.out.println(base);
            //将源文件写入到zip文件中
            while ((tag = bis.read()) != -1) {
                out.write(tag);
            }
            bis.close();
            fos.close();

        }
    }
    public static void copy(String srcPath,String destPath){
//         = "E:\\softwares\\demo.png";
//         = "E:\\softwares\\demo2.png";
        byte[] buf = new byte[1024];
        int resData = 0;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(srcPath);
            fileOutputStream = new FileOutputStream(destPath);
            while ((resData = fileInputStream.read(buf))!=-1){
                fileOutputStream.write(buf,0,resData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void deleteFile(File file) {
        //判断文件不为null或文件目录存在
        if (file != null && file.exists()) {
            //获取目录下子文件
            File[] files = file.listFiles();
            //遍历该目录下的文件对象
            for (File f : files) {
                //判断子目录是否存在子目录,如果是文件则删除
                if (f.isDirectory()) {
                    //递归删除目录下的文件
                    deleteFile(f);
                } else {
                    //文件删除
                    f.delete();
                }
            }
            //文件夹删除
            file.delete();
        }
    }


    public static void main(String[] args) {
        String res = "沈芳_综合检测室";
        System.out.println(res.split("\\(")[0]);
    }

}

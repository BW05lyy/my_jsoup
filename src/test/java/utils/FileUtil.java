package utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;

/**
 * @作者:lyy
 * @日期:2019年10月16日
 * @功能:
 * 
 *
 */
public class FileUtil {
//	path 文件路径  content 文件内容  charset 编码格式
	@SuppressWarnings("resource")
	public static void writerFile(String path,String content,String charset) throws IOException, FileNotFoundException{
//		创建写入的文件
		File file = new File(path);
		
//		序列化
//		ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream(file));
//		反序列化
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		
		
//		创建输出流对象（缓冲字符流）
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		bufferedWriter.write(content);
		bufferedWriter.flush();
		bufferedWriter.close();
		
	}
}

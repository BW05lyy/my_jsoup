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
 * @����:lyy
 * @����:2019��10��16��
 * @����:
 * 
 *
 */
public class FileUtil {
//	path �ļ�·��  content �ļ�����  charset �����ʽ
	@SuppressWarnings("resource")
	public static void writerFile(String path,String content,String charset) throws IOException, FileNotFoundException{
//		����д����ļ�
		File file = new File(path);
		
//		���л�
//		ObjectOutputStream oops = new ObjectOutputStream(new FileOutputStream(file));
//		�����л�
//		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
		
		
//		������������󣨻����ַ�����
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
		bufferedWriter.write(content);
		bufferedWriter.flush();
		bufferedWriter.close();
		
	}
}

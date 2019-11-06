package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.regex.Pattern;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import utils.FileUtil;

/**
 * @����:lyy
 * @����:2019��10��16��
 * @����:
 * 
 *
 */
public class TestJsoup {

	@Test
	public void test() throws IOException {
//		��¼������
		int count = 0;
		//��ȡ����
		Connection connect = Jsoup.connect("http://www.wutuxs.com/html/2/2165/");
//		��ȡ�ĵ�����(ͨ�����ӻ�ȡ��Ŀ����ҳ�Ķ���)
		Document document = connect.get();
//		��ȡ��ǰ��ҳ�ĳ�����
		Elements select = document.select("a[href]");
		
//		����Ԫ�ض���(Ԫ�ض��ǳ����ӵ�ַ)
		for (Element href : select) {
//			�����ӵ�url��ַ
			String url = href.attr("href");
			
//			�ƶ����ʽ(�����ӵ�ַ�Ĺ���)
			String regex = "/html/2/2165/.*html$";
			
//			����Ҫ��
			if(url != null && Pattern.matches(regex, url)){
//				�����ӵ��ı�����(���µı���)
				String title = href.text();
//				������µĵ�ַ�ͱ���
				System.out.println(url+"--------"+title);
				count++;
				
//				�ٴλ�ȡ���µ��ĵ�����(ĳЩ��վ�����±�����Ҫ����)
				Document article = Jsoup.connect("http://www.wutuxs.com"+url).get();
//				ͨ��id��ȡ����
				Element elementById = article.getElementById("contents");
//				�жϻ�ȡ�������Ƿ�Ϊ��
				if(elementById != null){
//					��ȡ���ı�����(ȥ����ǩ)
					String content = elementById.text();
					
//					ȥ�������е��������
					title = title.replace("?", "").replace(":", "").replace("\"", "");
					
//					д�뵽�ļ���
					FileUtil.writerFile("D:\\1705DJsoup\\"+title+".txt", content, "utf-8");
				}
//				���û�ȡ����
				if(count == 50){
					break;
				}
			}
		}
		System.out.println("��ȡ�ˣ�"+count+"ƪ����");
		
	}

}

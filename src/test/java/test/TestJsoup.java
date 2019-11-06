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
 * @作者:lyy
 * @日期:2019年10月16日
 * @功能:
 * 
 *
 */
public class TestJsoup {

	@Test
	public void test() throws IOException {
//		记录文章数
		int count = 0;
		//获取连接
		Connection connect = Jsoup.connect("http://www.wutuxs.com/html/2/2165/");
//		获取文档对象(通过链接获取了目标网页的对象)
		Document document = connect.get();
//		获取当前网页的超链接
		Elements select = document.select("a[href]");
		
//		遍历元素对象(元素都是超链接地址)
		for (Element href : select) {
//			超链接的url地址
			String url = href.attr("href");
			
//			制定表达式(超链接地址的规则)
			String regex = "/html/2/2165/.*html$";
			
//			特殊要求
			if(url != null && Pattern.matches(regex, url)){
//				超连接的文本内容(文章的标题)
				String title = href.text();
//				输出文章的地址和标题
				System.out.println(url+"--------"+title);
				count++;
				
//				再次获取文章的文档对象(某些网站的文章标题需要处理)
				Document article = Jsoup.connect("http://www.wutuxs.com"+url).get();
//				通过id获取文章
				Element elementById = article.getElementById("contents");
//				判断获取的文章是否为空
				if(elementById != null){
//					获取纯文本内容(去掉标签)
					String content = elementById.text();
					
//					去掉标题中的特殊符号
					title = title.replace("?", "").replace(":", "").replace("\"", "");
					
//					写入到文件中
					FileUtil.writerFile("D:\\1705DJsoup\\"+title+".txt", content, "utf-8");
				}
//				设置获取数量
				if(count == 50){
					break;
				}
			}
		}
		System.out.println("获取了："+count+"篇文章");
		
	}

}

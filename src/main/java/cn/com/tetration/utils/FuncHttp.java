package cn.com.tetration.utils;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;


public class FuncHttp {
	private static Logger logger = Logger.getLogger(FuncHttp.class.getName());

	/**
	 * 
	 * @param url
	 *            : 要访问网页的地址，可以带参数。例如：http://www.szairport.com/catalog_342.aspx?
	 *            SearchKey=enter&gs_szm=&AreaCode=&AirNo=
	 * @return
	 * @throws Exception
	 */
	public static String httpGet(String url) throws Exception {
		return httpGet(url, null);
	}

	public static String httpGet(String url, String reencode) throws Exception {
		return httpGet(url, reencode, null);
	}

	public static String httpGet(String url, String reencode, String[] headers)
			throws Exception {
		HttpClient client = new DefaultHttpClient();// 生成一个默认实例。
		HttpGet httpget = new HttpGet(url);
		HttpResponse response = null;
		HttpEntity entity = null;
		String responseString = null;
		try {
			HttpParams params = client.getParams();
			HttpConnectionParams.setConnectionTimeout(params, 30 * 1000);
			HttpConnectionParams.setSoTimeout(params, 60 * 1000);
			httpget.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
			if (headers != null) {
				for (String header : headers) {
					String[] kv = header.split(":", 2);// 若url中含有http:就会出现多次，所以限制为2.
					if (kv.length > 1) {
						httpget.setHeader(kv[0].trim(), kv[1].trim());// 添加一个referer链接。网站是先经过referer自动跳转到url的。
					}
				}
			}
			response = client.execute(httpget);
			entity = response.getEntity();
			if (entity != null) {
				if (reencode != null) {
					responseString = EntityUtils.toString(response.getEntity(),
							reencode);
				} else {
					responseString = EntityUtils.toString(response.getEntity());
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (entity != null) {
				EntityUtils.consume(entity);
			}
			httpget.abort();// 终止访问。
			client.getConnectionManager().shutdown();// 关闭client的连接管理。
			client = null;
		}
		return responseString;
	}

	public static Header[] httpHeaders(String url) throws Exception {
		HttpClient httpclient = new DefaultHttpClient();// 生成一个默认实例。
		HttpResponse response = null;
		HttpGet httpget = null;
		Header[] headers = null;
		try {
			httpclient = new DefaultHttpClient();
			HttpParams params = httpclient.getParams();
			HttpConnectionParams.setConnectionTimeout(params, 30 * 1000);
			HttpConnectionParams.setSoTimeout(params, 60 * 1000);
			httpget = new HttpGet(url);
			httpget.setHeader("User-Agent",
					"Mozilla/5.0 (Windows NT 6.1; rv:6.0.2) Gecko/20100101 Firefox/6.0.2");
			response = httpclient.execute(httpget);
			headers = response.getAllHeaders();

		} catch (Exception e1) {
			throw e1;
		} finally {
			httpget.abort();// 终止访问。
			httpclient.getConnectionManager().shutdown();// 关闭client的连接管理。
			httpclient = null;
		}
		return headers;
	}

	public static String httpPost(String url, HashMap<String, String> data,
			String[] headers)throws Exception  {
		return httpPost(url, data, headers, null);
	}

	public static String httpPost(String url, HashMap<String, String> data,
			String[] headers, String reencode) throws Exception {
		DefaultHttpClient httpclient = new DefaultHttpClient(); // 实例化一个HttpClient
		HttpResponse response = null;
		HttpEntity entity = null;
		String responseString = null;
		HttpPost httpost = null;
		try {
			HttpParams params = httpclient.getParams();
			HttpConnectionParams.setConnectionTimeout(params, 30 * 1000);
			HttpConnectionParams.setSoTimeout(params, 60 * 1000);

			httpost = new HttpPost(url); // 引号中的参数是：servlet的地址 ，既域名+路径
											// http://www.szairport.com/catalog_342.aspx
			if (headers != null && headers.length > 0) {// 若不为空则添加。new
														// String[]{}不为空
				for (String header : headers) {
					String[] kv = header.split(":", 2);// 若url中含有http:就会出现多次，所以限制为2.
					if (kv.length > 1) {
						httpost.addHeader(kv[0].trim(), kv[1].trim());// 添加一个referer链接。网站是先经过referer自动跳转到url的。
					}
				}
			}
			List<NameValuePair> formparams = new ArrayList<NameValuePair>();
			if (data != null) {
				for (String key : data.keySet()) {
					formparams.add(new BasicNameValuePair(key, data.get(key)));
				}
			}
			httpost.setEntity(new UrlEncodedFormEntity(formparams, HTTP.UTF_8));
			response = httpclient.execute(httpost); // 执行
			entity = response.getEntity(); // 返回服务器响应
			if (entity != null) {
				if (reencode != null) {
					responseString = EntityUtils.toString(response.getEntity(),
							reencode);
				} else {
					responseString = EntityUtils.toString(response.getEntity());
				}
			}
		}  catch (Exception e1) {
			throw e1;
		} finally {
			if (entity != null) {
				try {
					EntityUtils.consume(entity);
					entity = null;
				} catch (IOException e) {
					logger.error(e);
				}
			}
			httpost.abort();
			httpost = null;
			httpclient.getConnectionManager().shutdown();
			httpclient = null;
		}
		return responseString;
	}

	/**
	 * html实体转换 将html实体编码格式转换为中文 例：&#22823;&#36830; -> 大连
	 * 
	 * @param dataStr
	 * @return
	 */
	public static String decodeHtmlEntity(String dataStr) {
		if (dataStr.indexOf("&#") != -1) {
			int start = 0;
			int end = 0;
			final StringBuffer buffer = new StringBuffer();
			while (start > -1) {
				int system = 10;// 进制
				if (start == 0) {
					int t = dataStr.indexOf("&#");
					if (start != t)
						start = t;
				}
				end = dataStr.indexOf(";", start + 2);
				String charStr = "";
				if (end != -1) {
					charStr = dataStr.substring(start + 2, end);
					// 判断进制
					char s = charStr.charAt(0);
					if (s == 'x' || s == 'X') {
						system = 16;
						charStr = charStr.substring(1);
					}
				}
				// 转换
				try {
					char letter = (char) Integer.parseInt(charStr, system);
					buffer.append(new Character(letter).toString());
				} catch (NumberFormatException e) {
					e.printStackTrace();
				}
				// 处理当前unicode字符到下一个unicode字符之间的非unicode字符
				start = dataStr.indexOf("&#", end);
				if (start - end > 1) {
					buffer.append(dataStr.substring(end + 1, start));
				}
				// 处理最后面的非unicode字符
				if (start == -1) {
					int length = dataStr.length();
					if (end + 1 != length) {
						buffer.append(dataStr.substring(end + 1, length));
					}
				}
			}
			return buffer.toString();
		} else {
			return dataStr;
		}
	}

	/**
	 * 根据url下载文件
	 * 
	 * @param ourputFile
	 * @param url
	 * @throws Exception
	 */
	public static boolean downloadByUrl(String ourputFile, String url) throws Exception {
		try {
			URL resourceUrl = new URL(url);
			HttpURLConnection con = (HttpURLConnection) resourceUrl
					.openConnection();
			con.setConnectTimeout(30000);  
			con.setReadTimeout(30000);  
			DataInputStream reader = new DataInputStream(con.getInputStream());

			File f = new File(ourputFile);
			if (!f.getParentFile().exists()) {
				f.getParentFile().mkdirs();
			}
			DataOutputStream writer = new DataOutputStream(
					new FileOutputStream(f));
			int ks = 0;
			while ((ks = reader.read()) != -1) {
				writer.write(ks);
			}
			reader.close();
			writer.close();
			con.disconnect();
			return true;
		} catch (Exception e) {
			throw e;
		}
	}
	/**
	 * 请求类参数值拼接字url符串形式
	 * @param o
	 * @return
	 * @throws Exception
	 */
	public static String entityToUrlparam(Object o ) throws Exception{
		StringBuilder sb = new StringBuilder();
		ArrayList<Field> list = FuncStatic.findClassAllField(o.getClass());
		for(Field f : list){
			f.setAccessible(true);
			if(f.get(o) != null){
				sb.append(f.getName()+"="+f.get(o).toString()+"&");
			}
		}
		return sb.toString();
	}
	/**
	 * 请求类参数值拼接成HashMap
	 * @param o
	 * @return
	 * @throws Exception
	 */
	public static HashMap<String, String> entityToUrlMap(Object o ) throws Exception{
		HashMap<String, String> map = new HashMap<String, String>();
		ArrayList<Field> list = FuncStatic.findClassAllField(o.getClass());
		for(Field f : list){
			f.setAccessible(true);
			if(f.get(o) != null){
				map.put(f.getName(), f.get(o).toString());
			}
		}
		return map;
	}
	public static void main(String[] args) throws Exception {
		downloadByUrl("C:\\Users\\tao\\Desktop\\a.swf","http://www.iknei.test/data/uploads/dzsbpc/2015/0629/16/a58d923a-dd68-4f71-b429-27a39a8aa635/0ab9390fef3f49e6b7f58fefda6aab7e.swf");
	}
}

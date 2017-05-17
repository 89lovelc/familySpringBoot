/**
 * APITest.java
 * Created on: 2016年5月27日
 * Author: shangtao
 */
package com.hjh.cn.tools;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class HttpClientUtils {

	private static int SocketTimeout = 8000;// 8秒
	private static int ConnectTimeout = 8000;// 8秒

	private static Logger LOG = LoggerFactory.getLogger(HttpClientUtils.class);

	private static List<NameValuePair> buildParams(Map<String, String> params) {
		// 添加参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (params != null && params.keySet().size() > 0) {
			Iterator<Map.Entry<String, String>> iterator = params.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();
				nvps.add(new BasicNameValuePair((String) entry.getKey(), (String) entry.getValue()));
			}
		}
		return nvps;
	}

	private static void buildHeaders(HttpRequestBase request, Map<String, String> headers) {

		if (headers != null && headers.keySet().size() > 0) {
			Iterator<Map.Entry<String, String>> iterator = headers.entrySet().iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, String> entry = (Map.Entry<String, String>) iterator.next();

				request.setHeader(entry.getKey(), entry.getValue());
			}
		}
	}

	private static CloseableHttpClient getHttpClient() {
		RegistryBuilder<ConnectionSocketFactory> registryBuilder = RegistryBuilder.<ConnectionSocketFactory> create();
		ConnectionSocketFactory plainSF = new PlainConnectionSocketFactory();
		registryBuilder.register("http", plainSF);
		// 指定信任密钥存储对象和连接套接字工厂
		try {
			KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
			// 信任任何链接
			TrustStrategy anyTrustStrategy = new TrustStrategy() {
				public boolean isTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
					return true;
				}
			};
			@SuppressWarnings("deprecation")
			SSLContext sslContext = SSLContexts.custom().useTLS().loadTrustMaterial(trustStore, anyTrustStrategy)
					.build();
			@SuppressWarnings("deprecation")
			LayeredConnectionSocketFactory sslSF = new SSLConnectionSocketFactory(sslContext,
					SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			registryBuilder.register("https", sslSF);
		} catch (KeyStoreException e) {
			throw new RuntimeException(e);
		} catch (KeyManagementException e) {
			throw new RuntimeException(e);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
		Registry<ConnectionSocketFactory> registry = registryBuilder.build();
		// 设置连接管理器
		PoolingHttpClientConnectionManager connManager = new PoolingHttpClientConnectionManager(registry);
		// 构建客户端
		return HttpClientBuilder.create().setConnectionManager(connManager).build();
	}


	/**
	 * 传输json 格式
	 * @param url
	 * @param jsonString
	 * @param headers
	 * @return
	 */
	public static String postJson(String url,String jsonString,Map<String,String> headers) {
		String result = null;
		CloseableHttpClient httpClient = getHttpClient();
		HttpPost httpPost = new HttpPost(url);
		httpPost.setHeader(ACCEPT_LANGUAGE_KEY, ACCEPT_LANGUAGE_VALUE);
		httpPost.setHeader(ACCEPT_KEY, ACCEPT_VALUE);
		httpPost.setHeader(USER_AGENT_KEY, USER_AGENT_VALUE);
		httpPost.setHeader("Content-type","application/json; charset=utf-8");
		CloseableHttpResponse response = null;
		RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SocketTimeout)
				.setConnectTimeout(ConnectTimeout).build();// 设置请求和传输超时时间
		httpPost.setConfig(requestConfig);
		StringEntity stringEntity = null;
		stringEntity = new StringEntity(jsonString.toString(), Charset.forName("UTF-8"));
		httpPost.setEntity(stringEntity);
		try {
			response = httpClient.execute(httpPost);
			int status = response.getStatusLine().getStatusCode();
			if (status == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				 result = EntityUtils.toString(entity);
				EntityUtils.consume(entity);
			} else {
				throw new Exception("http error code:" + status);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public static String get(String url, Map<String, String> params, Map<String, String> headers,CallBackListener callBackListener) throws Exception {
		String result = "";
		// CloseableHttpClient httpClient=HttpClients.createDefault();
		// 支持https
		CloseableHttpClient httpClient = getHttpClient();
		if (!url.contains("?") && null != params && params.size() > 0) {
			url = url + "?";
		}
		if (url.contains("&") && !url.endsWith("&")) {
			url = url + "&";
		}
		String address = url + URLEncodedUtils.format(buildParams(params), "UTF-8");
		LOG.info("-------------------------http url: {}", address);
		HttpGet httpGet = new HttpGet(address);
		CloseableHttpResponse response = null;
		try {
			RequestConfig requestConfig = RequestConfig.custom().setSocketTimeout(SocketTimeout)
					.setConnectTimeout(ConnectTimeout).build();// 设置请求和传输超时时间
			httpGet.setConfig(requestConfig);
			buildHeaders(httpGet, headers);
			// 请求数据
			response = httpClient.execute(httpGet);
			int status = response.getStatusLine().getStatusCode();
			if (status == HttpStatus.SC_OK) {
				HttpEntity entity = response.getEntity();
				Header[] heads = response.getAllHeaders();
				boolean isStream = false;
				for (Header head : heads) {
					if(head.getName().equals("Content-Type")){
						if(head.getValue().contains("application/octet-stream")){
							callBackListener.handleInstream(entity.getContent());
							result = "回调函数进行处理";
							isStream = true;
						}
					}
				}
				if(!isStream){
					result = EntityUtils.toString(entity);
				}
				EntityUtils.consume(entity);
			} else {
				throw new Exception("http error code:" + status);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			result = ex.getMessage();
			throw new Exception(ex.getMessage());
		} finally {
			try {
				httpClient.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
		}
		System.out.println(result);
		return result;
	}



	private static final String USER_AGENT_KEY = "User-Agent";
	private static final String USER_AGENT_VALUE = "Apache-HttpClient/4.1.1";

	private static final String ACCEPT_KEY = "Accept";
	private static final String ACCEPT_VALUE = "*/*";

	private static final String ACCEPT_LANGUAGE_KEY = "Accept-Language";
	private static final String ACCEPT_LANGUAGE_VALUE = "zh-cn";

	public interface CallBackListener{
		void handleInstream(InputStream inputStream);
	}

}

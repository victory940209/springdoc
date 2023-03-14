package com.victory.system;

import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 *
 * @Title : http 통신 Util
 * @Desc : get, post 방식의 통신 시 원하는 객체로 통신하는 util
 * @author: Baek Seung Ri
 *
 */
@Slf4j
@Service
public class HttpUrlConnectUtil {

	@Autowired
	RestTemplate restTemplate;

	/**
	 * @Desc : get 방식의 통신
	 * @Method : httpGetConnection
	 * @param: (url, req 객체, httpHeader(Map 형식), 객체의 클래스)
	 * @Desc :
	 * @return : param으로 받은 객체 그대로
	 */
	public <T, K> K apiGet(String url, T obj, Map<String, Object> header, Class<K> cls) throws Exception {

		HttpHeaders reqheader = setHeader(header);
		HttpEntity<T> entity = new HttpEntity<T>(obj, reqheader);

		ResponseEntity<K> respEntity = restTemplate.getForEntity(url, cls, entity);

		return respEntity.getBody();

	}

	/**
	 * @Desc : get 방식의 통신
	 * @Method : httpGetConnection
	 * @param : (url, req 객체, 객체의 클래스)
	 * @Desc : 헤더값을 안넣을경우(해더값은 null로 들어감)
	 * @return : param으로 받은 객체 그대로
	 */

	public <T, K> K apiGet(String url, T obj, Class<K> cls) throws Exception {
		return apiGet(url, obj, null, cls);
	}

	/**
	 * @Desc : get 방식의 통신
	 * @Method : httpGetConnection
	 * @param : (url, req 객체)
	 * @Desc : 헤더값,객채의 클래스를 안넣을경우(해더값은 null로 들어감, 객체는 디폴트로 Map의 형식으로 가져감)
	 * @return : param으로 받은 객체 그대로
	 */
	@SuppressWarnings("unchecked")
	public <T, K> K apiGet(String url, T obj) throws Exception {
		Map<String, Object> paramobj = (Map<String, Object>) obj;
		return (K) apiGet(url, paramobj, null, Map.class);
	}

	/**
	 * @Desc : get 방식의 통신
	 * @Method : httpGetConnection
	 * @param : (url, req 객체, httpHeader(Map 형식))
	 * @Desc : 객채의 클래스를 안넣을경우 (객체는 디폴트로 Map의 형식으로 가져감)
	 * @return : param으로 받은 객체 그대로
	 */
	@SuppressWarnings("unchecked")
	public <T, K> K apiGet(String url, T obj, Map<String, Object> header) throws Exception {
		Map<String, Object> paramobj = (Map<String, Object>) obj;
		return (K) apiGet(url, paramobj, header, Map.class);

	}

	/**
	 * @Desc : post 방식의 통신 시 원하는 객체로 통신하는 util
	 * @Method : httpPostConnection
	 * @param : (url, req 객체, httpHeader(Map 형식), 객체의 클래스)
	 * @Desc :
	 * @return : param으로 받은 객체 그대로
	 */
	public <T, K> K apiPost(String url, T obj, Map<String, Object> header, Class<K> cls) throws Exception {

		HttpHeaders reqheader = setHeader(header);
		HttpEntity<T> entity = new HttpEntity<T>(obj, reqheader);

		ResponseEntity<K> respEntity = restTemplate.postForEntity(url, entity, cls);

		return respEntity.getBody();

	}

	/**
	 * @Desc : post 방식의 통신
	 * @Method : httpPostConnection
	 * @param : (url, req 객체, 객체의 클래스)
	 * @Desc : 헤더값을 안넣을경우(해더값은 null로 들어감)
	 * @return : param으로 받은 객체 그대로
	 */
	public <T, K> K apiPost(String url, T obj, Class<K> cls) throws Exception {
		return apiPost(url, obj, null, cls);
	}

	/**
	 * @Desc : post 방식의 통신
	 * @Method : httpPosrConnection
	 * @param : (url, req 객체)
	 * @Desc : 헤더값,객채의 클래스를 안넣을경우(해더값은 null로 들어감, 객체는 디폴트로 Map의 형식으로 가져감)
	 * @return : param으로 받은 객체 그대로
	 */
	@SuppressWarnings("unchecked")
	public <T, K> K apiPost(String url, T obj) throws Exception {
		Map<String, Object> paramobj = (Map<String, Object>) obj;
		return (K) apiPost(url, paramobj, null, Map.class);
	}

	/**
	 * @Desc : Post 방식의 통신
	 * @Method : httpPostConnection
	 * @param : (url, req 객체, httpHeader(Map 형식))
	 * @Desc : 객채의 클래스를 안넣을경우 (객체는 디폴트로 Map의 형식으로 가져감)
	 * @return : param으로 받은 객체 그대로
	 */
	@SuppressWarnings("unchecked")
	public <T, K> K apiPost(String url, T obj, Map<String, Object> header) throws Exception {
		Map<String, Object> paramobj = (Map<String, Object>) obj;
		return (K) apiPost(url, paramobj, header, Map.class);

	}

	/**
	 * @Desc : header 값 세팅
	 * @Method : setHeader
	 * @param : (httpHeader(Map 형식))
	 * @Desc : param으로 들어온 Map을 전부 HttpHeaders 객체에 넣어 반환
	 * @return : HttpHeaders
	 */
	public HttpHeaders setHeader(Map<String, Object> headers) throws Exception {

		HttpHeaders header = new HttpHeaders();

		for (Entry<String, Object> elem : headers.entrySet()) {
			if (!"".equals(elem.getValue()) && elem.getValue() != null) {
				header.set(elem.getKey().toString(), elem.getValue().toString());
			}
		}
		return header;
	}

}
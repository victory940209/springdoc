package com.victory.biz.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.victory.model.ResultVo;
import com.victory.model.TestVo;
import com.victory.system.HttpUrlConnectUtil;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/path1")
public class TestController {

	@Autowired
	HttpUrlConnectUtil apiCon;

	@Tag(name = "tag1", description = "tag1 입니다.")
	@GetMapping("/test/{name}")
	@Operation(method = "test method", summary = "test summary ", description = "test description")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "조회 성공", content = @Content(schema = @Schema(implementation = ResultVo.class))),
	        @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content(schema = @Schema(implementation = ResultVo.class)))
	    })
	public Map<String, Object> test(
			@RequestParam @Parameter(name = "parm Map", in = ParameterIn.QUERY, description = "param Map description") Map<String, Object> param,
			@Parameter(name = "name", in = ParameterIn.PATH, description = "param description") @PathVariable("name") String name)
			throws Exception {

		log.info("param : " + param);
		log.info("paramNm : " + name);
		return Map.of("key1", "value1", "key2", "value2");

	}

	@Tag(name = "tag1", description = "tag1 입니다.")
	@PostMapping(value = "/testResultPost")
	public Map<String, Object> testResultVoPost(@RequestBody Map<String, Object> param) throws Exception {

		String url = param.get("url").toString();
		String port = param.get("port").toString();
		String resulturl = "http://127.0.0.1:" + port + "/" + url;

		ResponseEntity<Map> respEntity = apiCon.apiGet(resulturl, Map.class);

		log.info("result : {}", respEntity.getBody());

		return Map.of("key12345", "value12345", "key2", "value2");
	}

	@Tag(name = "tag2", description = "tag2 입니다.")
	@PostMapping(value = "/testVo")
	public TestVo testVo(@RequestBody ResultVo param) throws Exception {

		log.debug("param : {}", param);

		TestVo tv = TestVo.builder().test("returnVal").test2("returnVal2").test3("returnVal3").test4(1).build();

		log.debug("return vo : {}", tv);

		return tv;

	}

	@Tag(name = "tag2", description = "tag2 입니다.")
	@GetMapping(value = "/testResultVoGet")
	public ResultVo testResultVoGet(@RequestParam Map<String, Object> param) throws Exception {

		log.debug("param : {}", param);

		ResultVo tv = ResultVo.builder().result("resultasd0").resultMsg("resultMsggasdasd").build();

		log.debug("return vo : {}", tv);

		return tv;

	}

	@PostMapping(value = "/apiConPost")
	public TestVo apiConPost(@RequestBody Map<String, Object> param, @RequestHeader Map<String, Object> requestHeader)
			throws Exception {

		String url = param.get("url").toString();
		String port = param.get("port").toString();
		String resulturl = "http://127.0.0.1:" + port + "/" + url;

		TestVo forObject = new TestVo();
		try {

			forObject = apiCon.apiPost(resulturl, param, requestHeader, TestVo.class);
			log.info("###end-point`s return value : {}", forObject);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forObject;
	}

	@PostMapping(value = "/apiConPostVo")
	public ResultVo apiConPostVo(@RequestBody TestVo param, @RequestHeader Map<String, Object> requestHeader)
			throws Exception {

		String resulturl = "http://127.0.0.1:" + "20030" + "/" + "testVo";

		ResultVo forObject = new ResultVo();
		try {

			forObject = apiCon.apiPost(resulturl, param, requestHeader, ResultVo.class);
			log.info("###end-point`s return value : {}", forObject);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forObject;
	}

	@PostMapping(value = "/apiConGet")
	public TestVo apiConGet(@RequestBody Map<String, Object> param, @RequestHeader Map<String, Object> requestHeader)
			throws Exception {

		String url = param.get("url").toString();
		String port = param.get("port").toString();
		String resulturl = "http://127.0.0.1:" + port + "/" + url;

		TestVo forObject = new TestVo();
		try {

			forObject = apiCon.apiGet(resulturl, param, requestHeader, TestVo.class);
			log.info("###end-point`s return value : {}", forObject);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forObject;
	}

	@PostMapping(value = "/apiConGetVo")
	public TestVo apiConGetVo(@RequestBody TestVo param, @RequestHeader Map<String, Object> requestHeader)
			throws Exception {

		String resulturl = "http://127.0.0.1:" + param.getTest() + "/" + param.getTest2();

		TestVo forObject = new TestVo();
		try {

			forObject = apiCon.apiGet(resulturl, param, requestHeader, TestVo.class);
			log.info("###end-point`s return value : {}", forObject);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return forObject;
	}
}

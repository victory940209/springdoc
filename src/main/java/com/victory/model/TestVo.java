package com.victory.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TestVo {

	@Schema(example = "testValue")
	@JsonProperty("test")
	private String test;

	@Schema(example = "testValue2")
	@JsonProperty("test2")
	private String test2;

	@Schema(example = "testValue3")
	@JsonProperty("test3")
	private String test3;

	@Schema(example = "1")
	@JsonProperty("test4")
	private int test4;

}

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
public class ResultVo {

	@Schema(example = "testValue")
	@JsonProperty("test")
	private String resultMsg;

	@Schema(example = "testValue2")
	@JsonProperty("test2")
	private String result;

}

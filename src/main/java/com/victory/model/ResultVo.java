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

	@Schema(name = "resultMsg", title = "testTitle", type = "String", example= "example text", nullable= true, defaultValue= "test", allowableValues = {"test","string"}, maxLength= 0, minLength = 10)
	@JsonProperty("resultMsg")
	private String resultMsg;

	@Schema(example = "result")
	@JsonProperty("result")
	private String result;

}

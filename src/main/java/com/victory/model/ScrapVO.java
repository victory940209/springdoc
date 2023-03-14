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
public class ScrapVO{
	
	@Schema(example = "https://tplugin.allcredit.co.kr:3443/jams/F009501A01/sc0309807456?EPARAM=TEST2021070915155056412")
	@JsonProperty("url")
	private String url;
}

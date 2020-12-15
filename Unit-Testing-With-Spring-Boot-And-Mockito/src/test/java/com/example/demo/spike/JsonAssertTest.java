package com.example.demo.spike;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class JsonAssertTest {

	String actualResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10.0,\"quantity\":100}";

	@Test
	public void jsonAssertStrictFalse() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\"}";
		JSONAssert.assertEquals(expectedResponse, this.actualResponse, false);
	}

	@Test
	public void jsonAssertStrictTrue() throws JSONException {
		String expectedResponse = "{\"id\":1,\"name\":\"Ball\",\"price\":10.0,\"quantity\":100}";
		JSONAssert.assertEquals(expectedResponse, this.actualResponse, true);
	}

	@Test
	public void jsonAssertStrictWithoutEscapeCharacters() throws JSONException {
		String expectedResponse = "{id:1, name:Ball}";
		JSONAssert.assertEquals(expectedResponse, this.actualResponse, false);
	}
}

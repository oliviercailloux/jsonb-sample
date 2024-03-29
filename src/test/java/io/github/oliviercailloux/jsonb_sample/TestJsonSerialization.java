package io.github.oliviercailloux.jsonb_sample;

import static org.junit.jupiter.api.Assertions.assertEquals;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestJsonSerialization {

	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(TestJsonSerialization.class);

	@Test
	public void testJson() throws Exception {
		final PdfBookmark bookmark = new PdfBookmark("Bookmark title", 12);
		try (Jsonb jsonb = JsonbBuilder.create()) {
			final String json = jsonb.toJson(bookmark);
			LOGGER.info("Serialized json: {}.", json);
			assertEquals("{\"title\":\"Bookmark title\",\"physicalPageNumber\":12}", json);
		}
	}

	@Test
	public void testPrettyJson() throws Exception {
		final PdfBookmark bookmark = new PdfBookmark("Bookmark title", 12);
		try (Jsonb jsonb = JsonbBuilder.create(new JsonbConfig().withFormatting(true))) {
			final String json = jsonb.toJson(bookmark);
			LOGGER.info("Serialized pretty json: {}.", json);
			assertEquals("{\n    \"title\": \"Bookmark title\",\n    \"physicalPageNumber\": 12\n}", json);
		}
	}
}

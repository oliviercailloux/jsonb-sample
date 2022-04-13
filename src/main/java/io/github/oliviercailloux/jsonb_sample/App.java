package io.github.oliviercailloux.jsonb_sample;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.json.bind.JsonbConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		new App().proceed();
	}

	public void proceed() throws Exception {
		final PdfBookmark bookmark = new PdfBookmark("Bookmark title", 12);
		try (Jsonb jsonb = JsonbBuilder.create(new JsonbConfig().withFormatting(true))) {
			final String json = jsonb.toJson(bookmark);
			LOGGER.info("Json: {}", json);
		}

	}
}

//
// Copyright 2009 Robin Komiwes, Bruno Verachten, Christophe Cordenier
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// 	http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//

package com.spreadthesource.tapestry.ganalytics.services;

import org.apache.tapestry5.MarkupWriter;
import org.apache.tapestry5.dom.Document;
import org.apache.tapestry5.dom.Element;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.ioc.internal.util.MessagesImpl;
import org.apache.tapestry5.services.MarkupRenderer;
import org.apache.tapestry5.services.MarkupRendererFilter;

import com.spreadthesource.tapestry.ganalytics.GAnalyticsConstants;
import com.spreadthesource.tapestry.ganalytics.GAnalyticsScriptsMessages;
import com.spreadthesource.tapestry.ganalytics.services.GAnalyticsScriptsInjector;

public class GAnalyticsScriptsInjector implements MarkupRendererFilter {

	private final static Messages SCRIPTS = MessagesImpl.forClass(GAnalyticsScriptsMessages.class);

	private final String key;

	public GAnalyticsScriptsInjector(@Inject @Symbol(GAnalyticsConstants.GANALYTICS_KEY) String key) {
		this.key = key;
	}

	private void addScript(Document document) {
		if (key != null && !key.trim().equals("")) {
			Element root = document.getRootElement();

			if (root == null)
				return;

			Element body = root.find("body");

			if (body == null) {
				body = root.element("body");
			}

			Element e = body.element("script", "type", "text/javascript");

			e.raw(SCRIPTS.get("scriptOne"));

			e = body.element("script", "type", "text/javascript");

			e.raw(SCRIPTS.format("scriptTwo", key));

		}
	}

	public void renderMarkup(MarkupWriter writer, MarkupRenderer renderer) {
		renderer.renderMarkup(writer);

		this.addScript(writer.getDocument());
	}

}

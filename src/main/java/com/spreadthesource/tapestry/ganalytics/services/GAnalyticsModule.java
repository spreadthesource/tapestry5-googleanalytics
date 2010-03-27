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

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.MarkupRendererFilter;

import com.spreadthesource.tapestry.ganalytics.GAnalyticsConstants;

public class GAnalyticsModule {

	public static void contributeFactoryDefaults(MappedConfiguration<String, String> configuration) {
		configuration.add(GAnalyticsConstants.GANALYTICS_KEY, "");
	}

	public void contributeMarkupRenderer(OrderedConfiguration<MarkupRendererFilter> configuration,
			@Symbol(SymbolConstants.PRODUCTION_MODE) final boolean productionMode) {

		if (productionMode) {
			configuration.addInstance("GAnalyticsScript", GAnalyticsScriptsInjector.class, "after:RenderSupport");
		}

	}
}

package com.spreadthesource.tapestry.ganalytics.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;
import org.apache.tapestry5.ioc.OrderedConfiguration;
import org.apache.tapestry5.ioc.ServiceBinder;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.ioc.annotations.Symbol;
import org.apache.tapestry5.services.ClientInfrastructure;
import org.apache.tapestry5.services.Environment;
import org.apache.tapestry5.services.MarkupRendererFilter;

import com.spreadthesource.tapestry.ganalytics.GAnalyticsConstants;

public class GAnalyticsModule {
	public static void bind(ServiceBinder binder) {
		binder.bind(GAnalyticsScriptsInjector.class, GAnalyticsScriptsInjector.class);
	}

	public static void contributeFactoryDefaults(MappedConfiguration<String, String> configuration) {
		configuration.add(GAnalyticsConstants.GANALYTICS_KEY, "");
	}

	public void contributeMarkupRenderer(OrderedConfiguration<MarkupRendererFilter> configuration, @Inject final GAnalyticsScriptsInjector scriptInjector,
			@Symbol(SymbolConstants.PRODUCTION_MODE) final boolean productionMode, @Inject final Environment environment,
			final ClientInfrastructure clientInfrastructure) {

		if (productionMode) {
			configuration.addInstance("GAnalyticsScript", GAnalyticsScriptsInjector.class, "after:RenderSupport");
		}

	}
}

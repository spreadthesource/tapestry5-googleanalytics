# Tapestry 5 Google Analytics Plugin

## How to

To use this plugin, just drop the generated JAR into your application classpath.
	
Then add Google Analytics key by setting the Symbol `ganalytics.key` to its value (look at `GAnalyticsConstants.GANALYTICS_KEY`) .

Run your application in `production mode`, and that's it!

## Maven dependency

To use this plugin, add the following dependency in your `pom.xml`.

	<dependencies>
		...
		<dependency>
			<groupId>com.spreadthesource</groupId>
			<artifactId>tapestry5-googleanalytics</artifactId>
			<version>1.2</version>
		</dependency>
		...
	</dependencies>
	
	<repositories>
		...

		<repository>
			<id>devlab722-repo</id>
			<url>http://nexus.devlab722.net/nexus/content/repositories/releases
			</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>

		<repository>
			<id>devlab722-snapshot-repo</id>
			<url>http://nexus.devlab722.net/nexus/content/repositories/snapshots
			</url>
			<releases>
				<enabled>false</enabled>
			</releases>
		</repository>
		
		...
		
	</repositories>

## More Informations & contacts

* Blog: http://spreadthesource.com
* Twitter: http://twitter.com/spreadthesource


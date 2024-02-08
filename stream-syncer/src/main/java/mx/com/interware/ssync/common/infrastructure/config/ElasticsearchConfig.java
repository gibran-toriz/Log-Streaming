package mx.com.interware.ssync.common.infrastructure.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import lombok.extern.slf4j.Slf4j;

@Configuration
@EnableElasticsearchRepositories
@Slf4j
public class ElasticsearchConfig {

	/**
	 * Atributte elasticEndpoint.
	 */
	@Value("${spring.elasticsearch.client.reactive.endpoints}")
	private String elasticEndpoint;

	/**
	 * Atributte userName.
	 */
	@Value("${spring.elasticsearch.client.reactive.username}")
	private String userName;

	/**
	 * Atributte userName.
	 */
	@Value("${spring.elasticsearch.client.reactive.password}")
	private String password;

	public boolean isRelease(String[] profiles) {
		String profileRelease = "release";
		try {
			List<String> profileList = Arrays.asList(profiles);
			log.info("### profiles:" + profileList);
			boolean contiene = profileList.contains(profileRelease);

			if (contiene) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			log.warn("An error occurred while verifying profile.", e);
			return false;
		}
	}

	@Configuration
	public class ElasticClientConfig extends ElasticsearchConfiguration {

		@Autowired
		private Environment environment;

		@Override
		public ClientConfiguration clientConfiguration() {
			String[] profiles = environment.getActiveProfiles();
			boolean isRelease = isRelease(profiles);
			log.info("*** isRelease: " + isRelease);

			ClientConfiguration config = null;
			if (isRelease) {
				config = ClientConfiguration.builder()
						.connectedTo(elasticEndpoint)
						.usingSsl()
						.withBasicAuth(userName, password)
						.build();
			} else {
				config = ClientConfiguration.builder().connectedTo(elasticEndpoint).build();
			}

			return config;

		}
	}

}
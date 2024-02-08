package mx.com.interware.ssync.logs.infrastructure;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import mx.com.interware.ssync.logs.domain.model.EsEvent;
import mx.com.interware.ssync.logs.domain.outgoing.DockerMessagePort;

public interface ElasticsearchDockerMessagesStore
		extends ElasticsearchRepository<EsEvent, String>, DockerMessagePort {
}

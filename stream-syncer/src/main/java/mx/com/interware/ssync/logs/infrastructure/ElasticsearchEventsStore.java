package mx.com.interware.ssync.logs.infrastructure;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import mx.com.interware.ssync.logs.domain.model.EsEvent;
import mx.com.interware.ssync.logs.domain.outgoing.EventsPort;

public interface ElasticsearchEventsStore extends ElasticsearchRepository<EsEvent, String>, EventsPort {
}

package io.zenwave360.example.core.outbound.search;

// import io.zenwave360.example.core.domain.*;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/** Spring Data Elasticsearch repository for the {@link CustomerDocument } entity. */
public interface CustomerSearchRepository extends ElasticsearchRepository<CustomerDocument, String>, CustomerSearchRepositoryInternal {}

interface CustomerSearchRepositoryInternal {
    Page<CustomerDocument> search(String query, Pageable pageable);
}

class CustomerSearchRepositoryInternalImpl implements CustomerSearchRepositoryInternal {

    private final ElasticsearchRestTemplate elasticsearchTemplate;

    CustomerSearchRepositoryInternalImpl(ElasticsearchRestTemplate elasticsearchTemplate) {
        this.elasticsearchTemplate = elasticsearchTemplate;
    }

    @Override
    public Page<CustomerDocument> search(String query, Pageable pageable) {
        NativeSearchQuery nativeSearchQuery = new NativeSearchQuery(queryStringQuery(query));
        nativeSearchQuery.setPageable(pageable);
        List<CustomerDocument> hits =
                elasticsearchTemplate.search(nativeSearchQuery, CustomerDocument.class).map(SearchHit::getContent).stream()
                        .collect(Collectors.toList());

        return new PageImpl<>(hits, pageable, hits.size());
    }
}

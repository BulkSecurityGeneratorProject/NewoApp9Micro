package io.github.jhipster.application.repository.search;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Configuration;

/**
 * Configure a Mock version of {@link TipoPrepagoConsumoSearchRepository} to test the
 * application without starting Elasticsearch.
 */
@Configuration
public class TipoPrepagoConsumoSearchRepositoryMockConfiguration {

    @MockBean
    private TipoPrepagoConsumoSearchRepository mockTipoPrepagoConsumoSearchRepository;

}
package br.edu.engsoft.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.edu.engsoft.client.PipedriveClient;
import br.edu.engsoft.dto.ProductResponseDTO;
import br.edu.engsoft.repository.ProductRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@ApplicationScoped
public class ProductService {

    @Inject
    private ProductRepository repository;

    @Inject
    @RestClient
    private PipedriveClient client;

    @ConfigProperty(name = "pipedrive.token")
    String pipedriveToken;

    public void processProduction() {
        try {
            ProductResponseDTO response = this.client.getAllProducts(pipedriveToken);
            if (response.getSuccess()) {
                response.getData().forEach(product -> {
                    this.repository.save(product);
                });
            }
        } catch (Exception e) {
            log.errorv("Error while processing organizations ", e);
        }
    }
}

package br.edu.engsoft.service;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.edu.engsoft.client.PipedriveClient;
import br.edu.engsoft.dto.OrganizationResponseDTO;
import br.edu.engsoft.repository.OrganizationRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@ApplicationScoped
public class OrganizationService {

    @Inject
    private OrganizationRepository repository;

    @Inject
    @RestClient
    private PipedriveClient client;

    @ConfigProperty(name = "pipedrive.token")
    String pipedriveToken;

    public void processOrganization() {
        try {
            OrganizationResponseDTO response = this.client.getAllOrganizations(pipedriveToken);
            if (response.getSuccess()) {
                response.getData().forEach(organizaton -> {
                    this.repository.save(organizaton);
                });
            }
        } catch (Exception e) {
            log.errorv("Error while processing organizations ", e);
        }
    }
}

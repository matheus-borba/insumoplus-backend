package br.edu.engsoft.service;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import br.edu.engsoft.client.PipedriveClient;
import br.edu.engsoft.dto.UserResponseDTO;
import br.edu.engsoft.repository.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.extern.jbosslog.JBossLog;

@JBossLog
@ApplicationScoped
public class UserService {

    @Inject
    private UserRepository repository;

    @Inject
    @RestClient
    private PipedriveClient client;

    @ConfigProperty(name = "pipedrive.token")
    String pipedriveToken;

    public void processUsers() {
        try {
            UserResponseDTO response = client.getAllUsers(pipedriveToken);
            if (response.getSuccess()) {
                response.getData().forEach(user -> {
                    repository.save(user);
                });
            }
        } catch (Exception e) {
            log.errorv("Error while processing users: {0}", e.getMessage());
        }
    }
}

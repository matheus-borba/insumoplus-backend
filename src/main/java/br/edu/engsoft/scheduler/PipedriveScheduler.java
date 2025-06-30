package br.edu.engsoft.scheduler;

import br.edu.engsoft.service.OrganizationService;
import br.edu.engsoft.service.ProductService;
import br.edu.engsoft.service.UserService;
import jakarta.inject.Inject;
import lombok.extern.jbosslog.JBossLog;
import io.quarkus.scheduler.Scheduled;
import io.quarkus.scheduler.Scheduled.ConcurrentExecution;

@JBossLog
public class PipedriveScheduler {

    @Inject
    OrganizationService organizationService;

    @Inject
    ProductService productService;

    @Inject
    UserService userService;

    @Scheduled(
        concurrentExecution = ConcurrentExecution.SKIP,
        every = "24h",
        identity = "get-all-organizations"
    )
    public void getAllOrganizations() {
        log.info("Starting - Getting All Organizations");
        this.organizationService.processOrganization();
        log.info("Completing - Getting All Organizations");
    }

    @Scheduled(
        concurrentExecution = ConcurrentExecution.SKIP,
        every = "24h",
        identity = "get-all-products"
    )
    public void getAllProducts() {
        log.info("Starting - Getting All Products");
        this.productService.processProduction();
        log.info("Completing - Getting All Products");
    }

    @Scheduled(
        concurrentExecution = ConcurrentExecution.SKIP,
        every = "24h",
        identity = "get-all-users"
    )
    public void getAllUsers() {
        log.info("Starting - Getting All Users");
        this.userService.processUsers();
        log.info("Completing - Getting All Users");
    }
}

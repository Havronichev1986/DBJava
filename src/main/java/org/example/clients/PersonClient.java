package org.example.clients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "feign.client", url = "${person.client.url}")
public interface PersonClient {
    @GetMapping
    Object getPerson();
}

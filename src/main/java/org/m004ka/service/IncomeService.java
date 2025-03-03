package org.m004ka.service;

import lombok.AllArgsConstructor;
import org.m004ka.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@AllArgsConstructor
public class IncomeService {

    private String link;

    public int getIncome(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<UserDTO[]> response = restTemplate.getForEntity(link, UserDTO[].class);
        List<UserDTO> userList = List.of(response.getBody());

        Optional<UserDTO> userUrl = userList.stream()
                .filter(u -> Objects.equals(u.getId(), id))
                .findFirst();

        if (userUrl.isPresent()) {
            return userUrl.get().getIncome();
        } else {
            return 0;
        }
    }
}

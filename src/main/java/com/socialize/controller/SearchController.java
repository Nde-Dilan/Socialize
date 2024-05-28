package com.socialize.controller;

import com.socialize.dto.UserDTO;
import com.socialize.service.entityService.SearchServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin/")
public class SearchController {

    @Autowired
    private SearchServiceImpl searchService;


    @GetMapping("/search")
    public ResponseEntity<List<UserDTO>> getUserByUsernameOrName(@RequestParam String keyword, @RequestParam int start,
                                                                 @RequestParam int stop) {
        List<UserDTO> feed = searchService.getUserDTOByUsername(keyword,start,stop);

        return ResponseEntity.ok(feed);
    }
}
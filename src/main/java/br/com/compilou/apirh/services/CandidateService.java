package br.com.compilou.apirh.services;

import br.com.compilou.apirh.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CandidateService {

        @Autowired
        private CandidateRepository candidate;
}

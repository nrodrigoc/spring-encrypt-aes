package br.easy.encrypt.controller;

import br.easy.encrypt.config.EncryptConfig;
import br.easy.encrypt.dto.CryptDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/")
public class EncryptController {

    @GetMapping("/encrypt")
    public CryptDTO getEncryptedString(@RequestParam String value) {
        return new CryptDTO(value, EncryptConfig.encrypt(value));
    }

    @GetMapping("/decrypt")
    public CryptDTO getDecryptedString(@RequestParam String value) {
        return new CryptDTO(value, EncryptConfig.decrypt(value));
    }

}

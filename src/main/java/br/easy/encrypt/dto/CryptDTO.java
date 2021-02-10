package br.easy.encrypt.dto;


import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CryptDTO {

    private String value;

    private String result;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}

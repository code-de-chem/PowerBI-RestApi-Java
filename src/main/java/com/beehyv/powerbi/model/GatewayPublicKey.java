package com.beehyv.powerbi.model;

public class GatewayPublicKey {
    private String exponent;
    private String modulus;

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }

    public String getModulus() {
        return modulus;
    }

    public void setModulus(String modulus) {
        this.modulus = modulus;
    }
}

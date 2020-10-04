package net.examples.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum SecureProtocol {

    DHCP("Dynamic Host Configuration Protocol"), HTTP("Hypertext Transfer Protocol", false),
    HTTPS("Hyper Text Transfer Protocol Secure"), NFS("Network File System");

    private SecureProtocol(String fullName) {
        this.fullName = fullName;
    }

    private SecureProtocol(String fullName, boolean secure) {
        this.fullName = fullName;
        this.secure = secure;
    }

    public String getFullName() {
        return fullName;
    }

    public boolean isSecure() {
        return secure;
    }

    private String fullName;
    private boolean secure = true;

    @Override
    public String toString() {
        return "Name: " + getFullName() + ". Is secure: " + isSecure();
    }

    public static List<SecureProtocol> getSecureProtocols() {
        return Arrays.asList(values()).stream().filter(SecureProtocol::isSecure).collect(Collectors.toList());
    }

}

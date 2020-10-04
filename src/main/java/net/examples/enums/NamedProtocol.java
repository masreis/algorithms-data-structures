package net.examples.enums;

public enum NamedProtocol {

    DHCP("Dynamic Host Configuration Protocol"), HTTP("Hypertext Transfer Protocol"),
    HTTPS("Hyper Text Transfer Protocol Secure"), NFS("Network File System");

    private NamedProtocol(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }

    private String fullName;

}

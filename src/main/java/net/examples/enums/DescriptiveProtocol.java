package net.examples.enums;

public enum DescriptiveProtocol implements Descriptive {

    DHCP("Dynamic Host Configuration Protocol", "Dynamically assigns an IP address."),
    HTTP("Hypertext Transfer Protocol", "Foundation of data communication for the World Wide Web."),
    HTTPS("Hyper Text Transfer Protocol Secure", "Extension of the HTTP used for secure communication."),
    NFS("Network File System", "Distributed file system protocol.");

    private DescriptiveProtocol(String fullName, String description) {
        this.fullName = fullName;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String getFullName() {
        return fullName;
    }

    private String description;
    private String fullName;

}

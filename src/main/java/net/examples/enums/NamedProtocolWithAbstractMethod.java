package net.examples.enums;

public enum NamedProtocolWithAbstractMethod {

    DHCP {
        @Override
        public String getFormattedName() {
            return "I am the Dynamic Host Configuration Protocol";
        }
    },
    HTTP {
        @Override
        public String getFormattedName() {
            return "I am the Hypertext Transfer Protocol";
        }
    },
    HTTPS {
        @Override
        public String getFormattedName() {
            return "I am the Hyper Text Transfer Protocol Secure";
        }
    },
    NFS {
        @Override
        public String getFormattedName() {
            return "I am the Network File System";
        }
    };

    public abstract String getFormattedName();
}

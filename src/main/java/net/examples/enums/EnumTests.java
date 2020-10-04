package net.examples.enums;

import java.util.Arrays;
import java.util.Date;

public class EnumTests {

    public static void main(String[] args) {

        // SimpleProtocol
        SimpleProtocol dhcp = SimpleProtocol.DHCP;

        System.out.println("Simple Protocol: " + dhcp);

        // valueOf
        SimpleProtocol nfs = SimpleProtocol.valueOf("NFS");

        System.out.println("From value: " + nfs);
        System.out.println("From enum: " + Enum.valueOf(SimpleProtocol.class, "HTTP"));

        String value = "nfs";
        try {
            System.out.println(SimpleProtocol.valueOf(value));
        } catch (Exception e) {
            System.err.println("Invalid value: " + value);
        }

        // values()
        System.out.println("Values: " + Arrays.toString(SimpleProtocol.values()));

        for (SimpleProtocol sp : SimpleProtocol.values()) {
            System.out.println("Value: " + sp + ". Position: " + sp.ordinal());
        }

        Arrays.asList(SimpleProtocol.values()).stream().forEach(System.out::println);

        // Switch
        SimpleProtocol protocol = SimpleProtocol.valueOf("NFS");
        switch (protocol) {
        case DHCP:
            System.out.println("I am DHCP.");
            break;
        case HTTP:
            System.out.println("I am HTTP.");
            break;
        case HTTPS:
            System.out.println("I am HTTPS.");
            break;
        case NFS:
            System.out.println("I am NFS.");
            break;
        }

        // IF

        if (SimpleProtocol.DHCP == dhcp) {
            System.out.println("We are equals.");
        }

        if (SimpleProtocol.DHCP.equals(dhcp)) {
            System.out.println("Yes, equals.");
        }

        // NamedProtocol
        System.out.println("Full name: " + NamedProtocol.NFS.getFullName());

        // DescriptiveProtocol
        DescriptiveProtocol https = DescriptiveProtocol.HTTPS;
        System.out.println("Description: " + https.getDescription());

        // SecureProtocol
        System.out.println(SecureProtocol.HTTP.toString());

        System.out.println(SecureProtocol.HTTPS);

        SecureProtocol.getSecureProtocols().stream().forEach(System.out::println);

        // Singleton
        Counter firstInstance = Counter.INSTANCE;
        firstInstance.setValue(1);
        firstInstance.process();

        Counter secondInstance = Counter.INSTANCE;
        secondInstance.setValue(2);
        secondInstance.process();
        firstInstance.process();

        // Abstract methods
        NamedProtocolWithAbstractMethod nfsAbs = NamedProtocolWithAbstractMethod.NFS;
        System.out.println(nfsAbs.getFormattedName());

        // Strategy
        ValidatorContext validator = new ValidatorContext(ValidatorStrategy.XML);
        validator.runValidation("XML content");

        validator.setValidator(ValidatorStrategy.YAML);
        validator.runValidation("YAML content");

        validator.setValidator(ValidatorStrategy.JSON);
        validator.runValidation("JSON content");

        // Strategy
        Date date = new Date();
        DateFormatterContext formatter = new DateFormatterContext(DateFormatterStrategy.BELGIUM);
        System.out.println("Belgium: " + formatter.format(date));

        formatter.setStrategy(DateFormatterStrategy.BRAZIL);
        System.out.println("Brazil: " + formatter.format(date));

        formatter.setStrategy(DateFormatterStrategy.US);
        System.out.println("US: " + formatter.format(date));

    }
}

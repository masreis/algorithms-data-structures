package net.examples.enums;

public enum ValidatorStrategy {

    XML {
        @Override
        void doValidation(String content) {
            // The validation code goes here
            System.out.println("This is a XML content");
        }
    },
    JSON {
        @Override
        void doValidation(String content) {
            // The validation code goes here
            System.out.println("This is a JSON content");
        }
    },
    YAML {
        @Override
        void doValidation(String content) {
            // The validation code goes here
            System.out.println("This is a YAML content");
        }
    },
    CSV {
        @Override
        void doValidation(String content) {
            // The validation code goes here
            System.out.println("This is a CSV content");
        }
    };

    abstract void doValidation(String content);

}
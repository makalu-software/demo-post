package post

enum HRM {
    KEKA("Keka"), DARWINBOX("Darwin Box"),
    ZOHO("Zoho"),ZENHR("Zenhr"),BAMBOOHR("BambooHR"),
    ORACLE("Oracle")

    private String displayName

    HRM(String displayName){
        this.displayName = displayName
    }

    String getDisplayName() {
        return displayName
    }
}
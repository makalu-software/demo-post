package post

enum BlockUserType {
    JustDelete("Just Delete"),
    Block("Block"),
    BlockAndProvideManagerAsReplacement("Block And Provide Manager As Replacement"),
    BlockAndProvideAsReplacement("Block And Provide As Replacement")
    private String displayName

    BlockUserType(String displayName){
        this.displayName = displayName
    }

    String getDisplayName() {
        return displayName
    }
}

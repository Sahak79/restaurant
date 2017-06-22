package common.data.model.lcp;

public enum UserProfile {

    MANAGER   (1, "Manager", "label.user.profile.manager"),
    WAITER    (2, "Waiter", "label.user.profile.waiter");

    UserProfile(int value, String title, String msgKey) {
        this.value = value;
        this.title = title;
        this.msgKey = msgKey;
    }

    public static UserProfile valueOf(int value) {
        for (UserProfile e : UserProfile.values()) {
            if (e.value == value) {
                return e;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public String getTitle() {
        return title;
    }

    public String getMsgKey() {
        return msgKey;
    }

    private final int value;

    private final String title;

    private final String msgKey;
}

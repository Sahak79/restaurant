package common.data.model.lcp;

/**
 * Created by SahakBabayan on 6/21/2017.
 */
public enum OrderStatus {
    OPEN        (1, "Pending",  "label.order.status.open"),
    CANCELLED   (2, "Active",   "label.order.status.cancelled"),
    CLOSED      (3, "Disabled", "label.order.status.closed");

    OrderStatus(int value, String title, String msgKey) {
        this.value = value;
        this.title = title;
        this.msgKey = msgKey;
    }

    public static OrderStatus valueOf(int value) {
        for (OrderStatus e : OrderStatus.values()) {
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

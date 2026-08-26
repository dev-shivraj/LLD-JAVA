package practice.builder.part3.notification;

import java.util.HashMap;
import java.util.Map;

/*
    recipient       required
    message         required

    title           optional
    priority        optional
    retryCount      optional
    scheduledTime   optional
    email           optional
    phone           optional
    pushEnabled     optional


    Validation:
        recipient → required
        message   → required
        retryCount >= 0

    And use sensible defaults:
        priority    = "NORMAL"
        retryCount  = 0
        pushEnabled = false

    Bonus: Add:
        .addMetadata("transactionId", "TXN123")
      where metadata is:
        Map<String, String>

 */
public class Notification {
    private final String recipient;
    private final String message;
    private final String title;
    private final String priority;
    private final int retryCount;
    private final String scheduledTime;
    private final String email;
    private final String phone;
    private final boolean pushEnabled;
    private final Map<String, String> metadata;

    private Notification(NotificationBuilder builder) {
        this.recipient = builder.recipient;
        this.message = builder.message;
        this.title = builder.title;
        this.priority = builder.priority;
        this.retryCount = builder.retryCount;
        this.scheduledTime = builder.scheduledTime;
        this.email = builder.email;
        this.phone = builder.phone;
        this.pushEnabled = builder.pushEnabled;
        this.metadata = Map.copyOf(builder.metadata);
    }

    public static NotificationBuilder builder() {
        return new NotificationBuilder();
    }

    public String getRecipient() {
        return recipient;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public String getPriority() {
        return priority;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isPushEnabled() {
        return pushEnabled;
    }

    public static class NotificationBuilder {
        private String recipient;
        private String message;
        private String title;
        private String priority = "NORMAL";
        private int retryCount = 0;
        private String scheduledTime;
        private String email;
        private String phone;
        private boolean pushEnabled = false;
        private final Map<String, String> metadata = new HashMap<>();



        public NotificationBuilder setRecipient(String recipient) {
            this.recipient = recipient;
            return this;
        }

        public NotificationBuilder setMessage(String message) {
            this.message = message;
            return this;
        }

        public NotificationBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public NotificationBuilder setPriority(String priority) {
            this.priority = priority;
            return this;
        }

        public NotificationBuilder setRetryCount(int retryCount) {
            this.retryCount = retryCount;
            return this;
        }

        public NotificationBuilder setScheduledTime(String scheduledTime) {
            this.scheduledTime = scheduledTime;
            return this;
        }

        public NotificationBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public NotificationBuilder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public NotificationBuilder setPushEnabled(boolean pushEnabled) {
            this.pushEnabled = pushEnabled;
            return this;
        }

        public NotificationBuilder addMetadata(String key, String value) {
            this.metadata.put(key, value);
            return this;
        }



        public Notification build() {
            if(recipient == null || recipient.isBlank()) {
                throw new IllegalArgumentException("Recipient is required");
            }

            if(message == null || message.isBlank()) {
                throw new IllegalArgumentException("Message is required");
            }

            if(retryCount < 0) {
                throw new IllegalArgumentException("Retry count should be greater than 0");
            }

            return new Notification(this);
        }
    }
}

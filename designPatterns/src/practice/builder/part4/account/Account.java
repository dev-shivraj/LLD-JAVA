package practice.builder.part4.account;

public class Account {

    private final String username;
    private final String password;
    private final String email;

    private Account(
            String username,
            String password,
            String email
    ) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public static UsernameStep builder() {
        return new Builder();
    }

    public interface UsernameStep {
        PasswordStep setUsername(String username);
    }

    public interface PasswordStep {
        OptionalStep setPassword(String password);
    }

    public interface OptionalStep {
        OptionalStep setEmail(String email);

        Account build();
    }

    private static class Builder
            implements UsernameStep,
                       PasswordStep,
                       OptionalStep {

        private String username;
        private String password;
        private String email;

        @Override
        public PasswordStep setUsername(
                String username
        ) {
            this.username = username;
            return this;
        }

        @Override
        public OptionalStep setPassword(
                String password
        ) {
            this.password = password;
            return this;
        }

        @Override
        public OptionalStep setEmail(
                String email
        ) {
            this.email = email;
            return this;
        }

        @Override
        public Account build() {

            if (username == null ||
                    username.isBlank()) {

                throw new IllegalArgumentException(
                        "Username is required"
                );
            }

            if (password == null ||
                    password.isBlank()) {

                throw new IllegalArgumentException(
                        "Password is required"
                );
            }

            return new Account(
                    username,
                    password,
                    email
            );
        }
    }
}
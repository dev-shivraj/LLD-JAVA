package librarymanagementsystem;

public class Client {
    static void main() {
        User user1 = new Member("Raj", "43423");
        User user2 = new Librarian("Shivraj", "234230423", "101");
//        User user3 = new Member(user2);

        user1.displayDashboard();
        user2.displayDashboard();

        System.out.println("Member Id : " + user1.getUserId());
        System.out.println("Librarian Id : " + user2.getUserId());
        System.out.println("Total Users: " + User.getTotalUser());

    }
}

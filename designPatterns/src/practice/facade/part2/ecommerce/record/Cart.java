package practice.facade.part2.ecommerce.record;

import java.util.List;

public record Cart(String userId, List<String> items) {

}
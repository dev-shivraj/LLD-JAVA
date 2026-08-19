package practice.boundedgenerics_04.part5;

class EntityRepository<T extends Entity> {

    public void save(T entity) {
        System.out.println("Saving entity: " + entity.getId());
    }
}
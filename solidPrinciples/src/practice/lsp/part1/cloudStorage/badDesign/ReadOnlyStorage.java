package practice.lsp.part1.cloudStorage.badDesign;

public class ReadOnlyStorage extends CloudStorage {
    @Override
    public void delete(String file) {
        throw new UnsupportedOperationException("Read-only storage cannot delete");
    }
}
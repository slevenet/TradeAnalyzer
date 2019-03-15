package exchange.analyzer.service;

public interface DBService<T> {
    T getByID(Long id);
}

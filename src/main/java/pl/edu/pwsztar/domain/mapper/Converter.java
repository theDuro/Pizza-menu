package pl.edu.pwsztar.domain.mapper;

@FunctionalInterface
public interface Converter<T, F> {
    T convert(F from);
}

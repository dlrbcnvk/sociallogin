package practice.sociallogin.converters;

/**
 * T -> R
 */
public interface ProviderUserConverter<T, R> {

    R converter(T t);
}

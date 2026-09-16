package practice.observer.base.observer;

public interface WeatherSubscriber {

    void onUpdateWeather(int newTemp);
}
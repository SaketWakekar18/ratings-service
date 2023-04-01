package app.ratingservice.Service;

import app.ratingservice.Entity.Ratings;

import java.util.List;

public interface RatingsService {

    Ratings createRatings(Ratings ratings);

    Ratings updteRatings(Ratings ratings, int rating_id);

    List<Ratings> getAllRatings();

    List<Ratings> getRatingsByUser(int userId);

    List<Ratings> getRatingsByHotel(int hotelId);

    void deleteHotel(int rating_id);
}

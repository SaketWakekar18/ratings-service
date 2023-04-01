package app.ratingservice.Service.Implementation;

import app.ratingservice.Entity.Ratings;
import app.ratingservice.Exception.HotelNotFoundException;
import app.ratingservice.Exception.ResourceNotFoundException;
import app.ratingservice.Exception.UserNotFoundException;
import app.ratingservice.Repository.RatingsRepository;
import app.ratingservice.Service.RatingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RatingsServiceImpl implements RatingsService {
    private final RatingsRepository ratingsRepository;

    @Override
    public Ratings createRatings(Ratings ratings) {
        Ratings saveUser = this.ratingsRepository.save(ratings);
        return saveUser;
    }

    @Override
    public Ratings updteRatings(Ratings ratings, int rating_id) {
        Ratings updateRatings = this.ratingsRepository.findById(rating_id).orElseThrow(()->new ResourceNotFoundException("Rating with "+rating_id+" not found on server"));
        updateRatings.setRating(ratings.getRating());
        updateRatings.setFeedback(ratings.getFeedback());
        updateRatings.setUserId(ratings.getUserId());
        updateRatings.setHotelId(ratings.getHotelId());
        return this.ratingsRepository.save(updateRatings);
    }

    @Override
    public List<Ratings> getAllRatings() {
        return this.ratingsRepository.findAll();
    }

    @Override
    public List<Ratings> getRatingsByUser(int userId) {
        if(this.ratingsRepository.existsByUserId(userId)) {
            return this.ratingsRepository.findByUserId(userId);
        }
        else{
            throw new UserNotFoundException("User with ID "+userId+" not found");
        }
    }

    @Override
    public List<Ratings> getRatingsByHotel(int hotelId) {
        if(this.ratingsRepository.existsByHotelId(hotelId)){
            return this.ratingsRepository.findByHotelId(hotelId);
        }
        else {
            throw new HotelNotFoundException("Hotel with ID "+hotelId+" not found");
        }
    }

    @Override
    public void deleteHotel(int rating_id) {
        Ratings deleteHotel = this.ratingsRepository.findById(rating_id).orElseThrow(()->new ResourceNotFoundException("Rating with "+rating_id+" not found on server"));;
        this.ratingsRepository.delete(deleteHotel);
    }
}

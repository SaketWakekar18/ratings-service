package app.ratingservice.Repository;

import app.ratingservice.Entity.Ratings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingsRepository extends JpaRepository<Ratings, Integer> {
    List<Ratings> findByUserId(int userId);

    List<Ratings> findByHotelId(int hotelId);

    boolean existsByUserId(int userId);

    boolean existsByHotelId(int hotelId);

}

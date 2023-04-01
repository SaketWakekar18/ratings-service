package app.ratingservice.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Ratings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ratingId;
    @NotEmpty(message = "Please enter User ID")
    private int userId;
    @NotEmpty(message = "Please enter Hotel ID")
    private int hotelId;
    @NotEmpty(message = "Please enter some rating")
    @Size(min = 1,max = 10,message = "Please enter rating between 1 to 10")
    private int rating;
    @NotEmpty(message = "Please enter some feedback")
    private String feedback;
}

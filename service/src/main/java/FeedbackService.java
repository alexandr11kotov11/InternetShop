import com.kotov.modelDTO.FeedbackDTO;
import org.springframework.transaction.annotation.Transactional;

public interface FeedbackService {
    @Transactional
    void save(FeedbackDTO feedback);

}
